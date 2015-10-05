package com.ciandt.people.task;

import android.os.AsyncTask;

import com.ciandt.people.application.PeopleComponent;
import com.ciandt.people.business.PeopleBusiness;
import com.ciandt.people.entity.People;
import com.squareup.otto.Bus;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by snoleto on 03/10/15.
 */
public class PeopleAsyncTask extends AsyncTask<Void, Void, List<People>> {

    @Inject
    PeopleBusiness business;

    @Inject
    Bus bus;

    public PeopleAsyncTask(PeopleComponent g) {
        g.inject(this);
        g.inject(business);
    }

    @Override
    protected List<People> doInBackground(Void... params) {
        List<People> archs = null;
        try {
            archs = business.getArchitectsFromCity("BH");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return archs;
    }

    @Override
    protected void onPostExecute(List<People> people) {
        bus.post(new ListPeopleEvent(people));
    }
}
