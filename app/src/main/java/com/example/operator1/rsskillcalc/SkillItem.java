package com.example.operator1.rsskillcalc;

/**
 * Created by Operator1 on 1/20/2016.
 */
public class SkillItem
{
        public String name;
        public float XpAmt;
        //public boolean IsMembers;
        public String category;
        public int LvlReq;

    public SkillItem(String itemName, float xpAmt, String category, int lvlReq)
    {
        this.name = itemName;
        this.XpAmt = xpAmt;
        this.category = category;
        this.LvlReq = lvlReq;
    }

}
