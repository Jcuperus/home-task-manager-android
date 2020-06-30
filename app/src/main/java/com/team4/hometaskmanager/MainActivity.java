package com.team4.hometaskmanager;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.team4.hometaskmanager.groups.GroupsListFragment;
import com.team4.hometaskmanager.tasks.TasksListFragment;
import com.team4.hometaskmanager.users.LoginActivity;

public class MainActivity extends AppCompatActivity {

    public static final String CURRENT_TAB_KEY = "current_tab";

    private int currentTab = 0;
    private FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Show login component on first boot
        if (true) {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }

        // Register bottom navigation selected event
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            // Set current tab id
            currentTab = item.getItemId();

            switch (item.getItemId()) {
                case R.id.tasks_page_menu_item:
                    openFragment(new TasksListFragment());
                    return true;
                case R.id.groups_page_menu_item:
                    openFragment(new GroupsListFragment());
                    return true;
            }
            return false;
        });

        // Set default opened fragment
        currentTab = savedInstanceState != null ? savedInstanceState.getInt(CURRENT_TAB_KEY) : R.id.tasks_page_menu_item;
        bottomNavigation.setSelectedItemId(currentTab);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt(CURRENT_TAB_KEY, currentTab);
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.page_content_frame, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}