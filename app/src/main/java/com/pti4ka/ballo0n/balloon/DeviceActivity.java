package com.pti4ka.ballo0n.balloon;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.TextView;

public class DeviceActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener{

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
        setContentView(R.layout.activity_device);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarDevice);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Device Information");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        BluetoothAdapter myDevice = BluetoothAdapter.getDefaultAdapter();
        String devicename = myDevice.getName();

        TextView deviceName = (TextView) findViewById(R.id.DeviceName);
        deviceName.setText("Your device name: " + devicename );

        TextView AndroidVer = (TextView) findViewById(R.id.AndroidVer);
        AndroidVer.setText("Your Android version: " + _RELEASE );

        TextView OSVer = (TextView) findViewById(R.id.OSVer);
        OSVer.setText("Kernel version: " + _OSVERSION );

        TextView DeviceModel = (TextView) findViewById(R.id.DeviceModel);
        DeviceModel.setText("Your Device model: " + _MODEL );

        TextView DeviceBrand = (TextView) findViewById(R.id.DeviceBrand);
        DeviceBrand.setText("Device brand: " + _BRAND );

        TextView cpu_abi = (TextView) findViewById(R.id.cpu_abi);
        cpu_abi.setText("Architecture: " +  _CPU_ABI );

        TextView Hardware = (TextView) findViewById(R.id.hardware);
        Hardware.setText("CPU: " +  _HARDWARE );

        TextView Manufacturer = (TextView) findViewById(R.id.manufacturer);
        Manufacturer.setText("Manufacturer: " +  _MANUFACTURER );

        TextView Display = (TextView) findViewById(R.id.Display);
        Display.setText("Display: " +  _DISPLAY );

        TextView id = (TextView) findViewById(R.id.id);
        id.setText("ID: " +  _ID );


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
        startActivity(new Intent(DeviceActivity.this, MainActivity.class));
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            startActivity(new Intent(DeviceActivity.this, MainActivity.class));

        } else if (id == R.id.nav_checker) {

            startActivity(new Intent(DeviceActivity.this, CheckerActivity.class));

        } else if (id == R.id.nav_info) {
            startActivity(new Intent(DeviceActivity.this, VersionActivity.class));

        } else if (id == R.id.nav_device) {
            startActivity(new Intent(DeviceActivity.this, DeviceActivity.class));
        } else if (id == R.id.nav_exit) {

            final AlertDialog.Builder builder = new AlertDialog.Builder(DeviceActivity.this);
            builder.setTitle("EXIT FROM THIS T3ST???");
            builder.setMessage("Are you sure you want to exit ??");
            builder.setPositiveButton("HECK YEAH!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

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

            final AlertDialog.Builder builder = new AlertDialog.Builder(DeviceActivity.this);
            builder.setTitle("EXIT FROM THIS T3ST???");
            builder.setMessage("Are you sure you want to exit ??");
            builder.setPositiveButton("HECK YEAH!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

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
