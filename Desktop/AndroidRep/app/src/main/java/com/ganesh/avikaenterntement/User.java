package com.ganesh.avikaenterntement;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("response")
    public String Response;

    @SerializedName("name")
    public String Name;

    public void setResponse(String response) {
        Response = response;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getResponse() {
        return Response;
    }

    public String getName() {
        return Name;
    }
}
