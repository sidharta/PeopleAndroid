package com.ciandt.people.application;

import android.app.Application;

/**
 * Created by snoleto on 03/10/15.
 */
public class App extends Application {

    private PeopleComponent peopleComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        //Fabric.with(this, new Crashlytics());

        peopleComponent = PeopleComponent.Initializer.init();
    }

    public PeopleComponent graph() {
        return peopleComponent;
    }

}
