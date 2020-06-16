package com.team4.hometaskmanager.groups;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team4.hometaskmanager.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditMembersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditMembersFragment extends Fragment {

    public EditMembersFragment() {
        // Required empty public constructor
    }

    public static EditMembersFragment newInstance() {
        return new EditMembersFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_edit_members, container, false);

        return v;
    }
}