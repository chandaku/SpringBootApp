package com.learn.springboot.model;

import java.io.Serializable;

public class Greetings implements Serializable {
    private String msg;
    private String name;

    public Greetings() {

    }

    public Greetings(String msg, String name) {
        this.msg = msg;
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return msg + ", " + name + "!";
    }
}
