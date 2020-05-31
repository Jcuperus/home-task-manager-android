package com.team4.hometaskmanager.tasks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.team4.hometaskmanager.R;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private Task[] tasksDataSet;

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView descriptionTextView;

        public TaskViewHolder(View view) {
            super(view);
            this.titleTextView = view.findViewById(R.id.title_text_view);
            this.descriptionTextView = view.findViewById(R.id.description_text_view);
        }
    }

    public TaskAdapter(Task[] tasksDataSet) {
        this.tasksDataSet = tasksDataSet;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_row_item, parent, false);

        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = tasksDataSet[position];
        holder.titleTextView.setText(task.name);
        holder.descriptionTextView.setText(task.description);
    }

    @Override
    public int getItemCount() {
        return tasksDataSet.length;
    }
}
