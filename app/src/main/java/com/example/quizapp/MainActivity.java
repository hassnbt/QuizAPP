package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    ImageView ivLogo;
    CardView cvcard;
    Animation slidedown;
    Animation move;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

init();

ivLogo.startAnimation(slidedown);
cvcard.startAnimation(move);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);

                finish();


            }
        },1750);
    }


    private void init()
    {

        ivLogo=findViewById(R.id.iVLogo);
        cvcard=findViewById(R.id.cvcard);

slidedown= AnimationUtils.loadAnimation(this,R.anim.animation_logo);
move=AnimationUtils.loadAnimation(this,R.anim.animation_card);
    }
}