package com.team4.hometaskmanager.groups;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.team4.hometaskmanager.R;

public class GroupMembersAdapter extends RecyclerView.Adapter<GroupMembersAdapter.MembersViewHolder> {
    protected Group group;

    public static class MembersViewHolder extends RecyclerView.ViewHolder{
        public TextView memberTextView;

        public MembersViewHolder(@NonNull View itemView) {
            super(itemView);
            this.memberTextView = itemView.findViewById(R.id.group_member_name_view);
        }
    }

    public GroupMembersAdapter(Group group){
        this.group = group;
    }
    @NonNull
    @Override
    public MembersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_member_item, parent, false);
        return new GroupMembersAdapter.MembersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MembersViewHolder holder, int position) {
        User member = group.members[position];
        holder.memberTextView.setText(member.name);
    }

    @Override
    public int getItemCount() {
        return group.members.length;
    }
}
