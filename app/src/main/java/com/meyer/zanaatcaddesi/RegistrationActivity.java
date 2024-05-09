package com.meyer.zanaatcaddesi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.meyer.zanaatcaddesi.models.UserModel;
import com.meyer.zanaatcaddesi.models.VibrateF;


public class RegistrationActivity extends AppCompatActivity {

    Button signUp;
    EditText name,email,password;
    TextView signIn;

    FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressBar progressBar;
    DatePicker datePicker;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);
        auth= FirebaseAuth.getInstance();
        database= FirebaseDatabase.getInstance();
        signUp= findViewById(R.id.reg_btn);
        name= findViewById(R.id.kullanici_reg);
        password= findViewById(R.id.parola_reg);
        email= findViewById(R.id.email_reg);
        signIn= findViewById(R.id.Giris_yap);
        progressBar= findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);

        VibrateF vibr =new VibrateF();
        long[] pattern = {0, 100,400};


        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
            }
        });



        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createUser();
                progressBar.setVisibility(View.VISIBLE);

            }




            public void createUser() {

                String userName= name.getText().toString();
                String userEmail= email.getText().toString();
                String userPass= password.getText().toString();



                if(TextUtils.isEmpty(userName)) {
                    vibr.vibrate(RegistrationActivity.this,1000);
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(RegistrationActivity.this,"Kullanıcı adi boş olamaz.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(userEmail)){
                    vibr.vibrate(RegistrationActivity.this,1000);
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(RegistrationActivity.this,"Email boş olamaz.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(userPass)){
                    vibr.vibrate(RegistrationActivity.this,1000);
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(RegistrationActivity.this,"Parola boş olamaz.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(userPass.length()<6){
                    vibr.vibrate(RegistrationActivity.this,1000);
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(RegistrationActivity.this,"Parola 6 haneden fazla olmalı.", Toast.LENGTH_SHORT).show();
                    return;
                }
                // Kullanıcı Oluşturma fonk.
                auth.createUserWithEmailAndPassword(userEmail,userPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            UserModel userModel = new UserModel(userName,userEmail,userPass);
                            String id= task.getResult().getUser().getUid();
                            database.getReference().child("Kullanıcılar").child(id).setValue(userModel);
                            progressBar.setVisibility(View.GONE);
                            vibr.vibratePattern(RegistrationActivity.this,pattern,1);


                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                      vibr.cancelVibration(RegistrationActivity.this);
                                    }
                                }, 1000); // 1000ms (1 saniye) gecikme süresi



                            Toast.makeText(RegistrationActivity.this, "Kayıt başarılı.", Toast.LENGTH_SHORT).show();

                        }
                        else {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(RegistrationActivity.this, "Error:"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }


}