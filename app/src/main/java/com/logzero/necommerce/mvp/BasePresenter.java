package com.logzero.necommerce.mvp;

/**
 * Created by day on 14/8/17.
 */

public class BasePresenter<ViewT> implements IBasePresenter<ViewT> {

    public ViewT mView;

    @Override
    public void onViewActive(ViewT view) {
        this.mView = view;
    }

    @Override
    public void onViewInactive() {
        mView = null;
    }
}
