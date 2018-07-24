package com.javatechig.droid.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

/**
 * Created by re033290 on 26/06/2016.
 */
public class DrawableTete extends Drawable {
    private Paint mPaint = new Paint();
    private float dy;

    public DrawableTete(Context ctx){
        mPaint.setColor(Color.WHITE);
        dy = ctx.getResources().getDimension(R.dimen.abc_action_bar_content_inset_material);

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRect(getBounds().left,getBounds().centerY()-dy/2,getBounds().right,getBounds().centerY()+dy/2,mPaint);
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
