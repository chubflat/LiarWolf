package com.example.kazuaki.liarwolf;

import android.media.Image;

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
        Seer,
        Medium,
        Madman,
        Bodyguard;
    }

    public static Map<String,Object> getRoleInfo(Role role) {
        Map<String, Object> infoDic = new HashMap<String, Object>();
        String name = "";
        Boolean hasTable = false;
        Boolean hasTableFirst = false;
        String explain = "";
        Boolean seerResult = false; //人狼判定
        Boolean mediumResult = false;//人狼判定
        int isFinishCount = 1;//人間カウント
        int cardId = R.drawable.card0;

        //TODO 役職追加時
        switch (role) {
            case Villager:
                name = "村人";
                hasTable = false;
                hasTableFirst = false;
                explain = "村人は特殊な能力を持たないただの一般人ですが、このゲームの主人公でもあります。他の村人や特殊能力を持った仲間たちと協力して人狼を処刑し、全滅させましょう。";

                seerResult = false;
                mediumResult = false;
                isFinishCount = 1;
                cardId = R.drawable.card0;
                break;

            case Werewolf:
                name = "人狼";
                hasTable = true;
                hasTableFirst = true;
                explain = "人狼は毎晩目を覚まし、村の人間を一人ずつ選んで喰い殺していきます。人狼同士で協力して人間を喰い尽くし、村を全滅させてしまいましょう。";
                // 判定
                seerResult = true;
                mediumResult = true;
                isFinishCount = -1;
                //tableString = "";//未実装
                //tableStringFirst = "";//未実装
                cardId = R.drawable.card1;
                break;

            case Seer:
                name = "予言者";
                hasTable = true;
                hasTableFirst = true;
                explain = "予言者は毎晩目を覚まし、自分が人狼だと疑っている人物を１人指定してその人物が人狼かそうでないかを知ることができます。";
                //判定
                seerResult = false;
                mediumResult = false;
                isFinishCount = 1;
                cardId = R.drawable.card2;
                break;

            case Medium:
                name = "霊媒師";
                hasTable = false;
                hasTableFirst = false;
                explain = "霊媒師は毎晩目を覚まし、その日の昼のターンに処刑された人が人狼だったのかそうでなかったのかを知ることができます。";
                //判定
                seerResult = false;
                mediumResult = false;
                isFinishCount = 1;
                cardId = R.drawable.card3;
                break;

            case Madman:
                name = "狂人";
                hasTable = false;
                hasTableFirst = false;
                explain = "狂人は何も能力を持っていませんが、人狼側の人間です。人狼が勝利した時、自らも勝者となります。予言者に見られてもただの人間と判定されます。積極的に役職を騙り村を混乱させましょう。";
                seerResult = false;
                mediumResult = false;
                isFinishCount = 1;
                cardId = R.drawable.card4;
                break;

            case Bodyguard:
                name = "狩人";
                hasTable = true;
                hasTableFirst = false;
                explain = "狩人は毎晩目を覚まし、誰かを一人指定してその人物を人狼の襲撃から守ります。ただし、自分自身を守ることはできません。";
                seerResult = false;
                mediumResult = false;
                isFinishCount = 1;
                cardId = R.drawable.card5;
                break;


            default:
                break;
        }
        infoDic.put("name", name);
        infoDic.put("explain", explain);
        infoDic.put("hasTable", hasTable);
        infoDic.put("hasTableFirst", hasTableFirst);
        infoDic.put("seerResult",seerResult);
        infoDic.put("mediumResult",mediumResult);
        infoDic.put("isFinishCount",isFinishCount);
        infoDic.put("cardId",cardId);
//        infoDic.put("tableString", tableString);
//        infoDic.put("tableStringFirst", tableStringFirst);

        return infoDic;
    }
}