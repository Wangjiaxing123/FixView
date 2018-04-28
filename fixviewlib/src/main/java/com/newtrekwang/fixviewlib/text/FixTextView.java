package com.newtrekwang.fixviewlib.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.newtrekwang.fixviewlib.R;
import com.newtrekwang.fixviewlib.edite.FixView;
import com.newtrekwang.fixviewlib.edite.SimpleFixView;
import com.newtrekwang.fixviewlib.util.ConstantUtil;

/**
 * Created by Newterk on 2018/4/27.
 */

public class FixTextView extends LinearLayout {
    // 默认前缀
    private int fixType = ConstantUtil.TYPE_PRE;
    private FixView mFixView;
    private AppCompatTextView mTextView;

    private String  mFixString;
    private String mTvString;
    private int mFixTextColor = Color.BLACK;
    private int mTextViewColor = Color.BLACK;
    private int mContentGravity = Gravity.LEFT;
    private Context mContext;



    public FixTextView (Context context) {
        this(context,null);
    }

    public FixTextView (Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public FixTextView (Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        setOrientation(HORIZONTAL);

        TypedArray attributeSet = context.obtainStyledAttributes(attrs, R.styleable.FixTextView);
        mFixString = attributeSet.getString(R.styleable.FixTextView_fix_text);
        mTvString = attributeSet.getString(R.styleable.FixTextView_content_text);
        fixType = attributeSet.getInt(R.styleable.FixTextView_preOrPost,ConstantUtil.TYPE_PRE);
        mFixTextColor = attributeSet.getColor(R.styleable.FixTextView_fix_text_color,Color.BLACK);
        mTextViewColor = attributeSet.getColor(R.styleable.FixTextView_content_text_color,Color.BLACK);
        mContentGravity = attributeSet.getInt(R.styleable.FixTextView_right_content_gravity,Gravity.LEFT);
        attributeSet.recycle();

        mContext = context;
        mFixView = new SimpleFixView(context);
        mTextView = new AppCompatTextView(context);
        mTextView.setGravity(mContentGravity);

        if (fixType == ConstantUtil.TYPE_PRE){
            addView(mFixView.getView());
            addView(mTextView);
        }else {
            addView(mTextView);
            addView(mFixView.getView());
        }

        LinearLayout.LayoutParams  mFixViewLayoutParams = new LinearLayout.LayoutParams(mFixView.getView().getLayoutParams());
        mFixViewLayoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT;
        mFixViewLayoutParams.height = LinearLayout.LayoutParams.MATCH_PARENT;
        mFixViewLayoutParams.gravity = Gravity.CENTER_VERTICAL;
        mFixView.getView().setLayoutParams( mFixViewLayoutParams);

        LinearLayout.LayoutParams mEditTextLayoutParams = new LinearLayout.LayoutParams( mTextView.getLayoutParams());
        mEditTextLayoutParams.width = LayoutParams.WRAP_CONTENT;
        mEditTextLayoutParams.weight = 1;
        mEditTextLayoutParams.height = LayoutParams.MATCH_PARENT;
        mEditTextLayoutParams.gravity = Gravity.CENTER_VERTICAL;
        mTextView.setLayoutParams( mEditTextLayoutParams);
        setTvText(mTvString);
        setFixText(mFixString);
        setFixTextColor(mFixTextColor);
        setTvTextColor(mTextViewColor);
    }

    public void setRightContentGravity(int gravity){
            mTextView.setGravity(gravity);
    }
    public void setTvTextColor(int mTextViewColor) {
        mTextView.setTextColor(mTextViewColor);
    }

    public void setFixTextColor(int mFixTextColor) {
        mFixView.setFixTextColor(mFixTextColor);
    }

    public void setFixText(String mFixString) {
        mFixView.setFixText(mFixString);
    }

    public void setTvText(String mTvString) {
        mTextView.setText(mTvString);
    }

    public AppCompatTextView getRightTextView() {
        return mTextView;
    }

    public void setRightTextView(AppCompatTextView mTextView) {
        this.mTextView = mTextView;
    }


}
