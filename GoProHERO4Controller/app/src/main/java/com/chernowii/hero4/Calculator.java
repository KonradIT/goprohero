package com.chernowii.hero4;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Calculator extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void sendCalculate(View view){
        EditText frameRate;
        frameRate   = (EditText)findViewById(R.id.editText);
        EditText totalHours;
        totalHours   = (EditText)findViewById(R.id.editText2);
        EditText vidDuration;
        vidDuration   = (EditText)findViewById(R.id.editText3);
        Double frameRateA = Double.parseDouble(frameRate.getText().toString());
        Double totalHoursA = Double.parseDouble(totalHours.getText().toString());
        Double vidDurationA = Double.parseDouble(vidDuration.getText().toString());

        //RESULTS

      Double AmountOfPics = vidDurationA * frameRateA;
        Double VarHourSeconds = totalHoursA * 60 * 60;
        Double interval = VarHourSeconds / AmountOfPics;

        String AmountOfPicsFinal = String.valueOf(AmountOfPics);
        String IntervalFinal = String.valueOf(interval);

        final TextView AmountOfPicsView = (TextView) findViewById(R.id.textView50);
        AmountOfPicsView.setText(AmountOfPicsFinal);
        final TextView IntervalView = (TextView) findViewById(R.id.textView52);
        IntervalView.setText(IntervalFinal + " seconds");
        if (AmountOfPics < 2000){
            final TextView SDSizeView = (TextView) findViewById(R.id.textView54);
            SDSizeView.setText("16 GB");
        }
        if (AmountOfPics > 2000){
            final TextView SDSizeView = (TextView) findViewById(R.id.textView54);
            SDSizeView.setText("32/64 GB");
        }
    }
}
