package com.ganesh.avikaenterntement;

import android.util.Log;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import android.util.Log;
public interface ApiInterface {

    @GET("reg")
    Call <User> performanceRegistration (
                                         @Query("Name") String name,
                                         @Query ("Gender") String gender,
                                         @Query ("Lastname") String lastname,
                                         @Query ("Dob") String dob,
                                         @Query ("Email") String email,
                                         @Query ("Password") String password,
                                         @Query ("ConfirmPassword") String confirmpassword,
                                         @Query ("Phonenumber") String phonenumber,
                                         @Query ("AppId") String appid,
                                         @Query("AnID") String anid

    );
//name,
//                   gender,lastname,dob,email,password,confirmpassword,phonenumber,appid,anid);
    @GET("login")
    Call<User> performUserLogin(@Query ("Email") String email,
                                @Query ("Password") String password,
                                @Query ("AppId") String appid,
                                @Query("AnID") String anid,
                                @Query("Reg") String reg
                                );

     /*

    @GET("Offer")
    Call<User> performUserLogin(@Query ("AppId") String appid,
                                @Query("AnID") String anid);
                                */

}
