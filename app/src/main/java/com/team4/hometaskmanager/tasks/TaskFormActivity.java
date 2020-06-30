package com.team4.hometaskmanager.tasks;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.team4.hometaskmanager.R;
import com.team4.hometaskmanager.common.RequestQueueSingleton;
import com.team4.hometaskmanager.databinding.ActivityTaskFormBinding;
import com.team4.hometaskmanager.groups.Group;
import com.team4.hometaskmanager.groups.GroupsListViewModel;
import com.team4.hometaskmanager.groups.GroupsRepository;

import org.json.JSONException;

public class TaskFormActivity extends AppCompatActivity {

    TaskViewModel taskViewModel;
    ActivityTaskFormBinding binding;
    GroupsListViewModel groupsViewModel;

    private GroupsRepository groupsRepository = new GroupsRepository();
    private TasksRepository tasksRepository = new TasksRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_form);

        tasksRepository.setContext(getApplicationContext());
        groupsRepository.setContext(getApplicationContext());

        groupsViewModel = new ViewModelProvider(this).get(GroupsListViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_task_form);
        taskViewModel = new TaskViewModel(new Task());
        binding.setTaskViewModel(taskViewModel);

        if (groupsViewModel.getGroups() == null || groupsViewModel.getGroups().length == 0) {
            loadGroups();
        } else {
            buildView();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.form_save_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_save_button:
                RequestQueueSingleton.getInstance(getApplicationContext()).addToRequestQueue(tasksRepository.saveTask(taskViewModel.getTask(),
                        response -> {
                            try {
                                Toast.makeText(getApplicationContext(), response.getString("message"), Toast.LENGTH_SHORT).show();
                            } catch (JSONException ignored) {}
                            finish();
                        },
                        error -> Log.d("error", error.toString())
                ));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void loadGroups() {
        RequestQueueSingleton.getInstance(getApplicationContext()).addToRequestQueue(groupsRepository.getGroups(
                groups -> {
                    groupsViewModel.setGroups(groups);
                    buildView();
                },
                error -> Log.e("Groups", error.toString())
        ));
    }

    private void loadTask(int taskId) {
        RequestQueueSingleton.getInstance(getApplicationContext()).addToRequestQueue(tasksRepository.getTask(taskId,
            task -> {
                taskViewModel.setTask(task);
                binding.invalidateAll();
            },
            error -> Log.e("Task form", error.toString())
        ));
    }

    private void buildView() {
        AutoCompleteTextView groupDropdown = findViewById(R.id.group_dropdown);
        ArrayAdapter<Group> groupArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, groupsViewModel.getGroups());  //new ArrayAdapter<>(getApplicationContext(), R.layout.dropdown_menu_popup_item, groupsViewModel.groups);
        groupDropdown.setAdapter(groupArrayAdapter);
        groupDropdown.setOnItemClickListener((parent, view, position, id) -> {
            taskViewModel.setGroup(groupsViewModel.getGroups()[position]);
        });

        //TODO: Re add reminders
//        AutoCompleteTextView hourDropDown = findViewById(R.id.hour_drop_down);
//        hourDropDown.setAdapter(new ArrayAdapter<Integer>(getApplicationContext(), R.layout.dropdown_menu_popup_item, filledArray(24)));
//        AutoCompleteTextView minuteDropDown = findViewById(R.id.minute_drop_down);
//        minuteDropDown.setAdapter(new ArrayAdapter<Integer>(getApplicationContext(), R.layout.dropdown_menu_popup_item, filledArray(60)));

        int taskId = getIntent().getIntExtra("id", 0);

        if (taskId > 0) {
            loadTask(taskId);
        }
    }

    private Integer[] filledArray(int amount){
        Integer[] array = new Integer[amount];
        for(int i=0; i<amount; i++){
            array[i] = i;
        }
        return array;
    }
}