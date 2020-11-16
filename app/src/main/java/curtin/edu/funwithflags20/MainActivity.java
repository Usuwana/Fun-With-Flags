/****************************************************************************
 *  Author: Tatenda Usuwana Mapuranga
 *  Purpose: For displaying the first page of the app and its contents
 *  Project: Fun With Flags
 *  Date Last modified: 09/10/2020
 ******************************************************************************/

package curtin.edu.funwithflags20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this, secondScreen.class));
            }
        });
    }
}