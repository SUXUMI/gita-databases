package com.example.len009.sqlexample;

import com.orm.SugarRecord;

/**
 * Created by len009 on 10/29/2016
 */
public class Contact extends SugarRecord {

    String name;

    String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
