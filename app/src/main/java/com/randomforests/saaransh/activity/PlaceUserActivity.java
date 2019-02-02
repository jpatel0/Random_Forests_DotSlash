package com.randomforests.saaransh.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.randomforests.saaransh.R;

public class PlaceUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_user);

        Button joinClub = findViewById(R.id.join_club_button);
        joinClub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PlaceUserActivity.this,MainActivity.class));
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
