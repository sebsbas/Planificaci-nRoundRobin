package com.example.planificacinroundrobin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class Tehory5 extends AppCompatActivity {

    private ImageButton btnNext;
    private ImageButton btnRestore;
    private ImageButton btnHome;
    private EditText text;

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
        setContentView(R.layout.activity_tehory5);

        text = (EditText) findViewById(R.id.txtDefinition5);
        text.setKeyListener(null);

        btnNext = (ImageButton) findViewById(R.id.btnNext5);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tehory5.this, Example.class);

                activityLauncher.launch(intent);

            }
        });

        btnRestore = (ImageButton) findViewById(R.id.btnBack5);
        btnRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tehory5.this, Tehory4.class);

                activityLauncher.launch(intent);

            }
        });

        btnHome = (ImageButton) findViewById(R.id.btnHome5);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tehory5.this, MainActivity.class);

                activityLauncher.launch(intent);

            }
        });
    }
}