package com.example.planificacinroundrobin;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class Example extends AppCompatActivity {

    private ImageButton btnNext;
    private ImageButton btnRestore;
    private ImageButton btnHome;

    ActivityResultLauncher<Intent> activityLauncher=registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        final EditText cuantum;
        cuantum = findViewById(R.id.editTxtQ);

        final EditText tLl1;
        tLl1 = findViewById(R.id.editTxtTL1);

        final EditText tR1;
        tR1 = findViewById(R.id.editTxtTR);

        final EditText tLl2;
        tLl2 = findViewById(R.id.editTxtTL2);

        final EditText tR2;
        tR2 = findViewById(R.id.editTxtTR2);

        final EditText tLl3;
        tLl3 = findViewById(R.id.editTxtTL3);

        final EditText tR3;
        tR3 = findViewById(R.id.editTxtTR3);

        btnNext = (ImageButton) findViewById(R.id.btnNext3);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Example.this, Example2.class);

                activityLauncher.launch(intent);

            }
        });

        btnRestore = (ImageButton) findViewById(R.id.btnBack3);
        btnRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Example.this, Tehory5.class);

                activityLauncher.launch(intent);

            }
        });

        btnHome = (ImageButton) findViewById(R.id.btnHome3);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Example.this, MainActivity.class);
                intent.putExtra("quantum",cuantum.getText().toString());
                activityLauncher.launch(intent);

            }
        });

    }
}