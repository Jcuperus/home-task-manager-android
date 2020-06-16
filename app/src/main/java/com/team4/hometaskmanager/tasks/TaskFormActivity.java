package com.team4.hometaskmanager.tasks;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.team4.hometaskmanager.Group;
import com.team4.hometaskmanager.R;
import com.team4.hometaskmanager.databinding.ActivityTaskFormBinding;

public class TaskFormActivity extends AppCompatActivity {

    TaskViewModel taskViewModel;
    Group[] groups = new Group[] { new Group(1, "Home"), new Group(2, "Work") };

    public Integer[] filledArray(int amount){
        Integer[] array = new Integer[amount];
        for(int i=0; i<amount; i++){
            array[i] = i;
        }
        return array;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_form);

        int taskId = getIntent().getIntExtra("id", -1);
        Task task = taskId >= 0 ? Task.getTask(taskId) : new Task();

        ActivityTaskFormBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_task_form);
        taskViewModel = new TaskViewModel(task);
        binding.setTaskViewModel(taskViewModel);

        AutoCompleteTextView groupDropdown = findViewById(R.id.group_exposed_dropdown);
        groupDropdown.setAdapter(new ArrayAdapter<Group>(getApplicationContext(), R.layout.dropdown_menu_popup_item, groups));
        AutoCompleteTextView hourDropDown = findViewById(R.id.hour_drop_down);
        hourDropDown.setAdapter(new ArrayAdapter<Integer>(getApplicationContext(), R.layout.dropdown_menu_popup_item, filledArray(24)));
        AutoCompleteTextView minuteDropDown = findViewById(R.id.minute_drop_down);
        minuteDropDown.setAdapter(new ArrayAdapter<Integer>(getApplicationContext(), R.layout.dropdown_menu_popup_item, filledArray(60)));
        groupDropdown.setOnItemClickListener((parent, view, position, id) -> taskViewModel.setGroupId(groups[position].id));
    }
}