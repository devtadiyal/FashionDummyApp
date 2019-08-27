package com.logzero.necommerce.mvp;

/**
 * Created by day on 14/8/17.
 */

public interface IBasePresenter<ViewT> {

    void onViewActive(ViewT view);

    void onViewInactive();
}
