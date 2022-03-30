package com.example.whatsappclone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.whatsappclone.databinding.ActivitySignInBinding;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class sign_in extends AppCompatActivity {

    ActivitySignInBinding binding;
    ProgressDialog progressDialog;
    FirebaseAuth auth;
    FirebaseAuth mAuth;
    BeginSignInRequest signInRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        binding = ActivitySignInBinding.inflate(getLayoutInflater());

        getSupportActionBar().hide();

        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(sign_in.this);
        progressDialog.setTitle("Signing in");
        progressDialog.setMessage("We are working on it.");

        signInRequest = BeginSignInRequest.builder()
                .setGoogleIdTokenRequestOptions(BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                        .setSupported(true)
                        // Your server's client ID, not your Android client ID.
                        .setServerClientId("login-7de03")
                        // Only show accounts previously used to sign in.
                        .setFilterByAuthorizedAccounts(true)
                        .build())
                .build();

        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                auth.signInWithEmailAndPassword(binding.etEmail.getText().toString(), binding.etPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()){
                            Intent intent = new Intent(sign_in.this, MainActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(sign_in.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        binding.tvClickSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sign_in.this, sign_up.class);
                startActivity(intent);
            }
        });

        binding.googleSignInBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

            }

        });

        if (auth.getCurrentUser()!= null){
            Intent intent = new Intent(sign_in.this, MainActivity.class);
            startActivity(intent);
        }
    }
    // ...
    private static final int REQ_ONE_TAP = 2;  // Can be any integer unique to the Activity.
    private final boolean showOneTapUI = true;
    // ...
    SignInClient oneTapClient;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_ONE_TAP:
                try {
                    SignInCredential credential = oneTapClient.getSignInCredentialFromIntent(data);
                    String idToken = credential.getGoogleIdToken();
                    if (idToken !=  null) {
                        // Got an ID token from Google. Use it to authenticate
                        // with Firebase.
                        Log.d("TAG", "Got ID token.");
                    }
                } catch (ApiException e) {
                    // ...
                }
                break;
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
        
    }

    private void updateUI(FirebaseUser currentUser) {
    }
}