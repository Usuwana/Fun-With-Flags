/****************************************************************************
 *  Author: Tatenda Usuwana Mapuranga
 *  Purpose: For displaying all the questions designated to a specific country and choosing which one to answer
 *  Project: Fun With Flags
 *  Date Last modified: 09/10/2020
 ******************************************************************************/

package curtin.edu.funwithflags20;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class Fragment_dzim extends Fragment {

    private Button q1;
    private Button q2;
    private Button q3;
    private Button q4;
    private Button q5;
    private Button q6;
    private Button q7;
    private Button q8;
    private Button q9;
    private Button q10;
    private Button finished;

    public Fragment_dzim() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dzim, container, false);
        q1 = view.findViewById(R.id.q1);
        q2 = view.findViewById(R.id.q2);
        q3 = view.findViewById(R.id.q3);
        q4 = view.findViewById(R.id.q4);
        q5 = view.findViewById(R.id.q5);
        q6 = view.findViewById(R.id.q6);
        q7 = view.findViewById(R.id.q7);
        q8 = view.findViewById(R.id.q8);
        q9 = view.findViewById(R.id.q9);
        q10 = view.findViewById(R.id.q10);
        finished = view.findViewById(R.id.finished);
        final Fragment_ezim frag = new Fragment_ezim();

        q1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                frag.setType(0);
                if (!frag.getAnswered1())
                {
                    frag.setAnswered1(true);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.frameLayout3,frag);
                    ft.commit();
                }
                else if(frag.getAnswered1())
                {
                    Toast.makeText(getContext(), "Answered Already!", Toast.LENGTH_LONG).show();
                }
            }
        });

        q2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                frag.setType(1);
                if (!frag.getAnswered2())
                {
                    frag.setAnswered2(true);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.frameLayout3,frag);
                    ft.commit();
                }
                else if(frag.getAnswered2())
                {
                    Toast.makeText(getContext(), "Answered Already!", Toast.LENGTH_LONG).show();
                }
            }
        });

        q3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                frag.setType(2);
                if (!frag.getAnswered3())
                {
                    frag.setAnswered3(true);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.frameLayout3,frag);
                    ft.commit();
                }
                else if(frag.getAnswered3())
                {
                    Toast.makeText(getContext(), "Answered Already!", Toast.LENGTH_LONG).show();
                }
            }
        });

        q4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                frag.setType(3);
                if (!frag.getAnswered4())
                {
                    frag.setAnswered4(true);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.frameLayout3,frag);
                    ft.commit();
                }
                else if(frag.getAnswered4())
                {
                    Toast.makeText(getContext(), "Answered Already!", Toast.LENGTH_LONG).show();
                }
            }
        });

        q5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                frag.setType(4);
                if (!frag.getAnswered5())
                {
                    frag.setAnswered5(true);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.frameLayout3,frag);
                    ft.commit();
                }
                else if(frag.getAnswered5())
                {
                    Toast.makeText(getContext(), "Answered Already!", Toast.LENGTH_LONG).show();
                }
            }
        });

        q6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                frag.setType(5);
                if (!frag.getAnswered6())
                {
                    frag.setAnswered6(true);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.frameLayout3,frag);
                    ft.commit();
                }
                else if(frag.getAnswered6())
                {
                    Toast.makeText(getContext(), "Answered Already!", Toast.LENGTH_LONG).show();
                }
            }
        });

        q7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                frag.setType(6);
                if (!frag.getAnswered7())
                {
                    frag.setAnswered7(true);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.frameLayout3,frag);
                    ft.commit();
                }
                else if(frag.getAnswered7())
                {
                    Toast.makeText(getContext(), "Answered Already!", Toast.LENGTH_LONG).show();
                }
            }
        });

        q8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                frag.setType(7);
                if (!frag.getAnswered8())
                {
                    frag.setAnswered8(true);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.frameLayout3,frag);
                    ft.commit();
                }
                else if(frag.getAnswered8())
                {
                    Toast.makeText(getContext(), "Answered Already!", Toast.LENGTH_LONG).show();
                }
            }
        });

        q9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                frag.setType(8);
                if (!frag.getAnswered9())
                {
                    frag.setAnswered9(true);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.frameLayout3,frag);
                    ft.commit();
                }
                else if(frag.getAnswered9())
                {
                    Toast.makeText(getContext(), "Answered Already!", Toast.LENGTH_LONG).show();
                }
            }
        });

        q10.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                frag.setType(9);
                if (!frag.getAnswered10())
                {
                    frag.setAnswered10(true);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.frameLayout3,frag);
                    ft.commit();
                }
                else if(frag.getAnswered10())
                {
                    Toast.makeText(getContext(), "Answered Already!", Toast.LENGTH_LONG).show();
                }
            }
        });

        finished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (frag.getAnswered1() && frag.getAnswered2() && frag.getAnswered3() && frag.getAnswered4() && frag.getAnswered5() && frag.getAnswered6() && frag.getAnswered7() && frag.getAnswered8() && frag.getAnswered9() && frag.getAnswered10())
                {
                    startActivity(new Intent(getContext(), secondScreen.class));
                }
                else
                {
                    Toast.makeText(getContext(), "ANSWER ALL QUESTIONS!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}