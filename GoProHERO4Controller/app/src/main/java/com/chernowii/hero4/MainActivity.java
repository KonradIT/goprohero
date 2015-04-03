package com.chernowii.hero4;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.Camera;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.*;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorListener;
import android.hardware.SensorEventListener;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.location.Address;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.RingtoneManager;
import android.media.session.MediaSession;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.text.format.Formatter;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
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
import android.location.Location;
import android.location.LocationListener;
import android.widget.EditText;
import android.widget.TextView;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.OutputStreamWriter;
import java.nio.channels.ClosedChannelException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import android.app.Notification;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureRequest;
import android.app.NotificationManager;

import android.app.PendingIntent;

import android.content.Intent;
import android.graphics.Outline;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.RemoteInput;
import android.app.Notification;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.content.Context;
import java.lang.UnsupportedOperationException;
import android.location.LocationManager;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureRequest;

public class MainActivity extends Activity {
    String version = "v11-alpha";
    private static final String AUDIO_RECORDER_FILE_EXT_3GP = ".3gp";
    private static final String AUDIO_RECORDER_FILE_EXT_MP4 = ".mp4";
    private static final String AUDIO_RECORDER_FOLDER = "AudioRecorder";
    private static final String PREFS_NAME = "";
    private MediaRecorder recorder = null;
    private int currentFormat = 0;
    private int output_formats[] = { MediaRecorder.OutputFormat.MPEG_4, MediaRecorder.OutputFormat.THREE_GPP };
    private String file_exts[] = { AUDIO_RECORDER_FILE_EXT_MP4, AUDIO_RECORDER_FILE_EXT_3GP };
    GPStracker gps;
    NotificationCompat.WearableExtender wearableExtender =
            new NotificationCompat.WearableExtender()
                    .setHintShowBackgroundOnly(true);

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_MEDIA_BUTTON.equals(intent.getAction())) {
            KeyEvent event = (KeyEvent)intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
            if (KeyEvent.KEYCODE_MEDIA_PLAY == event.getKeyCode()) {
                Toast.makeText(getApplicationContext(),
                        "Test!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                new AlertDialog.Builder(this)
                        .setTitle("About GoProHero")
                        .setMessage("Developed by Konrad Iturbe\n/u/konrad-iturbe | @KonradIT in XDA and GitHub\nGOPRO, HERO, the GOPRO logo, and the GoPro Be a Hero logo are trademarks or registered trademarks of GoPro, Inc\nHow to use it:\nHeroControl: creates a notification with three main controls that can be accessed from the lock screen, car stereo UI, android wear and more.\nThe live preview may lag a bit, this is normal :)\nIf you own a HERO2/HERO3/HERO3+ go to the 3 dot menu and tap on Set up password, its necessary to input the GoPro password.\nVersion: " + version)
                        .setPositiveButton(R.string.webpage, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.github.com/KonradIT/goprohero/blob/master/README.md"));
                                startActivity(browserIntent);
                            }
                        })
                        .setNeutralButton(R.string.reddit, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.reddit.com/r/Android/comments/2zxv84/devalpha_goprohero_unofficial_gopro_app/"));
                                startActivity(browserIntent);
                            }
                        })

                        .setNegativeButton(R.string.back, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(R.drawable.ic_launcher)
                        .show();

                return true;
           // case R.id.action_config:
            //    Intent intentTwo = new Intent(this, ConfigScreen.class);
              //  startActivity(intentTwo);
             //   return true;
            case R.id.action_calc:
                Intent intentThree = new Intent(this, Calculator.class);
                startActivity(intentThree);
                return true;
            case R.id.action_oldcam:
                Intent intentFour = new Intent(this, OldCamActivity.class);
                startActivity(intentFour);
                return true;
         /*   case R.id.action_profilesettings:
                Intent intentFour = new Intent(this, ProfileConfig.class);
                startActivity(intentFour);
                return true;
                */
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private NotificationManager mNotificationManager;
    private int notificationID = 100;
    private int numMessages = 0;

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
        }
        setTitle("GoProHero");
        getActionBar().setIcon(R.drawable.icono);
        WifiManager wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        final TextView mTextView = (TextView) findViewById(R.id.connectedcam);
        Log.d("wifiInfo", wifiInfo.toString());
        String wifiSSID = wifiInfo.getSSID();
        int ip = wifiInfo.getIpAddress();
        String ipAddress = Formatter.formatIpAddress(ip);
        String gopro = "10.5.5.100";
        String goprotwo = "10.5.5.109";
        mTextView.setText(wifiSSID);
        Toast.makeText(getApplicationContext(),
                ipAddress, Toast.LENGTH_SHORT).show();
        if (ipAddress.equals(gopro)){
            mTextView.setTextColor(Color.parseColor("#00FF00"));
        }

        else{
            if (ipAddress.equals(goprotwo)){
                Intent intentFour = new Intent(this, OldCamActivity.class);
                startActivity(intentFour);
            }
            else {
                mTextView.setTextColor(Color.parseColor("#FF0000"));
                new AlertDialog.Builder(this)
                        .setTitle("Camera not connected")
                        .setMessage("1. Make sure your GoPro has wifi turned on by checking in the LCD screen/back screen. If not, turn it on by going to the settings and scrolling until Wifi, then set GoPro app, choose Existing\n2. Tap on Open Wifi settings below and connect to the GoPro camera. \n3. Restart the app.")
                        .setPositiveButton(R.string.wifi, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent browserIntent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                                startActivity(browserIntent);
                            }
                        })

                        .setNegativeButton(R.string.back, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(R.drawable.ic_launcher)
                        .show();
            }
        }
    }
    public void startGPAudioRec(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Trigger + Audio!", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/shutter?p=1");
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(output_formats[currentFormat]);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy--HH-mm-ss");
        //get current date time with Date()
        Date date = new Date();
        String thedate = dateFormat.format(date);
        recorder.setOutputFile("sdcard/GoProRecording " + thedate + ".mp3");
        try {
            recorder.prepare();
            recorder.start();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        final TextView mTextView = (TextView) findViewById(R.id.recstatus);
        mTextView.setText("Status: recording");

    }

public void startJSONDiscovery(View view){

}
    public void stopGPAudioRec(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Stopped + Audio!", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/shutter?p=0");
        if (null != recorder) {
            recorder.stop();
            recorder.reset();
            recorder.release();
            recorder = null;
        }
        final TextView mTextView = (TextView) findViewById(R.id.recstatus);
        mTextView.setText("Status: ready");
    }
    public void startGPSLog(View view){
        gps = new GPStracker(MainActivity.this);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy--HH-mm-ss");
        //get current date time with Date()
        Date date = new Date();
        String thedate = dateFormat.format(date);
        DateFormat dateFormatTwo = new SimpleDateFormat("dd-MM-yyyy");
        //get current date time with Date()
        Date dateTwo = new Date();
        String theotherdate = dateFormatTwo.format(dateTwo);
        String thisfiledate = dateFormatTwo.format(dateTwo);
        // check if GPS enabled
        if(gps.canGetLocation()){

            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();

            // \n is for new line
            Toast.makeText(getApplicationContext(), "GPS Tracking started", Toast.LENGTH_LONG).show();
            try {
                File myFile = new File("/sdcard/GoProGPSTrack" + theotherdate + ".txt");
                myFile.createNewFile();
                FileOutputStream fOut = new FileOutputStream(myFile);
                OutputStreamWriter myOutWriter =
                        new OutputStreamWriter(fOut);
                myOutWriter.append("<gpx>");
                myOutWriter.append("<trk>");
                myOutWriter.append("<name>GoPro Track</name>");
                myOutWriter.append("<trkseg>");
                myOutWriter.append("<latitude>" + latitude + "</latitude>");
                myOutWriter.append("<longitude>" + longitude + "</longitude>");
                myOutWriter.append("<time>" + date + "</time>");
                myOutWriter.append("</trkseg>");
                myOutWriter.close();
                fOut.close();
            } catch (Exception e) {
                Toast.makeText(getBaseContext(), e.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        }else{
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
        }

}



    public void goProControlNotification(View view) {
        // Prepare intent which is triggered if the
        // notification is selected
        Intent intent = new Intent(this, TriggerActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent intentTwo = new Intent(this, TagActivity.class);
        PendingIntent pIntentTwo = PendingIntent.getActivity(this, 0, intentTwo, PendingIntent.FLAG_UPDATE_CURRENT);
        Intent intentThree = new Intent(this, StopActivity.class);
        PendingIntent pIntentThree = PendingIntent.getActivity(this, 0, intentThree, PendingIntent.FLAG_UPDATE_CURRENT);
        Intent intentFour = new Intent(this, VideoActivity.class);
        PendingIntent pIntentFour = PendingIntent.getActivity(this, 0, intentFour, PendingIntent.FLAG_UPDATE_CURRENT);
        Intent intentFive = new Intent(this, PhotoActivity.class);
        PendingIntent pIntentFive = PendingIntent.getActivity(this, 0, intentFive, PendingIntent.FLAG_UPDATE_CURRENT);
        Intent intentSix = new Intent(this, MSActivity.class);
        PendingIntent pIntentSix = PendingIntent.getActivity(this, 0, intentSix, PendingIntent.FLAG_UPDATE_CURRENT);
        // Build notification
        // Actions are just fake
        Notification noti = new Notification.Builder(this)
                .setContentTitle("Control your GoPro camera!")

                .setContentText("Right from lockscreen, car, wear watch and more!").setSmallIcon(R.drawable.icono)
             //   .setContentIntent(pIntent)
                .setPriority(0)
                .addAction(R.drawable.ic_trigger, "Trigger", pIntent)
                .addAction(R.drawable.ic_tag, "Tag", pIntentTwo)
                .addAction(R.drawable.ic_stop, "Stop", pIntentThree)
                .addAction(R.drawable.ig_video, "Video mode", pIntentFour)
                .addAction(R.drawable.ic_photo, "Photo mode", pIntentFive)
                .addAction(R.drawable.ic_ms, "MultiShot mode", pIntentSix).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // hide the notification after its selected
        noti.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0, noti);

    }


    private Camera camera;
    Camera.Parameters params;
    public void sendFlash(View view) {
        camera = Camera.open();
        params = camera.getParameters();
        params = camera.getParameters();
        params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(params);
        camera.startPreview();
    }


    public void sendTriggerWear() {
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/shutter?p=1");
    }
    public static void sendStopWear() {
    }
    public static void sendTagWear() {

    }

    public void sendDisplayAdvancedProtune(View view) {
        Intent intent = new Intent(this, ProtuneControls.class);
        startActivity(intent);
       // MainActivity.setContentView(R.layout.activity_protune_controls);
    }
    public void sendDisplayLiveViewH4(View view) {
        Intent intentTwo = new Intent(this, LiveStuffH4.class);
        startActivity(intentTwo);
    }
    public void sendHDR(View view) {
        Intent intentTwo = new Intent(this, HDR.class);
        startActivity(intentTwo);
    }
    public void sendMediaBrowser(View view) {
        Intent intentTwo = new Intent(this, MediaBrowser.class);
        startActivity(intentTwo);
    }
    public void sendOldCam(View view) {
        Intent intentTwo = new Intent(this, OldCamActivity.class);
        startActivity(intentTwo);
    }
    public void sendOldCamSet(View view) {
        Intent intentTwo = new Intent(this, WelcomeScreen.class);
        startActivity(intentTwo);
    }
    public void sendTriggerTest2() {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Trigger!", Toast.LENGTH_SHORT).show();
//GET("http://10.5.5.9/gp/gpControl/command/shutter?p=1");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/shutter?p=1");
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
                v.vibrate(200);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                v.vibrate(300);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                v.vibrate(300);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                v.vibrate(300);
                Toast.makeText(getApplicationContext(),
                        "Stopped!", Toast.LENGTH_SHORT).show();
	            new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/shutter?p=0");
	        }
	        if ((keyCode == KeyEvent.KEYCODE_VOLUME_UP)){
	            //Do something:
                Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                v.vibrate(600);
                Toast.makeText(getApplicationContext(),
                        "Trigger!", Toast.LENGTH_SHORT).show();
	            new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/shutter?p=1");
	        }
	        return true;
	    }
	// END OF VOLUME ROCKER ROFLMAO!!
	//SOME GOOD NOTIFICATION LMAOs


        //START OF THE WIFI HERO4 COMMANDS:

public void sendTrigger(View view) {
		Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Trigger!", Toast.LENGTH_SHORT).show();
//GET("http://10.5.5.9/gp/gpControl/command/shutter?p=1");
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/shutter?p=1");
      // new HttpAsyncTask().execute("http://10.5.5.9/bacpac/SH?t=20161962&p=%01");
    }

    public void sendTriggerGPS(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Trigger!", Toast.LENGTH_SHORT).show();
//GET("http://10.5.5.9/gp/gpControl/command/shutter?p=1");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/shutter?p=1");
    }
    public void sendAbout(View view) {
        new AlertDialog.Builder(this)
                .setTitle("About GoProHero")
                .setMessage("Developed by Konrad Iturbe\nGOPRO, HERO, the GOPRO logo, and the GoPro Be a Hero logo are trademarks or registered trademarks of GoPro, Inc")
                .setPositiveButton(R.string.webpage, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.github.com/KonradIT/goprohero/blob/master/README.md"));
                        startActivity(browserIntent);
                    }
                })
                .setNeutralButton(R.string.reddit, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.reddit.com/r/Android/comments/2zxv84/devalpha_goprohero_unofficial_gopro_app/"));
                        startActivity(browserIntent);
                    }
                })

                .setNegativeButton(R.string.back, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(R.drawable.icono)
                .show();
    }


    public void sendStop(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(200);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        v.vibrate(300);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        v.vibrate(300);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        v.vibrate(300);
		Toast.makeText(getApplicationContext(), 
                "Stopped!", Toast.LENGTH_SHORT).show();
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/shutter?p=0");

	}
	public void sendTag(View view) {
		Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(300);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        v.vibrate(300);
		Toast.makeText(getApplicationContext(), 
                "Tagged!", Toast.LENGTH_SHORT).show();
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/storage/tag_moment");
	}
	public void sendVideo(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
		Toast.makeText(getApplicationContext(), 
                "Set to Video mode!", Toast.LENGTH_SHORT).show();
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/mode?p=0");
	}
	public void sendPhoto(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
		Toast.makeText(getApplicationContext(), 
                "Set to Photo mode!", Toast.LENGTH_SHORT).show();
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/mode?p=1");
	}
	public void sendMultishot(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
		Toast.makeText(getApplicationContext(), 
                "Set to MultiShot mode!", Toast.LENGTH_SHORT).show();
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/mode?p=2");
	}
	public void sendHD(View view) {
		Toast.makeText(getApplicationContext(), 
                "HD Resolution!", Toast.LENGTH_SHORT).show();
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/1");
	}
	public void sendMidres(View view) {
		Toast.makeText(getApplicationContext(), 
                "1080p FTW!", Toast.LENGTH_SHORT).show();
		new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/9");
	}
	public void sendSlowMo(View view) {
		Toast.makeText(getApplicationContext(), 
                "That epic slow mo!", Toast.LENGTH_SHORT).show();
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

    //RESOLUTION FOR VIDEO
    public void sendVR4K(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "4K!", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/1");
    }
    public void sendVR4KS(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "4K SuperView!", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/2");
    }
    public void sendVR27K(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "2.7K!", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/4");
    }
    public void sendVR27KS(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "2.7K SuperView!", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/5");
    }
    public void sendVR27K43(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "2.7K 4:3!", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/6");
    }
    public void sendVR1440P(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "1440P!", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/7");
    }
    public void sendVR1080PS(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "1080P SuperView!", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/8");
    }
    public void sendVR1080P(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "1080p!", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/9");
    }
    public void sendVR960P(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "960p!", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/10");
    }
    public void sendVR720PS(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "720p SuperView!", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/11");
    }
    public void sendVR720P(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "720p!", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/12");
    }
    public void sendVRWVGA(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "WVGA!", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/13");
    }
//FOVs

public void sendNarrowFOV(View view) {
	Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
    v.vibrate(80);
	Toast.makeText(getApplicationContext(), 
            "Narrow", Toast.LENGTH_SHORT).show();
	new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/4/2");
}
public void sendMediumFOV(View view) {
	Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
    v.vibrate(80);
	Toast.makeText(getApplicationContext(), 
            "Medium", Toast.LENGTH_SHORT).show();
	new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/4/1");
}
public void sendWideFOV(View view) {
	Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
    v.vibrate(80);
	Toast.makeText(getApplicationContext(), 
            "Wide", Toast.LENGTH_SHORT).show();
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

    public void send12MPW(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "12MP W", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/17/0");
    }
    public void send7MPW(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "12MP W", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/17/1");
    }

    public void send7MPM(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "12MP W", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/17/2");
    }

    public void send5MPW(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "12MP W", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/17/3");
    }

    public void sendETNI2(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "2sec", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/31/1");
    }
    public void sendETNI5(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "5sec", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/31/2");
    }
    public void sendETNI10(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "10sec", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/31/3");
    }
    public void sendETNI15(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "15sec", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/31/4");
    }
    public void sendETNI20(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "20sec", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/31/5");
    }
    public void sendETNI30(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(80);
        Toast.makeText(getApplicationContext(),
                "30sec", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/31/6");
    }
    public static int myVar = 1;
    public void send120FPS(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "120FPS", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/3/0");
    }
    public void send60FPS(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(400);
        Toast.makeText(getApplicationContext(),
                "60FPS", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/3/5");
    }
    public void send30FPS(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(200);
        Toast.makeText(getApplicationContext(),
                "30FPS", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/3/8");
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
    public void send05TLI(View view) {
        Toast.makeText(getApplicationContext(),
                "Timelapse 0.5 seconds", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/30/0");
    }
    public void send1TLI(View view) {
        Toast.makeText(getApplicationContext(),
                "Timelapse 1 second", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/30/1");
    }
    public void send2TLI(View view) {
        Toast.makeText(getApplicationContext(),
                "Timelapse 2 seconds", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/30/2");
    }
    public void send5TLI(View view) {
        Toast.makeText(getApplicationContext(),
                "Timelapse 5 seconds", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/30/5");
    }
    public void send10TLI(View view) {
        Toast.makeText(getApplicationContext(),
                "Timelapse 10 seconds", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/30/10");
    }
    public void send30TLI(View view) {
        Toast.makeText(getApplicationContext(),
                "Timelapse 30 seconds", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/30/30");
    }
    public void send60TLI(View view) {
        Toast.makeText(getApplicationContext(),
                "Timelapse 60 seconds", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/30/60");
    }


    public void sendQKOn(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "QuikCapture ON", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/54/1");
    }
    public void sendQKOff(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "QuikCapture OFF", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/54/0");
    }

    public void sendLEDOff(View view) {
        Toast.makeText(getApplicationContext(),
                "LEDs OFF", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/55/0");
    }
    public void sendLED2(View view) {
        Toast.makeText(getApplicationContext(),
                "LEDs 2", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/55/1");
    }
    public void sendLED4(View view) {
        Toast.makeText(getApplicationContext(),
                "LEDs 4", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/55/2");
    }
    public void sendBuzzerOff(View view) {
        Toast.makeText(getApplicationContext(),
                "Buzzer Off", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/56/2");
    }
    public void sendBuzzer70(View view) {
        Toast.makeText(getApplicationContext(),
                "Buzzer 70%", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/56/1");
    }
    public void sendBuzzer100(View view) {
        Toast.makeText(getApplicationContext(),
                "Buzzer 100%", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/56/0");
    }

    public void sendActionProfile(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Be A HERO", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/9");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/3/5");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/4/0");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/10/0");
    }
    public void sendCinemaProfile(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(300);
        Toast.makeText(getApplicationContext(),
                "Be A HERO", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/4");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/3/10");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/4/0");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/10/1");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/11/4");
    }
    public void sendGPS(View view) {

        }

    public void sendIndoorProfile(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(400);
        Toast.makeText(getApplicationContext(),
                "Be A HERO", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/9");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/3/8");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/4/0");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/10/0");
    }
    public void sendProfileOne(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(400);

        String videoResolutionOne = "";
        String frameRateOne = "";
        String fovOne = "";
        String protuneOne = "";
        String wbOne = "";
        String colorOne = "";
        String isoOne = "";
        String sharpnessOne = "";
        String evOne = "";
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/" + videoResolutionOne);
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/3/" + frameRateOne);
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/4/" + fovOne);
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/10/" + protuneOne);
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/11/" + wbOne);
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/12/" + colorOne);
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/13/" + isoOne);
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/14/" + sharpnessOne);
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/15/" + evOne);
    }
    public void sendProfileTwo(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(400);
        Toast.makeText(getApplicationContext(),
                "Be A HERO", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/9");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/3/8");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/4/0");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/10/0");
    }
    public void sendProfileThree(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(400);
        Toast.makeText(getApplicationContext(),
                "Be A HERO", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/2/9");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/3/8");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/4/0");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/10/0");
    }

    public void sendWiFiOff(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Wifi Off", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/63/0");
    }
    public void sendCamOff(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Turned off", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/system/sleep");
    }
    public void sendFullOff(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "WiFi+Camera OFF", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/system/sleep");
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/63/0");
    }
    public void sendDeleteAll(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Camera media empty", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/storage/delete/all");
    }
    public void sendDeleteLast(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "Deleted last file", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/command/storage/delete/last");
    }
    public void sendLCDOn(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "LCD ON", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/72/1");
    }
    public void sendLCDOff(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "LCD OFF", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/72/0");
    }
    public void sendLCDHigh(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "LCD High", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/49/0");
    }
    public void sendLCDMedium(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "LCD Medium", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/49/1");
    }
    public void sendLCDLow(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "LCD Low", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/49/2");
    }
    public void sendLCDLock(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "LCD Locked", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/50/1");
    }
    public void sendLCDUnlock(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "LCD Unlocked", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/50/0");
    }
    public void sendLCDNever(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "LCD Sleep never", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/51/0");
    }
    public void sendLCD1Min(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "LCD Sleep 1 min", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/51/1");
    }
    public void sendLCD2Min(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "LCD Sleep 2 Min", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/51/2");
    }
    public void sendLCD3Min(View view) {
        Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(600);
        Toast.makeText(getApplicationContext(),
                "LCD Sleep 3 Min", Toast.LENGTH_SHORT).show();
        new HttpAsyncTask().execute("http://10.5.5.9/gp/gpControl/setting/51/3");
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
	            Toast.makeText(getBaseContext(), "Done!", Toast.LENGTH_SHORT).show();
	           ;
	       }
	    }
}

