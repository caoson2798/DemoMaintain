package com.example.daiphongpc.demomaintain.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daiphongpc.demomaintain.R;

import java.util.Timer;
import java.util.TimerTask;

public class WaitActivity extends AppCompatActivity {
    ImageView imgMaintain;
    Animation animation;
    TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait);
        addControls();
    }

    private void addControls() {
        imgMaintain=findViewById(R.id.img_maintain);
        txtTitle=findViewById(R.id.txt_title);
        animation=AnimationUtils.loadAnimation(this,R.anim.img_main);
        animation.setStartOffset(1000);
        animation.setRepeatCount(Animation.INFINITE);
        imgMaintain.startAnimation(animation);
        txtTitle.startAnimation(animation);

        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(WaitActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        };

        Timer timer=new Timer();
        timer.schedule(timerTask,5000);
    }
}
