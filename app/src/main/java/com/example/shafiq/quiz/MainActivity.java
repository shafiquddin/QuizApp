package com.example.shafiq.quiz;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_one, btn_two, btn_three, btn_four,cancel,submit;
    TextView tv_question,score;

    private Question question = new Question();

    private String answer;
    private int questionLength = question.questions.length;
    private int mScore=0;

    Random f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        f= new Random();


        btn_one = (Button)findViewById(R.id.btn_one);
        btn_one.setOnClickListener(this);
        btn_two = (Button)findViewById(R.id.btn_two);
        btn_two.setOnClickListener(this);
        btn_three = (Button)findViewById(R.id.btn_three);
        btn_three.setOnClickListener(this);
        btn_four = (Button)findViewById(R.id.btn_four);
        btn_four.setOnClickListener(this);
        cancel = (Button)findViewById(R.id.cancel);
        cancel.setOnClickListener(this);
        submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(this);

        tv_question = (TextView)findViewById(R.id.tv_question);
        NextQuestion(f.nextInt(questionLength));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_one:
                if(btn_one.getText() == answer){
                    mScore++;
                    NextQuestion(f.nextInt(questionLength));
                }else{
                    NextQuestion(f.nextInt(questionLength));
                }

                break;

            case R.id.btn_two:
                if(btn_two.getText() == answer){
                    mScore++;
                    NextQuestion(f.nextInt(questionLength));
                }else{
                    NextQuestion(f.nextInt(questionLength));
                }

                break;

            case R.id.btn_three:
                if(btn_three.getText() == answer){
                    mScore++;
                    NextQuestion(f.nextInt(questionLength));
                }else{
                    NextQuestion(f.nextInt(questionLength));

                }

                break;

            case R.id.btn_four:
                if(btn_four.getText() == answer){
                    mScore++;
                    NextQuestion(f.nextInt(questionLength));
                }else{
                    NextQuestion(f.nextInt(questionLength));
                }

                break;
            case R.id.cancel:
                GameOver();
                break;
            case R.id.submit:
                Submit();
                break;
        }

    }


    private void Submit(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setMessage("Your score is "+mScore)
                .setCancelable(false)
                .setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                });
        alertDialogBuilder.show();

    }

    private void GameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setMessage("Game Over")
                .setCancelable(false)
                .setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                });
        alertDialogBuilder.show();

    }

    private void NextQuestion(int num){
        tv_question.setText(question.getQuestion(num));
        btn_one.setText(question.getchoice1(num));
        btn_two.setText(question.getchoice2(num));
        btn_three.setText(question.getchoice3(num));
        btn_four.setText(question.getchoice4(num));

        answer = question.getCorrectAnswer(num);
    }

    public class Question {

        public String questions[] = {
                "what is the capital of India?",
                "who was the first men walk on the moon?",
                "what is full form of IPL?",
                "how many departments in MGM COE nanded",
                "what is GATE stand for?",
                "who is the captain of indian team Now?",
                "what is the capital city of Maharashtra",
                "the Multiplication of two odd no will be?",
                "who is the creator of the c language"

        };

        public String choices[][] = {
                {"mumbai", "dehli", "punjab", "maharshtra"},
                {"neil Armstrong", "Aldrin", "jackmaa", "rossow"},
                {"India pakistan League", "Indian Premier League", "Industrail Polution Level", "Indra Premium League"},
                {"two", "four", "five", "six"},
                {"Good Apptitude Test For Engineering", "Graduate Apptitude Test For Engineering","Goa Apptitude Test For Engineering","Give Apptitude Test For Engineering"},
                {"ms dhoni","virat kohli","yuvraj singh","Dinesh Kartik"},
                {"Nanded","Mumbai","hydrabad","Aurangabad"},
                {"Even","Odd","prime","Armstrong"},
                {"gems gausling","mark zukerberg","denis Ritchi","trump"}
        };

        public String correctAnswer[] = {
                "dehli",
                "neil Armstrong",
                "Indian Premiun League",
                "five",
                "Graduate Apptitude Test For Engineering",
                "virat kohli",
                "Mumbai",
                "Odd",
                "denis Ritchi"
        };

        public String getQuestion(int a){
            String question = questions[a];
            return question;
        }

        public String getchoice1(int a){
            String choice = choices[a][0];
            return choice;
        }

        public String getchoice2(int a){
            String choice = choices[a][1];
            return choice;
        }

        public String getchoice3(int a){
            String choice = choices[a][2];
            return choice;
        }

        public String getchoice4(int a){
            String choice = choices[a][3];
            return choice;
        }

        public String getCorrectAnswer(int a){
            String answer = correctAnswer[a];
            return answer;
        }
    }

}
