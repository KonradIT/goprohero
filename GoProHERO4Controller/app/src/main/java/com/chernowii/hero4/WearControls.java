package com.chernowii.hero4;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class WearControls extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wear_display);
        mTextView = (TextView) findViewById(R.id.text);
    }
}