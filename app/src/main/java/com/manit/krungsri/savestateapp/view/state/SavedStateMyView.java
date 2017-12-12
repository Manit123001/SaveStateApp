package com.manit.krungsri.savestateapp.view.state;


import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/**
 * Created by MCNEWZ on 11-Dec-17.
 */

public class SavedStateMyView extends View.BaseSavedState {

    private Bundle bundle = new Bundle();

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public SavedStateMyView(Parcel source) {
        super(source);
        bundle = source.readBundle();
    }

    public SavedStateMyView(Parcelable superState) {
        super(superState);
    }


    @Override
    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeBundle(bundle);
    }

    public static final Creator CREATOR = new Creator() {
        @Override
        public Object createFromParcel(Parcel source) {
            return new SavedStateMyView(source);
        }

        @Override
        public Object[] newArray(int size) {
            return new SavedStateMyView[size];
        }
    };

}
