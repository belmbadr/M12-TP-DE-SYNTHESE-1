package com.example.tpsynthesenote;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton rburgent;
    RadioButton rbnormale;
    RadioButton rboptionnel;
    DatePicker dp;
    EditText t1;
    Button btnvalider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rburgent=(RadioButton)findViewById(R.id.rburgent);
        rbnormale=(RadioButton)findViewById(R.id.rbnormale);
        rboptionnel=(RadioButton)findViewById(R.id.rboptionnel);
        dp=(DatePicker) findViewById(R.id.dp);
        t1=(EditText) findViewById(R.id.t1);

        final AlertDialog.Builder res = new AlertDialog.Builder(this);
        res.setTitle("MES TACHES");

        btnvalider=(Button) findViewById(R.id.btnvalider);
        btnvalider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String tyta="Urgente";
               if (rbnormale.isChecked()) tyta="Normale";
               if (rboptionnel.isChecked()) tyta="Optionnelle";
               String myta= t1.getText().toString();
               String date = dp.getDayOfMonth()+"/"+dp.getMonth()+"/"+dp.getYear();
               res.setMessage("Nom de la tache : "+myta+"\r\nDate de réalisation : "+date+"\r\nType de la tache : "+tyta);
               res.show();
            }
        });
    }


}
