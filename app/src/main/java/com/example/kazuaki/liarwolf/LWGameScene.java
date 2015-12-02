package com.example.kazuaki.liarwolf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import com.example.kazuaki.liarwolf.Enum.*;
import com.example.kazuaki.liarwolf.LWUtility.*;

/**
 * Created by Kazuaki on 2015/11/16.
 */

public class LWGameScene{
 public static void main(String[] args){
  Map<String,String> query = new HashMap<String,String>();
  ArrayList<Object> tablePlayerArray = new ArrayList<Object>();

  int day = 0;

  String victim = "いません";
  ArrayList<Object> victimArray = new ArrayList<Object>();]
  List<Map<String,Object>> playerArray = new ArrayList<>();

  Map<String,Object> playerMap;
  //map中身生成
  int i;
  String[] name = {"はせべ","はるき","くろき","きむ","しんぺー","かっきー","たけし","まさよし"};

  for(i=0;i<8;i++) {
   playerMap = new HashMap<>();
   playerMap.put("playerId", i);
   playerMap.put("name", name[i]);
   playerMap.put("roleId", Role.RoleVillager);
   playerMap.put("isLive", true);
   playerArray.add(playerMap);

  }



 // 初期化関数
 public void initBackground{


  // backgroundを設定
  // setRole（シャッフルして役職を決定）
  void setRole;

  query.put("phase","firstNight_opening");
  void setBackground;


 }

 public void setBackground{

  // Table内のデータを初期化
  // 画面を一度まっさらにする


  // phase に応じた処理を書く
  if(query.get("phase").equals("firstNight_opening") || query.get("phase").equals("nextPlayer") || query.get("phase").equals("afternoon_opening") || query.get("phase").equals("afternoon_opening2") || query.get("phase").equals("night_opening") || query.get("phase").equals("gameover") || query.get("phase").equals("winner"){


   // 画面を作る
   /* messageSize
   *  buttonSize
   *  margin

   *  UIColor
    fontSize */
   String message = "";

    //画面を作る終了

   if (query.get("phase").equals("firstNight_opening")){
    // refresh
    void refresh;
    // message 未実装
    message = "はじめの夜になりました。「%@」さんから端末をまわしてそれぞれ行動を決定してください。それ以外のプレイヤーは目を閉じて顔を伏せてください。",infoDic.get("players")[0]["name"]];
    /*backColor
    * fontColor
    * fontSize*/
   }
   if (query.get("phase").equals("night_opening")){
    //refresh
    //if (isFinish !=0){ //終了判定
     query.put("phase","gameover");
     // setBackground
     //戻り値を指定
    }
   }


  }


 }
 public void setRole{
  ArrayList<Object> array = new ArrayList<>();
  ArrayList<Object> roleArray = new ArrayList<>();



 }
 public void refresh{

 }
 public void isFinish{
  int point = 0;
  boolean wolfzero = true;
  // 生存者の役職を数える
  if (roleId == Role.RoleWerewolf){
   point --;
   wolfzero = false;
  } else{
   point ++;
  }

  int result = 0;
  if(wolfzero){
   result = 1; //村勝利
  }
  if (point <=0){
   result = -1;//人狼勝利
  }
  else {
   result = 0;//ゲーム続行
  }
  //return result;

 }

 }
}
