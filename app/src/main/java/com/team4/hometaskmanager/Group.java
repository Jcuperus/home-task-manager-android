package com.team4.hometaskmanager;

public class Group {
    public Integer id;
    public String name;

    public Group(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
