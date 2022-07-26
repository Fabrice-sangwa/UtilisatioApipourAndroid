package org.esisalama.mobile.apiapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textViewName;
    private TextView textViewId;
    private TextView textViewLogin;
    private EditText identifiant;
    private Button btnSoumettre;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialisation();
        setEcoteurEvenement();


    }

    private void initialisation(){

        textViewName = findViewById(R.id.textViewName);
        textViewId = findViewById(R.id.textViewId);
        textViewLogin = findViewById(R.id.textViewLogin);
        identifiant = findViewById(R.id.editTextId);
        btnSoumettre = findViewById(R.id.btnSoumettre);
        progressBar = findViewById(R.id.progress_bar);
    }

    private  void  setEcoteurEvenement(){
        btnSoumettre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idText = identifiant.getText().toString();
                if (idText.isEmpty()){
                    Toast.makeText(MainActivity.this, "Veuillez renseigner une valeur dans le champs Id", Toast.LENGTH_LONG).show();
                } else {
                    int id = Integer.parseInt(idText);
                    recupererGitHubUser(id);
                }
            }
        });
    }

    private void recupererGitHubUser(int id){
        progressBar.setVisibility(View.VISIBLE);
    }


}