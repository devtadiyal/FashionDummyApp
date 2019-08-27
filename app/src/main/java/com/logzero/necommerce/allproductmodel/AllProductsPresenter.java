package com.logzero.necommerce.allproductmodel;

import com.logzero.necommerce.mvp.MainView;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.Header;

public interface AllProductsPresenter {

    interface View<ViewT> extends MainView<ViewT> {

        void getAllProducts(List<AllProduct> response);
        void errorProducts(String error);

    }

    void allproduct(String oauth_consumer_key,
                    String oauth_signature_method,String oauth_timestamp,
                    String oauth_nonce,String oauth_version,
                    String oauth_signature);
}
