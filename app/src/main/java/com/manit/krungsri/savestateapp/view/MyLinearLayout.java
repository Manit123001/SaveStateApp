package com.manit.krungsri.savestateapp.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.manit.krungsri.savestateapp.view.state.SavedStateMyView;

/**
 * Created by MCNEWZ on 11-Dec-17.
 */

public class MyLinearLayout extends LinearLayout {
    private int backgroundResourceId;

    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Nullable
    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedStateMyView ss = new SavedStateMyView(superState);
        Bundle bundle = new Bundle();
        bundle.putInt("visible", this.getVisibility());
        ss.setBundle(bundle);

        return ss;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        SavedStateMyView ss = (SavedStateMyView) state;
        super.onRestoreInstanceState(ss.getSuperState());
        Bundle bundle = ss.getBundle();
        this.setVisibility(bundle.getInt("visible"));
    }

    @Override
    public void setBackgroundResource(int resid) {
        super.setBackgroundResource(resid);
        backgroundResourceId = resid;

    }

}
