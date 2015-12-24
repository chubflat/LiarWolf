package com.example.kazuaki.liarwolf;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kazuaki on 2015/12/23.
 */
public class CustomView extends View {

    private Bitmap background =null;
    private Bitmap frame = null;
    private Bitmap button;
    public String text = "text";
    public static String phase = "";
    public static int nowPlayer = 0;
    public static int day;
    public static int selectedPlayerId;
    public static int mediumId;
    public static int bodyguardId;
    public static boolean isFirstNight = true;

    //画面サイズ用宣言
    public static int dp_width;
    public static int dp_height;
    public static int textSize;

    public static Rect buttonrect;
    public static Rect addButton;
    public static Rect startButton;
    public static int playerVolume;

    public CustomView(Context context){
        super(context);
        setFocusable(true);

        // WindowsManager取得
        WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        // Displayインスタンス生成
        Display dp = wm.getDefaultDisplay();
        // ディスプレイサイズ取得
        dp_width = dp.getWidth();
        dp_height = dp.getHeight();
        // リサイズ画像の高さ
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        background = BitmapFactory.decodeResource(getResources(), R.drawable.night);
        frame = BitmapFactory.decodeResource(getResources(), R.drawable.frame);
        button = BitmapFactory.decodeResource(getResources(), R.drawable.button);
        textSize = 30;


        phase = GameScene.phase;
        nowPlayer = GameScene.nowPlayer;
        day = GameScene.day;
        selectedPlayerId = GameScene.selectedPlayerId;
        isFirstNight = GameScene.isFirstNight;
        mediumId = GameScene.mediumId;
        bodyguardId = GameScene.bodyguardId;


        switch (phase){
            case "player_setting":
                playerVolume = 0;

                break;
            case "role_setting":
                int villagerVolume = GameScene.roleArray.get(0);
                int werewolfVolume = GameScene.roleArray.get(1);
                int SeerVolume = GameScene.roleArray.get(2);
                int mediumVolume = GameScene.roleArray.get(3);
                int minionVolume = GameScene.roleArray.get(4);
                int bodyguardVolume = GameScene.roleArray.get(5);

                text = String.format("プレイヤー数は%d人です。\n" + "村人：%d人\n" + "人狼：%d人\n" +"予言者：%d人\n" + "霊媒師：%d人\n" + "狂人：%d人\n" +"狩人：%d人\n",playerVolume,villagerVolume,werewolfVolume,SeerVolume,mediumVolume,minionVolume,bodyguardVolume);
                break;
            case "night_opening" :
                text = String.format("%d日目の夜になりました。「%s」さんから端末を回してそれぞれ行動を決定してください。それ以外のプレイヤーは目を閉じて顔を伏せてください。",day,GameScene.playerArray.get(nowPlayer).get("name"));
                GameScene.drawListView(false);
                break;
            case "night_playerCheck":
                text = String.format("あなたは「%s」さんですね？",GameScene.playerArray.get(nowPlayer).get("name"));
                break;
            case "night_roleRotate":
                text = String.format("あなたの役職は「%s」です。", (String) Utility.getRoleInfo((Utility.Role) GameScene.playerArray.get(nowPlayer).get("roleId")).get("name"));
                textSize = 50;
                break;
            case "night_roleCheck":
                text = String.format("あなたの役職は「%s」です。%s", (String) Utility.getRoleInfo((Utility.Role) GameScene.playerArray.get(nowPlayer).get("roleId")).get("name"),(String) Utility.getRoleInfo((Utility.Role) GameScene.playerArray.get(nowPlayer).get("roleId")).get("explain"));
                if(isFirstNight) {
                    if((Boolean)Utility.getRoleInfo((Utility.Role) GameScene.playerArray.get(nowPlayer).get("roleId")).get("hasTableFirst")){
                        if(GameScene.playerArray.get(nowPlayer).get("roleId") == Utility.Role.Werewolf){
                            GameScene.setListAdapter(1);
                        }else if(GameScene.playerArray.get(nowPlayer).get("roleId") == Utility.Role.Seer){
                            GameScene.setListAdapter(2);
                        }
                        GameScene.drawListView(true);
                    }else{
                    }

                }else{
                    if((Boolean)Utility.getRoleInfo((Utility.Role) GameScene.playerArray.get(nowPlayer).get("roleId")).get("hasTable")){
                        if(GameScene.playerArray.get(nowPlayer).get("roleId") == Utility.Role.Werewolf){
                            GameScene.setListAdapter(1);
                        }else if(GameScene.playerArray.get(nowPlayer).get("roleId") == Utility.Role.Seer){
                            GameScene.setListAdapter(2);
                        }else if(GameScene.playerArray.get(nowPlayer).get("roleId") == Utility.Role.Bodyguard){
                            GameScene.setListAdapter(3);
                        }
                        GameScene.drawListView(true);
                    }else if(GameScene.playerArray.get(nowPlayer).get("roleId") == Utility.Role.Medium){
                        String result = "人間";
                        if((int)Utility.getRoleInfo((Utility.Role) GameScene.playerArray.get(mediumId).get("roleId")).get("mediumResult") == -1){
                            result = "人狼";
                        }
                        text = String.format("あなたは霊媒師です。昼に処刑された「%s」さんは＜%s＞でした。",(String)GameScene.playerArray.get(mediumId).get("name"),result);
                    }
                }
                break;
            case "Seer":
                String result = "人間";
                if((int)Utility.getRoleInfo((Utility.Role) GameScene.playerArray.get(selectedPlayerId).get("roleId")).get("seerResult") == -1){
                    result = "人狼";
                }
                text = String.format("「%s」さんは＜%s＞です",(String)GameScene.playerArray.get(selectedPlayerId).get("name"),result);
                break;
            case "nextPlayer":
                text = "次のプレイヤーに端末を渡してください。";
                break;
            case "afternoon_opening":
                background = BitmapFactory.decodeResource(getResources(), R.drawable.afternoon);
                if(GameScene.victimArray.size() == 0){
                    text = String.format("%d日目の朝になりました。昨晩の犠牲者はいませんでした。",day);
                }else {
                    text = String.format("%d日目の朝になりました。昨晩の犠牲者は、「%s」さんでした。", day, (String) GameScene.playerArray.get(GameScene.victimArray.get(0)).get("name"));
                }
                break;
            case "afternoon_opening2":
                background = BitmapFactory.decodeResource(getResources(), R.drawable.afternoon);
                text= "人狼を見つけるための会議を始めてください。議論の時間は5分です。";
                break;
            case "afternoon_meeting":
                background = BitmapFactory.decodeResource(getResources(), R.drawable.afternoon);
                // TODO タイマー実装時変更
                text = "議論時間中";
                break;
            case "afternoon_voting":
                background = BitmapFactory.decodeResource(getResources(), R.drawable.evening);
                text = "日が暮れて今日も1人処刑者を決めなければなりません。投票を行い、処刑者を決定してください。同票の場合は決選投票を行い、3回続けても変更がない場合は引き分けとなります。";
                GameScene.drawListView(true);
                break;
            case "excution":
                background = BitmapFactory.decodeResource(getResources(), R.drawable.evening);
                text = String.format("「%s」さんは村の総意で処刑されました。",(String)GameScene.playerArray.get(selectedPlayerId).get("name"));
                GameScene.drawListView(false);
                break;
            case "gameover":
                background = BitmapFactory.decodeResource(getResources(), R.drawable.evening);
                text = "この時点でゲームが終了しました。勝利者は、、、";
                break;
            case "winner":
                int winId = GameScene.isFinish();
                String message = "";
                if(winId == 1){
                    message = "村人チームの勝利です！";
                    background = BitmapFactory.decodeResource(getResources(), R.drawable.afternoon);
                }else if(winId == -1){
                    message = "人狼チームの勝利です！";
                    background = BitmapFactory.decodeResource(getResources(), R.drawable.night);
                }
                text = message;
                textSize = 50;
                break;
            case "ending":
                text = "お疲れさまでした。役職を確認してください";
                background = BitmapFactory.decodeResource(getResources(), R.drawable.night);
                break;
            default:
                text = "error";
                break;
        }
        if(phase.equals("player_setting")){
            canvas.drawBitmap(background, null, new Rect(0, 0, dp_width, dp_height), paint);
            // addButton
            addButton = new Rect(dp_width / 10,dp_height*15/100,dp_width*9/10,dp_height*25/100);
            canvas.drawBitmap(button, null, addButton, paint);
            String addButton = "プレイヤー追加";
            paint.setTextSize(50);
            canvas.drawText(addButton,dp_width*25/100,dp_height*22/100,paint);


            // startButton
            startButton = new Rect(dp_width / 10,dp_height*3/10,dp_width*9/10,dp_height*4/10);
            canvas.drawBitmap(button, null, startButton, paint);
            String startButton = "スタート";
            canvas.drawText(startButton,dp_width*35/100,dp_height*37/100,paint);

            playerVolume = GameScene.listInfoDicArray.size();
            String playersize = String.format("プレイヤー数：%d人",playerVolume);
            paint.setColor(Color.WHITE);
            canvas.drawText(playersize,dp_width*2/10,dp_height*10/100,paint);


        }else{
            canvas.drawBitmap(background, null, new Rect(0, 0, dp_width, dp_height), paint);
            canvas.drawBitmap(frame, null, new Rect(dp_width / 10, dp_height * 2 / 10, dp_width * 9 / 10, dp_height * 5 / 10), paint);//width 1/10~9/10,height 2/10~5/10

            buttonrect = new Rect(dp_width / 10, dp_height * 8 / 10, dp_width * 9 / 10, dp_height * 9 / 10);
            canvas.drawBitmap(button, null,buttonrect, paint);

            String button = "次へ";
            paint.setTextSize(50);
            canvas.drawText(button,dp_width*4/10,dp_height*87/100,paint);

            TextPaint mTextPaint = new TextPaint();
            mTextPaint.setTextSize(textSize);
            StaticLayout mTextLayout = new StaticLayout(text,mTextPaint,dp_width*3/5, Layout.Alignment.ALIGN_NORMAL,1.0f,0.0f,false);
            canvas.translate(dp_width * 2 / 10, dp_height * 25 / 100);//text の左上座標の指定

            mTextLayout.draw(canvas);
            canvas.restore();
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float pointX = event.getX();
        float pointY = event.getY();

//        buttonrect.contains((int) pointX, (int) pointY))

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                if(!(phase.equals("player_setting")) && buttonrect.contains((int) pointX, (int) pointY)) {//TODO or文で書き直す
                    GameScene.goNextPhase();
                }else if(addButton.contains((int) pointX, (int) pointY)){
                    //TODO 参加者を消す処理
                    String text = GameScene.editText.getText().toString();
                    if(!(text.equals(""))){
                        GameScene.prePlayerList.add(text);
                    }

                    GameScene.listInfoDicArray.clear();

                    for (int i = 0; i < GameScene.prePlayerList.size(); i++) {
//                        if ((boolean) playerArray.get(i).get("isLive") == true) {
////                    String name = (String) playerArray.get(i).get("name");
////                    names.add(name);
//                            GameScene.listPlayerArray.add(i);

                        Map<String,String> conMap = new HashMap<>();
                        conMap.put("name",GameScene.prePlayerList.get(i));
                        conMap.put("listSecondInfo","");
                        GameScene.listInfoDicArray.add(conMap);
//                        }
                    }

//                    Map<String ,String> map = new HashMap<>();
//                    map.put("name",text);
//                    map.put("listSecondInfo","");
//                    GameScene.listInfoDicArray.add(map);

                    GameScene.listView.invalidateViews();
                    // 中身クリア
                    GameScene.editText.getEditableText().clear();
                }else if(startButton.contains((int) pointX, (int) pointY)){
                    Log.d("start", "start=");
                    GameScene.editText.setVisibility(View.INVISIBLE);
                    GameScene.goNextPhase();
                    Log.d("startfin", "startfin=");
                }
                Log.d("break","break=");
                break;


            default:
                return true;
        }
//        playerVolume =  GameScene.listInfoDicArray.size();
        invalidate();
        return true;
    }
    public  void getInvalidate(){
        invalidate();
    }
}
