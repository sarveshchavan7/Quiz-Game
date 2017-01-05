package sarveshchavan777.triviaquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ResultPlayAgain extends Activity {

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultplayagain);
   TextView     t = (TextView) findViewById(R.id.score2);
        b1 = (Button) findViewById(R.id.platygaianbutton);
        Bundle b=getIntent().getExtras();
        int y=b.getInt("xscore");
        t.setText("Score: "+y);//very very important rember that setText when has int.And as you know
        // here compiler will look for corresponding resource value. So, just concat an empty string there as ""
    }
    public void PlayAgain(View view) {
        Intent intent = new Intent(ResultPlayAgain.this, MainActivity.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}
