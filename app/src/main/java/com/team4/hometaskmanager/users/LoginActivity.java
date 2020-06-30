package com.team4.hometaskmanager.users;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.team4.hometaskmanager.R;
import com.team4.hometaskmanager.common.RequestQueueSingleton;
import com.team4.hometaskmanager.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    public static final String ACCOUNT_TYPE_KEY = "account_type_tasks";
    public static final String AUTHENTICATION_TYPE_KEY = "auth_type";
    public static final String IS_NEW_KEY = "is_new";

    public LoginViewModel loginViewModel;
    public ActivityLoginBinding loginBinding;

    private LoginRepository loginRepository = new LoginRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginViewModel = new LoginViewModel();
        loginBinding.setUserViewModel(loginViewModel);
    }

    @Override
    public void onBackPressed() {
        //Block back press if not logged in
    }

    public void onLogin(View view) {
        Log.d("login", loginViewModel.getUser().toJson().toString());
        RequestQueueSingleton.getInstance(getApplicationContext()).addToRequestQueue(loginRepository.loginUser(loginViewModel.getUser(),
                response -> {
                    Log.d("login", response);
                    AccountManager accountManager = AccountManager.get(this);
                    Account account = new Account(loginViewModel.getUsername(), ACCOUNT_TYPE_KEY);
                    accountManager.addAccountExplicitly(account, loginViewModel.getPassword(), null);
                    accountManager.setAuthToken(account, AUTHENTICATION_TYPE_KEY, "token");
                    finish();
                },
                error -> { Log.e("login", error.toString()); }
        ));
    }
}