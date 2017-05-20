package com.vpopovic.chataplication2017;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import org.androidannotations.annotations.EApplication;

/**
 * Created by Alen on 20-May-17.
 */

@EApplication
public class ChatApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
    }
}
