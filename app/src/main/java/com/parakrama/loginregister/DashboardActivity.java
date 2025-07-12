package com.parakrama.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    TextView tvWelcome;
    Button btnLogout;
    SharedPrefManager spm;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        tvWelcome = findViewById(R.id.tvWelcome);
        btnLogout = findViewById(R.id.btnLogout);
        spm = new SharedPrefManager(this);
        db = new DatabaseHelper(this);

        String userEmail = spm.getEmail();
        String fullName = db.getFullName(userEmail);

        tvWelcome.setText("Welcome, " + fullName);

        btnLogout.setOnClickListener(v -> {
            spm.logout();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }
}
