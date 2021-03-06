package com.example.android.amity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import static com.example.android.amity.R.id.fab;

public class FABTestingActivity extends AppCompatActivity {
    FloatingActionButton fab_expand, fab_add, fab_home, fab_profile;
    Animation FabOpen, FabClose, FabRClockwise, FabRCounterclockwise;
    boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabtesting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //          Start of FAB**************************************
        /*
        initializing fab buttons by id
         */
        fab_expand = (FloatingActionButton) findViewById(R.id.fab_expand);
        fab_add = (FloatingActionButton) findViewById(R.id.fab_add);
        fab_home = (FloatingActionButton) findViewById(R.id.fab_home);
        fab_profile = (FloatingActionButton) findViewById(R.id.fab_profile);

         /*
        initializing animations
         */
        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        FabRClockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        FabRCounterclockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_counterclockwise);

         /*
            on click listener for expand fab
            creates animations for when expand fab is clicked
         */
        fab_expand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOpen){
                    //close animation for 3 buttons
                    fab_add.startAnimation(FabClose);
                    fab_home.startAnimation(FabClose);
                    fab_profile.startAnimation(FabClose);
                    //rotates expand button counterclockwise
                    fab_expand.startAnimation(FabRCounterclockwise);
                    //sets clickable for 3 buttons false
                    fab_add.setClickable(false);
                    fab_home.setClickable(false);
                    fab_profile.setClickable(false);
                    isOpen = false;

                }
                else{
                    //open animation for 3 buttons
                    fab_add.startAnimation(FabOpen);
                    fab_home.startAnimation(FabOpen);
                    fab_profile.startAnimation(FabOpen);
                    //rotates expand button clockwise
                    fab_expand.startAnimation(FabRClockwise);
                    //sets clickable for 3 buttons true
                    fab_add.setClickable(true);
                    fab_home.setClickable(true);
                    fab_profile.setClickable(true);
                    isOpen = true;
                }

            }
        });

        /*
            on click listener for add fab
            goes to PostActivity
         */
        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent postIntent = new Intent(FABTestingActivity.this, CreatePostActivity.class);
                startActivity(postIntent);
            }
        });

        /*
            on click listener for home fab
            goes to MapActivity
         */
        fab_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(FABTestingActivity.this, MapActivity.class);
                startActivity(homeIntent);
            }
        });

        /*
            on click listener for profile fab
            goes to ProfileActivity
         */
        fab_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileIntent = new Intent(FABTestingActivity.this, ProfileActivity.class);
                startActivity(profileIntent);
            }
        });
    }

}
