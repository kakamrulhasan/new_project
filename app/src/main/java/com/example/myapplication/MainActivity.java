package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText email , password;
    Button btn;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email_id);
        password = findViewById(R.id.password_id);
        btn = findViewById(R.id.button_id);
        auth = FirebaseAuth.getInstance();
        Button login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, siginActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            String email1;
            String password1 ;
            @Override
            public void onClick(View v) {
                email1 = email.getText().toString();
                password1 = password.getText().toString();
                if (email1.isEmpty() || password1.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Fillup all of requirements", Toast.LENGTH_SHORT).show();
                } else {
                    regis();

                }


            }
            private void regis() {
                auth.createUserWithEmailAndPassword(email1,password1).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            Toast.makeText(MainActivity.this, "successfully registered", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this, "failed!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}