package com.team4.hometaskmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class TasksListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter taskAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_list);

        // Initialize recycler view
        recyclerView = (RecyclerView) findViewById(R.id.tasks_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        taskAdapter = new TaskAdapter(new String[]{"Task 1", "Task 2", "Task 3"});
        recyclerView.setAdapter(taskAdapter);
    }
}