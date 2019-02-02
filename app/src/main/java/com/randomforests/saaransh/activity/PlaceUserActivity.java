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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.randomforests.saaransh.R;

public class PlaceUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_user);
        final EditText joinEdit = findViewById(R.id.join_club_edit_text);
        final Button joinClub = findViewById(R.id.join_club_button);
        joinClub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (joinEdit.getText().length()>0){
                    final DatabaseReference getClub = FirebaseDatabase.getInstance().getReference().child("clubs").child(joinEdit.getText().toString().trim());
                    getClub.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists() && dataSnapshot.getChildrenCount()>0){
                                getClub.child("members").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(true);
                                DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("clubId");
                                userRef.setValue(joinEdit.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        startActivity(new Intent(PlaceUserActivity.this,MainActivity.class));
                                        finish();
                                    }
                                });
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        });

        Button createClub = findViewById(R.id.create_club_button);
        createClub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PlaceUserActivity.this,CreateClub.class));
            }
        });
    }
}
