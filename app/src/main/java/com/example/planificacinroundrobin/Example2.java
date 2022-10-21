package com.example.planificacinroundrobin;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Example2 extends AppCompatActivity {

    int q, l1, l2, l3, r1, r2, r3, e1=0, e2=0, e3=0,ret1=0, ret2=0, ret3=0, f1=0, f2=0, f3=0, pos=0, et=0;
    int currentPos[]={0,0,0};
    boolean p1=false, p2=false, p3=false;
    TextView turno;
    TextView rIni;
    TextView rFin;
    TextView tEs;
    TextView tFin;
    TextView PFin;
    private RecyclerView listProcess;
    ArrayList<Process> processes;
    Adapter processAdapter;

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
        setContentView(R.layout.activity_example2);
        try {
            Bundle bundle = getIntent().getExtras();
            String quantum = bundle.getString("quantum");
            q = Integer.parseInt(quantum.toString());
            String sl1 = bundle.getString("l1");
            l1 = Integer.parseInt(sl1.toString());
            String sl2 = bundle.getString("l2");
            l2 = Integer.parseInt(sl2.toString());
            String sl3 = bundle.getString("l3");
            l3 = Integer.parseInt(sl3.toString());
            String sr1 = bundle.getString("r1");
            r1 = Integer.parseInt(sr1.toString());
            String sr2 = bundle.getString("r2");
            r2 = Integer.parseInt(sr2.toString());
            String sr3 = bundle.getString("r3");
            r3 = Integer.parseInt(sr3.toString());

            turno = findViewById(R.id.txtTurno);
            rIni = findViewById(R.id.txtRInicial);
            rFin = findViewById(R.id.txtRFinal);
            tEs = findViewById(R.id.txtTEspera);
            tFin = findViewById(R.id.txtFinalizacion);
            PFin = findViewById(R.id.textPuestosFinales);
            listProcess = findViewById(R.id.rvResultados);
            processes = new ArrayList<Process>();
            Process p = new Process("Nº Proceso","Rafaga","T. Inicial","T. Final");
            processes.add(p);

            listProcess.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            listProcess.setLayoutManager(linearLayoutManager);
            processAdapter = new Adapter(processes);
            listProcess.setAdapter(processAdapter);


            TextView text = findViewById(R.id.llegada1);
            text.setText(sl1);
            text = findViewById(R.id.llegada2);
            text.setText(sl2);
            text = findViewById(R.id.llegada3);
            text.setText(sl3);
            text = (TextView) findViewById(R.id.rafaga1);
            text.setText(sr1);
            text = (TextView) findViewById(R.id.rafaga2);
            text.setText(sr2);
            text = (TextView) findViewById(R.id.rafaga3);
            text.setText(sr3);
            text = (TextView) findViewById(R.id.quantum);
            text.setText(quantum);

            if (l1 > l2) {
                if (l1 > l3) {
                    currentPos[2]=1;
                } else {
                    currentPos[2]=3;
                }
            } else if (l2 > l3) {
                currentPos[2]=2;
            } else {
                currentPos[2]=3;
            }

            if (l1 < l2) {
                if (l1 < l3) {
                    currentPos[0]=1;
                } else {
                    currentPos[0]=3;
                }
            } else if (l2 < l3) {
                currentPos[0]=2;
            } else {
                currentPos[0]=3;
            }

            if((currentPos[0]==1 && currentPos[2]==3)||(currentPos[0]==3 && currentPos[2]==1)){
                currentPos[1]=2;
            }else if((currentPos[0]==2 && currentPos[2]==3)||(currentPos[0]==3 && currentPos[2]==2)){
                currentPos[1]=1;
            }else if((currentPos[0]==1 && currentPos[2]==2)||(currentPos[0]==2 && currentPos[2]==1)){
                currentPos[1]=3;
            }else{
                currentPos[0]=1;
                currentPos[1]=2;
                currentPos[2]=3;
            }
        }catch (Exception e){
            Toast.makeText(Example2.this, e.toString(), Toast.LENGTH_SHORT).show();
            System.out.println(e.toString());
        }
        Button btnsig = (Button) findViewById(R.id.btnSig);
        btnsig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(pos>2){
                        pos=0;
                    }
                    if(p1 && p2 && p3){
                        TextView title = findViewById(R.id.textTituFinales);
                        title.setText("Tiempos finales de los procesos");
                        PFin.setText("P1: "+f1+"  P2:"+f2+"   p3:"+f3);
                        return;
                    }
                    pos++;
                    switch(currentPos[pos-1]){
                        case 1:
                            if(!p1){
                                if(r1>q){
                                    et+=q;
                                    turno.setText("Proceso 1");
                                    rIni.setText(""+r1+"");
                                    r1-=q;
                                    rFin.setText(""+r1+"");
                                    e1+=r1;
                                    tEs.setText(""+e1+"");
                                    tFin.setText("No finalizado");
                                    add("Proceso 1",r1,(et-q),et);

                                }else{
                                    et+=r1;
                                    turno.setText("Proceso 1");
                                    rIni.setText(""+r1+"");
                                    r1-=r1;
                                    rFin.setText(""+r1+"");
                                    ret1+=(e1+r1);
                                    e1+=r1;
                                    tEs.setText(""+e1+"");
                                    f1=et;
                                    tFin.setText(""+f1+"");
                                    p1=true;
                                    add("Proceso 1",r1,(et-r1),et);
                                }
                            }else {
                                onClick(view);
                            }
                            break;

                        case 2:
                            if(!p2){
                                if(r2>q){
                                    et+=q;
                                    turno.setText("Proceso 2");
                                    rIni.setText(""+r2+"");
                                    Example2.this.r2 -=q;
                                    rFin.setText(""+r2+"");
                                    e2+=r2;
                                    tEs.setText(""+e2+"");
                                    tFin.setText("No finalizado");
                                    add("Proceso 2",r2,(et-q),et);
                                }else{
                                    et+=r2;
                                    turno.setText("Proceso 2");
                                    rIni.setText(""+r2+"");
                                    r2-=r2;
                                    rFin.setText(""+r2+"");
                                    e2+=r2;
                                    tEs.setText(""+e2+"");
                                    f2=et;
                                    tFin.setText(""+f2+"");
                                    p2=true;
                                    add("Proceso 2",r2,(et-r2),et);
                                }
                            }else {
                                onClick(view);
                            }
                            break;

                        case 3:
                            if(!p3){
                                if(r3>q){
                                    et+=q;
                                    turno.setText("Proceso 3");
                                    rIni.setText(""+r3+"");
                                    r3-=q;
                                    rFin.setText(""+r3+"");
                                    e3+=r3;
                                    tEs.setText(""+e3+"");
                                    tFin.setText("No finalizado");
                                    add("Proceso 3",r3,(et-q),et);
                                }else{
                                    et+=r3;
                                    turno.setText("Proceso 3");
                                    rIni.setText(""+r3+"");
                                    r3-=r3;
                                    rFin.setText(""+r3+"");
                                    e3+=r3;
                                    tEs.setText(""+e3+"");
                                    f3=et;
                                    tFin.setText(""+f3+"");
                                    p3=true;
                                    add("Proceso 3",r3,(et-r3),et);
                                }
                            }else {
                                onClick(view);
                            }
                            break;
                    }
                }catch (Exception e){
                    System.out.println(e.toString());
                    System.out.println(e.getMessage());
                }

            }
        });

        ImageButton btnNext = (ImageButton) findViewById(R.id.btnNext8);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Example2.this, Referencias.class);
                    activityLauncher.launch(intent);
                }catch (Exception e){
                    System.out.println(e.toString());
                }


            }
        });

        ImageButton btnRestore = (ImageButton) findViewById(R.id.btnBack8);
        btnRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Example2.this, Example.class);

                activityLauncher.launch(intent);

            }
        });

        ImageButton btnHome = (ImageButton) findViewById(R.id.btnHome8);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Example2.this, MainActivity.class);

                activityLauncher.launch(intent);

            }
        });
    }
    public void add(String name, int r, int i, int f){
        String tabo= "\t\t\t\t\t";
        String tab = "";
        if((String.valueOf(i).length()>1)&&(String.valueOf(f).length()>1)){
            tab = "\t\t\t\t";
        }else if(String.valueOf(f).length()>1){
            tab = "\t\t\t\t\t";
        }else{
            tab = "\t\t\t\t\t\t";
        }
        Process p = new Process(name,tabo+String.valueOf(r),tabo+String.valueOf(i),tab+String.valueOf(f));
        processes.add(p);
        processAdapter.notifyDataSetChanged();
        listProcess.scrollToPosition(processes.size()-1);

    }
}