package com.javatechig.droid.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imgLeft = (ImageView) findViewById(R.id.imageview_left);
        ImageView imgMiddle = (ImageView) findViewById(R.id.imageview_middle);
        ImageView imgRigth = (ImageView) findViewById(R.id.imageview_right);



    }
}
