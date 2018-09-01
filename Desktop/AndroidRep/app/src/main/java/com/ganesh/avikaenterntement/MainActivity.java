package com.ganesh.avikaenterntement;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements LoginFragment.OnLoginFormActivityListner,
        WelcomeFragment.OnLogoutListner {

    public static PrefConfig prefConfig;
    public static ApiInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        prefConfig=new PrefConfig (this);

        apiInterface=Apiclient.getApiClient ().create(ApiInterface.class);



        if(findViewById (R.id.fragement_container)!=null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }
            if(prefConfig.readLoginStatus ())
            {
                getSupportFragmentManager ().beginTransaction ().add (R.id.fragement_container, new WelcomeFragment ()).commit ();//comm)
            }
            else
            {
                getSupportFragmentManager ().beginTransaction ().add (R.id.fragement_container,new LoginFragment ()).commit () ;


            }

        }


    }


    @Override
    public void performRegister() {

        getSupportFragmentManager ().beginTransaction ().replace (R.id.fragement_container,
                new RegistrationFragment ()).addToBackStack (null).commit ();
    }

    @Override
    public void performLogin(String name) {
        prefConfig.writeName (name);
        getSupportFragmentManager ().beginTransaction ().replace (R.id.fragement_container,new WelcomeFragment ()).commit ();


    }

    @Override
    public void logoutPerformed() {
        prefConfig.writeLoginStatus (false);
        prefConfig.writeName ("User");

        getSupportFragmentManager ().beginTransaction ().replace (R.id.fragement_container,new LoginFragment ()).commit ();


    }
}
