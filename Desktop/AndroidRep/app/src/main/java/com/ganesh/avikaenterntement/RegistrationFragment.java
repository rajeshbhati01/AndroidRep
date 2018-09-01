package com.ganesh.avikaenterntement;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Callback;
import retrofit2.Response;


//import retrofit2.Call<User>;




/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragment extends Fragment {

private EditText Name,Lastname,Dob,Email,Password,ConfirmPassword,Phonenumber,Gender;
private Button bnReg;

    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate (R.layout.fragment_registration, container, false);
        Name=view.findViewById (R.id.user_name_txt);
        Lastname=view.findViewById (R.id.user_lname_txt);
        Dob=view.findViewById (R.id.user_DOB_txt);
        Email=view.findViewById (R.id.user_email_txt);
        Password=view.findViewById (R.id.user_pass_txt);
        ConfirmPassword=view.findViewById (R.id.user_confrm_pass_txt);
        Gender=view.findViewById (R.id.gender_txt);
        Phonenumber=view.findViewById (R.id.user_phone_txt);

        bnReg=view.findViewById (R.id.reg_btn);
        bnReg.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                performRegistration ();

            }
        });

        return view;
    }
    public void performRegistration()
    {
        String name=Name.getText () .toString ();
        String lastname=Lastname.getText ().toString ();
        String dob=Dob.getText ().toString ();
        String email=Email.getText ().toString ();
        String password=Password.getText ().toString ();
        String confirmpassword=ConfirmPassword.getText ().toString ();
        String phonenumber=Phonenumber.getText ().toString ();
        String gender=Gender.getText ().toString ();

        String appid="An".toString ();
        String anid="12345".toString ();

        //{"AppId":"rajesh",
        // "AnID":"male",
        // "Name":"bhati",
        // "Lastname":"10-1974",
        // "Dob":"rajeshbhati01@gmail.com",
        // "Gender":"12345",
        // "Email":"12345",
        // "Password":"9812852125","ConfirmPassword":"An","Phonenumber":"12345"}
       /* Log.i ("name", name);

        Log.i ("lastname", lastname);
        Log.i ("dob",dob);
        Log.i ("email",email);
        Log.i ("password",password);
        Log.i ("phonenumber",phonenumber);
        */


       //Call<User> call=MainActivity.apiInterface.performanceRegistration (name,lastname,dob,email,password,phonenumber);
           retrofit2.Call <User> call = MainActivity.apiInterface.performanceRegistration (name,
                   gender,lastname,dob,email,password,confirmpassword,phonenumber,appid,anid);
Log.i ("AppID",appid);
        Log.i ("anid",anid);


       call.enqueue (new Callback <User> ( ) {

           /**
            * Invoked for a received HTTP response.
            * <p>
            * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
            * Call {@link Response#isSuccessful()} to determine if the response indicates success.
            *
            * @param call
            * @param response
            */
           @Override
           public void onResponse(retrofit2.Call<User> call, Response <User> response) {
               if(response.body ().getResponse ().equals ("ok"))
               {
                   MainActivity.prefConfig.displayTost ("Registration sucessfully...");
               }
               else if(response.body ().getResponse ().equals ("exist"))
               {

                   MainActivity.prefConfig.displayTost ("User Already Register...");
               }

               else if(response.body ().getResponse ().equals ("error"))
               {

                   MainActivity.prefConfig.displayTost ("Some Thing Went wrong...");
               }

           }

           @Override
           public void onFailure(retrofit2.Call<User> call, Throwable t) {

           }
       });
Name.setText (" ");
Lastname.setText (" ");
Dob.setText (" ");
Email.setText (" ");
Password.setText (" ");
ConfirmPassword.setText (" ");
Phonenumber.setText (" ");



    }

}
