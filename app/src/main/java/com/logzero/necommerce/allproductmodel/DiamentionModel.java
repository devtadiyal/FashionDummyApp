package com.logzero.necommerce.allproductmodel;

import android.os.Parcel;
import android.os.Parcelable;

public class DiamentionModel implements Parcelable {

    protected DiamentionModel(Parcel in) {
        length = in.readString();
        width = in.readString();
        height = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(length);
        dest.writeString(width);
        dest.writeString(height);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DiamentionModel> CREATOR = new Creator<DiamentionModel>() {
        @Override
        public DiamentionModel createFromParcel(Parcel in) {
            return new DiamentionModel(in);
        }

        @Override
        public DiamentionModel[] newArray(int size) {
            return new DiamentionModel[size];
        }
    };

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public DiamentionModel(String length, String width, String height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    private String length;
private String width;
private String height;

}
