package com.example.pritesh.mymvp.BackTask;

import android.app.Application;
import android.content.Context;

/**
 * Created by yashwant on 6/17/2016.
 */
public class Myapp extends Application {

    private static Myapp instance;
   /* RequestQueue request;
    public  static   EtrackDatabase proj;*/
    public static String NOTIFICATION_URL ="http://www.magicdil.com";
    public static final String TAG = Myapp.class.getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;


    }

    public static Myapp getInstance()
    {

        return instance;
    }



    public static Context getapContext(){


        return instance.getApplicationContext();
    }



}