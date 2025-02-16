package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.Arrays;

public class quizactivity extends AppCompatActivity {

//    TextView tvname;
TextView cvquestion;
Button btnnext;
RadioButton option_1;
RadioButton option_2;
RadioButton option_3;
RadioButton option_4;
    RadioGroup radioGroup;
    TextView tvprevious;
    private int[] optionsselected={0,0,0,0,0};
    private String[] questions = {
            "What is the capital of France?",
            "Which planet is known as the Red Planet?",
            "What is 5 + 3?",
            "Who wrote 'To Kill a Mockingbird'?",
            "What is the square root of 16?"
    };

    private String[][] options = {
            {"Paris", "London", "Berlin", "Madrid"},
            {"Earth", "Mars", "Jupiter", "Venus"},
            {"5", "7", "8", "9"},
            {"Harper Lee", "Mark Twain", "J.K. Rowling", "Shakespeare"},
            {"2", "3", "4", "5"}
    };
private  int[] marks={0,0,0,0,0};
    private int[] answers = {0, 1, 2, 0, 2}; // Correct options index
    private int currentQuestion = 0;
    private int score = 0;
    private int selectedAnswer = -1;
    private  int lastquestion=4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quizactivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

init();
       Intent intent=getIntent();

       String name=intent.getStringExtra("Name");

        //tvname.setText(name);
//        if (currentQuestion == questions.length - 1) {
//            btnnext.setText(R.string.finish);
//        } else {
//            btnnext.setText(R.string.enter);
//        }
        loadquestion();
tvprevious.setOnClickListener((view)->{
    if(currentQuestion==0){


        Toast.makeText(this,"Can't go back.",Toast.LENGTH_SHORT).show();

    }else {
        questionnumber1();
        currentQuestion--;



        loadquestion();

    }
});
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


if(currentQuestion!=5){
                checkanswer();

}
//                if (currentQuestion == questions.length - 1) {
//                    btnnext.setText(R.string.finish);
//                } else {
//                    btnnext.setText(R.string.enter);
//                }
                currentQuestion++;
                questionnumber();

             /*   if (currentQuestion == questions.length - 1) {
                    btnnext.setText(R.string.finish);
                } else {
                    btnnext.setText(R.string.Next);
                }*/
                if(currentQuestion==5)
                {
                  //  calltoast();

                    Intent intent1=new Intent(quizactivity.this,Scoreboard.class);
                    String scoreString = String.valueOf(Arrays.stream(marks).sum());

                    intent1.putExtra("score",scoreString);
                    intent1.putExtra("name",name);

                    startActivity(intent1);
                    finish();
                }
else{
                    radioGroup.clearCheck();
                loadquestion();}
            }
        });
   }
   private void questionnumber()
   {


       if (currentQuestion == questions.length-1) {
           btnnext.setText(R.string.finish);
       } else {
           btnnext.setText(R.string.Next);
       }
   }
    private void questionnumber1()
    {


        if (currentQuestion == questions.length ) {
            btnnext.setText(R.string.finish);
        } else {
            btnnext.setText(R.string.Next);
        }
    }
   private  void calltoast(){



       Toast.makeText(this,score,Toast.LENGTH_SHORT).show();
   }
private void checkanswer()
{
    int selectedid=radioGroup.getCheckedRadioButtonId();

    if(selectedid!=-1){
        RadioButton radiobt=findViewById(selectedid);
        String ans=radiobt.getText().toString();
        optionsselected[currentQuestion]=selectedid;

        if(ans.equals(options[currentQuestion][answers[currentQuestion]]))
        {

           // score++;
marks[currentQuestion]=1;
            Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();


        }
        else {
marks[currentQuestion]=0;

            Toast.makeText(this, "Wrong answer", Toast.LENGTH_SHORT).show();


        }


    }
    else
    {

        marks[currentQuestion]=0;

        Toast.makeText(this, "Wrong answer", Toast.LENGTH_SHORT).show();

    }




}
private void loadquestion()
{ radioGroup.clearCheck();
    if (optionsselected[currentQuestion] != 0) {
        radioGroup.check(optionsselected[currentQuestion]);
    }

    cvquestion.setText(questions[currentQuestion]);
option_1.setText(options[currentQuestion][0]);
option_2.setText(options[currentQuestion][1]);
option_3.setText(options[currentQuestion][2]);
option_4.setText(options[currentQuestion][3]);

}

   private void init(){



        cvquestion=findViewById(R.id.cvquestion);
        btnnext=findViewById(R.id.btnnext);
        option_1=findViewById(R.id.radio_option1);
        option_2=findViewById(R.id.radio_option2);
        option_3=findViewById(R.id.radio_option3);
        option_4=findViewById(R.id.radio_option4);
       radioGroup=findViewById(R.id.radioGroup);
       tvprevious=findViewById(R.id.tvprevious);
   }


}