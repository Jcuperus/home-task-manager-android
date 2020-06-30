package com.team4.hometaskmanager.groups;

import androidx.lifecycle.ViewModel;

public class GroupsListViewModel extends ViewModel {

    private Group[] groups = new Group[]{};

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }
}