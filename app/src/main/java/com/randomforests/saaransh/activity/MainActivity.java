package com.randomforests.saaransh.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.randomforests.saaransh.R;
import com.randomforests.saaransh.adapter.RecyclerViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    ArrayList<String> list;
    RecyclerView recyclerView;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton=(FloatingActionButton)findViewById(R.id.floatingActionButton);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter= new RecyclerViewAdapter(this,list);
        list=new ArrayList<>();
        list.add("Darsh");
        list.add("suraj");
        list.add("jay");
        recyclerView.setAdapter(adapter);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, Recoard.class);
                startActivity(intent);
            }
        });
    }

}
