package com.meyer.zanaatcaddesi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.meyer.zanaatcaddesi.models.UserModel;


public class LoginActivity extends AppCompatActivity {
    Button signIn;
    EditText email,name,password;
    TextView signUp;
    FirebaseAuth auth;
    ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
        signIn = findViewById(R.id.login_btn);
        email= findViewById(R.id.kullanici_lgn);
        //name = findViewById(R.id.kullanici_lgn);
        password=findViewById(R.id.parola_lgn);
        signUp=findViewById(R.id.Kayıt_Ol);
        progressBar=findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                loginUser();



            }
        });


    }

    private void loginUser() {
        //String userName= name.getText().toString();
        String userPass= password.getText().toString();
        String userEmail= email.getText().toString();


        if(TextUtils.isEmpty(userEmail)){
            progressBar.setVisibility(View.GONE);
            Toast.makeText(LoginActivity.this,"Email boş olamaz.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(userPass)){
            progressBar.setVisibility(View.GONE);
            Toast.makeText(LoginActivity.this,"Parola boş olamaz.", Toast.LENGTH_SHORT).show();
            return;
        }
        if(userPass.length()<6){
            progressBar.setVisibility(View.GONE);
            Toast.makeText(LoginActivity.this,"Parola 6 haneden fazla olmalı.", Toast.LENGTH_SHORT).show();
            return;
        }
        // Kullanıcı giriş kontrolu
        auth.signInWithEmailAndPassword(userEmail,userPass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(LoginActivity.this, "Giriş başarılı", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this,VideoActivity.class));
                            //startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        }
                        else {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(LoginActivity.this, "Hata: Giriş işlemi başarısız Error:"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });



    }
}