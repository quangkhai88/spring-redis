package com.tqk.bean;


/**
 * Created by khaitq
 * Date: 30/04/2018
 * Github:  https://github.com/quangkhai88
 */

public enum Gender {
    MALE("Male"), FEMALE("Female"), UNKNOWN("Unknown");

    private String name;

    Gender(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
