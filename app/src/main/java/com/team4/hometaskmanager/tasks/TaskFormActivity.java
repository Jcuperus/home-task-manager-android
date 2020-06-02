package com.team4.hometaskmanager.tasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.team4.hometaskmanager.R;
import com.team4.hometaskmanager.databinding.ActivityTaskFormBinding;

public class TaskFormActivity extends AppCompatActivity {

    TaskViewModel taskViewModel;
    String[] groups = new String[] { "Home", "Work" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_form);

        ActivityTaskFormBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_task_form);
        taskViewModel = new TaskViewModel(Task.TASKS[0]);
        binding.setTaskViewModel(taskViewModel);

        AutoCompleteTextView groupDropdown = findViewById(R.id.group_exposed_dropdown);
        groupDropdown.setAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.dropdown_menu_popup_item, groups));
    }
}