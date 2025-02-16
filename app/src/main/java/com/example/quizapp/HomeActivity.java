package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    Animation slide;
    Animation rotate;
    ImageView logo;
    CardView card;
    EditText etName;
    Button btsubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
init();

card.startAnimation(slide);
logo.startAnimation(rotate);

btsubmit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
String name=etName.getText().toString();

Intent intent=new Intent(HomeActivity.this, quizactivity.class);
intent.putExtra("Name",name);

startActivity(intent);

finish();
    }
});
    }
    private void init()
    {

card=findViewById(R.id.cvcard1);
logo=findViewById(R.id.ivlogo1);
etName=findViewById(R.id.etName);
btsubmit=findViewById(R.id.btsubmit);
slide= AnimationUtils.loadAnimation(this,R.anim.animation_card1);
rotate=AnimationUtils.loadAnimation(this,R.anim.animation_logo1);

    }
}