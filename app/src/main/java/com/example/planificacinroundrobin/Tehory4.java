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

public class Tehory4 extends AppCompatActivity {

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
        setContentView(R.layout.activity_tehory4);

        text = (EditText) findViewById(R.id.txtDefinition4a);
        text.setKeyListener(null);

        btnNext = (ImageButton) findViewById(R.id.btnNext4);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Entró");
                try {
                    Intent intent = new Intent(Tehory4.this, Tehory5.class);

                    activityLauncher.launch(intent);
                }catch (Exception e){
                    e.toString();
                }


            }
        });

        btnRestore = (ImageButton) findViewById(R.id.btnBack4);
        btnRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tehory4.this, Tehory3.class);

                activityLauncher.launch(intent);

            }
        });

        btnHome = (ImageButton) findViewById(R.id.btnHome4);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tehory4.this, MainActivity.class);

                activityLauncher.launch(intent);

            }
        });
    }
}