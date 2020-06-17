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

    public static final Task[] TASKS = {
        new Task(1, 1, "Feed cat", "Give him the good stuff","9", "30", false),
        new Task(2, 1, "Do the dishes", "Please don't make me do it again", "19", "15", false),
        new Task(3, 2, "Do some paperwork", "Boy do I love me some paperwork", "20", "0", false)
    };

    public static Task getTask(Integer taskId) {
        Task task = null;

        for (Task currentTask: TASKS) {
            if (currentTask.id.equals(taskId)) task = currentTask;
        }

        return task;
    }
}
