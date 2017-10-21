package com.novalfakhri.android.jogjapedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.login_username);
        password = (EditText) findViewById(R.id.login_password);
        button = (Button) findViewById(R.id.login_btn);

      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                  Intent intent = new Intent(LoginActivity.this, SplashActivity.class);
                  startActivity(intent);
                  finish();
              }else{
                  Toast.makeText(LoginActivity.this, "Username & Password salah!", Toast.LENGTH_SHORT).show();
              }
          }
      });
    }
}
