package com.example.americanairline;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

//        ParseObject.registerSubclass(Products.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("qM6zagR6d2SgISA6xpFd9oqvgDnRynJJ9RnNnKsH")
                .clientKey("uNOuapKMqxLxnzkySSDd9bDwE6cLpNm97hy2ioa8")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
