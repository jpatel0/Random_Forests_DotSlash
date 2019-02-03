package com.randomforests.saaransh.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.MenuItem;

import com.randomforests.saaransh.R;
import com.randomforests.saaransh.fragments.AudioFragment;
import com.randomforests.saaransh.fragments.RawFragment;
import com.randomforests.saaransh.fragments.SuggestionFragment;
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
        navigation.setSelectedItemId(R.id.notes_summary);
//        loadFragment(new SummaryFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.notes_summary:
                    fragment = new SummaryFragment();
                    loadFragment(fragment);
                    toolbar.setTitle("Summary");
                    return true;
                case R.id.notes_raw:
                    fragment = new RawFragment();
                    loadFragment(fragment);
                    toolbar.setTitle("Raw Text");
                    return true;
                case R.id.notes_audio:
                    fragment = new AudioFragment();
                    loadFragment(fragment);
                    toolbar.setTitle("Audio");
                    return true;
                case R.id.notes_suggestion:
                    fragment = new SuggestionFragment();
                    loadFragment(fragment);
                    toolbar.setTitle("Youtube Suggestions");
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
