/****************************************************************************
 *  Author: Tatenda Usuwana Mapuranga
 *  Purpose: Defines the data types of the questions and answers
 *  Project: Fun With Flags
 *  Date Last modified: 09/10/2020
 *  Reference : YouTube - Coding in Flow. Playlist- SQLite Multiple Choice Quiz Android Studio Tutorial
 ******************************************************************************/

package curtin.edu.funwithflags20;

public class Questions
{
    private String question;
    private String firstchoice;
    private String secondchoice;
    private String thirdchoice;
    private String fourthchoice;
    private String fifthchoice;
    private String correctAnswer;

    public Questions()
    {

    }

    public Questions(String question, String firstchoice, String secondchoice, String thirdchoice, String fourthchoice, String fifthchoice, String correctAnswer)
    {
        this.question  = question;
        this.firstchoice = firstchoice;
        this.secondchoice = secondchoice;
        this.thirdchoice = thirdchoice;
        this.fourthchoice = fourthchoice;
        this.fifthchoice = fifthchoice;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public String getFirstchoice()
    {
        return firstchoice;
    }

    public void setFirstchoice(String firstchoice)
    {
        this.firstchoice = firstchoice;
    }

    public String getSecondchoice() {
        return secondchoice;
    }

    public void setSecondchoice(String secondchoice)
    {
        this.secondchoice = secondchoice;
    }

    public String getThirdchoice()
    {
        return thirdchoice;
    }

    public void setThirdchoice(String thirdchoice)
    {
        this.thirdchoice = thirdchoice;
    }

    public String getFourthchoice()
    {
        return fourthchoice;
    }

    public void setFourthchoice(String fourthchoice)
    {
        this.fourthchoice = fourthchoice;
    }

    public String getFifthchoice()
    {
        return fifthchoice;
    }

    public void setFifthchoice(String fifthchoice)
    {
        this.fifthchoice = fifthchoice;
    }

    public String getCorrectAnswer()
    {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer)
    {
        this.correctAnswer = correctAnswer;
    }
}
