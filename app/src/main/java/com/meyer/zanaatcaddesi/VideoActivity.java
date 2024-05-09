package com.meyer.zanaatcaddesi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VideoActivity extends AppCompatActivity {
    private VideoView videoView;
    private Button buttonToMainActivity;
    private final long startTime = 15000;
    TextView sayac;
    int sure=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_video);
        videoView =findViewById(R.id.videosrc);
        sayac=findViewById(R.id.countSayac);
        buttonToMainActivity = findViewById(R.id.sardırButton);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVideoPath(String.valueOf(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video)));
        videoView.start();
        startCountdownTimer();

        buttonToMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        buttonToMainActivity.setVisibility(View.GONE);


    }
    private void startCountdownTimer() {
        new CountDownTimer(startTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                sayac.setText("kalan süre:"+sure);
                sure--;
            }

            @Override
            public void onFinish() {
                
                sayac.setVisibility(View.GONE);
                buttonToMainActivity.setVisibility(View.VISIBLE);
            }
        }.start();
    }
}