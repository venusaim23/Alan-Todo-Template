package com.alan.todo;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.alan.todo.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private NavHostFragment navHostFragment;
    private NavController navController;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private static final String SDK_KEY = "YOUR SDK KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        fragmentManager = getSupportFragmentManager();
        navHostFragment = (NavHostFragment) fragmentManager.findFragmentById(R.id.nav_host_fragment_content_main);

        /* this type of initialisation requires the component fragment
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
         */
        assert navHostFragment != null;
        navController = navHostFragment.getNavController();
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Todo: Add Alan configuration and initialise Alan Button

        // Todo: create alanCallback object to use handlers to
        //  interact with Alan and register with Alan Button
    }

    // Todo: create executeCommand function to check for command and execute tasks

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        navHostFragment = (NavHostFragment) fragmentManager.findFragmentById(R.id.nav_host_fragment_content_main);
        assert navHostFragment != null;
        navController = navHostFragment.getNavController();
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}