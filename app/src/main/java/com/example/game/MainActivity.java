package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    MyView mw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mw = new MyView(this);
        setContentView(mw);
    }

}