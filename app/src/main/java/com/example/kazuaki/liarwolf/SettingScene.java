package com.example.kazuaki.liarwolf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import static android.widget.LinearLayout.*;

/**
 * Created by Kazuaki on 2015/12/06.
 */
public class SettingScene extends Activity {
    public static void main(String[] args){}

    public static String scene;


    @Override
    public void onCreate(Bundle savedInstanceState){
        scene = "setting_scene";
        super.onCreate(savedInstanceState);
        FrameLayout layout = new FrameLayout(this);
        setContentView(layout);

        //custom add
        final CustomView customView = new CustomView(this);
        layout.addView(customView);
    }
//    private final int MP = LinearLayout.LayoutParams.MATCH_PARENT;
//    private final int WC = LinearLayout.LayoutParams.WRAP_CONTENT;
//
//    public void initBackground(){
//        // ボタン生成処理
//    }
//    public void saveData(){}
//    public void loadData(){}
//    public void setPlayerInfo(){}
//    public void setRoleInfo(){}
//    public void setRuleInfo(){}
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.settingscene);
//
//        LinearLayout linearLayout = new LinearLayout(this);
//        linearLayout.setOrientation(VERTICAL);
//        setContentView(linearLayout);
//
//        Button roleSetting = new Button(this);
//        roleSetting.setText("配役設定");
//        roleSetting.setBackgroundResource(R.drawable.button);
//        roleSetting.setLayoutParams(new LinearLayout.LayoutParams(MP, WC));
//        linearLayout.addView(roleSetting);
//
//        Button ruleSetting = new Button(this);
//        ruleSetting.setText("ルール設定");
//        ruleSetting.setBackgroundResource(R.drawable.button);
//        ruleSetting.setLayoutParams(new LinearLayout.LayoutParams(MP, WC));
//        linearLayout.addView(ruleSetting);
//
//        Button playerSetting = new Button(this);
//        playerSetting.setText("プレイヤー設定");
//        playerSetting.setBackgroundResource(R.drawable.button);
//        playerSetting.setLayoutParams(new LinearLayout.LayoutParams(MP,WC));
//        linearLayout.addView(playerSetting);
//
//        Button gameScene = new Button(this);
//        gameScene.setText("スタート");
//        gameScene.setBackgroundResource(R.drawable.button);
//        gameScene.setLayoutParams(new LinearLayout.LayoutParams(MP, WC));
//        linearLayout.addView(gameScene);
//        gameScene.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SettingScene.this, GameScene.class);
//                startActivity(intent);
//            }
//        });
//    }
}
