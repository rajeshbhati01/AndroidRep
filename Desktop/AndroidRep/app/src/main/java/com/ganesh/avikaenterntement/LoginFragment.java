package com.ganesh.avikaenterntement;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    private EditText useremail ,userpassword;
    private Button btn_login;
 //onLoginFormActivityListner
 private TextView regText;

 //OnLoginFormActivityListner onLoginFormActivityListner;
    OnLoginFormActivityListner onLoginFormActivityListner;
    public interface OnLoginFormActivityListner

{
    public void performRegister();
    public void performLogin(String name );

}

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate (R.layout.fragment_login, container, false);
        regText=view.findViewById (R.id.register_txt);
        useremail=view.findViewById (R.id.user_name);
        userpassword=view.findViewById (R.id.user_pass);
        btn_login=view.findViewById (R.id.login_btn);

        btn_login.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                performLogin ();


            }
        });

        regText.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {

            onLoginFormActivityListner.performRegister ();

            }
        });
      return view;

    }

    @Override
    public void onAttach(Context context) {

        super.onAttach (context);
        Activity activity=(Activity) context;
        onLoginFormActivityListner=(OnLoginFormActivityListner) activity;
    }

    private void performLogin()
    {
        String username=useremail.getText ().toString ();
        String password=userpassword.getText ().toString ();
        String appid="An";
        String anid="12345";
        String reg=username;

        Call<User> call=MainActivity.apiInterface.performUserLogin (username,password,appid,anid,reg);
        call.enqueue (new Callback <User> ( ) {
            @Override
            public void onResponse(Call <User> call, Response<User> response) {

                if(response.body ().getResponse ().equals ("ok"))
                {
                   MainActivity.prefConfig.writeLoginStatus (true);

                   onLoginFormActivityListner.performLogin (response.body ().getName ());
                }
                else if(response.body ().getResponse ().equals ("failure"))
                {

                    MainActivity.prefConfig.displayTost ("Login failed  ..Please try..again");

                }
                else if(response.body ().getResponse ().equals ("missingparamater"))
                {

                    MainActivity.prefConfig.displayTost ("Required paramater is missing");

                }

            }

            @Override
            public void onFailure(Call <User> call, Throwable t) {

            }
        });
        useremail.setText (" ");
        userpassword.setText (" ");
    }
}
