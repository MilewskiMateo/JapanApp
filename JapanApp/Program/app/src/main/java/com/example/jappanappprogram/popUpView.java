package com.example.jappanappprogram;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class popUpView extends View {

    Bitmap mBitmap;
    Paint mPaint;
    public popUpView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
      //  canvas.drawBitmap(mBitmap, 0, 0, mPaint);
    }
}