package com.example.sewaklalcorporate.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RequestServiceAddonCategories {
    String id;
    String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<RequestServiceAddonSubCategories> getRequestServiceAddonSubCategories() {
        return requestServiceAddonSubCategories;
    }

    @SerializedName("sub_categories")
    private List<RequestServiceAddonSubCategories> requestServiceAddonSubCategories = null;

}
