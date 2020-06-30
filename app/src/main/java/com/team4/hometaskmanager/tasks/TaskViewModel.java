package com.team4.hometaskmanager.tasks;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.team4.hometaskmanager.groups.Group;

public class TaskViewModel extends BaseObservable {
    private Task task;
    private Group[] groups;

    public TaskViewModel(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Bindable
    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    @Bindable
    public Group getGroup() {
        return task.group;
    }

    public void setGroup(Group group) {
        task.group = group;
    }

    @Bindable
    public String getName() {
        return task.name;
    }

    public void setName(String name) {
        task.name = name;
    }

    @Bindable
    public String getDescription() {
        return task.description;
    }

    public void setDescription(String description) {
        task.description = description;
    }

    @Bindable
    public String getHour(){
        return task.hour;
    }

    public void setHour(String hour){
        task.hour = hour;
    }

    @Bindable
    public String getMinute(){
        return task.minute;
    }

    public void setMinute(String minute){
        task.minute = minute;
    }
}
