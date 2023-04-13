/*
Mobile App Development I -- COMP.4630 Honor Statement
The practice of good ethical behavior is essential for maintaining good
order in the classroom, providing an enriching learning experience for
students, and training as a practicing computing professional upon
graduation. This practice is manifested in the University's Academic
Integrity policy. Students are expected to strictly avoid academic
dishonesty and adhere to the Academic Integrity policy as outlined in the
course catalog. Violations will be dealt with as outlined therein. All
programming assignments in this class are to be done by the student alone
unless otherwise specified. No outside help is permitted except the
instructor and approved tutors.
I certify that the work submitted with this assignment is mine and was
generated in a manner consistent with this document, the course academic
policy on the course website on Blackboard, and the UMass Lowell academic
code.
Date:Sun nov 13 2022
Name: John Ersen Youte
*/

package com.example.lecture17exer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import android.os.Bundle;
import android.view.View;

import com.example.lecture17exer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //private MaterialToolbar toolbar;
        com.example.lecture17exer.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        //setContentView(R.layout.activity_main);
        setContentView(view);
        setContentView(view);


        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        assert navHostFragment != null;
        NavController navController = navHostFragment.getNavController();

    }
}