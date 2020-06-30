package com.team4.hometaskmanager.users;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class UserAuthenticationService extends Service {

    private UserAuthenticator authenticator;

    @Override
    public void onCreate() {
        super.onCreate();
        authenticator = new UserAuthenticator(this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return authenticator.getIBinder();
    }
}
