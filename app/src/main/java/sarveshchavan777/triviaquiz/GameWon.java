package sarveshchavan777.triviaquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameWon extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_won);
    }

    //This is onclick listener for button
    //it will navigate from this activity to MainGameActivity
    public void PlayAgain(View view) {
        Intent intent = new Intent(GameWon.this, MainGameActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
