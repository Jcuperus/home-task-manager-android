package com.team4.hometaskmanager.groups;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.team4.hometaskmanager.R;

public class GroupEditActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_edit);
        this.recyclerView = findViewById(R.id.members_rec_view);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        for(Group group : Group.GROUPS){
            Integer key = getIntent().getExtras().getInt("key");
            if(key != null && group.id == key){
                recyclerView.setAdapter(new GroupMembersAdapter(group));
            }
        }
    }
}