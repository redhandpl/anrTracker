package com.example.anr.app;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.ImageButton;

import org.w3c.dom.Text;


public class Tracker extends Activity implements OnClickListener {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tracker, menu);

        // set background
        View w = this.getWindow().getDecorView();
        w.setBackground(c);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    Button addCred;
    Button subCred;
    Button reset;
    TextView credits;
    int corpCredCounter = 5;
    Button addBrains;
    Button subBrains;
    TextView brains;
    int brainCounter = 0;
    Button addBadpubs;
    Button subBadpubs;
    TextView badpubs;
    int badpubCounter = 0;
    Button addTags;
    Button subTags;
    TextView tags;
    int tagCounter = 0;
    ImageButton click;
    ImageView click1;
    ImageView click2;
    ImageView click3;
    ImageView click4;
    int clickCounter = 0;
    int turnsCounter = 1;
    Button end;
    TextView turns;
    TextView turnsP;
    int runnerCredCounter = 5;
    ImageView oppCredit;
    TextView oppCredits;
    Button oppAddCred;
    Button oppSubCred;

    Drawable c;
    Drawable r;

    // 0 - corps move; 1 - runners move
    int side = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        addCred = (Button)findViewById(R.id.addCredit);
        subCred = (Button)findViewById(R.id.subtractCredit);
        reset = (Button)findViewById(R.id.resetButton);
        credits = (TextView)findViewById(R.id.myCredits);
        addBrains = (Button)findViewById(R.id.addBrain);
        subBrains = (Button)findViewById(R.id.subtractBrain);
        brains = (TextView)findViewById(R.id.myBrains);
        addBadpubs = (Button)findViewById(R.id.addPub);
        subBadpubs = (Button)findViewById(R.id.subractPub);
        badpubs = (TextView)findViewById(R.id.myBadpubs);
        addTags = (Button)findViewById(R.id.addTag);
        subTags = (Button)findViewById(R.id.subTag);
        tags = (TextView)findViewById(R.id.myTags);

        click = (ImageButton)findViewById(R.id.myClick);
        click1 = (ImageView)findViewById(R.id.myClick1);
        click2 = (ImageView)findViewById(R.id.myClick2);
        click3 = (ImageView)findViewById(R.id.myClick3);
        click4 = (ImageView)findViewById(R.id.myClick4);

        end = (Button)findViewById(R.id.endButton);
        turns = (TextView)findViewById(R.id.myTurns);
        turnsP = (TextView)findViewById(R.id.turnsPlayed);

        oppCredit = (ImageView)findViewById(R.id.oppCred);
        oppCredits = (TextView)findViewById(R.id.oppCreds);

        //---set on click listeners on the buttons-----
        addCred.setOnClickListener(this);
        subCred.setOnClickListener(this);
        reset.setOnClickListener(this);
        addBrains.setOnClickListener(this);
        subBrains.setOnClickListener(this);
        addBadpubs.setOnClickListener(this);
        subBadpubs.setOnClickListener(this);
        addTags.setOnClickListener(this);
        subTags.setOnClickListener(this);
        click.setOnClickListener(this);

        click1.setVisibility(1);
        click2.setVisibility(1);
        click3.setVisibility(1);
        click4.setVisibility(1);

        click1.setVisibility(View.GONE);
        click2.setVisibility(View.GONE);
        click3.setVisibility(View.GONE);
        click4.setVisibility(View.GONE);

        end.setOnClickListener(this);
        end.setVisibility(1);
        reset.setVisibility(1);
        reset.setVisibility(View.GONE);
        turns.setVisibility(1);
        turns.setVisibility(View.GONE);
        turnsP.setVisibility(1);
        turnsP.setVisibility(View.GONE);

        oppCredit.setVisibility(1);
        oppCredits.setVisibility(1);

        oppAddCred = (Button)findViewById(R.id.oppAdd);
        oppSubCred = (Button)findViewById(R.id.oppSub);
        oppAddCred.setVisibility(1);
        oppSubCred.setVisibility(1);
        oppAddCred.setOnClickListener(this);
        oppSubCred.setOnClickListener(this);

        c = getResources().getDrawable(R.drawable.corp);
        r = (getResources().getDrawable(R.drawable.runner));

        // change font size of the text
        //credits.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
    }

    @Override
    public void onClick(View v){

        if (v == addCred){
            if (side == 0) {
                corpCredCounter++;
                credits.setText(Integer.toString(corpCredCounter));
            }

            if (side == 1) {
                runnerCredCounter++;
                credits.setText(Integer.toString(runnerCredCounter));
            }
        }
        if (v == subCred){
            if (side == 0) {
                if (corpCredCounter == 0) {
                    corpCredCounter = 0;
                    credits.setText(Integer.toString(corpCredCounter));
                } else {
                    corpCredCounter--;
                    credits.setText(Integer.toString(corpCredCounter));
                }
            }

            if (side == 1) {
                if (runnerCredCounter == 0) {
                    runnerCredCounter = 0;
                    credits.setText(Integer.toString(runnerCredCounter));
                } else {
                    runnerCredCounter--;
                    credits.setText(Integer.toString(runnerCredCounter));
                }

            }
        }

        if (v == reset){
            corpCredCounter = 5;
            runnerCredCounter = 5;
            brainCounter = 0;
            badpubCounter = 0;
            tagCounter = 0;
            side = 0;
            credits.setText(Integer.toString(corpCredCounter));
            brains.setText(Integer.toString(brainCounter));
            badpubs.setText(Integer.toString(badpubCounter));
            tags.setText(Integer.toString(tagCounter));
            click1.setVisibility(View.GONE);
            click2.setVisibility(View.GONE);
            click3.setVisibility(View.GONE);
            click4.setVisibility(View.GONE);
            clickCounter = 0;
            turnsCounter = 1;
            reset.setVisibility(View.GONE);
            turns.setVisibility(View.GONE);
            turnsP.setVisibility(View.GONE);
            end.setVisibility(View.VISIBLE);
            oppCredits.setText(Integer.toString(runnerCredCounter));
            oppCredit.setVisibility(View.VISIBLE);
            oppCredits.setVisibility(View.VISIBLE);
            View w = this.getWindow().getDecorView();
            w.setBackground(c);
            oppAddCred.setVisibility(View.VISIBLE);
            oppSubCred.setVisibility(View.VISIBLE);
        }

        if (v == addBrains){
            brainCounter++;
            brains.setText(Integer.toString(brainCounter));
        }

        if (v == subBrains){
            if (brainCounter == 0){
                brainCounter = 0;
                brains.setText(Integer.toString(brainCounter));
            }
            else {
                brainCounter--;
                brains.setText(Integer.toString(brainCounter));
            }
        }

        if (v == addBadpubs){
            badpubCounter++;
            badpubs.setText(Integer.toString(badpubCounter));
        }

        if (v == subBadpubs){
            if (badpubCounter == 0) {
                badpubCounter = 0;
                badpubs.setText(Integer.toString(badpubCounter));
            }
            else {
                badpubCounter--;
                badpubs.setText(Integer.toString(badpubCounter));
            }
        }

        if (v == addTags){
            tagCounter++;
            tags.setText(Integer.toString(tagCounter));
        }

        if (v == subTags){
            if (tagCounter == 0){
                tagCounter = 0;
                tags.setText(Integer.toString(tagCounter));
            }
            else {
                tagCounter--;
                tags.setText(Integer.toString(tagCounter));
            }
        }

        if (v == click){
            if (clickCounter == 0){
                 clickCounter++;
                 click1.setVisibility(View.VISIBLE);
                 click2.setVisibility(View.GONE);
                 click3.setVisibility(View.GONE);
                 click4.setVisibility(View.GONE);
            }

            else if (clickCounter == 1){
                 clickCounter++;
                 click1.setVisibility(View.VISIBLE);
                 click2.setVisibility(View.VISIBLE);
                 click3.setVisibility(View.GONE);
                 click4.setVisibility(View.GONE);
            }

            else if (clickCounter == 2){
                 if (side == 0){
                     clickCounter = 4;
                                      }
                 else {
                     clickCounter++;
                 }
                 click1.setVisibility(View.VISIBLE);
                 click2.setVisibility(View.VISIBLE);
                 click3.setVisibility(View.VISIBLE);
                 click4.setVisibility(View.GONE);
            }

            else if (clickCounter == 3){
                 clickCounter++;
                 click1.setVisibility(View.VISIBLE);
                 click2.setVisibility(View.VISIBLE);
                 click3.setVisibility(View.VISIBLE);
                 click4.setVisibility(View.VISIBLE);
            }

            else if (clickCounter == 4){
                if (side == 0){
                    side = 1;
                    oppCredits.setText(Integer.toString(corpCredCounter));
                    credits.setText(Integer.toString(runnerCredCounter));
                    View w = this.getWindow().getDecorView();
                    w.setBackground(r);

                }
                else {
                    side = 0;
                    oppCredits.setText(Integer.toString(runnerCredCounter));
                    credits.setText(Integer.toString(corpCredCounter));
                    View w = this.getWindow().getDecorView();
                    w.setBackground(c);
                    turnsCounter++;
                }
                clickCounter = -1;
                clickCounter++;
                click1.setVisibility(View.GONE);
                click2.setVisibility(View.GONE);
                click3.setVisibility(View.GONE);
                click4.setVisibility(View.GONE);
            }

        }

        if (v == end){
            end.setVisibility(View.GONE);
            reset.setVisibility(View.VISIBLE);
            turns.setText(Integer.toString(turnsCounter));
            turns.setVisibility(View.VISIBLE);
            turnsP.setVisibility(View.VISIBLE);
            oppCredits.setVisibility(View.GONE);
            oppCredit.setVisibility(View.GONE);
            oppAddCred.setVisibility(View.VISIBLE);
            oppSubCred.setVisibility(View.VISIBLE);
        }

        if (v == oppAddCred){
            if (side == 0){
                runnerCredCounter++;
                oppCredits.setText(Integer.toString(runnerCredCounter));
            }

            if (side == 1){
                corpCredCounter++;
                oppCredits.setText(Integer.toString(corpCredCounter));
            }
        }

        if (v == oppSubCred){
            if (side == 0){
                if (runnerCredCounter == 0) {
                    runnerCredCounter = 0;
                    oppCredits.setText(Integer.toString(runnerCredCounter));
                } else {
                    runnerCredCounter--;
                    oppCredits.setText(Integer.toString(runnerCredCounter));
                }
            }

            if (side == 1){
                if (corpCredCounter == 0) {
                    corpCredCounter = 0;
                    oppCredits.setText(Integer.toString(corpCredCounter));
                } else {
                    corpCredCounter--;
                    oppCredits.setText(Integer.toString(corpCredCounter));
                }
            }
        }
    }


}
