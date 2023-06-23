package com.example.usermang2023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    FirebaseService fbs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      /*  fbs=FirebaseService.getInstance();
        if(fbs.getAuth().getCurrentUser()!=null){
            Intent intent = new Intent(this, StartActivity.class);
            startActivity(intent);
        }*/


        //else{gotoLoginFragment();}
        gotoLoginFragment();


    }

    private void gotoLoginFragment() {



        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, new LoginFragment());
        ft.commit();


    }
}