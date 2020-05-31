package com.team4.hometaskmanager.tasks;

public class Task {
    public Integer id;
    public Integer groupId;
    public String name;
    public String description;
    public boolean isDone;

    public Task(Integer id, Integer groupId, String name, String description, boolean isDone) {
        this.id = id;
        this.groupId = groupId;
        this.name = name;
        this.description = description;
        this.isDone = isDone;
    }

    public static final Task[] TASKS = {
        new Task(1, 1, "Feed cat", "Give him the good stuff", false),
        new Task(2, 1, "Do the dishes", "Please don't make me do it again", false),
        new Task(3, 2, "Do some paperwork", "Boy do I love me some paperwork", false)
    };
}
