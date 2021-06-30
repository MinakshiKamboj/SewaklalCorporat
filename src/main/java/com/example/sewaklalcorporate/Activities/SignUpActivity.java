package com.example.sewaklalcorporate.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sewaklalcorporate.Interfase.InterUserdata;
import com.example.sewaklalcorporate.Models.OTPModel;
import com.example.sewaklalcorporate.R;
import com.example.sewaklalcorporate.Services.ServiceGenerator;
import com.example.sewaklalcorporate.Utility.MyPreferences;
import com.example.sewaklalcorporate.Utility.Preferences;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    TextView btn_Login, txt_verify_otp, txt_send_otp;
    EditText etPhone, etOtp, etcompanyName, etEmail, etPassword, etPhone_reg;
    ProgressDialog progressDialog;
    Button btnSignUP;
    private static final String TAG = "SignUpActivity";
    String mob;
    LinearLayout linear_otp, linear_resend_otp, linear_send_otp, linear_all,
            linear_otp_verify, linear_again_verify;
    CardView card_otp;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        progressDialog=new ProgressDialog(SignUpActivity.this);
        progressDialog.setMessage("Please wait...");
        spinner = findViewById(R.id.spinner);
        btn_Login = findViewById(R.id.btn_Login);
        card_otp = findViewById(R.id.card_otp);
        linear_again_verify = findViewById(R.id.linear_again_verify);
        linear_all = findViewById(R.id.linear_all);
        linear_otp_verify = findViewById(R.id.linear_otp_verify);
        linear_otp = findViewById(R.id.linear_otp);
        linear_send_otp = findViewById(R.id.linear_send_otp);
        linear_resend_otp = findViewById(R.id.linear_resend_otp);
        txt_verify_otp = findViewById(R.id.txt_verify_otp);
        txt_send_otp = findViewById(R.id.txt_send_otp);
        etPhone = findViewById(R.id.etPhone);
        etOtp = findViewById(R.id.etOtp);
        etEmail = findViewById(R.id.etEmail);
        btnSignUP = findViewById(R.id.btnSignUP);
        etcompanyName = findViewById(R.id.etcompanyName);
        etPassword = findViewById(R.id.etPassword);
        etPhone_reg = findViewById(R.id.etPhone_reg);
        if (mob == null){
            etPhone_reg.setText("");
        }else {
            etPhone_reg.setText(mob);
        }
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
        txt_verify_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etOtp.getText().toString().equals("")){
                    etOtp.setError("Enter valid otp...");
                    etOtp.requestFocus();
                }else {
                    VerifyOtp();
                }
            }
        });

        linear_again_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linear_again_verify.setVisibility(View.GONE);
                linear_all.setVisibility(View.GONE);
                linear_otp_verify.setVisibility(View.VISIBLE);
            }
        });

        txt_send_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etPhone.getText().toString().equals("")){
                    etPhone.setError("Enter mobile number");
                    etPhone.requestFocus();
                }else {
                    SendOtp();
                }
            }
        });

        linear_resend_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etPhone.getText().toString().equals("")){
                    etPhone.setError("Enter mobile number");
                    etPhone.requestFocus();
                }else {
                    SendOtp();
                }
            }
        });
        btnSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etcompanyName.getText().toString().equals("")){
                    etcompanyName.setError("Enter company number");
                    etcompanyName.requestFocus();
                }
                else  if (etEmail.getText().toString().equals("")){
                    etEmail.setError("Enter email");
                    etEmail.requestFocus();
                }
                else if (etPassword.getText().toString().equals("")) {
                    etPassword.setError("Enter password");
                    etPassword.requestFocus();
                }else {
                    Register();
                }
            }
        });
    }
    private void SendOtp() {
        progressDialog.show();
        String mobile = etPhone.getText().toString().trim();
        InterUserdata interUserdata = ServiceGenerator.createService(InterUserdata.class);
        interUserdata.sendotp(mobile).enqueue(new Callback<OTPModel>() {
            @Override
            public void onResponse(Call<OTPModel> call, Response<OTPModel> response) {
                progressDialog.hide();
                Log.d(TAG, "onResponse: "+new Gson().toJson(response.body()));
                Log.d(TAG, "onResponse: "+response.message());
                Log.d(TAG, "onResponse: "+response.code());
                if (response.isSuccessful()) {
                    if (response.body().getStatusCode() == 200 ) {
                        mob = response.body().getResult();
                        linear_send_otp.setVisibility(View.GONE);
                        linear_otp.setVisibility(View.VISIBLE);
                        linear_resend_otp.setVisibility(View.VISIBLE);
                        card_otp.setVisibility(View.VISIBLE);
                        Toast.makeText(SignUpActivity.this, response.body().getAPICODERESULT(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SignUpActivity.this, response.body().getAPICODERESULT(), Toast.LENGTH_SHORT).show();
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

    private void VerifyOtp() {
        progressDialog.show();
        String otp = etOtp.getText().toString().trim();
        InterUserdata interUserdata = ServiceGenerator.createService(InterUserdata.class);
        interUserdata.verifyotp(mob, otp).enqueue(new Callback<OTPModel>() {
            @Override
            public void onResponse(Call<OTPModel> call, Response<OTPModel> response) {
                progressDialog.hide();
                Log.d(TAG, "onResponse: "+new Gson().toJson(response.body()));
                Log.d(TAG, "onResponse: "+response.message());
                Log.d(TAG, "onResponse: "+response.code());
                if (response.isSuccessful()) {
                    if (response.body().getStatusCode() == 200) {
                        MyPreferences.getActiveInstance(SignUpActivity.this).setUserId(response.body().getUser_id());
                        linear_all.setVisibility(View.VISIBLE);
                        linear_otp.setVisibility(View.GONE);
                        linear_otp_verify.setVisibility(View.GONE);
                        linear_again_verify.setVisibility(View.VISIBLE);
                        Toast.makeText(SignUpActivity.this, response.body().getAPICODERESULT(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SignUpActivity.this, response.body().getAPICODERESULT(), Toast.LENGTH_SHORT).show();
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

    private void Register() {
        progressDialog.show();
        String email = etEmail.getText().toString().trim();
        String companyName = etcompanyName.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        InterUserdata interUserdata = ServiceGenerator.createService(InterUserdata.class);
        interUserdata.register(mob,companyName, "5", password,email,MyPreferences.getActiveInstance(this).getUserId()).enqueue(new Callback<OTPModel>() {
            @Override
            public void onResponse(Call<OTPModel> call, Response<OTPModel> response) {
                progressDialog.hide();
                Log.d(TAG, "onResponse: "+new Gson().toJson(response.body()));
                Log.d(TAG, "onResponse: "+response.message());
                Log.d(TAG, "onResponse: "+response.code());
                if (response.isSuccessful()) {
                    if (response.body().getStatusCode() == 200 ) {

//                        Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
//                        startActivity(i);
//                        finish();
                        Toast.makeText(SignUpActivity.this, response.body().getAPICODERESULT(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SignUpActivity.this, response.body().getAPICODERESULT(), Toast.LENGTH_SHORT).show();
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