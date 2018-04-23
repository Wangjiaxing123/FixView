package com.newtrekwang.fixviewlib.edite;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;

/**
 * Created by Newterk on 2018/4/23.
 */

public class SimpleFixView extends AppCompatTextView implements FixView{

    private Context mContext;
    public SimpleFixView(Context context) {
        this(context,null);
    }

    public SimpleFixView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SimpleFixView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        mContext = context;
        setGravity(Gravity.CENTER);
    }

    @Override
    public void setFixText(CharSequence str) {
        super.setText(str);
    }

    @Override
    public CharSequence getFixText() {
        return super.getText();
    }

    @Override
    public void setFixTextColor(int color) {
        super.setTextColor(color);
    }

    @Override
    public void setFixTextSize(float size) {
        super.setTextSize(size);
    }

    @Override
    public View getView() {
        return this;
    }
}
