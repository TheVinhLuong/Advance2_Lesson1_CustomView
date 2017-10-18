package com.example.android.advance2_lesson1_customview.widget.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by VinhTL on 17/10/2017.
 */

public class TouchEventView extends View {
    private Paint mPaint;
    private Path mPath;

    public TouchEventView(Context context) {
        super(context);
        setAttribute();
    }

    public TouchEventView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setAttribute();
    }

    public TouchEventView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setAttribute();
    }

    private void setAttribute() {
        mPaint = new Paint();
        mPath = new Path();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(15f);
        mPaint.setColor(Color.BLACK);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(eventX, eventY);
                return true;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(eventX, eventY);
                break;
            default: return false;
        }
        
        invalidate();
        return true;
    }
    
    public void erase(){
        mPath.reset();
        invalidate();
    }
}
