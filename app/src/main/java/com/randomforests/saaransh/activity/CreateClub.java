package com.randomforests.saaransh.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.randomforests.saaransh.R;

public class CreateClub extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_club);

        final EditText clubName = findViewById(R.id.create_club_name);
        final EditText interests = findViewById(R.id.club_interests_edittext);

        Button createClub = findViewById(R.id.create_new_club);
        createClub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clubName.getText().length()>0 && interests.getText().length()>0){
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                    reference.child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("clubId").setValue(clubName.getText().toString());
                    reference.child("clubs").child(clubName.getText().toString()).child("members").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(true).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            startActivity(new Intent(CreateClub.this,MainActivity.class));
                            finish();
                        }
                    });
                }
            }
        });
    }
}
