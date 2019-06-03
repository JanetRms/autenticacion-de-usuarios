package com.example.fayusers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Next Button
    public void Next(View view) {
        Intent next = new Intent( this, RegistryActivity.class);
        startActivity(next);
    }

}
