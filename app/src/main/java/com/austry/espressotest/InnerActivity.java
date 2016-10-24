package com.austry.espressotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class InnerActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner);
    }
}
