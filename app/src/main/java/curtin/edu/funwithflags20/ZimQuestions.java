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

public class ZimQuestions extends SQLiteOpenHelper
{
    private static final String DATABASENAME = "ZimQuestions.db";
    private static final int  DATABASEVERSION = 1;
    private SQLiteDatabase sqLiteDatabase;

    public ZimQuestions(Context context)
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
        Questions one = new Questions("What is the national flower of Zimbabwe?", "Flame Lily", "Rose", "African Daisy", "Mayflower", "Shasta Daisy", "Flame Lily");
        Questions two = new Questions("Which year did Zimbabwe gain independence?", "2005", "1975", "1990", "1965", "1980", "1980");
        Questions three = new Questions("Which natural wonder is located in Zimbabwe?", "Victoria Falls", "Paricutin Volcano", "Mount Kilamanjaro", "Aurora Borealis", "Grand Canyon", "Victoria Falls");
        Questions four = new Questions("When is Independence Day in Zimbabwe?", "21 April 1965", "20 April 1990", "18 April 1975", "18 April 1980", "20 April 2005", "18 April 1980");
        Questions five = new Questions("Who was Zimbabwe's first president?", "Nelson Mandela", "Robert Mugabe", "Canaan Banana", "Emmerson Mnangagwa", "Jacob Zuma", "Canaan Banana");
        Questions six = new Questions("Zimbabwe's longest serving president's stay in office?", "40 years", "10 years", "30 years", "5 years", "15 years", "30 years");
        Questions seven = new Questions("Who is the current president of Zimbabwe?", "Nelson Chamisa", "Cyril Ramaphosa", "Robert Mugabe", "Emmerson Mnangagwa", "Constantino Chiwenga", "Emmerson Mnangagwa");
        Questions eight = new Questions("What is the predominant religion in Zimbabwe?", "Christianity", "Islam", "Hinduism", "Atheism", "African Traditional", "Christianity");
        Questions nine = new Questions("How many official languages does Zimbabwe have?", "1", "4", "16", "2", "20", "16");
        Questions ten = new Questions("Where is Zimbabwe?", "East Africa", "West Africa", "Central Africa", "South Africa", "Southern Africa", "Southern Africa");
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
