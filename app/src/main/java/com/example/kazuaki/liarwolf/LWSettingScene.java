package com.example.kazuaki.liarwolf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import static android.widget.LinearLayout.*;

/**
 * Created by Kazuaki on 2015/12/06.
 */
public class LWSettingScene extends Activity {
    private final int MP = LinearLayout.LayoutParams.MATCH_PARENT;
    private final int WC = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settingscene);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(VERTICAL);
        setContentView(linearLayout);

        Button roleSetting = new Button(this);
        roleSetting.setText("配役設定");
        roleSetting.setLayoutParams(new LinearLayout.LayoutParams(MP,WC));
        linearLayout.addView(roleSetting);

        Button ruleSetting = new Button(this);
        ruleSetting.setText("ルール設定");
        ruleSetting.setLayoutParams(new LinearLayout.LayoutParams(MP,WC));
        linearLayout.addView(ruleSetting);

        Button playerSetting = new Button(this);
        playerSetting.setText("プレイヤー設定");
        playerSetting.setLayoutParams(new LinearLayout.LayoutParams(MP,WC));
        linearLayout.addView(playerSetting);

        Button gameScene = new Button(this);
        gameScene.setText("スタート");
        gameScene.setLayoutParams(new LinearLayout.LayoutParams(MP, WC));
        linearLayout.addView(gameScene);
        gameScene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LWSettingScene.this, LWGameScene.class);
                startActivity(intent);
            }
        });






    }
}
