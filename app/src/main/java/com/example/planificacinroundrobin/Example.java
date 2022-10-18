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
import android.widget.Toast;

public class Example extends AppCompatActivity {

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

        EditText text = (EditText) findViewById(R.id.txtInstructions);
        text.setKeyListener(null);

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


        /*for (e:Elem) {

        }*/


        ImageButton btnNext = (ImageButton) findViewById(R.id.btnNext3);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int Elem[] = {Integer.parseInt(cuantum.getText().toString()), Integer.parseInt(tLl1.getText().toString()), Integer.parseInt(tLl2.getText().toString()), Integer.parseInt(tLl3.getText().toString()), Integer.parseInt(tR1.getText().toString()), Integer.parseInt(tR2.getText().toString()), Integer.parseInt(tR3.getText().toString())};
                    if(Elem[0]<0 || Elem[1]<0 || Elem[2]<0 || Elem[3]<0 || Elem[4]<0 || Elem[5]<0 || Elem[6]<0){
                        Toast.makeText(Example.this, "Los números deben ser positivos", Toast.LENGTH_SHORT).show();
                    }else{
                        System.out.println(Elem.length + " elementos");
                        Intent intent = new Intent(Example.this, Example2.class);
                        intent.putExtra("quantum", cuantum.getText().toString());
                        activityLauncher.launch(intent);
                    }

                }catch (NumberFormatException e){
                    Toast.makeText(Example.this, "Debe agregar números positivos en todos los campos", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    System.out.println(e.toString());
                }


            }
        });

        ImageButton btnRestore = (ImageButton) findViewById(R.id.btnBack3);
        btnRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Example.this, Tehory5.class);

                activityLauncher.launch(intent);

            }
        });

        ImageButton btnHome = (ImageButton) findViewById(R.id.btnHome3);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Example.this, MainActivity.class);

                activityLauncher.launch(intent);

            }
        });

    }
}