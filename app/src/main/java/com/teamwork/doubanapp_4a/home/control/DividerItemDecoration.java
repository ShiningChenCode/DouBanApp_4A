package com.teamwork.doubanapp_4a.home.control;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by XiaGF on 2017/4/23.
 */

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS=new int[]{
            android.R.attr.listDivider
    };

    private Drawable mDivider;

    private int dividHeight;

    public DividerItemDecoration(Context context,int dividHeight) {
        final TypedArray a=context.obtainStyledAttributes(ATTRS);
        mDivider=a.getDrawable(0);
        this.dividHeight=dividHeight;
        a.recycle();

    }

    public void drawVertical(Canvas c, RecyclerView parent){
        final int left=parent.getPaddingLeft();
        final int right=parent.getWidth()-parent.getPaddingRight();

        final int childCount=parent.getChildCount();
        for(int i=0;i<childCount;i++){
            final View child=parent.getChildAt(i);
            RecyclerView v=new RecyclerView(parent.getContext());
            final RecyclerView.LayoutParams params=(RecyclerView.LayoutParams)child.getLayoutParams();
            final int top=child.getBottom()+params.bottomMargin;
            final int bottom=top+mDivider.getIntrinsicHeight();
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(c);
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        drawVertical(c,parent);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0, 0, 0, dividHeight);

    }
}
