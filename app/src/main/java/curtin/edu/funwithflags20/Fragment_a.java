/****************************************************************************
 *  Author: Tatenda Usuwana Mapuranga
 *  Purpose: For choosing how to display the orientation and different fragments
 *  Project: Fun With Flags
 *  Date Last modified: 09/10/2020
 ******************************************************************************/

package curtin.edu.funwithflags20;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;


public class Fragment_a extends Fragment {

   private ImageButton one;
   private ImageButton two;
   private ImageButton three;
   private ImageButton arrow;

    public Fragment_a()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View view =  inflater.inflate(R.layout.fragment_a, container, false);
        one = view.findViewById(R.id.onecolumn);
        two = view.findViewById(R.id.twocolumn);
        three = view.findViewById(R.id.threecolumn);
        arrow = view.findViewById(R.id.arrow);

        arrow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int orientation = getActivity().getRequestedOrientation();
                if(orientation == ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT)
                {
                    getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_LANDSCAPE);
                }
                else if(orientation == ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE)
                {
                    getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT);
                }
                else if(orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                {
                    getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_LANDSCAPE);
                }
                else if(orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
                {
                    getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT);
                }
            }
        });
        return view;
    }
}