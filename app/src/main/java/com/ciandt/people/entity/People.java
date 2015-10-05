package com.ciandt.people.entity;

import java.util.List;

import lombok.Data;

/**
 * Created by snoleto on 02/10/15.
 */
@Data
public class People {
    String name;
    String login;
    String role;
    String coach;
    String manager;
    String city;

    public People(List<String> pieces) {
        this.name = pieces.get(0);
        this.login = pieces.get(1);
        this.role = pieces.get(4);
        this.coach = pieces.get(5);
        this.manager = pieces.get(6);
        this.city = pieces.get(7);
    }
}
