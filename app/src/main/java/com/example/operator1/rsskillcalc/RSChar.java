package com.example.operator1.rsskillcalc;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Operator1 on 1/4/2016.
 */
public class RSChar implements Parcelable {


    public int overallRank;
    public int overallLevel;
    public long overallXp;
    public int attackRank;
    public int attackLevel;
    public int attackXp;
    public int defenceRank;
    public int defenceLevel;
    public int defenceXp;
    public int strengthRank;
    public int strengthLevel;
    public int strengthXp;
    public int constRank;
    public int constLevel;
    public int constXp;
    public int rangedRank;
    public int rangedLevel;
    public int rangedXp;
    public int prayerRank;
    public int prayerLevel;
    public int prayerXp;
    public int magicRank;
    public int magicLevel;
    public int magicXp;
    public int cookingRank;
    public int cookingLevel;
    public int cookingXp;
    public int woodcuttingRank;
    public int woodcuttingLevel;
    public int woodcuttingXp;
    public int fletchingRank;
    public int fletchingLevel;
    public int fletchingXp;
    public int fishingRank;
    public int fishingLevel;
    public int fishingXp;
    public int firemakingRank;
    public int firemakingLevel;
    public int firemakingXp;
    public int craftingRank;
    public int craftingLevel;
    public int craftingXp;
    public int smithingRank;
    public int smithingLevel;
    public int smithingXp;
    public int miningRank;
    public int miningLevel;
    public int miningXp;
    public int herbloreRank;
    public int herbloreLevel;
    public int herbloreXp;
    public int agilityRank;
    public int agilityLevel;
    public int agilityXp;
    public int thievingRank;
    public int thievingLevel;
    public int thievingXp;
    public int slayerRank;
    public int slayerLevel;
    public int slayerXp;
    public int farmingRank;
    public int farmingLevel;
    public int farmingXp;
    public int runecraftRank;
    public int runecraftLevel;
    public int runecraftXp;
    public int hunterRank;
    public int hunterLevel;
    public int hunterXp;
    public int constructionRank;
    public int constructionLevel;
    public int constructionXp;
    public int summoningRank;
    public int summoningLevel;
    public int summoningXp;
    public int dungRank;
    public int dungLevel;
    public int dungXp;
    public int divinationRank;
    public int divinationLevel;
    public int divinationXp;
    public String charactersName;
    public List statsList;

    public RSChar(String characterName, Context context)
    {
        try
        {
            URL charURL = new URL("http://services.runescape.com/m=hiscore/index_lite.ws?player=" + characterName);
            AsyncHiScoreLookup ahsl = new AsyncHiScoreLookup();
            ahsl.execute(charURL);
            String[] characterData = ahsl.get();
            applyStatsToObject(characterData);
            statsList = Arrays.asList(characterData);
            charactersName = characterName;

        } catch(Exception ex){}
    }

    public void applyStatsToObject(String[] data)
    {
        overallRank = Integer.valueOf(data[0]);
        overallLevel = Integer.valueOf(data[1]);
        overallXp = Long.valueOf(data[2]);
        attackRank = Integer.valueOf(data[3]);
        attackLevel = Integer.valueOf(data[4]);
        attackXp = Integer.valueOf(data[5]);
        defenceRank = Integer.valueOf(data[6]);
        defenceLevel = Integer.valueOf(data[7]);
        defenceXp = Integer.valueOf(data[8]);
        strengthRank  = Integer.valueOf(data[9]);
        strengthLevel  = Integer.valueOf(data[10]);
        strengthXp = Integer.valueOf(data[11]);
        constRank = Integer.valueOf(data[12]);
        constLevel = Integer.valueOf(data[13]);
        constXp = Integer.valueOf(data[14]);
        rangedRank = Integer.valueOf(data[15]);
        rangedLevel = Integer.valueOf(data[16]);
        rangedXp = Integer.valueOf(data[17]);
        prayerRank = Integer.valueOf(data[18]);
        prayerLevel = Integer.valueOf(data[19]);
        prayerXp = Integer.valueOf(data[20]);
        magicRank = Integer.valueOf(data[21]);
        magicLevel = Integer.valueOf(data[22]);
        magicXp = Integer.valueOf(data[23]);
        cookingRank = Integer.valueOf(data[24]);
        cookingLevel = Integer.valueOf(data[25]);
        cookingXp = Integer.valueOf(data[26]);
        woodcuttingRank = Integer.valueOf(data[27]);
        woodcuttingLevel = Integer.valueOf(data[28]);
        woodcuttingXp = Integer.valueOf(data[29]);
        fletchingRank = Integer.valueOf(data[30]);
        fletchingLevel = Integer.valueOf(data[31]);
        fletchingXp = Integer.valueOf(data[32]);
        fishingRank = Integer.valueOf(data[33]);
        fishingLevel = Integer.valueOf(data[34]);
        fishingXp = Integer.valueOf(data[35]);
        firemakingRank = Integer.valueOf(data[36]);
        firemakingLevel = Integer.valueOf(data[37]);
        firemakingXp = Integer.valueOf(data[38]);
        craftingRank = Integer.valueOf(data[39]);
        craftingLevel = Integer.valueOf(data[40]);
        craftingXp = Integer.valueOf(data[41]);
        smithingRank = Integer.valueOf(data[42]);
        smithingLevel = Integer.valueOf(data[43]);
        smithingXp = Integer.valueOf(data[44]);
        miningRank = Integer.valueOf(data[45]);
        miningLevel = Integer.valueOf(data[46]);
        miningXp = Integer.valueOf(data[47]);
        herbloreRank = Integer.valueOf(data[48]);
        herbloreLevel = Integer.valueOf(data[49]);
        herbloreXp = Integer.valueOf(data[50]);
        agilityRank = Integer.valueOf(data[51]);
        agilityLevel = Integer.valueOf(data[52]);
        agilityXp = Integer.valueOf(data[53]);
        thievingRank = Integer.valueOf(data[54]);
        thievingLevel = Integer.valueOf(data[55]);
        thievingXp = Integer.valueOf(data[56]);
        slayerRank = Integer.valueOf(data[57]);
        slayerLevel = Integer.valueOf(data[58]);
        slayerXp = Integer.valueOf(data[59]);
        farmingRank = Integer.valueOf(data[60]);
        farmingLevel = Integer.valueOf(data[61]);
        farmingXp = Integer.valueOf(data[62]);
        runecraftRank = Integer.valueOf(data[63]);
        runecraftLevel = Integer.valueOf(data[64]);
        runecraftXp = Integer.valueOf(data[65]);
        hunterRank = Integer.valueOf(data[66]);
        hunterLevel = Integer.valueOf(data[67]);
        hunterXp = Integer.valueOf(data[68]);
        constructionRank = Integer.valueOf(data[69]);
        constructionLevel = Integer.valueOf(data[70]);
        constructionXp = Integer.valueOf(data[71]);
        summoningRank = Integer.valueOf(data[72]);
        summoningLevel = Integer.valueOf(data[73]);
        summoningXp = Integer.valueOf(data[74]);
        dungRank = Integer.valueOf(data[75]);
        dungLevel = Integer.valueOf(data[76]);
        dungXp = Integer.valueOf(data[77]);
        divinationRank = Integer.valueOf(data[78]);
        divinationLevel = Integer.valueOf(data[79]);
        divinationXp = Integer.valueOf(data[80]);
    }

    public List getCharacterStatsList()
    {
        return statsList;
    }

    public class AsyncHiScoreLookup extends AsyncTask<URL,Void,String[]>
    {
        protected String[] doInBackground(URL... urls) {
            try {
                String line;
                String[] characterData = new String[200];
                String delimiter = ",";
                String[] tempArray;
                int counter = 0;


                URLConnection urlConn = urls[0].openConnection();
                InputStreamReader iStream = new InputStreamReader(urlConn.getInputStream());
                BufferedReader buffer = new BufferedReader(iStream);
                line = buffer.readLine();

                while (line != null) {
                    if (line.split(delimiter).length == 3) {
                        tempArray = line.split(delimiter);
                        characterData[counter] = tempArray[0];
                        counter++;
                        characterData[counter] = tempArray[1];
                        counter++;
                        characterData[counter] = tempArray[2];
                        counter++;
                        line = buffer.readLine();
                        Arrays.fill(tempArray, null);
                    }
                    else if (line.split(delimiter).length == 2) {
                        tempArray = line.split(delimiter);
                        characterData[counter] = tempArray[0];
                        counter++;
                        characterData[counter] = tempArray[1];
                        counter++;
                        line = buffer.readLine();
                        Arrays.fill(tempArray, null);
                    }
                }

                return characterData;



            } catch(IOException ioex) {return null;}
        }
        protected void onPostExecute(String[] result)
        {

        }

    }


    protected RSChar(Parcel in) {
        if (in.readByte() == 0x01) {
            statsList = new ArrayList<>();
            in.readList(statsList, this.getClass().getClassLoader());
        }   else {
            statsList = null;
        }
        overallRank = in.readInt();
        overallLevel = in.readInt();
        overallXp = in.readLong();
        attackRank = in.readInt();
        attackLevel = in.readInt();
        attackXp = in.readInt();
        defenceRank = in.readInt();
        defenceLevel = in.readInt();
        defenceXp = in.readInt();
        strengthRank = in.readInt();
        strengthLevel = in.readInt();
        strengthXp = in.readInt();
        constRank = in.readInt();
        constLevel = in.readInt();
        constXp = in.readInt();
        rangedRank = in.readInt();
        rangedLevel = in.readInt();
        rangedXp = in.readInt();
        prayerRank = in.readInt();
        prayerLevel = in.readInt();
        prayerXp = in.readInt();
        magicRank = in.readInt();
        magicLevel = in.readInt();
        magicXp = in.readInt();
        cookingRank = in.readInt();
        cookingLevel = in.readInt();
        cookingXp = in.readInt();
        woodcuttingRank = in.readInt();
        woodcuttingLevel = in.readInt();
        woodcuttingXp = in.readInt();
        fletchingRank = in.readInt();
        fletchingLevel = in.readInt();
        fletchingXp = in.readInt();
        fishingRank = in.readInt();
        fishingLevel = in.readInt();
        fishingXp = in.readInt();
        firemakingRank = in.readInt();
        firemakingLevel = in.readInt();
        firemakingXp = in.readInt();
        craftingRank = in.readInt();
        craftingLevel = in.readInt();
        craftingXp = in.readInt();
        smithingRank = in.readInt();
        smithingLevel = in.readInt();
        smithingXp = in.readInt();
        miningRank = in.readInt();
        miningLevel = in.readInt();
        miningXp = in.readInt();
        herbloreRank = in.readInt();
        herbloreLevel = in.readInt();
        herbloreXp = in.readInt();
        agilityRank = in.readInt();
        agilityLevel = in.readInt();
        agilityXp = in.readInt();
        thievingRank = in.readInt();
        thievingLevel = in.readInt();
        thievingXp = in.readInt();
        slayerRank = in.readInt();
        slayerLevel = in.readInt();
        slayerXp = in.readInt();
        farmingRank = in.readInt();
        farmingLevel = in.readInt();
        farmingXp = in.readInt();
        runecraftRank = in.readInt();
        runecraftLevel = in.readInt();
        runecraftXp = in.readInt();
        hunterRank = in.readInt();
        hunterLevel = in.readInt();
        hunterXp = in.readInt();
        constructionRank = in.readInt();
        constructionLevel = in.readInt();
        constructionXp = in.readInt();
        summoningRank = in.readInt();
        summoningLevel = in.readInt();
        summoningXp = in.readInt();
        dungRank = in.readInt();
        dungLevel = in.readInt();
        dungXp = in.readInt();
        divinationRank = in.readInt();
        divinationLevel = in.readInt();
        divinationXp = in.readInt();
        charactersName = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (statsList == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(statsList);
        }
        dest.writeInt(overallRank);
        dest.writeInt(overallLevel);
        dest.writeLong(overallXp);
        dest.writeInt(attackRank);
        dest.writeInt(attackLevel);
        dest.writeInt(attackXp);
        dest.writeInt(defenceRank);
        dest.writeInt(defenceLevel);
        dest.writeInt(defenceXp);
        dest.writeInt(strengthRank);
        dest.writeInt(strengthLevel);
        dest.writeInt(strengthXp);
        dest.writeInt(constRank);
        dest.writeInt(constLevel);
        dest.writeInt(constXp);
        dest.writeInt(rangedRank);
        dest.writeInt(rangedLevel);
        dest.writeInt(rangedXp);
        dest.writeInt(prayerRank);
        dest.writeInt(prayerLevel);
        dest.writeInt(prayerXp);
        dest.writeInt(magicRank);
        dest.writeInt(magicLevel);
        dest.writeInt(magicXp);
        dest.writeInt(cookingRank);
        dest.writeInt(cookingLevel);
        dest.writeInt(cookingXp);
        dest.writeInt(woodcuttingRank);
        dest.writeInt(woodcuttingLevel);
        dest.writeInt(woodcuttingXp);
        dest.writeInt(fletchingRank);
        dest.writeInt(fletchingLevel);
        dest.writeInt(fletchingXp);
        dest.writeInt(fishingRank);
        dest.writeInt(fishingLevel);
        dest.writeInt(fishingXp);
        dest.writeInt(firemakingRank);
        dest.writeInt(firemakingLevel);
        dest.writeInt(firemakingXp);
        dest.writeInt(craftingRank);
        dest.writeInt(craftingLevel);
        dest.writeInt(craftingXp);
        dest.writeInt(smithingRank);
        dest.writeInt(smithingLevel);
        dest.writeInt(smithingXp);
        dest.writeInt(miningRank);
        dest.writeInt(miningLevel);
        dest.writeInt(miningXp);
        dest.writeInt(herbloreRank);
        dest.writeInt(herbloreLevel);
        dest.writeInt(herbloreXp);
        dest.writeInt(agilityRank);
        dest.writeInt(agilityLevel);
        dest.writeInt(agilityXp);
        dest.writeInt(thievingRank);
        dest.writeInt(thievingLevel);
        dest.writeInt(thievingXp);
        dest.writeInt(slayerRank);
        dest.writeInt(slayerLevel);
        dest.writeInt(slayerXp);
        dest.writeInt(farmingRank);
        dest.writeInt(farmingLevel);
        dest.writeInt(farmingXp);
        dest.writeInt(runecraftRank);
        dest.writeInt(runecraftLevel);
        dest.writeInt(runecraftXp);
        dest.writeInt(hunterRank);
        dest.writeInt(hunterLevel);
        dest.writeInt(hunterXp);
        dest.writeInt(constructionRank);
        dest.writeInt(constructionLevel);
        dest.writeInt(constructionXp);
        dest.writeInt(summoningRank);
        dest.writeInt(summoningLevel);
        dest.writeInt(summoningXp);
        dest.writeInt(dungRank);
        dest.writeInt(dungLevel);
        dest.writeInt(dungXp);
        dest.writeInt(divinationRank);
        dest.writeInt(divinationLevel);
        dest.writeInt(divinationXp);
        dest.writeString(charactersName);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<RSChar> CREATOR = new Parcelable.Creator<RSChar>() {
        @Override
        public RSChar createFromParcel(Parcel in) {
            return new RSChar(in);
        }

        @Override
        public RSChar[] newArray(int size) {
            return new RSChar[size];
        }
    };
}