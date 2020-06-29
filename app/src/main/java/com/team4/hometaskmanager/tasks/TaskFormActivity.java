package com.team4.hometaskmanager.tasks;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.team4.hometaskmanager.groups.Group;
import com.team4.hometaskmanager.R;
import com.team4.hometaskmanager.common.RequestQueueSingleton;
import com.team4.hometaskmanager.databinding.ActivityTaskFormBinding;
import com.team4.hometaskmanager.groups.GroupsListViewModel;
import com.team4.hometaskmanager.groups.GroupsRepository;

import java.util.Arrays;

public class TaskFormActivity extends AppCompatActivity {

    TaskViewModel taskViewModel;
    ActivityTaskFormBinding binding;
    GroupsListViewModel groupsViewModel;
    ArrayAdapter<Group> groupsAdapter;
    Spinner groupDropdown;

    private GroupsRepository groupsRepository = new GroupsRepository();
    private TasksRepository tasksRepository = new TasksRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_form);

        groupsViewModel = new ViewModelProvider(this).get(GroupsListViewModel.class);

//        if (groupsViewModel.groups.isEmpty()) {
//            loadGroups();
//        }

        int taskId = getIntent().getIntExtra("id", 0);

        if (taskId > 0) {
            loadTask(taskId);
        }

        groupDropdown = findViewById(R.id.group_spinner);
        groupsAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, groupsViewModel.groups);  //new ArrayAdapter<>(getApplicationContext(), R.layout.dropdown_menu_popup_item, groupsViewModel.groups);
        groupsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        groupDropdown.setAdapter(groupsAdapter);
        groupDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                taskViewModel.setGroupId(groupsViewModel.groups.get(position).id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//        AutoCompleteTextView hourDropDown = findViewById(R.id.hour_drop_down);
//        hourDropDown.setAdapter(new ArrayAdapter<Integer>(getApplicationContext(), R.layout.dropdown_menu_popup_item, filledArray(24)));
//        AutoCompleteTextView minuteDropDown = findViewById(R.id.minute_drop_down);
//        minuteDropDown.setAdapter(new ArrayAdapter<Integer>(getApplicationContext(), R.layout.dropdown_menu_popup_item, filledArray(60)));

        Task task = new Task();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_task_form);
        taskViewModel = new TaskViewModel(task);
        binding.setTaskViewModel(taskViewModel);
    }

    private void loadGroups() {
        RequestQueueSingleton.getInstance(getApplicationContext()).addToRequestQueue(groupsRepository.getGroups(
                groups -> {
                    groupsViewModel.groups.clear();
                    groupsViewModel.groups.addAll(Arrays.asList(groups));
                    groupsAdapter.notifyDataSetChanged();
                },
                error -> Log.e("Groups", error.toString())
        ));
    }

    private void loadTask(int taskId) {
        RequestQueueSingleton.getInstance(getApplicationContext()).addToRequestQueue(tasksRepository.getTask(taskId,
            task -> binding.setTaskViewModel(new TaskViewModel(task)),
            error -> Log.e("Task form", error.toString())
        ));
    }

    private Integer[] filledArray(int amount){
        Integer[] array = new Integer[amount];
        for(int i=0; i<amount; i++){
            array[i] = i;
        }
        return array;
    }
}