package com.example.operator1.rsskillcalc;


import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;

import android.widget.ListView;
import android.widget.TextView;



public class StatsListViewActivity extends ListActivity {

    RSChar tempCharacter;
    TextView characterNameHeader;
    ListView list;

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


