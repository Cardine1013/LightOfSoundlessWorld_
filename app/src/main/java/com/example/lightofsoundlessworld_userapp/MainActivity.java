package com.example.lightofsoundlessworld_userapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    RelativeLayout batteryStatus, bellStatus, addDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        addDevice = (RelativeLayout)findViewById(R.id.addDevice);
        bellStatus = (RelativeLayout)findViewById(R.id.bellStatus);
        batteryStatus = (RelativeLayout)findViewById(R.id.batteryStatus);
        BluetoothConnect btConnect = new BluetoothConnect();

        addDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BluetoothConnect.class);
                startActivity(intent);
            }
        });

        if(btConnect.getWatchConnected()){
            showBatteryStatus();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    if(BluetoothConnect.getWatchConnected()){
            showBatteryStatus();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(BluetoothConnect.getWatchConnected()){
            showBatteryStatus();
        }
    }

    public void showBatteryStatus(){
        batteryStatus.setVisibility(View.VISIBLE);
    }
}
