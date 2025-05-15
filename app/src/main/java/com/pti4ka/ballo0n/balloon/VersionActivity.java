package com.pti4ka.ballo0n.balloon;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;

public class VersionActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.version);
    }

    public void startMainActivity(View view) {
        startActivity(new Intent(VersionActivity.this, MainActivity.class));
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            startActivity(new Intent(VersionActivity.this, CheckerActivity.class));

        } else if (id == R.id.nav_checker) {

            startActivity(new Intent(VersionActivity.this, MainActivity.class));

        } else if (id == R.id.nav_info) {
            startActivity(new Intent(VersionActivity.this, VersionActivity.class));
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
