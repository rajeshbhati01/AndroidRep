package com.ganesh.avikaenterntement;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment {


    private TextView textView;
    private Button logout_btn;
    OnLogoutListner logoutListner;
    public interface  OnLogoutListner
    {
        public void logoutPerformed();
    }
    public WelcomeFragment() {
        // Required empty public constructor
    }



    /*

     Process: com.ganesh.avikaenterntement, PID: 5103
                  java.lang.NullPointerException: Attempt to invoke interface method 'void android.view.inputmethod.InputConnection.closeConnection()'
                  on a null object reference
                      at android.view.inputmethod.InputConnectionWrapper.closeConnection(InputConnectionWrapper.java:270)
                      at com.android.internal.view.IInputConnectionWrapper.executeMessage(IInputConnectionWrapper.java:553)
                      at com.android.internal.view.IInputConnectionWrapper$MyHandler.handleMessage(IInputConnectionWrapper.java:93)
                      at android.os.Handler.dispatchMessage(Handler.java:110)
                      at android.os.Looper.loop(Looper.java:203)
                      at android.app.ActivityThread.main(ActivityThread.java:6339)
                      at java.lang.reflect.Method.invoke(Native Method)
                      at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1084)
                      at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:945)
Disconnected from the target VM, address: 'localhost:8600', tra














                    Process: com.ganesh.avikaenterntement, PID: 8784
                  java.lang.NullPointerException: Attempt to invoke interface method 'void android.view.inputmethod.InputConnection.closeConnection()'
                  on a null object reference
                      at android.view.inputmethod.InputConnectionWrapper.closeConnection(InputConnectionWrapper.java:270)
                      at com.android.internal.view.IInputConnectionWrapper.executeMessage(IInputConnectionWrapper.java:553)
                      at com.android.internal.view.IInputConnectionWrapper$MyHandler.handleMessage(IInputConnectionWrapper.java:93)
                      at android.os.Handler.dispatchMessage(Handler.java:110)
                      at android.os.Looper.loop(Looper.java:203)
                      at android.app.ActivityThread.main(ActivityThread.java:6339)
                      at java.lang.reflect.Method.invoke(Native Method)
                      at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1084)
                      at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:945)


     */



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate (R.layout.fragment_welcome, container, false);
        textView=view.findViewById (R.id.welcome_txt);
        textView.setText ("Wecome   "+MainActivity.prefConfig.readName ());
        logout_btn=view.findViewById (R.id.logout_bth);
        logout_btn.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                logoutListner.logoutPerformed ();


            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach (context);
        Activity activity=(Activity)context;
        logoutListner=(OnLogoutListner)activity;
    }
}
