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

public class Cameroon extends SQLiteOpenHelper
{
    private static final String DATABASENAME = "Cameroon.db";
    private static final int  DATABASEVERSION = 1;
    private SQLiteDatabase sqLiteDatabase;

    public Cameroon(Context context)
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
        Questions one = new Questions("How many countries have colonized Cameroon?", "None", "1", "2", "3", "4", "3");
        Questions two = new Questions("What is the largest city in Cameroon?", "Douala", "Kumba", "", "Yaounde", "Bamenda", "Douala");
        Questions three = new Questions("When did Cameroon attain UN membership?", "21 September 1960", "19 September 1960", "25 September 1960", "Never", "20 September 1960", "20 September 1960");
        Questions four = new Questions("What is the highest point in Cameroon?", "Mount Cameroon", "Mount Everest", "Mount Kilamanjaro", "Mount Kumba", "Mount Douala", "Mount Cameroon");
        Questions five = new Questions("What is the largest river in Cameroon?", "Sanaga River", "Wouri River", "Ngoko River", "Nyong River", "Logone River", "Sanaga River");

        addQuestion(one);
        addQuestion(two);
        addQuestion(three);
        addQuestion(four);
        addQuestion(five);
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

