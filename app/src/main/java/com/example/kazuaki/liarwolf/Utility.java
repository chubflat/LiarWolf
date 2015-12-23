package com.example.kazuaki.liarwolf;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kazuaki on 2015/11/16.
 */
public class Utility{
    public static enum Role{
        /* TODO 役職追加時 */
        Villager,
        Werewolf,
        FortuneTeller,
        Shaman,
        Madman,
        Bodyguard;
    }

    public static Map<String,Object> getRoleInfo(Role role) {
        Map<String, Object> infoDic = new HashMap<String, Object>();
        String name = "";
        Boolean hasTable = false;
        Boolean hasTableFirst = false;
        String explain = "";
        Boolean isWolfF = false;
        Boolean isWolfS = false;

        //TODO 役職追加時
        switch (role) {
            case Villager:
                name = "村人";
                hasTable = false;
                explain = "村人は特殊な能力を持たないただの一般人ですが、このゲームの主人公でもあります。他の村人や特殊能力を持った仲間たちと協力して人狼を処刑し、全滅させましょう。";
                isWolfF = false;
                isWolfS = false;
                break;

            case Werewolf:
                name = "人狼";
                hasTable = true;
                hasTableFirst = true;
                isWolfF = true;
                isWolfS = true;
                //tableString = "";//未実装
                //tableStringFirst = "";//未実装
                explain = "人狼は毎晩目を覚まし、村の人間を一人ずつ選んで喰い殺していきます。人狼同士で協力して人間を喰い尽くし、村を全滅させてしまいましょう。";
                break;

            case FortuneTeller:
                name = "予言者";
                hasTable = true;
                hasTableFirst = true;
                explain = "予言者は毎晩目を覚まし、自分が人狼だと疑っている人物を１人指定してその人物が人狼かそうでないかを知ることができます。";
                isWolfF = false;
                isWolfS = false;
                break;

            case Shaman:
                name = "霊媒師";
                hasTable = false;
                hasTableFirst = false;
                explain = "霊媒師は毎晩目を覚まし、その日の昼のターンに処刑された人が人狼だったのかそうでなかったのかを知ることができます。";
                isWolfF = false;
                isWolfS = false;
                break;

            case Madman:
                name = "狂人";
                hasTable = false;
                hasTableFirst = false;
                explain = "狂人は何も能力を持っていませんが、人狼側の人間です。人狼が勝利した時、自らも勝者となります。予言者に見られてもただの人間と判定されます。積極的に役職を騙り村を混乱させましょう。";
                isWolfF = false;
                isWolfS = false;
                break;

            case Bodyguard:
                name = "狩人";
                hasTable = true;
                hasTableFirst = false;
                explain = "狩人は毎晩目を覚まし、誰かを一人指定してその人物を人狼の襲撃から守ります。ただし、自分自身を守ることはできません。";
                isWolfF = false;
                isWolfS = false;
                break;

            default:
                break;
        }
        infoDic.put("name", name);
        infoDic.put("explain", explain);
        infoDic.put("hasTable", hasTable);
        infoDic.put("hasTableFirst", hasTableFirst);
        infoDic.put("isWolfF",isWolfF);
        infoDic.put("isWolfS",isWolfS);
//        infoDic.put("count",count);
//        infoDic.put("tableString", tableString);
//        infoDic.put("tableStringFirst", tableStringFirst);

        return infoDic;
    }
}