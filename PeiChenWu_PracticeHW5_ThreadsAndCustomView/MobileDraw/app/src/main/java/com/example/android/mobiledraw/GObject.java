package com.example.android.mobiledraw;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by peichenwu on 2/22/17.
 */

public class GObject {
    private float left, right, top, bottom;
    private int mode;
    private boolean selected;

    public GObject(int mode, float left, float right, float top, float bottom, boolean selected) {
        this.mode = mode;
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
        this.selected = selected;
    }

    private void drawRectBorder(Paint currPaint, Canvas canvas) {
        currPaint.setStyle(Paint.Style.STROKE);
        currPaint.setStrokeWidth(5.0f);
        currPaint.setColor(Color.rgb(140, 21, 21));
        canvas.drawRect(left, top, right, bottom, currPaint);
    }

    private void drawOvalBorder(Paint currPaint, Canvas canvas) {
        currPaint.setStyle(Paint.Style.STROKE);
        RectF ovalBounds = new RectF(left, top, right, bottom);
        currPaint.setStrokeWidth(5.0f);
        currPaint.setColor(Color.rgb(140, 21, 21));
        canvas.drawOval(ovalBounds, currPaint);
    }

    private void drawBlueRectBorder(Paint currPaint, Canvas canvas) {
        currPaint.setStyle(Paint.Style.STROKE);
        currPaint.setStrokeWidth(15.0f);
        currPaint.setColor(Color.rgb(0, 0, 255));
        canvas.drawRect(left, top, right, bottom, currPaint);
    }

    private void drawBlueOvalBorder(Paint currPaint, Canvas canvas) {
        currPaint.setStyle(Paint.Style.STROKE);
        RectF ovalBounds = new RectF(left, top, right, bottom);
        currPaint.setStrokeWidth(15.0f);
        currPaint.setColor(Color.rgb(0, 0, 255));
        canvas.drawOval(ovalBounds, currPaint);
    }

    private void myDrawRect(Paint currPaint, Canvas canvas) {
        currPaint.setColor(Color.rgb(255, 255, 255));
        canvas.drawRect(left, top, right, bottom, currPaint);
    }

    private void myDrawOval(Paint currPaint, Canvas canvas) {
        currPaint.setColor(Color.rgb(255, 255, 255));
        RectF ovalBounds = new RectF(left, top, right, bottom);
        canvas.drawOval(ovalBounds, currPaint);
    }

    public void selfDrawing(Canvas canvas) {
        if (!selected) {
            if (mode == 2) {
                Paint currentPaint = new Paint();
                myDrawRect(currentPaint, canvas);
                drawRectBorder(currentPaint, canvas);
            }
            else if (mode == 3) {
                Paint currentPaint = new Paint();
                myDrawOval(currentPaint, canvas);
                drawOvalBorder(currentPaint, canvas);
            }
        } else {
            if (mode == 2) {
                Paint currentPaint = new Paint();
                myDrawRect(currentPaint, canvas);
                drawBlueRectBorder(currentPaint, canvas);
            }
            else if (mode == 3) {
                Paint currentPaint = new Paint();
                myDrawOval(currentPaint, canvas);
                drawBlueOvalBorder(currentPaint, canvas);
            }
        }
    }


    public int getMode() {
        return mode;
    }


    public boolean selectOrNot() {
        return selected;
    }

    public float getLeft() {
        return left;
    }

    public float getRight() {
        return right;
    }

    public float getTop() {
        return top;
    }

    public float getBottom() {
        return bottom;
    }

    public float getWidth() {
        return right - left;
    }

    public float getHeight() {
        return bottom - top;
    }

    public float getX() {
        return (left + right)/2;
    }

    public float getY() {
        return (top + bottom)/2;
    }

}
