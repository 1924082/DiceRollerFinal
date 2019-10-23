 package com.example.a1924082.diceroller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

 public class DiceRoller extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roller);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dice_roller, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void txtNoNumberYet (View view) {
        TextView tv = (TextView) this.findViewById(R.id.txtNoNumberYet);
        final Random r = new Random();
        int txtNoNumberYet = r.nextInt(6) + 1;

        tv.setText(Integer.toString(txtNoNumberYet));

        TextView tv2 = (TextView) this.findViewById(R.id.ResultMessage);

        //method1
        EditText mEdit;
        mEdit = (EditText) this.findViewById(R.id.EnterNumber);

        Editable guessedText;



        if (mEdit.getText().toString() !=""){
            try {
                guessedText = mEdit.getText();

                //method2

                //parsing to int
                int guessme = Integer.parseInt(guessedText.toString());

                TextView tv3 = (TextView) this.findViewById(R.id.Points);

                if (guessme == txtNoNumberYet) {
                    tv2.setText("Congratulation you guessed the right number!");
                    score += 1;
                    tv3.setText("Your score is: " + score);
                } else {
                    tv2.setText("You did not guessed the right number!");
                }
            }
            catch(Exception ex){

                    Toast.makeText(DiceRoller.this,
                            "Error" + ex.toString(),
                            Toast.LENGTH_SHORT).show();

            }

        }

    }

     private int score;


}
