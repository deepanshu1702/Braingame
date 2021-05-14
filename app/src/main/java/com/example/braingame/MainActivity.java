package com.example.braingame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button goButton;
    TextView sumText;
    TextView resultText;
    TextView scoreText;
    TextView timerText;
    int locationca;
    int score=0;
    int numberofq=0;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button playAgain;
    ConstraintLayout gameLayout;



    ArrayList<Integer> answers=new ArrayList<Integer>();

    public void playAgain(View view){
        score=0;
        numberofq=0;
        timerText.setText("30s");
        resultText.setText("");
        playAgain.setVisibility(View.INVISIBLE);
        scoreText.setText(Integer.toString(score)+"/"+Integer.toString(numberofq));
        newQuestion();
        new CountDownTimer(30100,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                timerText.setText(String.valueOf(millisUntilFinished/1000)+"s");
            }

            @Override
            public void onFinish() {
                resultText.setText("Done!");
                playAgain.setVisibility(View.VISIBLE);
            }
        }.start();

    }

    public void chooseAns(View view){
        if(Integer.toString(locationca).equals(view.getTag().toString())){
            resultText.setText("Correct :)");
            score++;
        } else{
            resultText.setText("Wrong :(");
        }
        numberofq++;
        scoreText.setText(Integer.toString(score)+"/"+Integer.toString(numberofq));
        newQuestion();


    }
    public void startButton(View view){
        goButton.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
    }
    public void newQuestion(){
        Random random=new Random();
        int a=random.nextInt(21);
        int b=random.nextInt(21);
        sumText.setText(Integer.toString(a) +" + "+Integer.toString(b));

        locationca=random.nextInt(4);
        answers.clear();


        for(int i=0;i<4;i++){
            if(i == locationca){
                answers.add(a+b);
            }else{
                int wronga=random.nextInt(41);
                while(wronga == a+b){
                    wronga=random.nextInt(41);
                }
                answers.add(wronga);
            }
        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goButton=findViewById(R.id.goButton);
        sumText=findViewById(R.id.sumText);
        button0=findViewById(R.id.button0);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        scoreText=findViewById(R.id.scoreText);
        resultText=findViewById(R.id.resultText);
        timerText=findViewById(R.id.timerText);
        playAgain=findViewById(R.id.playAgain);
        gameLayout=findViewById(R.id.gameLayout);


        playAgain(findViewById(R.id.resultText));
        gameLayout.setVisibility(View.INVISIBLE);
        goButton.setVisibility(View.VISIBLE);







    }
}