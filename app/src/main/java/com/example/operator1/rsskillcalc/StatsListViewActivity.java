package com.example.operator1.rsskillcalc;


import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;



public class StatsListViewActivity extends ListActivity {

    RSChar tempCharacter;
    TextView characterNameHeader;
    ListView list;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.skilllistview_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {
        try{
            for(int i = 0; i < menu.size();i++)
            {
                MenuItem mi = menu.getItem(i);
                String title = mi.getTitle().toString();
                Spannable spannable = new SpannableString(title);
                spannable.setSpan(new ForegroundColorSpan(Color.WHITE),0,spannable.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                mi.setTitle(spannable);
            }
        }catch(Exception ex){}
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
        else if(id == R.id.action_skillcalc){
            RSChar chara = tempCharacter;
            Intent intent = new Intent(this,Skill_Calc.class);
            intent.putExtra("RSCharacter",chara);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_list_view);

        //Get necessary variables and views
        list = (ListView)findViewById(android.R.id.list);
        Context ctx = getApplicationContext();
        Resources res = ctx.getResources();


        //Get bundled character data
        Bundle data = getIntent().getExtras();
        tempCharacter = data.getParcelable("Character");

        //Get skill names and icons from skills.xml
        String[] skillNames = res.getStringArray(R.array.skill_names);
        TypedArray skillIcons = res.obtainTypedArray(R.array.skill_icons);

        setListAdapter(new ImageAndTextAdapter(ctx,R.layout.skilllistviewitem, skillNames, skillIcons,tempCharacter.getCharacterStatsList()));
        characterNameHeader = (TextView)findViewById(R.id.characterNameHeader);
        characterNameHeader.setText(tempCharacter.charactersName);


        }


    }


