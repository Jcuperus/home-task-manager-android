package com.team4.hometaskmanager.tasks;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.team4.hometaskmanager.R;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private ArrayList<Task> tasksDataSet;
    private OnClickedListener taskClickedListener;
    private OnClickedListener finishClickListener;

    public TaskAdapter(ArrayList<Task> tasksDataSet, OnClickedListener taskClickedListener, OnClickedListener finishClickListener) {
        this.tasksDataSet = tasksDataSet;
        this.taskClickedListener = taskClickedListener;
        this.finishClickListener = finishClickListener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_row_item, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = tasksDataSet.get(position);
        holder.titleTextView.setText(task.name);
        holder.descriptionTextView.setText(task.description);
        holder.setOnTaskClickListener(taskClickedListener);
        holder.setOnTaskFinishClickListener(finishClickListener);
    }

    @Override
    public int getItemCount() {
        return tasksDataSet.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView descriptionTextView;
        public ImageButton finishButton;

        public TaskViewHolder(View view) {
            super(view);
            this.titleTextView = view.findViewById(R.id.title_text_view);
            this.descriptionTextView = view.findViewById(R.id.description_text_view);
            this.finishButton = view.findViewById(R.id.task_finish_button);
        }

        public void setOnTaskClickListener(OnClickedListener listener) {
            itemView.setOnClickListener(view -> listener.onTaskClicked(getAdapterPosition()));
        }

        public void setOnTaskFinishClickListener(OnClickedListener listener) {
            finishButton.setOnClickListener(view -> listener.onTaskClicked(getAdapterPosition()));
        }
    }

    public interface OnClickedListener  {
        void onTaskClicked(int position);
    }
}
