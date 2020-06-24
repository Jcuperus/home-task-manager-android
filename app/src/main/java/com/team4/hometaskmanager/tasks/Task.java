package com.team4.hometaskmanager.tasks;

public class Task {
    public Integer id;
    public Integer groupId;
    public String name;
    public String description;
    public String hour;
    public String minute;
    public boolean isDone;

    public Task() {

    }

    public Task(Integer id, Integer groupId, String name, String description, String reminderHour, String reminderMinute, boolean isDone) {
        this.id = id;
        this.groupId = groupId;
        this.name = name;
        this.description = description;
        this.hour = reminderHour;
        this.minute = reminderMinute;
        this.isDone = isDone;
    }

    public static Task getTask(Integer taskId) {
        return null;
    }
}
