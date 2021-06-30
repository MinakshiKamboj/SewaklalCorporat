package com.example.sewaklalcorporate.Interfase;

import com.example.sewaklalcorporate.Models.OTPModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface InterUserdata {
    @POST("mobileotp")
    @FormUrlEncoded
    Call<OTPModel> sendotp(@Field("mobile") String mobile);

    @POST("otpverify")
    @FormUrlEncoded
    Call<OTPModel> verifyotp(@Field("mobile") String mobile, @Field("otp") String otp);

    @POST("register")
    @FormUrlEncoded
    Call<OTPModel> register(@Field("mobile") String mobile, @Field("comp_name") String comp_name
    ,@Field("service_type") String service_type, @Field("password") String password,
     @Field("email") String email, @Field("user_id") String user_id);

    @POST("login")
    @FormUrlEncoded
    Call<OTPModel> login(@Field("email") String email, @Field("password") String password);

    @POST("getprofiledetails")
    @FormUrlEncoded
    Call<OTPModel> getProfileDetail(@Field("mobile") String mobile);

    @POST("getcategory")
    @FormUrlEncoded
    Call<OTPModel> getCategoryDetails();

}
