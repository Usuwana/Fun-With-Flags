/****************************************************************************
 *  Author: Tatenda Usuwana Mapuranga
 *  Purpose: For displaying an individual question and its answer options and allowing the user to select an option for a designated country
 *  Project: Fun With Flags
 *  Date Last modified: 09/10/2020
 *  Reference : YouTube - Coding in Flow. Playlist- SQLite Multiple Choice Quiz Android Studio Tutorial
 ******************************************************************************/

package curtin.edu.funwithflags20;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class Fragment_ekenya extends Fragment {

    private TextView question;
    private RadioGroup options;
    private RadioButton option1;
    private RadioButton option2;
    private RadioButton option3;
    private RadioButton option4;
    private RadioButton option5;
    private Button next;
    private List<Questions> questions;
    private Questions currentQuestion;
    private int points;
    private int questionsNumber;
    private int questionNumber;
    private int type=5;
    private static boolean answered = false;
    private static boolean answered1 = false;
    private static boolean answered2 = false;
    private static boolean answered3 = false;
    private static boolean answered4 = false;
    private static boolean answered5 = false;
    Fragment_dkenya frag = new Fragment_dkenya();
    Fragment_c fragc = new Fragment_c();

    public Fragment_ekenya() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_e, container, false);
        question = view.findViewById(R.id.question);
        options = view.findViewById(R.id.options);
        option1 = view.findViewById(R.id.radioButton);
        option2 = view.findViewById(R.id.radioButton2);
        option3 = view.findViewById(R.id.radioButton3);
        option4 = view.findViewById(R.id.radioButton4);
        option5 = view.findViewById(R.id.radioButton5);
        next = view.findViewById(R.id.next);


        if(getType()==0)
        {
            getQuestionone();
        }
        else if(getType()==1)
        {
            getQuestiontwo();
        }
        else if(getType()==2)
        {
            getQuestionthree();
        }
        else if(getType()==3)
        {
            getQuestionfour();
        }
        else if(getType()==4)
        {
            getQuestionfive();
        }
        else if(getType()==5)
        {
            getQuestionsix();
        }

        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(getAnswered1() || getAnswered2() || getAnswered3() || getAnswered4() || getAnswered5() || getAnswered6())
                {
                    if (option1.isChecked() || option2.isChecked() || option3.isChecked() || option4.isChecked() || option5.isChecked())
                    {
                        checkAnswer();
                    }
                    else
                    {
                        Toast.makeText(getContext(), "Select an answer!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        Kenya kenya = new Kenya(context);
        questions = kenya.getQuestions();
    }

    private void checkAnswer()
    {
        RadioButton chosen = getView().findViewById(options.getCheckedRadioButtonId());

        if (chosen.getText().equals(currentQuestion.getCorrectAnswer()))
        {
            Toast.makeText(getContext(), "CORRECT! +5 POINTS", Toast.LENGTH_SHORT).show();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.frameLayout3, frag);
            ft.commit();
            fragc.setSeed(fragc.getSeed()+5);
            if (fragc.getSeed() >= fragc.getTarget())
            {
                Toast.makeText(getContext(), "GAME OVER, YOU HAVE WON!", Toast.LENGTH_SHORT).show();
                fragc.setTarget((int) (Math.random() * ((100 - 50)+1) + 50));
                fragc.setSeed((int) (Math.random() * (((fragc.getTarget()/2) - 0)+1) + 0));
                setAnswered1(false);
                setAnswered2(false);
                setAnswered3(false);
                setAnswered4(false);
                setAnswered5(false);
                setAnswered6(false);
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        }
        else
        {
            Toast.makeText(getContext(), "WRONG! -5 POINTS", Toast.LENGTH_SHORT).show();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.frameLayout3, frag);
            ft.commit();
            fragc.setSeed(fragc.getSeed()-5);
            if (fragc.getSeed() <= 0)
            {
                Toast.makeText(getContext(), "GAME OVER, YOU HAVE LOST!", Toast.LENGTH_SHORT).show();
                fragc.setTarget((int) (Math.random() * ((100 - 50)+1) + 50));
                fragc.setSeed((int) (Math.random() * (((fragc.getTarget()/2) - 0)+1) + 0));
                setAnswered1(false);
                setAnswered2(false);
                setAnswered3(false);
                setAnswered4(false);
                setAnswered5(false);
                setAnswered6(false);
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        }
    }

    public void setAnswered1(boolean answered)
    {
        this.answered = answered;
    }

    public boolean getAnswered1()
    {
        return answered;
    }
    public void setAnswered2(boolean answered)
    {
        this.answered1 = answered;
    }

    public boolean getAnswered2()
    {
        return answered1;
    }
    public void setAnswered3(boolean answered)
    {
        this.answered2 = answered;
    }

    public boolean getAnswered3()
    {
        return answered2;
    }
    public void setAnswered4(boolean answered)
    {
        this.answered3 = answered;
    }

    public boolean getAnswered4()
    {
        return answered3;
    }
    public void setAnswered5(boolean answered)
    {
        this.answered4 = answered;
    }

    public boolean getAnswered5()
    {
        return answered4;
    }
    public void setAnswered6(boolean answered)
    {
        this.answered5 = answered;
    }

    public boolean getAnswered6()
    {
        return answered5;
    }
    public void setType(int type)
    {
        this.type = type;
    }

    public int getType()
    {
        return type;
    }

    public void getQuestionone()
    {
        questionNumber = 0;
        currentQuestion = questions.get(questionNumber);
        question.setText(currentQuestion.getQuestion());
        option1.setText(currentQuestion.getFirstchoice());
        option2.setText(currentQuestion.getSecondchoice());
        option3.setText(currentQuestion.getThirdchoice());
        option4.setText(currentQuestion.getFourthchoice());
        option5.setText(currentQuestion.getFifthchoice());
        setAnswered1(true);

    }

    public void getQuestiontwo()
    {
        questionNumber = 1;
        currentQuestion = questions.get(questionNumber);
        question.setText(currentQuestion.getQuestion());
        option1.setText(currentQuestion.getFirstchoice());
        option2.setText(currentQuestion.getSecondchoice());
        option3.setText(currentQuestion.getThirdchoice());
        option4.setText(currentQuestion.getFourthchoice());
        option5.setText(currentQuestion.getFifthchoice());
        setAnswered2(true);

    }

    public void getQuestionthree()
    {
        questionNumber = 2;
        currentQuestion = questions.get(questionNumber);
        question.setText(currentQuestion.getQuestion());
        option1.setText(currentQuestion.getFirstchoice());
        option2.setText(currentQuestion.getSecondchoice());
        option3.setText(currentQuestion.getThirdchoice());
        option4.setText(currentQuestion.getFourthchoice());
        option5.setText(currentQuestion.getFifthchoice());
        setAnswered3(true);
    }

    public void getQuestionfour()
    {
        questionNumber = 3;
        currentQuestion = questions.get(questionNumber);
        question.setText(currentQuestion.getQuestion());
        option1.setText(currentQuestion.getFirstchoice());
        option2.setText(currentQuestion.getSecondchoice());
        option3.setText(currentQuestion.getThirdchoice());
        option4.setText(currentQuestion.getFourthchoice());
        option5.setText(currentQuestion.getFifthchoice());
        setAnswered4(true);
    }

    public void getQuestionfive()
    {
        questionNumber = 4;
        currentQuestion = questions.get(questionNumber);
        question.setText(currentQuestion.getQuestion());
        option1.setText(currentQuestion.getFirstchoice());
        option2.setText(currentQuestion.getSecondchoice());
        option3.setText(currentQuestion.getThirdchoice());
        option4.setText(currentQuestion.getFourthchoice());
        option5.setText(currentQuestion.getFifthchoice());
        setAnswered5(true);
    }

    public void getQuestionsix()
    {
        questionNumber = 5;
        currentQuestion = questions.get(questionNumber);
        question.setText(currentQuestion.getQuestion());
        option1.setText(currentQuestion.getFirstchoice());
        option2.setText(currentQuestion.getSecondchoice());
        option3.setText(currentQuestion.getThirdchoice());
        option4.setText(currentQuestion.getFourthchoice());
        option5.setText(currentQuestion.getFifthchoice());
        setAnswered6(true);
    }

}
