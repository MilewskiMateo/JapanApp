package com.example.jappanappprogram;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class PopUpPaintView extends View {
    Bitmap mBitMap;
    Paint mPaint;
    Context mContext;

    public PopUpPaintView(Context context) {
        super(context);
        this.mContext = context;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        canvas.drawBitmap(mBitMap,0,0,mPaint);
    }


    public void addBitmapAndPaint(Bitmap bitmap, Paint paint,int width, int height){
        this.mBitMap = Bitmap.createScaledBitmap(bitmap,width,height,false);
        this.mPaint = paint;
    }
}
