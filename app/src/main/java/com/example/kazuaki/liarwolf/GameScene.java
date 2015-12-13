package com.example.kazuaki.liarwolf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import com.example.kazuaki.liarwolf.Enum.*;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.kazuaki.liarwolf.Enum.Role.*;

/**
 * Created by Kazuaki on 2015/11/16.
 */

public class GameScene extends Activity{
    private boolean showCanvas = true;
    private SetView setView;
 public void main(String args[]) {
      }

 @Override
 public void onCreate(Bundle savedInstanceState){
  super.onCreate(savedInstanceState);
  setContentView(R.layout.gamescene);

/*     setView = (SetView)findViewById(R.id.setView);

     Button button = (Button)findViewById(R.id.testbtn);
     button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             if(showCanvas) {
                 setView.showCanvas(false);
                 showCanvas = false;
             }
             else{
                 setView.showCanvas(true);
                 showCanvas = true;
             }
          }
     });*/
 }

 private static Map<String, String> query;
 private static ArrayList<Object> tablePlayerArray;
 private static int day;
 private static String victim;
 private static ArrayList<Object> victimArray;
 private static List<Map<String,Object>> playerArray;


 // 初期化メソッド
  public void initBackground() {

   query = new HashMap<String, String>();
   tablePlayerArray = new ArrayList<Object>();

   day = 0;

   victim = "いません";
   victimArray = new ArrayList<Object>();
   playerArray = new ArrayList<>();

   setRole();
   setBackground();
  }
 public void setRole(){
  Map<String, Object> playerMap;
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
   query.put("phase", "firstNight_opening");

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