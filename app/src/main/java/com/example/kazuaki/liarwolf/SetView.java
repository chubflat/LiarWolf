package com.example.kazuaki.liarwolf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Kazuaki on 2015/12/13.
 */
public class SetView extends View {
    Paint paint;
    private Boolean viewflg;

    public SetView(Context context,AttributeSet attrs){
        super(context,attrs);
        paint = new Paint();
        viewflg = true;
    }
    public void showCanvas(boolean flg){
        viewflg = flg;
        //再描画
        invalidate();
    }
    public void canvasClear(Canvas canvas){
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
    }
    @Override
    public void onDraw(Canvas canvas){
        canvas.drawText("testtest",50,30,paint);

    }
}
