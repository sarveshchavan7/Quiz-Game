package sarveshchavan777.triviaquiz;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;



public class TriviaQuizHelper extends SQLiteOpenHelper {

    private Context context;
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

    TriviaQuizHelper(Context context) {
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

    void allQuestion() {
        ArrayList<TriviaQuestion> list = new ArrayList<>();
        TriviaQuestion q1 = new TriviaQuestion("Galileo was an Italian astronomer who developed?", "Telescope", "Airoplane", "Electricity", "Train", "Telescope");
        list.add(q1);
        TriviaQuestion q2 = new TriviaQuestion("Who is the father of Geometry ?", "Aristotle", "Euclid", "Pythagoras", "Kepler", "Euclid");
        list.add(q2);
        TriviaQuestion q3 = new TriviaQuestion("Who was known as Iron man of India ?", "Govind Ballabh Pant", "Jawaharlal Nehru", "Subhash Chandra Bose", "Sardar Vallabhbhai Patel", "Sardar Vallabhbhai Patel");
        list.add(q3);
        TriviaQuestion q4 = new TriviaQuestion("The first woman in space was ?", "Valentina Tereshkova", "Sally Ride", "Naidia Comenci", "Tamara Press", "Valentina Tereshkova");
        list.add(q4);
        TriviaQuestion q5 = new TriviaQuestion("Who is the Flying Sikh of India ?", "Mohinder Singh", "Joginder Singh", "Ajit Pal Singh", "Milkha singh", "Milkha singh");
        list.add(q5);
        TriviaQuestion q6 = new TriviaQuestion("The Indian to beat the computers in mathematical wizardry is", "Ramanujam", "Rina Panigrahi", "Raja Ramanna", "Shakunthala Devi", "Shakunthala Devi");
        list.add(q6);
        TriviaQuestion q7 = new TriviaQuestion("Who is Larry Pressler ?", "Politician", "Painter", "Actor", "Tennis player", "Politician");
        list.add(q7);
        TriviaQuestion q8 = new TriviaQuestion("Michael Jackson is a distinguished person in the field of ?", "Pop Music", "Jounalism", "Sports", "Acting", "Pop Music");
        list.add(q8);
        TriviaQuestion q9 = new TriviaQuestion("The first Indian to swim across English channel was ?", "V. Merchant", "P. K. Banerji", "Mihir Sen", "Arati Saha", "Mihir Sen");
        list.add(q9);
        TriviaQuestion q10 = new TriviaQuestion("Who was the first Indian to make a movie?", "Dhundiraj Govind Phalke", " Asha Bhonsle", " Ardeshir Irani", "V. Shantaram", "Dhundiraj Govind Phalke");
        list.add(q10);
        TriviaQuestion q11 = new TriviaQuestion("Who is known as the ' Saint of the gutters ?", "B.R.Ambedkar", "Mother Teresa", "Mahatma Gandhi", "Baba Amte", "Mother Teresa");
        list.add(q11);
        TriviaQuestion q12 = new TriviaQuestion("Who invented the famous formula E=mc^2", "Albert Einstein", "Galilio", "Sarvesh", "Bill Gates", "Albert Einstein");
        list.add(q12);
        TriviaQuestion q13 = new TriviaQuestion("Who is elected as president of us 2016", "Donald Trump", "Hilary Clinton", "Jhon pol", "Barack Obama", "Donald Trump");
        list.add(q13);
        TriviaQuestion q14 = new TriviaQuestion("Who was the founder of company Microsoft", "Bill Gates", "Bill Clinton", "Jhon rio", "Steve jobs", "Bill Gates");
        list.add(q14);
        TriviaQuestion q15 = new TriviaQuestion("Who was the founder of company Apple ?", "Steve Jobs", "Steve Washinton", "Bill Gates", "Jobs Wills", "Steve Jobs");
        list.add(q15);
        TriviaQuestion q16 = new TriviaQuestion("Who was the founder of company Google ?", "Steve Jobs", "Bill Gates", "Larry Page", "Sundar Pichai", "Larry Page");
        list.add(q16);
        TriviaQuestion q17 = new TriviaQuestion("Who is know as god of cricket ?", "Sachin Tendulkar", "Kapil Dev", "Virat Koli", "Dhoni", "Sachin Tendulkar");
        list.add(q17);
        TriviaQuestion q18 = new TriviaQuestion("who has won ballon d'or of 2015 ?", "Lionel Messi", "Cristiano Ronaldo", "Neymar", "Kaka", "Lionel Messi");
        list.add(q18);
        TriviaQuestion q19 = new TriviaQuestion("who has won ballon d'or of 2014 ?", "Neymar", "Lionel Messi", "Cristiano Ronaldo", "Kaka", "Cristiano Ronaldo");
        list.add(q19);
        TriviaQuestion q20 = new TriviaQuestion("the Founder of the most famous gaming platform steam is ?", "Bill Cliton", "Bill Williams", "Gabe Newell", "Bill Gates", "Gabe Newell");
        list.add(q20);
        insert(list);
    }

     private void insert(ArrayList<TriviaQuestion> list) {
        ContentValues contentvalues = new ContentValues();
        for(int i = 0 ; i < list.size() ; i++){
            contentvalues.put(QUESTION, list.get(i).getQuestion());
            contentvalues.put(OPTA, list.get(i).getOptA());
            contentvalues.put(OPTB, list.get(i).getOptB());
            contentvalues.put(OPTC, list.get(i).getOptC());
            contentvalues.put(OPTD, list.get(i).getOptD());
            contentvalues.put(ANSWER, list.get(i).getAnswer());
        }
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, contentvalues);
    }

     List<TriviaQuestion> getAllQuestion() {
        List<TriviaQuestion> que = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String coloumns[] = {UID, QUESTION, OPTA, OPTB, OPTC, OPTD, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, coloumns, null, null, null, null, null);
        while (cursor.moveToNext()) {
            TriviaQuestion triviaQuestion = new TriviaQuestion();
            triviaQuestion.setId(cursor.getInt(0));
            triviaQuestion.setQuestion(cursor.getString(1));
            triviaQuestion.setOptA(cursor.getString(2));
            triviaQuestion.setOptB(cursor.getString(3));
            triviaQuestion.setOptC(cursor.getString(4));
            triviaQuestion.setOptD(cursor.getString(5));
            triviaQuestion.setAnswer(cursor.getString(6));
            que.add(triviaQuestion);
        }
        cursor.close();
        return que;
    }
}
