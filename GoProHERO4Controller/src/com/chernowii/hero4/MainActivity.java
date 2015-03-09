package com.chernowii.hero4;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import java.util.Timer;
import java.util.TimerTask;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;
 
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.os.Bundle;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	Spinner spnr;
	  String[] vidreslist = {
		  "Select",
		  "4K",
	      "2.7K",
	      "1440p",
	      "1080p",
	      "720p",
	      "WVGA"
	  };
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			super.onCreate(savedInstanceState);
		    setContentView(R.layout.activity_main);
		    spnr = (Spinner)findViewById(R.id.spinner);
		    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
		        this, android.R.layout.simple_spinner_item, vidreslist);
		    spnr.setAdapter(adapter);
		    spnr.setOnItemSelectedListener(
		              new AdapterView.OnItemSelectedListener() {
		                  @Override
		                  public void onItemSelected(AdapterView<?> arg0, View arg1,
		                          int arg2, long arg3) {
		                    int position = spnr.getSelectedItemPosition();
		                    Toast.makeText(getApplicationContext(),"Resolution: "+vidreslist[+position],Toast.LENGTH_SHORT).show();
		                  

		                    // TODO Auto-generated method stub
		                  }
		                  
		                  @Override
		                  public void onNothingSelected(AdapterView<?> arg0) {
		                      // TODO Auto-generated method stub
		                  }
		              }
		          );
		 
					
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	

	/**
	 * A placeholder fragment containing a simple view.
	 */
	
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
	//START OF VOLUME ROCKER ayy lmao!
	
	 @Override
	    public boolean onKeyDown(int keyCode, KeyEvent event) {
	        if ((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)){
	            //Do something:
	        	Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
	            v.vibrate(500);
	            new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/shutter?p=0");
	        }
	        if ((keyCode == KeyEvent.KEYCODE_VOLUME_UP)){
	            //Do something:
	        	Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
	            v.vibrate(500);
	            new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/shutter?p=1");
	        }
	        return true;
	    }
	// END OF VOLUME ROCKER ROFLMAO!!
	
	//START OF THE WIFI HERO4 COMMANDS:
	
	public void sendTrigger(View view) {
		Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(1000);
		Toast.makeText(getApplicationContext(), 
                "Trigger!", Toast.LENGTH_SHORT).show();
//GET("http://10.5.5.9/gp/gpControl/command/shutter?p=1");
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/shutter?p=1");
		
	}
	public void sendStop(View view) {
		Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(1000);
		Toast.makeText(getApplicationContext(), 
                "Stopped!", Toast.LENGTH_SHORT).show();
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/shutter?p=0");
		
	}
	public void sendTag(View view) {
		Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
         v.vibrate(500);
		Toast.makeText(getApplicationContext(), 
                "Tagged!", Toast.LENGTH_SHORT).show();
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/storage/tag_moment");
	}
	public void sendVideo(View view) {
		Toast.makeText(getApplicationContext(), 
                "Set to Video mode!", Toast.LENGTH_LONG).show();
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/mode?p=0");
	}
	public void sendPhoto(View view) {
		Toast.makeText(getApplicationContext(), 
                "Set to Photo mode!", Toast.LENGTH_LONG).show();
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/mode?p=1");
	}
	public void sendMultishot(View view) {
		Toast.makeText(getApplicationContext(), 
                "Set to MultiShot mode!", Toast.LENGTH_LONG).show();
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/mode?p=2");
	}
	public void sendHD(View view) {
		Toast.makeText(getApplicationContext(), 
                "HD Resolution!", Toast.LENGTH_LONG).show();
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/1");
	}
	public void sendMidres(View view) {
		Toast.makeText(getApplicationContext(), 
                "1080p FTW!", Toast.LENGTH_LONG).show();
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/9");
	}
	public void sendSlowMo(View view) {
		Toast.makeText(getApplicationContext(), 
                "That epic slow mo!", Toast.LENGTH_LONG).show();
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/12");
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/3/0");
	}
 //RISKY ZONE:
	public void sendModeVideoVideo(View view) {
		Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
		Toast.makeText(getApplicationContext(), 
                "Video mode!", Toast.LENGTH_SHORT).show();
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/68/0");
	}
public void sendModeVideoLooping(View view) {
		Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
		Toast.makeText(getApplicationContext(), 
                "Looping video!", Toast.LENGTH_SHORT).show();
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/68/3");
	}
public void sendModeVideoVideoPhoto(View view) {
		Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
		Toast.makeText(getApplicationContext(), 
                "Video plus photo!", Toast.LENGTH_SHORT).show();
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/68/2");
	}
public void sendModePhotoSingle(View view) {
		Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
		Toast.makeText(getApplicationContext(), 
                "Photo mode!", Toast.LENGTH_SHORT).show();
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/69/0");
	}

public void sendModePhotoContinuous(View view) {
		Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
		Toast.makeText(getApplicationContext(), 
                "Continuous photo mode!", Toast.LENGTH_SHORT).show();
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/69/1");
	}
public void sendModePhotoNight(View view) {
		Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
		Toast.makeText(getApplicationContext(), 
                "Night photo mode!", Toast.LENGTH_SHORT).show();
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/69/2");
	}

public void sendModeMSBurst(View view) {
		Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
		Toast.makeText(getApplicationContext(), 
                "Burst mode!", Toast.LENGTH_SHORT).show();
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/70/0");
	}

public void sendModeMSNightLapse(View view) {
		Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
		Toast.makeText(getApplicationContext(), 
                "Nightlapse!", Toast.LENGTH_SHORT).show();
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/70/1");
	}
public void sendModeMSTimeLapse(View view) {
		Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
		Toast.makeText(getApplicationContext(), 
                "Timelapse mode!", Toast.LENGTH_SHORT).show();
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/70/2");
	}
//FOVs

public void sendNarrowFOV(View view) {
	Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
    v.vibrate(80);
	Toast.makeText(getApplicationContext(), 
            "2sec", Toast.LENGTH_SHORT).show();
	new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/4/2");
}
public void sendMediumFOV(View view) {
	Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
    v.vibrate(80);
	Toast.makeText(getApplicationContext(), 
            "5sec", Toast.LENGTH_SHORT).show();
	new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/4/1");
}
public void sendWideFOV(View view) {
	Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
    v.vibrate(80);
	Toast.makeText(getApplicationContext(), 
            "10sec", Toast.LENGTH_SHORT).show();
	new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/4/0");
}
//EXPOSURE TIMES FOR NIGHT PHOTO:

public void sendETNP2(View view) {
	Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
    v.vibrate(80);
	Toast.makeText(getApplicationContext(), 
            "2sec", Toast.LENGTH_SHORT).show();
	new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/19/1");
}
public void sendETNP5(View view) {
	Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
    v.vibrate(80);
	Toast.makeText(getApplicationContext(), 
            "5sec", Toast.LENGTH_SHORT).show();
	new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/19/2");
}
public void sendETNP10(View view) {
	Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
    v.vibrate(80);
	Toast.makeText(getApplicationContext(), 
            "10sec", Toast.LENGTH_SHORT).show();
	new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/19/3");
}
public void sendETNP15(View view) {
	Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
    v.vibrate(80);
	Toast.makeText(getApplicationContext(), 
            "15sec", Toast.LENGTH_SHORT).show();
	new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/19/4");
}
public void sendETNP20(View view) {
	Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
    v.vibrate(80);
	Toast.makeText(getApplicationContext(), 
            "20sec", Toast.LENGTH_SHORT).show();
	new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/19/5");
}
public void sendETNP30(View view) {
	Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
    v.vibrate(80);
	Toast.makeText(getApplicationContext(), 
            "30sec", Toast.LENGTH_SHORT).show();
	new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/19/6");
}
 // END OF RISKY ZONE; CARRY ON.


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
	 
	    private static String convertInputStreamToString(InputStream inputStream) throws IOException{
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
	            Toast.makeText(getBaseContext(), "Done!", Toast.LENGTH_LONG).show();
	           ;
	       }
	    }
}

