package com.ciandt.people.application;

import android.util.Base64;

import com.ciandt.people.business.PeopleBusiness;
import com.ciandt.people.service.PeopleService;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by snoleto on 02/10/15.
 */
@Module
public class PeopleModule {

    @Singleton
    @Provides
    public PeopleService getPeopleService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://people.cit.com.br")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(PeopleService.class);
    }

    @Singleton
    @Provides
    public String getBasicAuth() {
        return "Basic " + Base64.encodeToString(String.format("%s:%s", "", "").getBytes(),
                Base64.NO_WRAP);
    }

    @Singleton
    @Provides
    public PeopleBusiness getPeopleBusiness(){
        return new PeopleBusiness();
    }

    @Singleton
    @Provides
    public Bus getBus(){
        return new Bus();
    }
}
