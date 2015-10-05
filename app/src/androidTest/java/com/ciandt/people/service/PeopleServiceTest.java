package com.ciandt.people.service;

import android.test.InstrumentationTestCase;

import com.ciandt.people.application.App;
import com.ciandt.people.application.PeopleComponent;
import com.ciandt.people.entity.People;
import com.ciandt.people.entity.PeopleResponse;

import java.io.IOException;

import javax.inject.Inject;

import retrofit.Call;

/**
 * Created by snoleto on 02/10/15.
 */
public class PeopleServiceTest extends InstrumentationTestCase {

    @Inject
    PeopleService service;

    @Inject
    String auth;

    @Override
    protected void setUp() throws Exception {
        App app = (App) getInstrumentation().getTargetContext().getApplicationContext();
        PeopleComponent g = app.graph();
        this.service =  g.peopleService();
        this.auth  = g.basicAuth();
    }

    public void testRequestWithData() throws IOException {
        Call<PeopleResponse> peopleList = service.getPeopleFromQuery(auth, "akieras");
        PeopleResponse res = peopleList.execute().body();

        assertNotNull(res);
        assertTrue(res.getData().size() > 0);
    }

    public void testRequestConvertingToPeople() throws IOException {
        Call<PeopleResponse> peopleList = service.getPeopleFromQuery(auth, "akieras");
        PeopleResponse res = peopleList.execute().body();
        People p = new People(res.getData().get(0));

        assertNotNull(res);
        assertNotNull(p.getLogin());
    }

}

