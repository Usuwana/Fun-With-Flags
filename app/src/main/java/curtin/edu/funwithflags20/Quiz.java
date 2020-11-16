/****************************************************************************
 *  Author: Tatenda Usuwana Mapuranga
 *  Purpose: Brings together all the classes to run the game
 *  Project: Defines the data types and names of the questions and answer columns for database
 *  Date Last modified: 09/10/2020
 *  Reference : YouTube - Coding in Flow. Playlist- SQLite Multiple Choice Quiz Android Studio Tutorial
 ******************************************************************************/

package curtin.edu.funwithflags20;

import android.provider.BaseColumns;

public final class Quiz
{
    public Quiz()
    {

    }
    public static final class QuestionTable implements BaseColumns
    {
        public static final String NAME = "Quiz_Questions";
        public static final String QUESTION = "Question";
        public static final String FIRSTCHOICE = "firstchoice";
        public static final String SECONDCHOICE = "secondchoice";
        public static final String THIRDCHOICE = "thirdchoice";
        public static final String FOURTHCHOICE = "fourthchoice";
        public static final String FIFTHCHOICE = "fifthchoice";
        public static final String ANSWER = "correctAnswer";
    }
}
