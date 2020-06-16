package com.team4.hometaskmanager.groups;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.team4.hometaskmanager.R;

import org.w3c.dom.Text;

import java.io.IOException;

public class GroupFormActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_form);

        Button addButton = (Button) findViewById(R.id.add_member);
        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                newFragment(new AddMembersFragment());
            }
        });
    }

    public void newFragment(final AddMembersFragment fragment){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        EditText text = (EditText) findViewById(R.id.name_of_member_field);
        String memberName = text.getText().toString();
        Bundle args = new Bundle();
        args.putString("member", memberName);
        fragment.setArguments(args);
        transaction.add(R.id.members_list_layout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}