package com.team4.hometaskmanager.groups;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.team4.hometaskmanager.R;
import com.team4.hometaskmanager.tasks.Task;
import com.team4.hometaskmanager.tasks.TaskAdapter;

import java.util.ArrayList;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.GroupViewHolder> {
    public Group[] groupSet;

    public static class GroupViewHolder extends RecyclerView.ViewHolder {
        public TextView groupTextView;
        public Button groupEditButton;
        private final Context context;

        public GroupViewHolder(View view, final Context context){
            super(view);
            this.context = context;
            this.groupTextView = view.findViewById(R.id.group_item_view);
            this.groupEditButton = view.findViewById(R.id.group_edit_button);
        }
    }

    public GroupAdapter(Group[] dataset){
        this.groupSet = dataset;
    }

    @NonNull
    @Override
    public GroupAdapter.GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_row_item, parent, false);

        return new GroupAdapter.GroupViewHolder(view, view.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull final GroupAdapter.GroupViewHolder holder, int position) {
        final Group group = groupSet[position];
        holder.groupTextView.setText(group.name);
        holder.groupEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, GroupEditActivity.class);
                Bundle b = new Bundle();
                b.putInt("key", group.id);
                intent.putExtras(b);
                holder.context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount(){
        return groupSet.length;
    }

}
