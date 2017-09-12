package sarveshchavan777.triviaquiz;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.HeaderViewListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import info.hoang8f.widget.FButton;

public class MainGameActivity extends AppCompatActivity {
    FButton buttonA, buttonB, buttonC, buttonD;
    TextView questionText, triviaQuizText, timeText, resultText, coinText;
    TriviaQuizHelper triviaQuizHelper;
    TriviaQuestion currentQuestion;
    List<TriviaQuestion> list;
    int qid = 0;
    Handler handler;
    int timeValue = 20;
    int coinValue = 0;
    CountDownTimer countDownTimer;
    Typeface tb, sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_main);
        //Initializing variables
        questionText = (TextView) findViewById(R.id.triviaQuestion);
        buttonA = (FButton) findViewById(R.id.buttonA);
        buttonB = (FButton) findViewById(R.id.buttonB);
        buttonC = (FButton) findViewById(R.id.buttonC);
        buttonD = (FButton) findViewById(R.id.buttonD);
        triviaQuizText = (TextView) findViewById(R.id.triviaQuizText);
        handler = new Handler();
        timeText = (TextView) findViewById(R.id.timeText);
        resultText = (TextView) findViewById(R.id.resultText);
        coinText = (TextView) findViewById(R.id.coinText);

        //setting typeface
        tb = Typeface.createFromAsset(getAssets(), "fonts/TitilliumWeb-Bold.ttf");
        sb = Typeface.createFromAsset(getAssets(), "fonts/shablagooital.ttf");
        triviaQuizText.setTypeface(sb);
        questionText.setTypeface(tb);
        buttonA.setTypeface(tb);
        buttonB.setTypeface(tb);
        buttonC.setTypeface(tb);
        buttonD.setTypeface(tb);
        timeText.setTypeface(tb);
        resultText.setTypeface(sb);
        coinText.setTypeface(tb);


        triviaQuizHelper = new TriviaQuizHelper(this);
        triviaQuizHelper.getWritableDatabase();

        if(triviaQuizHelper.getAllOfTheQuestions().size() == 0){
            triviaQuizHelper.allQuestion();
        }


        list = triviaQuizHelper.getAllOfTheQuestions();
        Collections.shuffle(list);

        currentQuestion = list.get(qid);

        countDownTimer = new CountDownTimer(22000, 1000) {
            public void onTick(long millisUntilFinished) {
                //here you can have your logic to set text to timeText
                timeText.setText(String.valueOf(timeValue) + "\"");
                //each iteration decrement the time
                timeValue -= 1;

                //This means the user is out of time
                if (timeValue == -1) {
                    resultText.setText(getString(R.string.timeup));
                    disableButton();
                }
            }

            public void onFinish() {
                timeUp();
            }
        }.start();

        updateQueAndOptions();


    }



    public void updateQueAndOptions() {
        questionText.setText(currentQuestion.getQuestion());
        buttonA.setText(currentQuestion.getOptA());
        buttonB.setText(currentQuestion.getOptB());
        buttonC.setText(currentQuestion.getOptC());
        buttonD.setText(currentQuestion.getOptD());
        timeValue = 20;
        countDownTimer.cancel();
        countDownTimer.start();
        coinText.setText(String.valueOf(coinValue));
        coinValue++;
        buttonA.setButtonColor(getResources().getColor(R.color.white));
    }


    public void buttonA(View view) {

        if (currentQuestion.getOptA().equals(currentQuestion.getAnswer())) {
            buttonA.setButtonColor(getResources().getColor(R.color.lightGreen));

            if (qid < list.size()-1) {
                disableButton();
                correctDialog();
            } else {

                gameWon();
            }
        } else {

            gameLostPlayAgain();
        }
    }

    public void buttonB(View view) {
        if (currentQuestion.getOptB().equals(currentQuestion.getAnswer())) {
            buttonB.setButtonColor(getResources().getColor(R.color.lightGreen));
            if (qid < list.size()-1) {
                disableButton();
                correctDialog();
            } else {
                gameWon();
            }
        } else {
            gameLostPlayAgain();
        }
    }

    public void buttonC(View view) {
        if (currentQuestion.getOptC().equals(currentQuestion.getAnswer())) {
            buttonC.setButtonColor(getResources().getColor(R.color.lightGreen));
            if (qid < list.size()-1) {
                disableButton();
                correctDialog();
            } else {
                gameWon();
            }
        } else {
            gameLostPlayAgain();
        }
    }

    public void buttonD(View view) {
        if (currentQuestion.getOptD().equals(currentQuestion.getAnswer())) {
            buttonD.setButtonColor(getResources().getColor(R.color.lightGreen));
            if (qid < list.size()-1) {
                disableButton();
                correctDialog();
            } else {
                gameWon();
            }
        } else {
            gameLostPlayAgain();
        }
    }



    public void gameWon() {
        Intent intent = new Intent(this, GameWon.class);
        startActivity(intent);
        finish();
    }

    //This method is called when user ans is wrong
    //this method will navigate him to the activity PlayAgain
    public void gameLostPlayAgain() {
        Intent intent = new Intent(this, PlayAgain.class);
        startActivity(intent);
        finish();
    }

    public void timeUp() {
        Intent intent = new Intent(this, Time_Up.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        countDownTimer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        countDownTimer.cancel();
    }

    @Override
    protected void onPause() {
        super.onPause();
        countDownTimer.cancel();
    }

    //On BackPressed
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
        finish();
    }

    public void correctDialog() {
        final Dialog dialogCorrect = new Dialog(MainGameActivity.this);
        dialogCorrect.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialogCorrect.getWindow() != null) {
            ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
            dialogCorrect.getWindow().setBackgroundDrawable(colorDrawable);
        }
        dialogCorrect.setContentView(R.layout.dialog_correct);
        dialogCorrect.setCancelable(false);
        dialogCorrect.show();

        onPause();

        TextView correctText = (TextView) dialogCorrect.findViewById(R.id.correctText);
        FButton buttonNext = (FButton) dialogCorrect.findViewById(R.id.dialogNext);
        correctText.setTypeface(sb);
        buttonNext.setTypeface(sb);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogCorrect.dismiss();
                qid++;
                currentQuestion = list.get(qid);
                updateQueAndOptions();
                resetColor();
                enableButton();
            }
        });
    }


    public void resetColor() {
        buttonA.setButtonColor(getResources().getColor(R.color.white));
        buttonB.setButtonColor(getResources().getColor(R.color.white));
        buttonC.setButtonColor(getResources().getColor(R.color.white));
        buttonD.setButtonColor(getResources().getColor(R.color.white));
    }

    public void disableButton() {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
    }

    public void enableButton() {
        buttonA.setEnabled(true);
        buttonB.setEnabled(true);
        buttonC.setEnabled(true);
        buttonD.setEnabled(true);
    }


}
