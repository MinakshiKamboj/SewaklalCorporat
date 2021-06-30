package com.example.sewaklalcorporate.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.sewaklalcorporate.Interfase.InterUserdata;
import com.example.sewaklalcorporate.Models.LoginRequest;
import com.example.sewaklalcorporate.Models.OTPModel;
import com.example.sewaklalcorporate.R;
import com.example.sewaklalcorporate.Services.ServiceGenerator;
import com.example.sewaklalcorporate.Utility.MyPreferences;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyProfileActivity extends BaseAppCompatActivity {
    protected Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        initToolBar("My Profile", true);
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

/*
    private void LoginUser() {
        progressDialog.show();
        String email = etEmail.getText().toString().trim();
        String password = etPass.getText().toString().trim();
        InterUserdata interUserdata = ServiceGenerator.createService(InterUserdata.class);
        interUserdata.login(email, password).enqueue(new Callback<OTPModel>() {
            @Override
            public void onResponse(Call<OTPModel> call, Response<OTPModel> response) {
                progressDialog.hide();
                Log.d(TAG, "onResponse: "+new Gson().toJson(response.body()));
                Log.d(TAG, "onResponse: "+response.message());
                Log.d(TAG, "onResponse: "+response.code());
                if (response.isSuccessful()) {
                    if (response.body().getStatusCode() == 200 ) {
                        OTPModel login = response.body();
                        LoginRequest loginRequest = login.getLoginRequest();
                        MyPreferences.getActiveInstance(LoginActivity.this).setId(loginRequest.getId());
                        Toast.makeText(LoginActivity.this, response.body().getAPICODERESULT(), Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(LoginActivity.this, MainHomeActivity.class);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, response.body().getAPICODERESULT(), Toast.LENGTH_SHORT).show();
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
*/

}