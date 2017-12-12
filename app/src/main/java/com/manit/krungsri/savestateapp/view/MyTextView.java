package com.manit.krungsri.savestateapp.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.manit.krungsri.savestateapp.view.state.SavedStateMyView;

/**
 * Created by MCNEWZ on 11-Dec-17.
 */

@SuppressLint("AppCompatCustomView")
public class MyTextView extends TextView {
    private int backgroundResourceId;

    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void setBackgroundResource(int resid) {
        super.setBackgroundResource(resid);
        backgroundResourceId = resid;

    }

    @Nullable
    @Override
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedStateMyView ss = new SavedStateMyView(superState);

        Bundle bundle = new Bundle();
        bundle.putInt("bgResource", backgroundResourceId);
        ss.setBundle(bundle);

        return ss;

    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        SavedStateMyView ss = (SavedStateMyView) state;
        super.onRestoreInstanceState(ss);
        Bundle bundle = ss.getBundle();
        this.setBackgroundResource(bundle.getInt("bgResource"));

    }
}
