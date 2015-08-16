package com.juanlabrador.recyclerviewwithheaderfooter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by juanlabrador on 16/08/15.
 */
public class LineRelativeLayout extends RelativeLayout {

    private final Paint mPaintLeft = new Paint(),
            mPaintRight = new Paint(),
            mPaintBackground = new Paint();
    private final Rect mRectLeft = new Rect(),
            mRectRight = new Rect(),
            mRectBackground = new Rect();
    private final float mDensity;

    public LineRelativeLayout(Context context) {
        this(context, null);
    }

    public LineRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LineRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setWillNotDraw(false);
        mDensity = context.getResources().getDisplayMetrics().density;
        mPaintLeft.setColor(Color.TRANSPARENT);
        mPaintRight.setColor(Color.TRANSPARENT);
        mPaintBackground.setColor(Color.TRANSPARENT);
    }

    public void drawLabel(int left, int right, int background) {
        mPaintBackground.setColor(background);
        mPaintLeft.setColor(left);
        mPaintRight.setColor(right);
        invalidate();
    }

    public void drawLeft(int color) {
        drawLabel(color, mPaintRight.getColor(), mPaintBackground.getColor());
    }

    public void drawRight(int color) {
        drawLabel(mPaintLeft.getColor(), color, mPaintBackground.getColor());
    }

    public void drawBackground(int color) {
        drawLabel(mPaintLeft.getColor(), mPaintRight.getColor(), color);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawRect(mRectBackground, mPaintBackground);
        canvas.drawRect(mRectLeft, mPaintLeft);
        canvas.drawRect(mRectRight, mPaintRight);
        super.onDraw(canvas);
    }

    @Override
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        mRectBackground.set(0, 0, w, h);
        mRectLeft.set(0, 0, (int)(4 * mDensity), h);
        mRectRight.set(w - (int)(4 * mDensity), 0, w, h);
        super.onSizeChanged(w, h, oldw, oldh);
    }
}