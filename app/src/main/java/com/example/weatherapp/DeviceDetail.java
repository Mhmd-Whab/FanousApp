package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class DeviceDetail extends AppCompatActivity {
    VideoView vid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_detail);

        /*vid= (VideoView) findViewById(R.id.videoView);
        String videopath = "android.resource://"+ getPackageName()+"/"+R.raw.video1;
        Uri uri = Uri.parse(videopath);
        vid.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        vid.setMediaController(mediaController);
        mediaController.setAnchorView(vid);
        vid.start();*/

    }
}
