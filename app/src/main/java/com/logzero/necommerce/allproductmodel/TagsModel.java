package com.logzero.necommerce.allproductmodel;

import android.os.Parcel;
import android.os.Parcelable;

public class TagsModel implements Parcelable {
    protected TagsModel(Parcel in) {
        id = in.readInt();
        name = in.readString();
        slug = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(slug);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TagsModel> CREATOR = new Creator<TagsModel>() {
        @Override
        public TagsModel createFromParcel(Parcel in) {
            return new TagsModel(in);
        }

        @Override
        public TagsModel[] newArray(int size) {
            return new TagsModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public TagsModel(int id, String name, String slug) {
        this.id = id;
        this.name = name;
        this.slug = slug;
    }

    private int id;
    private String name;
    private String slug;
}
