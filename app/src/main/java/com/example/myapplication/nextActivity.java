package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class nextActivity extends AppCompatActivity {

    EditText name , age ;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        name = findViewById(R.id.name_id);
        age = findViewById(R.id.number_id);
        next = findViewById(R.id.next_id);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> m = new HashMap<>();
                m.put("name ", name.getText().toString());
                m.put("age", age.getText().toString());

                FirebaseDatabase.getInstance().getReference()
                        .child("vendor2")
                        .push()
                        .setValue(m);
            }
        });
    }
}