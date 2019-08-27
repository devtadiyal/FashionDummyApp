package com.logzero.necommerce.allproductmodel;

import android.os.Parcel;
import android.os.Parcelable;

public class SelfModel implements Parcelable {

    protected SelfModel(Parcel in) {
        href = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(href);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<SelfModel> CREATOR = new Creator<SelfModel>() {
        @Override
        public SelfModel createFromParcel(Parcel in) {
            return new SelfModel(in);
        }

        @Override
        public SelfModel[] newArray(int size) {
            return new SelfModel[size];
        }
    };

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public SelfModel(String href) {
        this.href = href;
    }

    private String href;
}
