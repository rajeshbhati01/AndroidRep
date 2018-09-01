package com.ganesh.avikaenterntement;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiclient   {
    public static  final String BASE_URL="http://ec2-52-66-98-205.ap-south-1.compute.amazonaws.com:3000/user/";
    public static Retrofit retrofit=null;

    public static Retrofit getApiClient()
    {
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder ().baseUrl (BASE_URL).addConverterFactory (GsonConverterFactory.create ()).build ();
            Log.i ("retrofit",retrofit.toString () );
        }
        return  retrofit;
    }

}
