package com.example.whatsappclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.whatsappclone.Models.Users;
import com.example.whatsappclone.databinding.ActivitySignInBinding;
import com.example.whatsappclone.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class sign_up extends AppCompatActivity {

    ActivitySignUpBinding binding;

    private FirebaseAuth auth;
    FirebaseDatabase database;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).hide();
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        progressDialog = new ProgressDialog(sign_up.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("We are working on it.");

        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog.show();

                auth.createUserWithEmailAndPassword(binding.etEmail.getText().toString(), binding.etPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()){
                            Users user = new Users(binding.etUserName.getText().toString(), binding.etEmail.getText().toString(), binding.etPassword.getText().toString());

                            String id = task.getResult().getUser().getUid();
                            database.getReference().child("Users").child(id).setValue(user);

                            Toast.makeText(sign_up.this,"User Created Successfully", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(sign_up.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });
        binding.tvClickSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sign_up.this, sign_in.class);
                startActivity(intent);
            }
        });
    }
}