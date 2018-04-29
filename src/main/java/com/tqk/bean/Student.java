package com.tqk.bean;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * Created by khaitq
 * Date: 29/04/2018 - Paris, France
 * Github:  https://github.com/quangkhai88
 */

@RedisHash
public class Student implements Serializable {

    private static final long serialVersionUID = -6398546860689891181L;

    public enum Gender  {
        MALE, FEMALE;
    }


    private int id;

    private String name;

    private  Gender gender;

    public Student(int id, String name, Gender gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
