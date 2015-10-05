package com.ciandt.people.entity;

import java.util.List;

import lombok.Data;

/**
 * Created by snoleto on 02/10/15.
 */
@Data
public class PeopleResponse {
    List<List<String>> data;
}
