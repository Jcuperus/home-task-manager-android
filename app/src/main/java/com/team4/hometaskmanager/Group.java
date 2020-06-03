package com.team4.hometaskmanager;

import androidx.annotation.NonNull;

public class Group {
    public Integer id;
    public String name;

    public Group(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    @NonNull
    public String toString() {
        return name;
    }
}
