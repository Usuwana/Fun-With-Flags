/****************************************************************************
 *  Author: Tatenda Usuwana Mapuranga
 *  Purpose: For displaying the first page of the app and its contents in certain contexts
 *  Project: Fun With Flags
 *  Date Last modified: 09/10/2020
 ******************************************************************************/

package curtin.edu.funwithflags20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class secondScreen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        Fragment_a frag2 = new Fragment_a();
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.frameLayout2, frag2).commit();

        Fragment_b frag1 = new Fragment_b();
        fm.beginTransaction().add(R.id.frameLayout3, frag1).commit();

        Fragment_c frag3 = new Fragment_c();
        fm.beginTransaction().add(R.id.frameLayout, frag3).commit();

    }
}