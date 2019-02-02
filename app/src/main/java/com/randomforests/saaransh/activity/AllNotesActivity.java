package com.randomforests.saaransh.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.randomforests.saaransh.R;
import com.randomforests.saaransh.adapter.NotesAdapter;
import com.randomforests.saaransh.models.Notes;

import java.util.ArrayList;

public class AllNotesActivity extends AppCompatActivity {

    private ArrayList<Notes> notesList;
    private NotesAdapter notesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_notes);
        notesList = new ArrayList<>();
        notesList.add(new Notes("Web","The World Wide Web, also known as the WWW and the Web, is an information space where documents and other web resources are identified by Uniform Resource Locators (URLs), interlinked by hypertext links, and accessible via the Internet.[1] English scientist Tim Berners-Lee invented the World Wide Web in 1989. ","jayze","today"));
        notesAdapter = new NotesAdapter(this,notesList);
        RecyclerView recyclerView = findViewById(R.id.all_notes_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(notesAdapter);
    }
}
