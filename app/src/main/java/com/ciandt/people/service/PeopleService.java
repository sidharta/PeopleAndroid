package com.ciandt.people.service;


import com.ciandt.people.entity.PeopleResponse;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Query;

/**
 * Created by snoleto on 02/10/15.
 */
public interface PeopleService {

    @GET("/search/json")
    Call<PeopleResponse> getPeopleFromQuery(@Header("Authorization") String auth, @Query("q") String query);

}

