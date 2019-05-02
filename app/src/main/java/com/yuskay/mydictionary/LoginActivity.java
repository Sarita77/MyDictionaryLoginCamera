package com.yuskay.mydictionary;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckUser();
            }
        });


    }

    private void CheckUser() {
        SharedPreferences sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");

        if (username.equals(etUsername.getText().toString()) ||
                password.equals(etPassword.getText().toString())) {
            Toast.makeText(LoginActivity.this, "Successful", Toast.LENGTH_SHORT).show();
            //Open the login dashboard
        } else {
            Toast.makeText(LoginActivity.this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
        }

    }

}
