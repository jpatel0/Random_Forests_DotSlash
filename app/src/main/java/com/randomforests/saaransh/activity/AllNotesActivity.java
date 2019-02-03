package com.randomforests.saaransh.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.randomforests.saaransh.R;
import com.randomforests.saaransh.adapter.NotesAdapter;
import com.randomforests.saaransh.models.Notes;

import java.util.ArrayList;

public class AllNotesActivity extends AppCompatActivity {

    private ArrayList<Notes> notesList;
    private NotesAdapter notesAdapter;
    String type,id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_notes);
        notesList = new ArrayList<>();
        type = getIntent().getStringExtra("type");
        id = getIntent().getStringExtra("id");
        notesList.add(new Notes("Web","The World Wide Web, also known as the WWW and the Web, is an information space where documents and other web resources are identified by Uniform Resource Locators (URLs), interlinked by hypertext links, and accessible via the Internet.[1] English scientist Tim Berners-Lee invented the World Wide Web in 1989. ","jayze",1500000,""));
        notesAdapter = new NotesAdapter(this,notesList);
        RecyclerView recyclerView = findViewById(R.id.all_notes_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(notesAdapter);
        updateData();
    }

    private void updateData(){
        notesList.clear();
        if (type!=null && id!=null){
            if (type.equals("solo")){
                DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("Users").child(id).child("notes");
                userRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Log.d("AllNotes",dataSnapshot.toString());
                        if (dataSnapshot.exists() && dataSnapshot.getChildrenCount()>0){
                            for (DataSnapshot note:dataSnapshot.getChildren()){
                                notesList.add(note.getValue(Notes.class));
                            }
                        }
                        notesAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }
            else {
                DatabaseReference clubRef = FirebaseDatabase.getInstance().getReference().child("clubs").child(id).child("notes");
                clubRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists() && dataSnapshot.getChildrenCount()>0){
                            for (DataSnapshot note:dataSnapshot.getChildren()){
                                notesList.add(note.getValue(Notes.class));
                            }
                        }
                        notesAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }
        }
    }
}
