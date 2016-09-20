package com.ramadhan.robby.indoorgarden;

/**
 * Created by asus on 8/29/2016.
 */

import com.firebase.client.Firebase;

/**
 * Includes one-time initialization of Firebase related code
 */
public class EvergreenApplication extends android.app.Application {
    
    @Override
    public void onCreate() {
        super.onCreate();
        /* Initialize Firebase */
        Firebase.setAndroidContext(this);
    }
}
