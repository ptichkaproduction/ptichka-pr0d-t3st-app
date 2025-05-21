package com.pti4ka.ballo0n.balloon;

import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.net.Uri;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.MenuItem;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    String _OSVERSION = System.getProperty("os.version");
    String _RELEASE = android.os.Build.VERSION.RELEASE;
    String _DEVICE = android.os.Build.DEVICE;
    String _MODEL = android.os.Build.MODEL;
    String _PRODUCT = android.os.Build.PRODUCT;
    String _BRAND = android.os.Build.BRAND;
    String _DISPLAY = android.os.Build.DISPLAY;
    String _CPU_ABI = android.os.Build.CPU_ABI;
    String _CPU_ABI2 = android.os.Build.CPU_ABI2;
    String _UNKNOWN = android.os.Build.UNKNOWN;
    String _HARDWARE = android.os.Build.HARDWARE;
    String _ID = android.os.Build.ID;
    String _MANUFACTURER = android.os.Build.MANUFACTURER;
    String _SERIAL = android.os.Build.SERIAL;
    String _USER = android.os.Build.USER;
    String _HOST = android.os.Build.HOST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pti4ka Pr0d utility");

        if( getIntent().getBooleanExtra("Exit", false)){
            finish();
        }

        BluetoothAdapter myDevice = BluetoothAdapter.getDefaultAdapter();
        String devicename = myDevice.getName();
        TextView textview = (TextView) findViewById(R.id.DeviceName);
        textview.setText("btw Your device name is: " + devicename );

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


    public void startOmgActivity(View view) {
        startActivity(new Intent(MainActivity.this, OmgActivity.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_setting) {

            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("EXIT FROM THIS T3ST???");
            builder.setMessage("Are you sure you want to exit ??");
            builder.setPositiveButton("HECK YEAH!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("Exit", true);
                    startActivity(intent);
                    finishAffinity();
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


    public void goToPti4kaPr0d(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://ptichkaproduction.github.io")));
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            startActivity(new Intent(MainActivity.this, MainActivity.class));

        } else if (id == R.id.nav_checker) {
            startActivity(new Intent(MainActivity.this, CheckerActivity.class));

        } else if (id == R.id.nav_info) {
            startActivity(new Intent(MainActivity.this, VersionActivity.class));

        } else if (id == R.id.nav_device) {
            startActivity(new Intent(MainActivity.this, DeviceActivity.class));
        } else if (id == R.id.nav_exit) {

            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("EXIT FROM THIS T3ST???");
            builder.setMessage("Are you sure you want to exit ??");
            builder.setPositiveButton("HECK YEAH!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("Exit", true);
                    startActivity(intent);
                    finishAffinity();
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


    }


