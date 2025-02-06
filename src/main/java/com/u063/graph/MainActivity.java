package com.u063.graph;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }
    public void bm_activity(View view){
        Intent i = new Intent(MainActivity.this,BitmapActivity.class);
        startActivity(i);
    }
    public void agsl_activity(View view){
        if(Build.VERSION.SDK_INT>=33) {
            Intent i = new Intent(MainActivity.this, AgslActivity.class);
            startActivity(i);
        }
    }
}