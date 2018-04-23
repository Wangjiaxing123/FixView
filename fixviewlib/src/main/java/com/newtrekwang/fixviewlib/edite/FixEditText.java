package com.newtrekwang.fixviewlib.edite;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.newtrekwang.fixviewlib.R;
import com.newtrekwang.fixviewlib.util.ConstantUtil;

/**
 * Created by Newterk on 2018/4/23.
 * 带前缀或后缀的EditText
 */

public class FixEditText extends LinearLayout {

    // 默认前缀
    private int fixType = ConstantUtil.TYPE_PRE;
    private FixView mFixView;
    private AppCompatEditText mEditText;

    private String  mFixString;
    private String mEtString;
    private String mHintString;
    private int mFixTextColor = Color.BLACK;
    private int mEditTextColor = Color.BLACK;


    private Context mContext;

    public FixEditText(Context context) {
        this(context,null);
    }

    public FixEditText(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public FixEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        setOrientation(HORIZONTAL);

        TypedArray attributeSet = context.obtainStyledAttributes(attrs, R.styleable.FixEditText);
        mFixString = attributeSet.getString(R.styleable.FixEditText_fix_text);
        mEtString = attributeSet.getString(R.styleable.FixEditText_content_text);
        mHintString = attributeSet.getString(R.styleable.FixEditText_hint_text);
        fixType = attributeSet.getInt(R.styleable.FixEditText_preOrPost,ConstantUtil.TYPE_PRE);
        mFixTextColor = attributeSet.getColor(R.styleable.FixEditText_fix_text_color,Color.BLACK);
        mEditTextColor = attributeSet.getColor(R.styleable.FixEditText_content_text_color,Color.BLACK);
        attributeSet.recycle();

        mContext = context;
        mFixView = new SimpleFixView(context);
        mEditText = new AppCompatEditText(context);

        if (fixType == ConstantUtil.TYPE_PRE){
            addView(mFixView.getView());
            addView(mEditText);
        }else {
            addView(mEditText);
            addView(mFixView.getView());
        }

        LinearLayout.LayoutParams  mFixViewLayoutParams = new LinearLayout.LayoutParams(mFixView.getView().getLayoutParams());
        mFixViewLayoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT;
        mFixViewLayoutParams.height = LinearLayout.LayoutParams.MATCH_PARENT;
        mFixViewLayoutParams.gravity = Gravity.CENTER_VERTICAL;
        mFixView.getView().setLayoutParams( mFixViewLayoutParams);

        LinearLayout.LayoutParams mEditTextLayoutParams = new LinearLayout.LayoutParams( mEditText.getLayoutParams());
        mEditTextLayoutParams.width = LayoutParams.WRAP_CONTENT;
        mEditTextLayoutParams.weight = 1;
        mEditTextLayoutParams.height = LayoutParams.MATCH_PARENT;
        mEditTextLayoutParams.gravity = Gravity.CENTER_VERTICAL;
        mEditText.setLayoutParams( mEditTextLayoutParams);
        setEditText(mEtString);
        setFixText(mFixString);
        setHintString(mHintString);
        setFixTextColor(mFixTextColor);
        setEditTextColor(mEditTextColor);
    }

    public void setFixText(String str){
        mFixView.setFixText(str);
    }

    public void setEditText(String str){
        mEditText.setText(str);
    }

    public void setHintString(String hintString){
        mEditText.setHint(hintString);
    }

    public void setFixTextColor(int color){
        mFixView.setFixTextColor(color);
    }

    public void setEditTextColor(int color){
        mEditText.setTextColor(color);
    }

    public String getEditTextString(){
        return mEditText.getText().toString();
    }

    public FixView getFixView() {
        return mFixView;
    }

    public void setFixView(FixView mFixView) {
        this.mFixView = mFixView;
    }

    public AppCompatEditText getEditText() {
        return mEditText;
    }

    public void setEditText(AppCompatEditText mEditText) {
        this.mEditText = mEditText;
    }
}
