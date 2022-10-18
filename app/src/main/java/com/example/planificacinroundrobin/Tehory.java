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

public class Tehory extends AppCompatActivity {

    private ImageButton btnContinue;
    private ImageButton btnHome;
    private ImageButton btnRestore;
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
        setContentView(R.layout.activity_tehory);
        text = (EditText) findViewById(R.id.txtDefinition);
        text.setKeyListener(null);
        btnContinue = (ImageButton) findViewById(R.id.btnNext);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tehory.this, Tehory2.class);

                activityLauncher.launch(intent);

            }
        });

        btnRestore = (ImageButton) findViewById(R.id.btnBack);
        btnRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tehory.this, MainActivity.class);

                activityLauncher.launch(intent);

            }
        });

        btnHome = (ImageButton) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tehory.this, MainActivity.class);

                activityLauncher.launch(intent);

            }
        });
    }
}