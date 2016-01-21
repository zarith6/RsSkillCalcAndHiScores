package com.example.operator1.rsskillcalc;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Operator1 on 1/20/2016.
 */
public class RsExpXMLParser
{
    private static final String ns = null;

    public List parse(InputStream in) throws XmlPullParserException, IOException
    {
        try{
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            return readSkillItem(parser);
        } finally{
            in.close();
        }
    }

    private List readSkillItem(XmlPullParser parser) throws XmlPullParserException, IOException
    {
        List entries = new ArrayList();

        parser.require(XmlPullParser.START_TAG, ns, "SkillItem");
        while(parser.next() != XmlPullParser.END_TAG)
        {
            if(parser.getEventType() != XmlPullParser.START_TAG)
            {
                continue;
            }
            String name = parser.getName();

            if(name.equals("item"))
            {
                entries.add(readItem(parser));
            } else
            {
                skip(parser);
            }
        }
        return entries;
    }

    private SkillItem readItem(XmlPullParser parser) throws XmlPullParserException, IOException
    {
        parser.require(XmlPullParser.START_TAG, ns, "item");
        String name = null;
        int XpAmt = 0;
        boolean IsMembers = false;
        int LvlReq = 0;

        while(parser.next() != XmlPullParser.END_TAG)
        {
            if(parser.getEventType() != XmlPullParser.START_TAG)
            {
                continue;
            }
            String tag = parser.getName();
            if(tag.equals("name")){
                name = readName(parser);
            }
            else if(tag.equals("XpAmt")){
                XpAmt = readXpAmt(parser);
            }
            else if(tag.equals("Members")){
                IsMembers = readMembers(parser);
            }
            else if(tag.equals("LvlReq")){
                LvlReq = readLvlReq(parser);
            }
            else{
                skip(parser);
            }
        }
        return new SkillItem(name,XpAmt,IsMembers,LvlReq);
    }

    private String readName(XmlPullParser parser) throws XmlPullParserException, IOException
    {
        parser.require(XmlPullParser.START_TAG, ns, "name");
        String name = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "name");
        return name;
    }

    private int readXpAmt(XmlPullParser parser) throws XmlPullParserException, IOException
    {
        parser.require(XmlPullParser.START_TAG, ns, "XpAmt");
        int XpAmt = readInt(parser);
        parser.nextTag();
        parser.require(XmlPullParser.END_TAG, ns, "XpAmt");
        return XpAmt;
    }

    private boolean readMembers(XmlPullParser parser) throws XmlPullParserException, IOException
    {
        parser.require(XmlPullParser.START_TAG, ns, "Members");
        boolean IsMembers = readBool(parser);
        parser.require(XmlPullParser.END_TAG,ns,"Members");
        return IsMembers;
    }

    private int readLvlReq(XmlPullParser parser) throws XmlPullParserException, IOException
    {
        parser.require(XmlPullParser.START_TAG, ns, "LvlReq");
        int LvlReq = readInt(parser);
        parser.nextTag();
        parser.require(XmlPullParser.END_TAG,ns,"LvlReq");
        return LvlReq;
    }

    private String readText(XmlPullParser parser) throws XmlPullParserException, IOException
    {
        String result = "";
        if(parser.next() == XmlPullParser.TEXT)
        {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }

    private boolean readBool(XmlPullParser parser) throws XmlPullParserException, IOException
    {
        boolean result = false;
        if(parser.next() == XmlPullParser.TEXT){
            String stringBool = parser.getText();
            if(stringBool.equals("true")){
                result = true;
            }
            else{
                result = false;
            }
            parser.nextTag();

        }
        return result;
    }

    private int readInt(XmlPullParser parser) throws XmlPullParserException, IOException
    {
        int result = 0;
        if(parser.next() == XmlPullParser.TEXT){
            String stringInt = parser.getText();
            try{
                result = Integer.valueOf(stringInt);
            } catch(Exception ex){}
        }
        return result;
    }

    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException
    {
        if(parser.getEventType() != XmlPullParser.START_TAG)
        {
            throw new IllegalStateException();
        }
        int depth = 1;
        while(depth != 0)
        {
            switch (parser.next()){
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }
}
