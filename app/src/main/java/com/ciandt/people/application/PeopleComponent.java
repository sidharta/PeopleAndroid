package com.ciandt.people.application;

import com.ciandt.people.MainActivity;
import com.ciandt.people.business.PeopleBusiness;
import com.ciandt.people.service.PeopleService;
import com.ciandt.people.task.PeopleAsyncTask;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by snoleto on 03/10/15.
 */
@Singleton
@Component(modules = {PeopleModule.class})
public interface PeopleComponent {

    PeopleService peopleService();
    String basicAuth();
    PeopleBusiness peopleBusiness();
    Bus bus();

    void inject(PeopleBusiness business);
    void inject(MainActivity activity);
    void inject(PeopleAsyncTask task);

    public final static class Initializer {
        public static PeopleComponent init() {
            return DaggerPeopleComponent.builder()
                    .peopleModule(new PeopleModule())
                    .build();
        }
    }
}