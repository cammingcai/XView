package com.gz.cammingview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 *
 * 自定义拖动的view
 * */
@SuppressLint("AppCompatCustomView")
public class CammingView extends ImageView {


    //view 的宽
    private int width;
    //view的高
    private int height;
    //屏幕的宽高
    private int screenWidth;
    private int screenHeight;
    //是否可以拖动
    private boolean isDrag;

    //开始拖动的xy坐标
    private float startX;
    private float startY;
    //结束拖动的偏移xy坐标
    private float offsetX;
    private float offsetY;
    private Context context;

    public CammingView(Context context) {
        super(context);
        this.context=context;
        Log.i("CammingView","CammingView1111111111");
    }

    public CammingView(Context context,AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        Log.i("CammingView","CammingView2222222222");
    }

    //当前是否在拖动
    public boolean isDrag() {
        return isDrag;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.i("CammingView","onMeasure");
        init();
    }

    private void init() {
        width = this.getMeasuredWidth();
        height = this.getMeasuredHeight();
        screenWidth = ScreenUtils.getScreenWidth(context);
        screenHeight = ScreenUtils.getScreenHeight(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i("CammingView","ACTION_DOWN");
                isDrag = false;
                startX = event.getX();
                startY = event.getY();

                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("CammingView","ACTION_MOVE");
                offsetX = event.getX() - startX;
                offsetY = event.getY() - startY;

                //绝对值
                float disanceX = Math.abs(offsetX);
                float disanceY = Math.abs(offsetY);
                if(disanceX>10||disanceY>10){
                    isDrag = true;
                    int l =(int)(getLeft()+offsetX) ;
                    int r = l+width;
                    int t = (int)(getTop()+offsetY);
                    int d = t +height;
                    if(l<0){
                        l=0;
                        r=l+width;
                    }else if(r>screenWidth){
                        r=screenWidth;
                        l=r-width;
                    }
                    if(t<0){
                        t=0;
                        d=t+height;
                    }else if(d>screenHeight){
                        d=screenHeight;
                        t=d-height;
                    }
                    this.layout(l,t,r,d);
                }

                break;
            case MotionEvent.ACTION_UP:
                isDrag = false;
                Log.i("CammingView","ACTION_UP");
                setPressed(false);
                break;
            case MotionEvent.ACTION_CANCEL:
                isDrag = false;
                Log.i("CammingView","ACTION_CANCEL");
                setPressed(false);
                break;

        }
        return true;

    }
}
