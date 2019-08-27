package com.logzero.necommerce.allproductmodel;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class LinkModel implements Parcelable {

    protected LinkModel(Parcel in) {
        self = in.createTypedArrayList(SelfModel.CREATOR);
        collection = in.createTypedArrayList(CollectionModel.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(self);
        dest.writeTypedList(collection);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LinkModel> CREATOR = new Creator<LinkModel>() {
        @Override
        public LinkModel createFromParcel(Parcel in) {
            return new LinkModel(in);
        }

        @Override
        public LinkModel[] newArray(int size) {
            return new LinkModel[size];
        }
    };

    public ArrayList<SelfModel> getSelf() {
        return self;
    }

    public void setSelf(ArrayList<SelfModel> self) {
        this.self = self;
    }

    public ArrayList<CollectionModel> getCollection() {
        return collection;
    }

    public void setCollection(ArrayList<CollectionModel> collection) {
        this.collection = collection;
    }

    public LinkModel(ArrayList<SelfModel> self, ArrayList<CollectionModel> collection) {
        this.self = self;
        this.collection = collection;
    }

    private ArrayList<SelfModel> self;
    private ArrayList<CollectionModel> collection;
}
