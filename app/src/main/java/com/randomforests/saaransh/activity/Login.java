package com.randomforests.saaransh.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.randomforests.saaransh.R;
import com.randomforests.saaransh.models.User;

import java.util.Arrays;
import java.util.List;

public class Login extends AppCompatActivity {

    private final int RC_SIGN_IN = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

// Create and launch sign-in intent
        if (FirebaseAuth.getInstance().getCurrentUser() == null){
            // Choose authentication providers
            List<AuthUI.IdpConfig> providers = Arrays.asList(
                    new AuthUI.IdpConfig.GoogleBuilder().build(),
                    new AuthUI.IdpConfig.EmailBuilder().setRequireName(true).build());
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(providers)
                            .setIsSmartLockEnabled(true)
                            .build(),
                    RC_SIGN_IN);
        }else
            startActivity(new Intent(Login.this,MainActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN && resultCode==RESULT_OK){
            DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
            userRef.setValue(new User(FirebaseAuth.getInstance().getCurrentUser().getDisplayName())).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    startActivity(new Intent(Login.this,MainActivity.class));
                    finish();
                }
            });
        }
    }
}
