package com.teamwork.doubanapp_4a.bmm.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.teamwork.doubanapp_4a.R;

/**
 * Created by admin on 2017/4/23.
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private  int dividerSize;
    private int type;
    public static final int LEFT_SPACE = 0;
    public static final int TOP_SPACE = 1;
    public static final int TYPE_DIVIDER = 2;
    private int space;
    private Context context;
    private int color;
    private Paint mPaint = new Paint();

    public SpaceItemDecoration() {
    }

    public SpaceItemDecoration(int space, int type) {
        this.space = space;
        this.type = type;
    }


    public SpaceItemDecoration(Context context,int space, int dividerSize, int type, int color) {
        this.context = context;
        this.dividerSize = dividerSize;
        this.space = space;
        this.type = type;
        this.color = color;
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        if (type == TOP_SPACE) {
            outRect.top = space;
            return;
        }

        if (type == TYPE_DIVIDER) {
            if (parent.getChildLayoutPosition(view) != parent.getChildCount()-1) {
                    outRect.top = space;
                    outRect.bottom = space;
            }
            outRect.set(0, 0, 0, dividerSize);
            return;
        }

        if (parent.getChildLayoutPosition(view) != 0) {
            if (type == LEFT_SPACE) {
                outRect.left = space;
            }
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }


    @Override
    public void onDrawOver(Canvas c, RecyclerView parent) {
        if (type == TYPE_DIVIDER) {
            if (parent.getLayoutManager() instanceof LinearLayoutManager) {
                LinearLayoutManager layoutManager = (LinearLayoutManager) parent.getLayoutManager();
                if (layoutManager.getOrientation() == LinearLayoutManager.VERTICAL) {
                    final int left = parent.getPaddingLeft();
                    final int right = parent.getWidth() - parent.getPaddingRight();
                    final int childCount = parent.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        final View child = parent.getChildAt(i);
                        final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                                .getLayoutParams();
                        final int top = child.getBottom() + params.bottomMargin;
                        final int bottom = top + dividerSize;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            mPaint.setColor(context.getResources().getColor(color, null));
                        } else {
                            mPaint.setColor(context.getResources().getColor(color));
                        }
                        c.drawRect(left, top, right, bottom, mPaint);
                    }
                }
            }
        }
    }
}
