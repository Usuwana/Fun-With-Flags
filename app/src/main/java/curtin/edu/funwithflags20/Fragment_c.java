/****************************************************************************
 *  Author: Tatenda Usuwana Mapuranga
 *  Purpose: For keeping track of the current points and points needed to win the game
 *  Project: Fun With Flags
 *  Date Last modified: 09/10/2020
 ******************************************************************************/

package curtin.edu.funwithflags20;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


public class Fragment_c extends Fragment {

    private static int winningPoints = (int) (Math.random() * ((100 - 50)+1) + 50);
    private static int currentPoints = (int) (Math.random() * (((winningPoints/2) - 0)+1) + 0);
    private EditText current;
    private EditText target;
    private TextView result;

    public Fragment_c()
    {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_c, container, false);
        current = view.findViewById(R.id.currentshow);
        target = view.findViewById(R.id.targetshow);

        current.setText(""+getSeed());
        target.setText(""+getTarget());



        return view;
    }


    public void setSeed(int currentPoints)
    {

        this.currentPoints = currentPoints;
    }

    public int getSeed()
    {
        return currentPoints;
    }

    public void setTarget(int winningPoints)
    {
        this.winningPoints = winningPoints;
    }

    public int getTarget()
    {
        return winningPoints;
    }
}