package com.example.udp_packetsender;

import static android.content.pm.PackageManager.PERMISSION_DENIED;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    HotSpot hotspot;
    Button button;
    String [] premissions = {"android.permission.INTERNET","android.permission.ACCESS_NETWORK_STATE","android.permission.ACCESS_WIFI_STATE"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        if(checkSelfPermission("android.permission.ACCESS_WIFI_STATE")==PERMISSION_DENIED)
        {
            requestPermissions(premissions,0);
        }
    }

    public void sender(View view) {
        hotspot = new HotSpot("0.0.0.0",4454);
        hotspot.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Stop the server when the activity is destroyed
        if (hotspot != null) {
            hotspot.stopServer();
        }
    }

}