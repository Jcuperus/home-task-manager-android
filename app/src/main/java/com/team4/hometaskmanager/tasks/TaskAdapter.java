package com.team4.hometaskmanager.tasks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.team4.hometaskmanager.R;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private String[] tasksDataSet;

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;

        public TaskViewHolder(View view) {
            super(view);
            this.titleTextView = view.findViewById(R.id.title_text_view);
        }
    }

    public TaskAdapter(String[] tasksDataSet) {
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
        holder.titleTextView.setText(tasksDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return tasksDataSet.length;
    }
}
