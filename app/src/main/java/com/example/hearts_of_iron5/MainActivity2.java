package com.example.hearts_of_iron5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    Button GerButton;
    Button PolButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        GerButton = findViewById(R.id.button3);
        PolButton = findViewById(R.id.button4);
        GerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("VIPint", 0);
                startActivity(intent);
            }
        });
        PolButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("VIPint", 1);
                startActivity(intent);
            }
        });

    }
}