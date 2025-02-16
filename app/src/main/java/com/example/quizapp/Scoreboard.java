package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Scoreboard extends AppCompatActivity {
TextView tvnam;
TextView tvscore;
Button btnshare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_scoreboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
       String score =intent.getStringExtra("score");
        tvnam.setText(name);
        tvscore.setText(score);
        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Share Your awsome score which is "+score);
                Intent chooser = Intent.createChooser(shareIntent, "Share via");
                startActivity(chooser);
            }
        });
    }
    private void init()
    {

        tvnam=findViewById(R.id.tvnam);
        tvscore=findViewById(R.id.tvscore);
btnshare=findViewById(R.id.btnshare);

    }
}