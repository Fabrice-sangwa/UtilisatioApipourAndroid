package org.esisalama.mobile.apiapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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


        Retrofit  retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GitHubUserService userService = retrofit.create(GitHubUserService.class);
        Call<GitHubUsers> callback = userService.getUser(id);

        callback.enqueue(new Callback<GitHubUsers>() {
            @Override
            public void onResponse(Call<GitHubUsers> call, Response<GitHubUsers> response) {

                if(response.isSuccessful()){

                    GitHubUsers user = response.body();
                    if (user == null){
                        Toast.makeText(MainActivity.this, "L'utilisateur n'a pas été trouvé", Toast.LENGTH_LONG).show();
                    }
                    textViewLogin.setText("Login : " + user.getLogin());
                    textViewName.setText("Name : " + user.getName());
                    textViewId.setText("Id : " + user.getId());

                } else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<GitHubUsers> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });



    }


}