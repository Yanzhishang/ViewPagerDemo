package com.yzs.viewpagerdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

public class CustomSlidingViewpager extends ViewPager {

    /**
     * 上一次x坐标
     */
    private float beforeX;
    private boolean isCanLeftScroll = true;
    private boolean isCanScrollAll = true;


    public CustomSlidingViewpager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomSlidingViewpager(Context context) {
        super(context);
    }


    //    ----------禁止左右滑动------------------
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (isCanScrollAll) {
            return super.onTouchEvent(ev);
        } else {
            return false;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (isCanScrollAll) {
            return super.onInterceptTouchEvent(arg0);
        } else {
            return false;
        }

    }

//-------------------------------------------


    //-----禁止左滑-------左滑：上一次坐标 > 当前坐标
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (isCanLeftScroll) {
            return super.dispatchTouchEvent(ev);
        } else {
            switch (ev.getAction()) {
                case MotionEvent.ACTION_DOWN://按下如果‘仅’作为‘上次坐标’，不妥，因为可能存在左滑，motionValue大于0的情况（来回滑，只要停止坐标在按下坐标的右边，左滑仍然能滑过去）
                    beforeX = ev.getX();
                    break;
                case MotionEvent.ACTION_MOVE:
                    float motionValue = ev.getX() - beforeX;
                    if (motionValue < 0) {//禁止左滑
                        return true;
                    }
                    beforeX = ev.getX();//手指移动时，再把当前的坐标作为下一次的‘上次坐标’，解决上述问题

                    break;
                default:
                    break;
            }
            return super.dispatchTouchEvent(ev);
        }

    }


    public void setScrollble(boolean isCanScroll) {
        this.isCanLeftScroll = isCanScroll;
    }

    public void setScrollbleAll(boolean isCanScrollAll) {
        this.isCanScrollAll = isCanScrollAll;
    }
}