package com.example.sewaklalcorporate.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sewaklalcorporate.Interfase.InterUserdata;
import com.example.sewaklalcorporate.Models.LoginRequest;
import com.example.sewaklalcorporate.Models.OTPModel;
import com.example.sewaklalcorporate.Models.ProfileDetails;
import com.example.sewaklalcorporate.R;
import com.example.sewaklalcorporate.Services.ServiceGenerator;
import com.example.sewaklalcorporate.Utility.MyPreferences;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileDetailActivity extends BaseAppCompatActivity {
    protected Toolbar toolbar;
    TextView tv_cmpy_name,tv_email_id , tv_mob_no, tv_cat_type;
    private static final String TAG = "SignUpActivity";
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_detail);
        progressDialog=new ProgressDialog(ProfileDetailActivity.this);
        progressDialog.setMessage("Please wait...");
        tv_cmpy_name = findViewById(R.id.tv_cmpy_name);
        tv_email_id = findViewById(R.id.tv_email_id);
        tv_mob_no = findViewById(R.id.tv_mob_no);
        tv_cat_type = findViewById(R.id.tv_cat_type);
        initToolBar("My Profile Detail", true);
        getProfileDetail();
    }
    public void initToolBar(String title,boolean backpress) {
        toolbar = findViewById(R.id.toolbar);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(backpress);
        getSupportActionBar().setHomeAsUpIndicator(getHomeIcon());
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimary));
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));
        toolbar.setSubtitleTextColor(ContextCompat.getColor(this, R.color.white));
    }
    private void getProfileDetail() {
        progressDialog.show();
        InterUserdata interUserdata = ServiceGenerator.createService(InterUserdata.class);
        interUserdata.getProfileDetail(MyPreferences.getActiveInstance(this).getId()).enqueue(new Callback<OTPModel>() {
            @Override
            public void onResponse(Call<OTPModel> call, Response<OTPModel> response) {
                progressDialog.hide();
                Log.d(TAG, "onResponse: "+new Gson().toJson(response.body()));
                Log.d(TAG, "onResponse: "+response.message());
                Log.d(TAG, "onResponse: "+response.code());
                if (response.isSuccessful()) {
                    if (response.body().getStatusCode() == 200 ) {
                        OTPModel otpModel = response.body();
                        ProfileDetails profileDetails = otpModel.getProfileDetails();
                        tv_cmpy_name.setText(profileDetails.getComp_name());
                        tv_email_id.setText(profileDetails.getEmail());
                        tv_mob_no.setText(profileDetails.getMobile());
                    }
                }
            }
            @Override
            public void onFailure(Call<OTPModel> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
                t.printStackTrace();
            }
        });
    }

}