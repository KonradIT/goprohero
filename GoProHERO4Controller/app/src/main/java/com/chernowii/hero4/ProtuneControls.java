package com.chernowii.hero4;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class ProtuneControls extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protune_controls);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_protune_controls, menu);
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
    //PROTUNE VIDEO
    public void sendVideoProtuneON(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Protune ON!", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/10/1");
    }
    public void sendVideoProtuneOFF(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Protune OFF!", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/10/0");
    }
    public void sendVideoWBAuto(View view) {
        Toast.makeText(getApplicationContext(),
                "WB Auto", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/11/0");
    }
    public void sendVideoWB3000K(View view) {
        Toast.makeText(getApplicationContext(),
                "WB 3000K", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/11/1");
    }
    public void sendVideoWB5500K(View view) {
        Toast.makeText(getApplicationContext(),
                "WB 5500K", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/11/2");
    }
    public void sendVideoWB6500K(View view) {
        Toast.makeText(getApplicationContext(),
                "WB 6500K", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/11/3");
    }
    public void sendVideoGPColor(View view) {
        Toast.makeText(getApplicationContext(),
                "GoPro Color", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/12/0");
    }
    public void sendVideoFlatColor(View view) {
        Toast.makeText(getApplicationContext(),
                "Flat Color", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/12/1");
    }
    public void sendVideoHighSharpness(View view) {
        Toast.makeText(getApplicationContext(),
                "High", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/14/0");
    }
    public void sendVideoMediumSharpness(View view) {
        Toast.makeText(getApplicationContext(),
                "Medium", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/14/1");
    }
    public void sendVideoLowSharpness(View view) {
        Toast.makeText(getApplicationContext(),
                "Low", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/14/2");
    }
    public void sendOneVideoEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "+2.0", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/15/0");
    }
    public void sendTwoVideoEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "+1.5", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/15/1");
    }
    public void sendThreeVideoEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "+1.0", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/15/2");
    }
    public void sendFourVideoEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "+0.5", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/15/3");
    }
    public void sendFiveVideoEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "0", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/15/4");
    }
    public void sendSixVideoEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "-2.0", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/15/8");
    }
    public void sendSevenVideoEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "-1.5", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/15/7");
    }
    public void sendEightVideoEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "-1.0", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/15/6");
    }
    public void sendNineVideoEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "-0.5", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/15/5");
    }
    public void sendVideoISO400(View view) {
        Toast.makeText(getApplicationContext(),
                "ISO 400", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/13/2");
    }
    public void sendVideoISO1600(View view) {
        Toast.makeText(getApplicationContext(),
                "ISO 1600", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/13/1");
    }
    public void sendVideoISO6400(View view) {
        Toast.makeText(getApplicationContext(),
                "ISO 6400", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/13/0");
    }

    //PROTUNE PHOTO
    public void sendPhotoProtuneON(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Protune ON!", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/21/1");
    }
    public void sendPhotoProtuneOFF(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Protune OFF!", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/21/0");
    }
    public void sendPhotoWBAuto(View view) {
        Toast.makeText(getApplicationContext(),
                "WB Auto", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/22/0");
    }
    public void sendPhotoWB3000K(View view) {
        Toast.makeText(getApplicationContext(),
                "WB 3000K", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/22/1");
    }
    public void sendPhotoWB5500K(View view) {
        Toast.makeText(getApplicationContext(),
                "WB 5500K", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/22/2");
    }
    public void sendPhotoWB6500K(View view) {
        Toast.makeText(getApplicationContext(),
                "WB 6500K", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/22/3");
    }
    public void sendPhotoGPColor(View view) {
        Toast.makeText(getApplicationContext(),
                "GoPro Color", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/23/0");
    }
    public void sendPhotoFlatColor(View view) {
        Toast.makeText(getApplicationContext(),
                "Flat Color", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/23/1");
    }
    public void sendPhotoHighSharpness(View view) {
        Toast.makeText(getApplicationContext(),
                "High", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/25/0");
    }
    public void sendPhotoMediumSharpness(View view) {
        Toast.makeText(getApplicationContext(),
                "Medium", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/25/1");
    }
    public void sendPhotoLowSharpness(View view) {
        Toast.makeText(getApplicationContext(),
                "Low", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/25/2");
    }
    public void sendOnePhotoEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "+2.0", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/26/0");
    }
    public void sendTwoPhotoEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "+1.5", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/26/1");
    }
    public void sendThreePhotoEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "+1.0", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/26/2");
    }
    public void sendFourPhotoEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "+0.5", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/26/3");
    }
    public void sendFivePhotoEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "0", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/26/4");
    }
    public void sendSixPhotoEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "-2.0", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/26/8");
    }
    public void sendSevenPhotoEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "-1.5", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/26/7");
    }
    public void sendEightPhotoEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "-1.0", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/26/6");
    }
    public void sendNinePhotoEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "-0.5", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/26/5");
    }
    public void sendPhotoISO400(View view) {
        Toast.makeText(getApplicationContext(),
                "ISO 400", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/24/2");
    }
    public void sendPhotoISO1600(View view) {
        Toast.makeText(getApplicationContext(),
                "ISO 1600", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/24/1");
    }
    public void sendPhotoISO6400(View view) {
        Toast.makeText(getApplicationContext(),
                "ISO 6400", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/24/0");
    }
    //PROTUNE Multishot
    public void sendMultishotProtuneON(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Protune ON!", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/34/1");
    }
    public void sendMultishotProtuneOFF(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Protune OFF!", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/34/0");
    }
    public void sendMultishotWBAuto(View view) {
        Toast.makeText(getApplicationContext(),
                "WB Auto", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/35/0");
    }
    public void sendMultishotWB3000K(View view) {
        Toast.makeText(getApplicationContext(),
                "WB 3000K", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/35/1");
    }
    public void sendMultishotWB5500K(View view) {
        Toast.makeText(getApplicationContext(),
                "WB 5500K", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/35/2");
    }
    public void sendMultishotWB6500K(View view) {
        Toast.makeText(getApplicationContext(),
                "WB 6500K", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/35/3");
    }
    public void sendMultishotGPColor(View view) {
        Toast.makeText(getApplicationContext(),
                "GoPro Color", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/36/0");
    }
    public void sendMultishotFlatColor(View view) {
        Toast.makeText(getApplicationContext(),
                "Flat Color", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/36/1");
    }
    public void sendMultishotHighSharpness(View view) {
        Toast.makeText(getApplicationContext(),
                "High", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/38/0");
    }
    public void sendMultishotMediumSharpness(View view) {
        Toast.makeText(getApplicationContext(),
                "Medium", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/38/1");
    }
    public void sendMultishotLowSharpness(View view) {
        Toast.makeText(getApplicationContext(),
                "Low", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/38/2");
    }
    public void sendOneMultishotEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "+2.0", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/39/0");
    }
    public void sendTwoMultishotEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "+1.5", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/39/1");
    }
    public void sendThreeMultishotEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "+1.0", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/39/2");
    }
    public void sendFourMultishotEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "+0.5", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/39/3");
    }
    public void sendFiveMultishotEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "0", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/39/4");
    }
    public void sendSixMultishotEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "-2.0", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/39/8");
    }
    public void sendSevenMultishotEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "-1.5", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/39/7");
    }
    public void sendEightMultishotEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "-1.0", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/39/6");
    }
    public void sendNineMultishotEVComp(View view) {
        Toast.makeText(getApplicationContext(),
                "-0.5", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/39/5");
    }
    public void sendMultishotISO400(View view) {
        Toast.makeText(getApplicationContext(),
                "ISO 400", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/37/2");
    }
    public void sendMultishotISO1600(View view) {
        Toast.makeText(getApplicationContext(),
                "ISO 1600", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/37/1");
    }
    public void sendMultishotISO6400(View view) {
        Toast.makeText(getApplicationContext(),
                "ISO 6400", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/37/0");
    }
    public static String GET(String url){
        InputStream inputStream = null;
        String result = "";
        try {

            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return result;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

    public boolean isConnected(){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }
    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return GET(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "Done!", Toast.LENGTH_SHORT).show();
            ;
        }
    }
}
