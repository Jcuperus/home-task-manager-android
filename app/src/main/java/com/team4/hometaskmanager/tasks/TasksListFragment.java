package com.team4.hometaskmanager.tasks;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.team4.hometaskmanager.R;
import com.team4.hometaskmanager.common.GsonRequest;
import com.team4.hometaskmanager.common.RequestQueueSingleton;
import com.team4.hometaskmanager.groups.GroupFormActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TasksListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TasksListFragment extends Fragment {

    public static final String API_URL = "http://tasks.jaep.nl/tasks";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter taskAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private TasksListViewModel viewModel;
    private TasksRepository tasksRepository = new TasksRepository();

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

        viewModel = new ViewModelProvider(this).get(TasksListViewModel.class);

        if (viewModel.tasks.size() == 0) {
            updateTasks();
        }

        // Initialize recycler view
        recyclerView = view.findViewById(R.id.tasks_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        taskAdapter = new TaskAdapter(viewModel.tasks,
                position -> startActivity(getTaskFormIntent(viewModel.tasks.get(position).id)),
                position -> Log.d("task", "Finished " + position) // TODO: Finish task
        );
        recyclerView.setAdapter(taskAdapter);

        // Register floating button click handler
        FloatingActionButton floatingActionButton = view.findViewById(R.id.create_task_button);
        floatingActionButton.setOnClickListener(v -> startActivity(getTaskFormIntent()));

        return view;
    }

    private Intent getTaskFormIntent() {
        return new Intent(getContext(), TaskFormActivity.class);
    }

    private Intent getTaskFormIntent(int taskId) {
        return getTaskFormIntent().putExtra("id", taskId);
    }

    private void updateTasks() {
        // Fetch tasks data
        Request<Task[]> request = tasksRepository.getTasks(this::updateTasksViewData, error -> Log.d("tasks", error.toString()));
        RequestQueueSingleton.getInstance(getContext()).addToRequestQueue(request);
    }

    private void updateTasksViewData(Task[] tasks) {
        recyclerView.removeAllViews();
        viewModel.tasks.clear();
        viewModel.tasks.addAll(Arrays.asList(tasks));
        taskAdapter.notifyDataSetChanged();
    }
}