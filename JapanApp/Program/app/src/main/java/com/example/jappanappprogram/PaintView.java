package com.example.jappanappprogram;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.os.Environment;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;


public class PaintView extends View {

    public static int BRUSH_SIZE = 20;
    public static final int DEFAULT_COLOR = Color.BLACK;
    public static final int DEFAULT_BG_COLOR = Color.GRAY;
    private static final float TOUCH_TOLERANCE = 2;
    private float mX, mY;
    private Path mPath;
    private Paint mPaint;
    private ArrayList<FingerPath> paths = new ArrayList<>();
    private int backgroundColor = DEFAULT_BG_COLOR;
    private Bitmap mBitmap;
    private Canvas mCanvas;


    public PaintView(Context context) {
        this(context, null);
    }

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPath = new Path();

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(DEFAULT_COLOR);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setXfermode(null);
        mPaint.setAlpha(0xff);
        mPaint.setStrokeWidth(BRUSH_SIZE);



    }

    public void init(DisplayMetrics metrics) {
        int height = metrics.heightPixels;
        int width = metrics.widthPixels;

        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
        mCanvas.drawColor(backgroundColor);


    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(mBitmap, 0, 0, null);
    }


    private void touchStart(float x, float y) {
        mPath.moveTo(x, y);
        mX = x;
        mY = y;
    }
    public void clear() {
        FileOutputStream fos = null;

        try
        {
            fos = this.getContext().openFileOutput("narywowany", MODE_PRIVATE);
            mBitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);

            fos.flush();
            fos.close();
            fos = null;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (fos != null)
            {
                try
                {
                    fos.close();
                    fos = null;
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }


        System.out.println(Environment.getExternalStorageDirectory());


        mCanvas.drawColor(backgroundColor);
        invalidate();
    }

    private void touchMove(float x, float y) {
        float dx = Math.abs(x - mX);
        float dy = Math.abs(y - mY);
        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
            mPath.quadTo(mX, mY, (x + mX)/2, (y + mY)/2);
            mX = x;
            mY = y;
            mCanvas.drawPath(mPath, mPaint);
        }
    }

    private void touchUp() {

        mPath.reset();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchStart(x, y);
                break;
            case MotionEvent.ACTION_MOVE:
                touchMove(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                touchUp();
                break;
            default:
        }
        return true;
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }
    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }
}