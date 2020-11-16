/****************************************************************************
 *  Author: Tatenda Usuwana Mapuranga
 *  Purpose: For displaying the country flags and choosing which country questions to view and answer
 *  Project: Fun With Flags
 *  Date Last modified: 09/10/2020
 ******************************************************************************/

package curtin.edu.funwithflags20;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class Fragment_b extends Fragment {

    private ImageButton sa;
    private ImageButton bots;
    private ImageButton cameroon;
    private ImageButton ethiopia;
    private ImageButton ghana;
    private ImageButton ivorycoast;
    private ImageButton kenya;
    private ImageButton malawi;
    private ImageButton moz;
    private ImageButton namibia;
    private ImageButton nigeria;
    private ImageButton tanzania;
    private ImageButton uganda;
    private ImageButton zambia;
    private ImageButton zim;
    private ImageButton rwanda;


    public Fragment_b() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_b, container, false);
        sa = view.findViewById(R.id.sa);
        bots = view.findViewById(R.id.bots);
        cameroon = view.findViewById(R.id.cameroon);
        ethiopia = view.findViewById(R.id.ethiopia);
        ghana = view.findViewById(R.id.ghana);
        ivorycoast = view.findViewById(R.id.ivorycoast);
        kenya = view.findViewById(R.id.kenya);
        malawi = view.findViewById(R.id.malawi);
        moz = view.findViewById(R.id.moz);
        namibia = view.findViewById(R.id.namibia);
        nigeria = view.findViewById(R.id.nigeria);
        rwanda = view.findViewById(R.id.rwanda);
        tanzania = view.findViewById(R.id.tanzania);
        uganda = view.findViewById(R.id.uganda);
        zambia = view.findViewById(R.id.zambia);
        zim = view.findViewById(R.id.zim);

        sa.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Fragment_dSA fragSA = new Fragment_dSA();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout3,fragSA);
                ft.commit();
            }
        });

        bots.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Fragment_dbots fragBots = new Fragment_dbots();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout3,fragBots);
                ft.commit();
            }
        });

        cameroon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Fragment_dcameroon fragCam = new Fragment_dcameroon();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout3,fragCam);
                ft.commit();
            }
        });

        ethiopia.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Fragment_dethiopia fragEth = new Fragment_dethiopia();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout3,fragEth);
                ft.commit();
            }
        });

        ghana.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Fragment_dghana fragGha = new Fragment_dghana();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout3,fragGha);
                ft.commit();
            }
        });

        ivorycoast.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Fragment_divorycoast fragIvo = new Fragment_divorycoast();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout3,fragIvo);
                ft.commit();
            }
        });

        kenya.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Fragment_dkenya fragKenya = new Fragment_dkenya();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout3,fragKenya);
                ft.commit();
            }
        });

        malawi.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Fragment_dmalawi fragMalawi = new Fragment_dmalawi();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout3,fragMalawi);
                ft.commit();
            }
        });

        moz.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Fragment_dmoz fragMoz = new Fragment_dmoz();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout3,fragMoz);
                ft.commit();
            }
        });

        namibia.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Fragment_dnamibia fragNam = new Fragment_dnamibia();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout3,fragNam);
                ft.commit();
            }
        });

        nigeria.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Fragment_dnigeria fragNig = new Fragment_dnigeria();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout3,fragNig);
                ft.commit();
            }
        });

        rwanda.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Fragment_drwanda fragRwa = new Fragment_drwanda();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout3,fragRwa);
                ft.commit();
            }
        });

        tanzania.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Fragment_dtanzania fragTan = new Fragment_dtanzania();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout3,fragTan);
                ft.commit();
            }
        });

        uganda.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Fragment_duganda fragU = new Fragment_duganda();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout3,fragU);
                ft.commit();
            }
        });

        zambia.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Fragment_dzambia fragZa = new Fragment_dzambia();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout3,fragZa);
                ft.commit();
            }
        });

        zim.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Fragment_dzim fragZim = new Fragment_dzim();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout3,fragZim);
                ft.commit();
            }
        });
        return view;
    }
}