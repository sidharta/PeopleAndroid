package com.ciandt.people.business;

import com.ciandt.people.entity.People;
import com.ciandt.people.entity.PeopleResponse;
import com.ciandt.people.service.PeopleService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit.Call;

/**
 * Created by snoleto on 02/10/15.
 */
@Singleton
public class PeopleBusiness {

    @Inject
    PeopleService service;

    @Inject
    String auth;

    public List<People> getArchitectsFromCity(String city) throws IOException {

        Call<PeopleResponse> call = service.getPeopleFromQuery(auth, "Software Architect " + city);
        PeopleResponse res = call.execute().body();
        List<People> pList = new ArrayList<>();

        for (List<String> pData : res.getData()) {
            pList.add(new People(pData));
        }

        return pList;
    }

    public People getPerson(String login) throws IOException {

        Call<PeopleResponse> person = service.getPeopleFromQuery(auth, login);
        List<List<String>> data = person.execute().body().getData();

        People personFound = null;

        for (List<String> item : data) {
            People p = new People(item);
            if (p.getLogin().equals(login)) {
                personFound = p;
            }
        }

        return personFound;
    }

}
