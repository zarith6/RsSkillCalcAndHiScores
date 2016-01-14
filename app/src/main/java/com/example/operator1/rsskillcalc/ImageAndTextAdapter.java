package com.example.operator1.rsskillcalc;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Operator1 on 1/7/2016.
 */
public class ImageAndTextAdapter extends ArrayAdapter<String>
{
    private LayoutInflater mInflater;

    private String[] mStrings;
    private TypedArray mIcons;

    private int mViewResourceId;

    private String[] charStatsAsArray;
    private String[] charStatsFormatted;



    public ImageAndTextAdapter(Context ctx, int viewResourceId, String[] strings, TypedArray icons, List charactersStats)
    {
        super(ctx, viewResourceId, strings);
        mInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mStrings = strings;
        mIcons = icons;

        mViewResourceId = viewResourceId;
        if(charactersStats != null)
        {
            String[] charStats = new String[charactersStats.size()];
            for (int i = 0; i < 81; i++) {
                charStats[i] = charactersStats.get(i).toString();
            }

            charStatsAsArray = charStats;
            charStatsFormatted = formatStatsArray(charStatsAsArray);
        }
    }

    //Formats the array of stats brought in from the hi scores to remove minigame stuff and prepare for adding to listview
    public String[] formatStatsArray(String[] stats)
    {
        int j = 0;
        String[] formattedStats = new String[27];
        int counter = 0;

        while(counter < 27)
        {
            formattedStats[counter] = "Rank: " + stats[j] + " Level: " + stats[j+1] + " Xp: " + stats[j+2];
            counter++;
            j += 3;
        }


        return formattedStats;
    }

    @Override
    public int getCount()
    {
        return mStrings.length;
    }

    @Override
    public int getItemViewType(int position)
    {
        return position;
    }

    @Override
    public int getViewTypeCount()
    {
        return getCount();
    }

    @Override
    public String getItem(int position)
    {
        return mStrings[position];
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        if(convertView == null)
        {
            convertView = mInflater.inflate(mViewResourceId, null);
        }

        ImageView iv = (ImageView)convertView.findViewById(R.id.option_icon);
        iv.setImageDrawable(mIcons.getDrawable(position));

        TextView tv = (TextView)convertView.findViewById(R.id.option_text);
        tv.setText(mStrings[position]);

        TextView tv2 = (TextView) convertView.findViewById(R.id.option_text_2);
        tv2.setText(charStatsFormatted[position]);



        return convertView;
    }

}
