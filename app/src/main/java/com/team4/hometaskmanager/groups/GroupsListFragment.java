package com.team4.hometaskmanager.groups;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team4.hometaskmanager.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GroupsListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GroupsListFragment extends Fragment {
    public RecyclerView recyclerView;
    public RecyclerView.Adapter adapter;
    public RecyclerView.LayoutManager manager;

    public GroupsListFragment(){}

    public GroupsListFragment newInstance(){
        return new GroupsListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_groups_list, container, false);
        recyclerView = view.findViewById(R.id.groups_view);
        recyclerView.setHasFixedSize(true);
        manager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(manager);
        adapter = new GroupAdapter(Group.GROUPS);
        recyclerView.setAdapter(adapter);
        return view;
    }
}