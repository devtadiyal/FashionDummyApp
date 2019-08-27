package com.logzero.necommerce.allproductmodel;

import android.os.Parcel;
import android.os.Parcelable;

public class CategoryModel implements Parcelable {

    protected CategoryModel(Parcel in) {
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

    public static final Creator<CategoryModel> CREATOR = new Creator<CategoryModel>() {
        @Override
        public CategoryModel createFromParcel(Parcel in) {
            return new CategoryModel(in);
        }

        @Override
        public CategoryModel[] newArray(int size) {
            return new CategoryModel[size];
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

    public CategoryModel(int id, String name, String slug) {
        this.id = id;
        this.name = name;
        this.slug = slug;
    }

    private int id;
    private String name;
    private String slug;


}
