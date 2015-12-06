package com.example.kazuaki.liarwolf;

import java.util.HashMap;
import java.util.Map;
import com.example.kazuaki.liarwolf.Enum.*;
import android.widget.Button;
/**
 * Created by Kazuaki on 2015/11/16.
 */
public class LWUtility {
    public static void main(String[] args) {
            Map<String, Object> infoDic = new HashMap<String, Object>();
            String name = "name";
            String explain = "explain";
            String detailExplain = "特になし";
            boolean hasTable = false; //夜のアクションでテーブルがあるか
            boolean hasTableFirst = false;//初夜のアクションでテーブルがあるか
            String tableString = "";// 夜のアクションでテーブルに表示する文字列
            String tableStringFirst = "";// 初夜のアクションでテーブルに表示する文字列

            Role role = Role.RoleVillager;


            switch (role) {
                case RoleVillager: //RoleVillager
                    name = "村人";
                    hasTable = false;
                    explain = "村人は特殊な能力を持たないただの一般人ですが、このゲームの主人公でもあります。他の村人や特殊能力を持った仲間たちと協力して人狼を処刑し、全滅させましょう。";
                    break;

                case RoleWerewolf://RoleWerewolf
                    name = "人狼";
                    hasTable = true;
                    hasTableFirst = true;
                    tableString = "";//未実装
                    tableStringFirst = "";//未実装
                    explain = "人狼は毎晩目を覚まし、村の人間を一人ずつ選んで喰い殺していきます。人狼同士で協力して人間を喰い尽くし、村を全滅させてしまいましょう。";
                    break;

                default:
                    break;
            }
            // infoDicにキーと値を設定
            infoDic.put("name", name);
            infoDic.put("explain", explain);
            infoDic.put("hasTable", hasTable);
            infoDic.put("hasTableFirst", hasTableFirst);
            infoDic.put("tableString", tableString);
            infoDic.put("tableStringFirst", tableStringFirst);



        }
}
