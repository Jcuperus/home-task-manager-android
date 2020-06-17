package com.team4.hometaskmanager.tasks;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class TaskViewModel extends BaseObservable {
    private Task task;

    public TaskViewModel(Task task) {
        this.task = task;
    }

    @Bindable
    public Integer getGroupId() {
        return task.groupId;
    }

    public void setGroupId(Integer groupId) {
        task.groupId = groupId;
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
