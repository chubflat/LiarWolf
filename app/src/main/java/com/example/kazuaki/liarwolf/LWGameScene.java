package com.example.kazuaki.liarwolf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import com.example.kazuaki.liarwolf.Enum.*;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.*;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import static com.example.kazuaki.liarwolf.Enum.Role.*;

/**
 * Created by Kazuaki on 2015/11/16.
 */

public class LWGameScene extends Activity{
 @Override
 public void onCreate(Bundle savedInstanceState){
  super.onCreate(savedInstanceState);
  setContentView(R.layout.gamescene);

  TextView test = new TextView(this);
  test.setText("test");
  setContentView(test,new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));

 }

 private static Map<String, String> query;
 private static ArrayList<Object> tablePlayerArray;
 private static int day;
 private static String victim;
 private static ArrayList<Object> victimArray;
 private static List<Map<String,Object>> playerArray;

 public void main(String[] args) {
 }
 // 初期化メソッド
  public void initBackground(){

  query = new HashMap<String,String>();
  tablePlayerArray = new ArrayList<Object>();

  day = 0;

  victim = "いません";
  victimArray = new ArrayList<Object>();
  playerArray = new ArrayList<>();

  Map<String,Object> playerMap;
  //map中身生成
  int i;
  String[] name = {"はせべ","はるき","くろき","きむ","しんぺー","かっきー","たけし","まさよし"};

  for(i=0;i<8;i++) {
   playerMap = new HashMap<>();
   playerMap.put("playerId", i);
   playerMap.put("name", name[i]);
   playerMap.put("roleId", RoleVillager);
   playerMap.put("isLive", true);
   playerArray.add(playerMap);
     }
   query.put("phase","firstNight_opening");

   //TODO setBackgroundを呼び出す
 }
 public void setBackground(){
  //TODO 画面作成処理

  // phase が・・・の場合のif文を書く
  // if(query.get("phase").equals("firstNight_opening") || query.get("phase").equals("nextPlayer") || query.get("phase").equals("afternoon_opening") || query.get("phase").equals("afternoon_opening2") || query.get("phase").equals("night_opening") || query.get("phase").equals("gameover") || query.get("phase").equals("winner"){


  //TODO 終了判定
  // isFinishメソッドを呼び出す
  // winIdに応じてテキストをかえる

  //TODO 続行の場合
  // 最初の人を探す
  // ◯日目の夜になりました
  // 役職ごとに文章を表示
 }
 public void checkExcutedPlayer(){
  // phaseRole:どんな役職の効果で死亡したのか
 }
 public void setTableDataFirst(){}
 public void setTableData(){}
 public void setRole(){}
 public void setBackScene(){}
 // public void touchesBegan(){}
 public void goNextPhase(){
  // TODO phaseの順番を定義する
 }
 public void refresh(){
  //TODO 保持している情報を消す
 }
 public int isFinish(){
  int point;
  point = 0;
  return point;
  //TODO 終了判定を記述
 }
 public void alertView(){
  // アラートのボタンが押されたときに呼ばれるデリゲート例文
 }


 }


/*
 public void onDraw(Canvas c){
  //TODO ここの描画処理を追加
  Paint fill_paint = new Paint();
  c.drawText("test",50,50,fill_paint);
  c.drawBitmap(img,50,50,fill_paint);
 }


}
*/
