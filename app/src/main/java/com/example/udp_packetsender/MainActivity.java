package com.example.udp_packetsender;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
    }

    public void sender(View view) {



//        String message = "Hello from Device 1";
//        String ipAddress = "192.168.1.101";  // IP of Device 2
//        int port = 12345;
//        new Transmitter(message, ipAddress, port).start();
    }
}