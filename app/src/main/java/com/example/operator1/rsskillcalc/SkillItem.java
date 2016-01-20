package com.example.operator1.rsskillcalc;

/**
 * Created by Operator1 on 1/20/2016.
 */
public class SkillItem
{
        public String name;
        public int XpAmt;
        public boolean IsMembers;
        public int LvlReq;

    public SkillItem(String itemName, int xpAmt, boolean isMembers, int lvlReq)
    {
        this.name = itemName;
        this.XpAmt = xpAmt;
        this.IsMembers = isMembers;
        this.LvlReq = lvlReq;
    }

}
