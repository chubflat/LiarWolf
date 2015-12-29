package com.example.kazuaki.liarwolf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
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

    @Override
    public boolean onTouchEvent(MotionEvent event){
        int actionId = event.getAction();

        switch (actionId){
            case MotionEvent.ACTION_DOWN:
                if(scene.equals("game_scene")){
                    Intent intent = new Intent();

                }else{

                }
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);

    }
}
