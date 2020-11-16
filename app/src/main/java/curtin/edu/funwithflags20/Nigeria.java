/****************************************************************************
 *  Author: Tatenda Usuwana Mapuranga
 *  Purpose: Creates Database to hold data including questions, options and correct answers for a designated country
 *  Project: Fun With Flags
 *  Date Last modified: 09/10/2020
 *  Reference : YouTube - Coding in Flow. Playlist- SQLite Multiple Choice Quiz Android Studio Tutorial
 ******************************************************************************/

package curtin.edu.funwithflags20;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Nigeria extends SQLiteOpenHelper
{
    private static final String DATABASENAME = "Nigeria.db";
    private static final int  DATABASEVERSION = 1;
    private SQLiteDatabase sqLiteDatabase;

    public Nigeria(Context context)
    {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        this.sqLiteDatabase = sqLiteDatabase;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                Quiz.QuestionTable.NAME + " ( " +
                Quiz.QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Quiz.QuestionTable.QUESTION + " TEXT, " +
                Quiz.QuestionTable.FIRSTCHOICE + " TEXT, " +
                Quiz.QuestionTable.SECONDCHOICE + " TEXT, " +
                Quiz.QuestionTable.THIRDCHOICE + " TEXT, " +
                Quiz.QuestionTable.FOURTHCHOICE + " TEXT, " +
                Quiz.QuestionTable.FIFTHCHOICE + " TEXT, " +
                Quiz.QuestionTable.ANSWER + " INTEGER " +
                ")";
        sqLiteDatabase.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        addQuestions();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }

    //Create new instances of Questions class in order to add them to database
    private void addQuestions()
    {
        Questions one = new Questions("Nigeria is the ___________ most populous country in the world.", "tenth", "twenty-first", "third", "eighteenth", "seventh", "seventh");
        Questions two = new Questions("What is the local town of Igbo-Ora known as?", "Home of Legends", "Home of Prosperity", "Home of Twins", "Home of Love", "Home of Nigeria", "Home of Twins");
        Questions three = new Questions("What is the former capital of Nigeria?", "Abuja", "Niger", "Lagos", "Benin", "Swaziland", "Lagos");
        Questions four = new Questions("What is the country's film industry known as?", "Nollywood", "Nigerian Hollywood", "Nyollywood", "Nigerian Film", "Hollywood", "Nollywood");
        Questions five = new Questions("What is Nigeria home to?", "Barack Obama", "most wildlife in Africa", "richest city in Africa", "richest man in Africa", "Jacob Zuma", "richest man in Africa");
        Questions six = new Questions("What do Nigerians believe about the left hand?", "It is unclean", "It has wealth", "It is disrespectful", "It is weak", "It is strong", "It is unclean");
        Questions seven = new Questions("Is Nigeria in the British Commonwealth?", "No", "Yes", "No, but it once was", "Yes, but not from the beginning", "Never", "Yes");
        Questions eight = new Questions("What is the official name for Nigeria?", "Republic of Nigeria", "Nigeria", "Federal States of Nigeria", "Federal Republic of Nigeria", "Niger", "Federal Republic of Nigeria");
        Questions nine = new Questions("What is the largest city in Nigeria?", "Cairo", "Abuja", "Lagos", "Abidjan", "Niger", "Lagos");
        Questions ten = new Questions("How many states are in Nigeria?", "12", "22", "32", "36", "44", "36");
        addQuestion(one);
        addQuestion(two);
        addQuestion(three);
        addQuestion(four);
        addQuestion(five);
        addQuestion(six);
        addQuestion(seven);
        addQuestion(eight);
        addQuestion(nine);
        addQuestion(ten);
    }

    //Add Questions and their associated answers into database
    private void addQuestion(Questions question)
    {
        ContentValues values = new ContentValues();
        values.put(Quiz.QuestionTable.QUESTION, question.getQuestion());
        values.put(Quiz.QuestionTable.FIRSTCHOICE, question.getFirstchoice());
        values.put(Quiz.QuestionTable.SECONDCHOICE, question.getSecondchoice());
        values.put(Quiz.QuestionTable.THIRDCHOICE, question.getThirdchoice());
        values.put(Quiz.QuestionTable.FOURTHCHOICE, question.getFourthchoice());
        values.put(Quiz.QuestionTable.FIFTHCHOICE, question.getFifthchoice());
        values.put(Quiz.QuestionTable.ANSWER, question.getCorrectAnswer());
        sqLiteDatabase.insert(Quiz.QuestionTable.NAME, null, values);
    }

    //Get Questions and their options and answers from created database
    public List<Questions> getQuestions()
    {
        List<Questions> questions = new ArrayList<>();
        sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + Quiz.QuestionTable.NAME, null);

        if (cursor.moveToFirst())
        {
            do {
                Questions question = new Questions();
                question.setQuestion(cursor.getString(cursor.getColumnIndex(Quiz.QuestionTable.QUESTION)));
                question.setFirstchoice(cursor.getString(cursor.getColumnIndex(Quiz.QuestionTable.FIRSTCHOICE)));
                question.setSecondchoice(cursor.getString(cursor.getColumnIndex(Quiz.QuestionTable.SECONDCHOICE)));
                question.setThirdchoice(cursor.getString(cursor.getColumnIndex(Quiz.QuestionTable.THIRDCHOICE)));
                question.setFourthchoice(cursor.getString(cursor.getColumnIndex(Quiz.QuestionTable.FOURTHCHOICE)));
                question.setFifthchoice(cursor.getString(cursor.getColumnIndex(Quiz.QuestionTable.FIFTHCHOICE)));
                question.setCorrectAnswer(cursor.getString(cursor.getColumnIndex(Quiz.QuestionTable.ANSWER)));
                questions.add(question);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return questions;
    }
}

