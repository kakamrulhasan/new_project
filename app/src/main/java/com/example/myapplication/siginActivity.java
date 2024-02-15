package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class siginActivity extends AppCompatActivity {

    EditText emails , passwords;
    Button signin;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigin);
        emails = findViewById(R.id.siemail_id);
        passwords = findViewById(R.id.sipassword_id);
        signin = findViewById(R.id.sibutton_id);
        auth = FirebaseAuth.getInstance();
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email2 = emails.getText().toString();
                String password2 = passwords.getText().toString();
                if (email2.isEmpty() || password2.isEmpty()) {
                    Toast.makeText(siginActivity.this, "Fillup all of requirements", Toast.LENGTH_SHORT).show();
                } else {

                    auth.signInWithEmailAndPassword(email2, password2).addOnSuccessListener(siginActivity.this, new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {

                            startActivity(new Intent(siginActivity.this, nextActivity.class));
                            Toast.makeText(siginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}