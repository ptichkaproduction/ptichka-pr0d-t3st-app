package com.pti4ka.ballo0n.balloon;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;

public class VersionActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarVer);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Application Info");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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

            startActivity(new Intent(VersionActivity.this, MainActivity.class));

        } else if (id == R.id.nav_checker) {
            startActivity(new Intent(VersionActivity.this, CheckerActivity.class));

        } else if (id == R.id.nav_info) {
            startActivity(new Intent(VersionActivity.this, VersionActivity.class));

        } else if (id == R.id.nav_device) {
            startActivity(new Intent(VersionActivity.this, DeviceActivity.class));
        } else if (id == R.id.nav_exit) {

            final AlertDialog.Builder builder = new AlertDialog.Builder(VersionActivity.this);
            builder.setTitle("EXIT FROM THIS T3ST???");
            builder.setMessage("Are you sure you want to exit ??");
            builder.setPositiveButton("HECK YEAH!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    Intent intent = new Intent(VersionActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("Exit", true);
                    startActivity(intent);
                    finish();

                }
            });
            builder.setNegativeButton("No, thanks!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    dialogInterface.dismiss();
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_setting) {

            final AlertDialog.Builder builder = new AlertDialog.Builder(VersionActivity.this);
            builder.setTitle("EXIT FROM THIS T3ST???");
            builder.setMessage("Are you sure you want to exit ??");
            builder.setPositiveButton("HECK YEAH!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    Intent intent = new Intent(VersionActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("Exit", true);
                    startActivity(intent);
                    finish();

                }
            });
            builder.setNegativeButton("No, thanks!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    dialogInterface.dismiss();
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        }


        return super.onOptionsItemSelected(item);
    }
}
