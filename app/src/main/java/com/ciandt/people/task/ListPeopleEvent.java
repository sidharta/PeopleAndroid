package com.ciandt.people.task;

import com.ciandt.people.entity.People;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

/**
 * Created by snoleto on 03/10/15.
 */
@ToString
@Getter
public class ListPeopleEvent {

    private List<People> list;

    public ListPeopleEvent(List<People> list) {
        this.list = list;
    }

}
