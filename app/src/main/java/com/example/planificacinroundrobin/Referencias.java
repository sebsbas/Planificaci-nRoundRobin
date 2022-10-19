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

public class Referencias extends AppCompatActivity {

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
        setContentView(R.layout.activity_referencias);

        EditText text = (EditText) findViewById(R.id.txtReferencias);
        text.setKeyListener(null);

        ImageButton btnNext = (ImageButton) findViewById(R.id.btnNext7);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Referencias.this, Example.class);

                activityLauncher.launch(intent);

            }
        });

        ImageButton btnRestore = (ImageButton) findViewById(R.id.btnBack7);
        btnRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Referencias.this, Referencias.class);

                activityLauncher.launch(intent);

            }
        });

        ImageButton btnHome = (ImageButton) findViewById(R.id.btnHome7);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Referencias.this, MainActivity.class);

                activityLauncher.launch(intent);

            }
        });
    }
}