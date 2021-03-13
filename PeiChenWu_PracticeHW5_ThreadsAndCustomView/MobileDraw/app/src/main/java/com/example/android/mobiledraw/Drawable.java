package com.example.android.mobiledraw;

/**
 * Created by peichenwu on 2/22/17.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Drawable extends View {
    private List<GObject> list = new ArrayList<>();
    public static int mode;


    public Drawable(Context context, AttributeSet attrs) {
        super(context, attrs);

    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        if (!list.isEmpty()) {
            for (GObject item : list) {
                item.selfDrawing(canvas);
            }
        }


    }


    float top, left, bottom, right;
    float x1,y1,x2,y2;
    float x, y;
    float x_, y_;

    boolean addNewOb1 = false;
    boolean addNewOb2 = false;
    boolean selection1 = false;
    boolean erase1 = false;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mode == 2) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    x1 = event.getX();
                    y1 = event.getY();
                    addNewOb1 = true;
                    break;
                case MotionEvent.ACTION_UP:
                    x2 = event.getX();
                    y2 = event.getY();
                    addNewOb2 = true;

                    if (x1>x2) {
                        left = x2;
                        right = x1;
                    } else {
                        left = x1;
                        right = x2;
                    }

                    if (y1>y2) {
                        top = y2;
                        bottom = y1;
                    } else {
                        top = y1;
                        bottom = y2;
                    }
                    invalidate();
            }
            if (addNewOb1 && addNewOb2) {
                GObject ob = new GObject(mode, left, right, top, bottom, false);
                list.add(ob);

                addNewOb1 = false;
                addNewOb2 = false;
            }
        } else if (mode == 3) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    x1 = event.getX();
                    y1 = event.getY();
                    addNewOb1 = true;
                    break;
                case MotionEvent.ACTION_UP:
                    x2 = event.getX();
                    y2 = event.getY();
                    addNewOb2 = true;

                    if (x1>x2) {
                        left = x2;
                        right = x1;
                    } else {
                        left = x1;
                        right = x2;
                    }

                    if (y1>y2) {
                        top = y2;
                        bottom = y1;
                    } else {
                        top = y1;
                        bottom = y2;
                    }

                    invalidate();
            } if (addNewOb1 && addNewOb2) {
                GObject ob = new GObject(mode, left, right, top, bottom, false);
                list.add(ob);
                addNewOb1 = false;
                addNewOb2 = false;
            }
        } else if (mode == 1) {
            if (!list.isEmpty()) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = event.getX();
                        y = event.getY();
                        selection1 = true;
                        invalidate();
                }
                if (selection1) {
                    int found = -1;
                    for (int i = list.size() - 1; i >= 0; i--) {
                        GObject item = list.get(i);
                        if (item.getLeft() <= x && item.getRight() >= x) {
                            if (item.getBottom() >= y && item.getTop() <= y) {
                                found = i;
                                break;
                            }
                        }
                    }


                    for (int i = list.size() - 1; i >= 0; i--) {
                        if (list.get(i).selectOrNot()) {
                            GObject ob1 = new GObject(list.get(i).getMode(), list.get(i).getLeft(), list.get(i).getRight(), list.get(i).getTop(), list.get(i).getBottom(), false);
                            list.remove(i);
                            list.add(i, ob1);
                        }
                    }
                    if (found != -1) {
                        GObject ob = new GObject(list.get(found).getMode(), list.get(found).getLeft(), list.get(found).getRight(), list.get(found).getTop(), list.get(found).getBottom(), true);
                        list.remove(found);
                        list.add(found, ob);

                        MainActivity.X = list.get(found).getX();
                        MainActivity.Y = list.get(found).getY();
                        MainActivity.WIDTH = list.get(found).getWidth();
                        MainActivity.HEIGHT = list.get(found).getHeight();
                        MainActivity.SELECTION = true;

                    }

                    selection1 = false;
                }
            }
        } else if (mode == 4) {
            if (!list.isEmpty()) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x_ = event.getX();
                        y_ = event.getY();
                        erase1 = true;
                        invalidate();
                }
                if (erase1) {
                    int found = -1;
                    for (int i = list.size() - 1; i >= 0; i--) {
                        GObject item = list.get(i);
                        if (item.getLeft() <= x_ && item.getRight() >= x_) {
                            if (item.getBottom() >= y_ && item.getTop() <= y_) {
                                found = i;
                                break;
                            }
                        }
                    }
                    if (found != -1) {
                        list.remove(found);
                    }
                    erase1 = false;
                }
            }
        }

        return true;
    }


}

