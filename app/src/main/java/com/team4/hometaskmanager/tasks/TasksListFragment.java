package com.team4.hometaskmanager.tasks;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.team4.hometaskmanager.R;
import com.team4.hometaskmanager.groups.GroupFormActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TasksListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TasksListFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter taskAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public TasksListFragment() {
        // Required empty public constructor
    }

    public static TasksListFragment newInstance() {
        return new TasksListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tasks_list, container, false);

        // Initialize recycler view
        recyclerView = view.findViewById(R.id.tasks_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);

        taskAdapter = new TaskAdapter(Task.TASKS, position -> startActivity(getTaskFormIntent(Task.TASKS[position].id)));
        recyclerView.setAdapter(taskAdapter);

        // Register floating button click handler
        FloatingActionButton floatingActionButton = view.findViewById(R.id.create_task_button);
        floatingActionButton.setOnClickListener(v -> startActivity(getTaskFormIntent()));

        FloatingActionButton floatingActionButton1 = view.findViewById(R.id.floatingActionButton);
        floatingActionButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(getContext(), GroupFormActivity.class));
            }
        });

        return view;
    }

    private Intent getTaskFormIntent() {
        return new Intent(getContext(), TaskFormActivity.class);
    }

    private Intent getTaskFormIntent(int taskId) {
        return getTaskFormIntent().putExtra("id", taskId);
    }
}