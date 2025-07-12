package com.parakrama.loginregister;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {
    private static final String PREF_NAME = "auth_pref";
    private static final String KEY_EMAIL = "email";
    private final SharedPreferences sp;
    private final SharedPreferences.Editor editor;

    public SharedPrefManager(Context context) {
        sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public void saveLogin(String email) {
        editor.putString(KEY_EMAIL, email);
        editor.apply();
    }

    public boolean isLoggedIn() {
        return sp.contains(KEY_EMAIL);
    }

    public String getEmail() {
        return sp.getString(KEY_EMAIL, null);
    }

    public void logout() {
        editor.clear();
        editor.apply();
    }
}
