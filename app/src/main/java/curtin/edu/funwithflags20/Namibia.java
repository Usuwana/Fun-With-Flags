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

public class Namibia extends SQLiteOpenHelper
{
    private static final String DATABASENAME = "Namibia.db";
    private static final int  DATABASEVERSION = 1;
    private SQLiteDatabase sqLiteDatabase;

    public Namibia(Context context)
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
        Questions one = new Questions("Where does Namibia get its name from?", "Namibius Motsande", "The Namib Mountains", "The Namib River", "The Namib Desert", "The Namib Falls", "The Namib Desert");
        Questions two = new Questions("How many ethnic groups are in Namibia?", "2", "13", "4", "3", "16", "13");
        Questions three = new Questions("What is the highest mountain in Namibia?", "Brandberg Mountain", "Mount Kilamanjaro", "Namib Mountains", "Omatako Mountains", "Spitzkoppe Mountain", "Brandberg Mountain");
        Questions four = new Questions("Namibia has the largest population of _________ in the world", "Stray Elephants", "Free roaming Cheetahs", "Free roaming Lions", "Monkeys", "Baboons", "Free roaming Cheetahs");
        Questions five = new Questions("Namibia was the first country to _________", "Gain independence", "Legalise use of weed", "include environmental protection laws", "discover coffee", "be colonised by the British", "include environmental protection laws");
        Questions six = new Questions("Which famous couple chose to give birth to their child in Namibia?", "Will Smith & Jada Pinket Smith", "Denzel & Pauletta Washington", "Barack & Michelle Obama", "Brad Pitt & Angelina Jolie", "John Legend & Chrissy Teigen", "Brad Pitt & Angelina Jolie");
        Questions seven = new Questions("Where was Namibia ranked for freedom of press in the world?", "17", "100", "67", "150", "16", "17");

        addQuestion(one);
        addQuestion(two);
        addQuestion(three);
        addQuestion(four);
        addQuestion(five);
        addQuestion(six);
        addQuestion(seven);
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
