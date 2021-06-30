package com.example.sewaklalcorporate.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
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

public class LoginActivity extends AppCompatActivity {
    TextView tvSignup, btn_ForgotPass, btn_Signup;
    Button btn_Login;
    LinearLayout skip;
    EditText etEmail, etPass;
    ProgressDialog progressDialog;
    private static final String TAG = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressDialog=new ProgressDialog(LoginActivity.this);
        progressDialog.setMessage("Please wait...");
        tvSignup = findViewById(R.id.btn_Signup);
        btn_ForgotPass = findViewById(R.id.btn_ForgotPass);
        btn_Login = findViewById(R.id.btn_Login);
        btn_Signup = findViewById(R.id.btn_Signup);
        skip = findViewById(R.id.skip);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        btn_Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });
        btn_ForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, ForgotActivity.class);
                startActivity(i);
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, MainHomeActivity.class);
                startActivity(i);
            }
        });
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etEmail.getText().toString().equals("")){
                    etEmail.setError("Enter email");
                    etEmail.requestFocus();
                }
                else if (etPass.getText().toString().equals("")){
                    etPass.setError("Enter company number");
                    etPass.requestFocus();
                }else{
                    LoginUser();
                }
            }
        });
    }
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

}