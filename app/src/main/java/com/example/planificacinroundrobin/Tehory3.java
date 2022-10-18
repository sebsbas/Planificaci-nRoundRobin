package com.example.planificacinroundrobin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class Tehory3 extends AppCompatActivity {

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
        setContentView(R.layout.activity_tehory3);

        text = (EditText) findViewById(R.id.txtDefinition3);
        text.setKeyListener(null);

        btnNext = (ImageButton) findViewById(R.id.btnNext3);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tehory3.this, Tehory4.class);

                activityLauncher.launch(intent);

            }
        });

        btnRestore = (ImageButton) findViewById(R.id.btnBack3);
        btnRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tehory3.this, Tehory2.class);

                activityLauncher.launch(intent);

            }
        });

        btnHome = (ImageButton) findViewById(R.id.btnHome3);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tehory3.this, MainActivity.class);

                activityLauncher.launch(intent);

            }
        });
    }
}