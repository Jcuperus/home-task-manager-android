package com.team4.hometaskmanager.users;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.team4.hometaskmanager.R;
import com.team4.hometaskmanager.common.RequestQueueSingleton;
import com.team4.hometaskmanager.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

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
        RequestQueueSingleton.getInstance(getApplicationContext()).addToRequestQueue(loginRepository.loginUser(loginViewModel.getUser(),
                response -> {
                    AccountManager accountManager = AccountManager.get(this);
                    Account account = new Account(loginViewModel.getUsername(), UserAuthenticator.ACCOUNT_TYPE_KEY);
                    accountManager.addAccountExplicitly(account, loginViewModel.getPassword(), null);
                    accountManager.setAuthToken(account, UserAuthenticator.AUTHENTICATION_TYPE_KEY, response);
                    finish();
                },
                error -> { Log.e("login", error.toString()); }
        ));
    }
}