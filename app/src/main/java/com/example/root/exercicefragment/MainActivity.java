package com.example.root.exercicefragment;

import android.content.res.Configuration;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.example.root.exercicefragment.Fragments.DetailFragment;
import com.example.root.exercicefragment.Fragments.MenuFragment;

public class MainActivity extends AppCompatActivity  implements MenuFragment.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d("DEBUG", getResources().getConfiguration().orientation + "");

        if (savedInstanceState == null) {
            MenuFragment firstFragment = new MenuFragment();

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.flContainer, firstFragment);
            ft.commit();
        }


    }

    @Override
    public void onItemSelected(int position) {
       // Toast.makeText(this, "Called By Fragment A: position - " + position, Toast.LENGTH_SHORT).show();

        DetailFragment secondFragment = new DetailFragment();

        Bundle args = new Bundle();
        args.putInt("position", position);
        secondFragment.setArguments(args);


        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.flContainer2, secondFragment)

                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContainer, secondFragment)
                    .addToBackStack(null)
                    .commit();
        }

    }
}

