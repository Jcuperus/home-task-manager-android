package com.team4.hometaskmanager.tasks;

import com.team4.hometaskmanager.groups.Group;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class Task {
    public Integer id;
    public Group group;
    public String name;
    public String description;
    public Date dueDate;
    public String hour;
    public String minute;
    public boolean isDone;

    public Task() {

    }

    public Task(Integer id, Group group, String name, String description, String reminderHour, String reminderMinute, boolean isDone) {
        this.id = id;
        this.group = group;
        this.name = name;
        this.description = description;
        this.hour = reminderHour;
        this.minute = reminderMinute;
        this.isDone = isDone;
    }

    public JSONObject toJson() {
        try {
            JSONObject taskJson = new JSONObject();
            taskJson.put("id", id);
            taskJson.put("group", group.toJson());
            taskJson.put("name", name);
            taskJson.put("description", description);
            taskJson.put("dueDate", dueDate);
            taskJson.put("isDone", isDone);
            return taskJson;
        } catch (JSONException e) {
            return null;
        }
    }
}
