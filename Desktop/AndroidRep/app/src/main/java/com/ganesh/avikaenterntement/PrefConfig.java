package com.ganesh.avikaenterntement;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;

public class PrefConfig {

    private SharedPreferences sharedPreferences;
    private Context context;

    public PrefConfig(Context context)
    {
        this.context=context;
        sharedPreferences=context.getSharedPreferences (context.getString (R.string.pref_file),Context.MODE_PRIVATE);
    }
    public void writeLoginStatus(boolean status)
    {

        SharedPreferences.Editor editor = sharedPreferences.edit ();

        editor.putBoolean(context.getString (R.string.pref_login_status_file),status);
        editor.commit();

       // sharedPreferences.Eeditor=sharedPreferences.edit ();
        //editor.
    }
    public boolean readLoginStatus()
    {
        return sharedPreferences.getBoolean (context.getString (R.string.pref_login_status_file),false);
    }
    public void writeName(String name)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit ();
        editor.putString (context.getString (R.string.pref_user_name),name);
        editor.commit ();



    }


    public String readName()
    {

        return  sharedPreferences.getString (context.getString (R.string.pref_user_name),"User");
    }
    public void displayTost(String message)
    {
        Toast.makeText (context,message,Toast.LENGTH_SHORT).show ();
    }
}
