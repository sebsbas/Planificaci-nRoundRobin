package com.example.planificacinroundrobin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Example2 extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example2);

        Bundle bundle = getIntent().getExtras();
        int quantum = Integer.parseInt(bundle.getString("quantum"));

    }
}