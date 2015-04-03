package com.chernowii.hero4;

import java.net.URL;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

    public class  LiveStuffH4 extends Activity implements MediaPlayer.OnPreparedListener, SurfaceHolder.Callback {
        final static String USERNAME = "admin";
        final static String PASSWORD = "camera";
        final static String RTSP_URL = "udp://:8554";

        private MediaPlayer _mediaPlayer;
        private SurfaceHolder _surfaceHolder;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Set up a full-screen black window.
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            Window window = getWindow();
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            window.setBackgroundDrawableResource(android.R.color.black);

            setContentView(R.layout.activity_live_stuff);

            // Configure the view that renders live video.
            SurfaceView surfaceView =
                    (SurfaceView) findViewById(R.id.surfaceView);
            _surfaceHolder = surfaceView.getHolder();
            _surfaceHolder.addCallback(this);
            _surfaceHolder.setFixedSize(320, 240);
        }


        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }




/*
SurfaceHolder.Callback
*/




        @Override
        public void surfaceCreated(SurfaceHolder sh) {
            _mediaPlayer = new MediaPlayer();
            _mediaPlayer.setDisplay(_surfaceHolder);

            Context context = getApplicationContext();
       //     Map<String, String> headers = getRtspHeaders();
            Uri source = Uri.parse(RTSP_URL);

            try {
                // Specify the IP camera's URL and auth headers.
             //   _mediaPlayer.setDataSource(context, source, headers);

                // Begin the process of setting up a video stream.
                _mediaPlayer.setOnPreparedListener(this);
                _mediaPlayer.prepareAsync();
            }
            catch (Exception e) {}
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder sh) {
            _mediaPlayer.release();
        }
        /*
        MediaPlayer.OnPreparedListener
        */
        @Override
        public void onPrepared(MediaPlayer mp) {
            _mediaPlayer.start();
        }

    }



