package com.logzero.necommerce.allproductmodel;

import android.os.Parcel;
import android.os.Parcelable;

public class MetaDataModel implements Parcelable {

    protected MetaDataModel(Parcel in) {
        id = in.readInt();
        key = in.readString();
        value = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(key);
        dest.writeString(value);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MetaDataModel> CREATOR = new Creator<MetaDataModel>() {
        @Override
        public MetaDataModel createFromParcel(Parcel in) {
            return new MetaDataModel(in);
        }

        @Override
        public MetaDataModel[] newArray(int size) {
            return new MetaDataModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public MetaDataModel(int id, String key, String value) {
        this.id = id;
        this.key = key;
        this.value = value;
    }

    private int id;
    private String key;
    private String value;


}
