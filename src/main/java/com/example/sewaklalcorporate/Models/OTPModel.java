package com.example.sewaklalcorporate.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OTPModel {

    int statusCode;

    String APICODERESULT;

    String result;
    String user_id;

    public String getUser_id() {
        return user_id;
    }


    public int getStatusCode() {
        return statusCode;
    }

    public String getAPICODERESULT() {
        return APICODERESULT;
    }

    public String getResult() {
        return result;
    }

    @SerializedName("logindetail")
    LoginRequest loginRequest;
    public LoginRequest getLoginRequest() {
        return loginRequest;
    }

    @SerializedName("profiledetails")
    ProfileDetails profileDetails;
    public ProfileDetails getProfileDetails() {
        return profileDetails;
    }




    @SerializedName("categorydetail")
    private List<getCategoryRequest> getCategoryRequests = null;
    public List<getCategoryRequest> getGetCategoryRequests() {
        return getCategoryRequests;
    }


    @SerializedName("categories")
    private List<RequestServiceAddonCategories> requestServiceAddonCategories = null;
    public List<RequestServiceAddonCategories> getRequestServiceAddonCategories() {
        return requestServiceAddonCategories;
    }


}
