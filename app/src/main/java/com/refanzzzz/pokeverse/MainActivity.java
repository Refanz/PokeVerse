package com.refanzzzz.pokeverse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.refanzzzz.pokeverse.databinding.ActivityMainBinding;
import com.refanzzzz.pokeverse.fragment.HomeFragment;
import com.refanzzzz.pokeverse.fragment.UserFragment;
import com.refanzzzz.pokeverse.shared_preferences.SharedPrefConfig;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        replaceFragment(new HomeFragment());

        activityMainBinding.bottomNavBar.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.i_home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.i_user:
                    replaceFragment(new UserFragment());
                    break;
            }

            return true;
        });
    }

    void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_main, fragment);
        fragmentTransaction.commit();
    }

}