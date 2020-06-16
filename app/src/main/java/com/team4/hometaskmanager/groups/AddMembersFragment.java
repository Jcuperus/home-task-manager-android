package com.team4.hometaskmanager.groups;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.team4.hometaskmanager.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Objects;

public class AddMembersFragment extends Fragment {

    private TextView textView;
    private Button removeButton;
    public AddMembersFragment(){
    }

    public static AddMembersFragment newInstance(){
        return new AddMembersFragment();
    }

    public void setTextView(String text){
        this.textView.setText(text);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String memberName = getArguments().getString("member", "");
        System.out.println(inflater.inflate(R.layout.fragment_add_members, container, false));
        View view = inflater.inflate(R.layout.fragment_add_members, container, false);
        this.textView = (TextView) view.findViewById(R.id.textView2);
        setTextView(memberName);
        this.removeButton = (Button) view.findViewById(R.id.delete_button);
        this.removeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().remove(AddMembersFragment.this).commit();
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("hallo", "onCreate: MemberFragment");
    }
}