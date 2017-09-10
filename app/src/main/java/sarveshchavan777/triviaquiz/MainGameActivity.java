package sarveshchavan777.triviaquiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainGameActivity extends AppCompatActivity {
    Button buttonA, buttonB, buttonC, buttonD;
    TextView questionText,triviaQuizText;
    TriviaQuizHelper triviaQuizHelper;
    TriviaQuestion currentQuestion;
    List<TriviaQuestion> list;
    int qid = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_main);
        //Initializing variables
        questionText = (TextView) findViewById(R.id.triviaQuestion);
        buttonA = (Button) findViewById(R.id.buttonA);
        buttonB = (Button) findViewById(R.id.buttonB);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonD = (Button) findViewById(R.id.buttonD);
        triviaQuizText = (TextView)findViewById(R.id.triviaQuizText);

        //setting typeface
        Typeface tb = Typeface.createFromAsset(getAssets(),"fonts/TitilliumWeb-Bold.ttf");
        Typeface sb = Typeface.createFromAsset(getAssets(),"fonts/shablagooital.ttf");
        triviaQuizText.setTypeface(sb);
        questionText.setTypeface(sb);
        buttonA.setTypeface(tb);
        buttonB.setTypeface(tb);
        buttonC.setTypeface(tb);
        buttonD.setTypeface(tb);

        triviaQuizHelper = new TriviaQuizHelper(this);
        triviaQuizHelper.getWritableDatabase();
        triviaQuizHelper.allQuestion();
        list = triviaQuizHelper.getAllQuestion();
        currentQuestion = list.get(qid);
        updateQueAndOptions();
    }

    public void updateQueAndOptions() {
        questionText.setText(currentQuestion.getQuestion());
        buttonA.setText(currentQuestion.getOptA());
        buttonB.setText(currentQuestion.getOptB());
        buttonC.setText(currentQuestion.getOptC());
        buttonD.setText(currentQuestion.getOptD());
    }


    public void buttonA(View view) {

        if (currentQuestion.getOptA().equals(currentQuestion.getAnswer())) {
            if (qid < 19) {
                qid++;
                currentQuestion = list.get(qid);
                updateQueAndOptions();
            } else {
                gameWon();
            }
        } else {
            gameLostPlayAgain();
        }
    }

    public void buttonB(View view) {
        if (currentQuestion.getOptB().equals(currentQuestion.getAnswer())) {

            if (qid < 19) {
                qid++;
                currentQuestion = list.get(qid);
                updateQueAndOptions();
            } else {
                gameWon();
            }
        } else {
            gameLostPlayAgain();
        }
    }

    public void buttonC(View view) {
        if (currentQuestion.getOptC().equals(currentQuestion.getAnswer())) {

            if (qid < 19) {
                qid++;
                currentQuestion = list.get(qid);
                updateQueAndOptions();
            } else {
                gameWon();
            }
        } else {
            gameLostPlayAgain();
        }
    }

    public void buttonD(View view) {
        if (currentQuestion.getOptD().equals(currentQuestion.getAnswer())) {

            if (qid < 19) {
                qid++;
                currentQuestion = list.get(qid);
                updateQueAndOptions();
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

    public void gameLostPlayAgain() {
        Intent intent = new Intent(this, PlayAgain.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
