package com.newtrekwang.fixviewlib.edite;

import android.support.annotation.ColorInt;
import android.view.View;

/**
 * Created by Newterk on 2018/4/23.
 */

public interface FixView {
    /**
     * 设置文字
     * @param str
     */
    void setFixText(CharSequence   str);

    /**
     * 获取文字
     * @return
     */
    CharSequence  getFixText();

    /**
     * 设置文字颜色
     * @param color
     */
    void setFixTextColor(@ColorInt int color);

    /**
     * 设置文字大小
     * @param size
     */
    void setFixTextSize(float size);

    /**
     * 获取自身View
     * @return
     */
    View getView();
}
