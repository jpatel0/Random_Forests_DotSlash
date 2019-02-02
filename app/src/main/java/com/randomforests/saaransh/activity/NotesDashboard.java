package com.randomforests.saaransh.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.MenuItem;

import com.randomforests.saaransh.R;
import com.randomforests.saaransh.fragments.SummaryFragment;

public class NotesDashboard extends AppCompatActivity {

    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_dashboard);

        toolbar = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.notes_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            SummaryFragment summaryFragment = new SummaryFragment();
            switch (item.getItemId()) {
                case R.id.notes_summary:

                    toolbar.setTitle("Summary");
                    return true;
                case R.id.notes_raw:
                    toolbar.setTitle("Raw Text");
                    return true;
                case R.id.notes_audio:
                    toolbar.setTitle("Audio");
                    return true;
                case R.id.notes_suggestion:
                    toolbar.setTitle("Youtube Suggestions");
                    return true;
            }
            return false;
        }
    };
}
