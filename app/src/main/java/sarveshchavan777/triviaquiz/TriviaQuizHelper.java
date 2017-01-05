package sarveshchavan777.triviaquiz;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LENOVO on 1/4/2017.
 */

public class TriviaQuizHelper extends SQLiteOpenHelper {

    Context context;
    private static final String DATABASE_NAME = "DATABASEQUIZ";
    private static final int DATABASE_VERSION = 17;
    private static final String TABLE_NAME = "TRIVIAQUIZ";
    private static final String UID = "_UID";
    private static final String QUESTION = "QUESTION";
    private static final String OPTA = "OPTA";
    private static final String OPTB = "OPTB";
    private static final String OPTC = "OPTC";
    private static final String OPTD = "OPTD";
    private static final String ANSWER = "ANSWER";
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + QUESTION + " VARCHAR(255), " + OPTA + " VARCHAR(255), " + OPTB + " VARCHAR(255), " + OPTC + " VARCHAR(255), " + OPTD + " VARCHAR(255), " + ANSWER + " VARCHAR(255));";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public TriviaQuizHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);

    }

    public void allQuestion() {
        TriviaQuestion q1 = new TriviaQuestion("Galileo was an Italian astronomer who developed?", "Telescope", "Airoplane", "Electricity", "Train", "Telescope");
        this.insert(q1);
        TriviaQuestion q2 = new TriviaQuestion("Who is the father of Geometry ?", "Aristotle", "Euclid", "Pythagoras", "Kepler", "Euclid");
        this.insert(q2);
        TriviaQuestion q3 = new TriviaQuestion("Who was known as Iron man of India ?", "Govind Ballabh Pant", "Jawaharlal Nehru", "Subhash Chandra Bose", "Sardar Vallabhbhai Patel", "Sardar Vallabhbhai Patel");
        this.insert(q3);
        TriviaQuestion q4 = new TriviaQuestion("The first woman in space was ?", "Valentina Tereshkova", "Sally Ride", "Naidia Comenci", "Tamara Press", "Valentina Tereshkova");
        this.insert(q4);
        TriviaQuestion q5 = new TriviaQuestion("Who is the Flying Sikh of India ?", "Mohinder Singh", "Joginder Singh", "Ajit Pal Singh", "Milkha singh", "Milkha singh");
        this.insert(q5);
        TriviaQuestion q6 = new TriviaQuestion("The Indian to beat the computers in mathematical wizardry is", "Ramanujam", "Rina Panigrahi", "Raja Ramanna", "Shakunthala Devi", "Shakunthala Devi");
        this.insert(q6);
        TriviaQuestion q7 = new TriviaQuestion("Who is Larry Pressler ?", "Politician", "Painter", "Actor", "Tennis player", "Politician");
        this.insert(q7);
        TriviaQuestion q8 = new TriviaQuestion("Michael Jackson is a distinguished person in the field of ?", "Pop Music", "Jounalism", "Sports", "Acting", "Pop Music");
        this.insert(q8);
        TriviaQuestion q9 = new TriviaQuestion("The first Indian to swim across English channel was ?", "V. Merchant", "P. K. Banerji", "Mihir Sen", "Arati Saha", "Mihir Sen");
        this.insert(q9);
        TriviaQuestion q10 = new TriviaQuestion("Who was the first Indian to make a movie?", "Dhundiraj Govind Phalke", " Asha Bhonsle", " Ardeshir Irani", "V. Shantaram", "Dhundiraj Govind Phalke");
        this.insert(q10);
        TriviaQuestion q11 = new TriviaQuestion("Who is known as the ' Saint of the gutters ?", "B.R.Ambedkar", "Mother Teresa", "Mahatma Gandhi", "Baba Amte", "Mother Teresa");
        this.insert(q11);
        TriviaQuestion q12 = new TriviaQuestion("Who invented the famous formula E=mc^2", "Albert Einstein", "Galilio", "Sarvesh", "Bill Gates", "Albert Einstein");
        this.insert(q12);
       TriviaQuestion q13 = new TriviaQuestion("Who is elected as president of us 2016", "Donald Trump", "Hilary Clinton", "Jhon pol", "Barack Obama", "Donald Trump");
        this.insert(q13);
        TriviaQuestion q14 = new TriviaQuestion("Who was the founder of company Microsoft", "Bill Gates", "Bill Clinton", "Jhon rio", "Steve jobs", "Bill Gates");
        this.insert(q14);
        TriviaQuestion q15 = new TriviaQuestion("Who was the founder of company Apple ?", "Steve Jobs", "Steve Washinton", "Bill Gates", "Jobs Wills", "Steve Jobs");
        this.insert(q15);
        TriviaQuestion q16 = new TriviaQuestion("Who was the founder of company Google ?", "Steve Jobs", "Bill Gates", "Larry Page", "Sundar Pichai", "Larry Page");
        this.insert(q16);
        TriviaQuestion q17 = new TriviaQuestion("Who is know as god of cricket ?", "Sachin Tendulkar", "Kapil Dev", "Virat Koli", "Dhoni", "Sachin Tendulkar");
        this.insert(q17);
        TriviaQuestion q18 = new TriviaQuestion("who has won ballon d'or of 2015 ?", "Lionel Messi", "Cristiano Ronaldo", "Neymar", "Kaka", "Lionel Messi");
        this.insert(q18);
        TriviaQuestion q19 = new TriviaQuestion("who has won ballon d'or of 2014 ?", "Neymar", "Lionel Messi", "Cristiano Ronaldo", "Kaka", "Cristiano Ronaldo");
        this.insert(q19);
        TriviaQuestion q20 = new TriviaQuestion("the Founder of the most famous gaming platform steam is ?", "Bill Cliton", "Bill Williams", "Gabe Newell", "Bill Gates", "Gabe Newell");
        this.insert(q20);
    }
    public void insert(TriviaQuestion triviaQuestion) {
        ContentValues contentvalues = new ContentValues();
       /* contentvalues.put(UID,triviaQuestion.getId());*/
        contentvalues.put(QUESTION, triviaQuestion.getQuestion());
        contentvalues.put(OPTA, triviaQuestion.getOpta());
        contentvalues.put(OPTB, triviaQuestion.getOptb());
        contentvalues.put(OPTC, triviaQuestion.getOptc());
        contentvalues.put(OPTD, triviaQuestion.getOptd());
        contentvalues.put(ANSWER, triviaQuestion.getAnswer());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, contentvalues);
    }
    public List<TriviaQuestion> getAllQuestion() {
        List<TriviaQuestion> que = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String coloumns[] = {UID, QUESTION, OPTA, OPTB, OPTC, OPTD, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, coloumns, null, null, null, null, null);
        while (cursor.moveToNext()) {
            TriviaQuestion triviaQuestion = new TriviaQuestion();
            triviaQuestion.setId(cursor.getInt(0));
            triviaQuestion.setQuestion(cursor.getString(1));
            triviaQuestion.setOpta(cursor.getString(2));
            triviaQuestion.setOptb(cursor.getString(3));
            triviaQuestion.setOptc(cursor.getString(4));
            triviaQuestion.setOptd(cursor.getString(5));
            triviaQuestion.setAnswer(cursor.getString(6));
            que.add(triviaQuestion);
        }
        return que;
    }
}
