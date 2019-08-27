package com.logzero.necommerce.allproductmodel;

import android.util.Log;

import com.logzero.necommerce.mvp.BasePresenter;
import com.logzero.necommerce.networking.ApiClient;
import com.logzero.necommerce.networking.ApiInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllProductImp extends BasePresenter<AllProductsPresenter.View>
        implements AllProductsPresenter {

    public AllProductImp(View view) {
        mView = view;
    }


    @Override
    public void allproduct(String oauth_consumer_key,
                           String oauth_signature_method,
                           String oauth_timestamp, String oauth_nonce,
                           String oauth_version, String oauth_signature) {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<AllProduct>> userCall = apiInterface.getAllProducts(
                oauth_consumer_key,
                oauth_signature_method, oauth_timestamp,
                oauth_nonce, oauth_version,
                oauth_signature);
        userCall.enqueue(new Callback<List<AllProduct>>() {
            @Override
            public void onResponse(Call<List<AllProduct>> call, Response<List<AllProduct>> response) {
                if (response.isSuccessful()) {
                    mView.hideLoadingLayout();


                    List<AllProduct> allProduct = response.body();
                    Log.d("login successful ", response.message());
                    mView.getAllProducts(allProduct);
                    System.out.println("RESPONSE 1");

                }
                else
                {
                    mView.errorProducts(response.message());
                    System.out.println("RESPONSE 2");
                }
            }


            @Override
            public void onFailure(Call<List<AllProduct>> call, Throwable t) {
                System.out.println("RESPONSE 3"+ t.getMessage());

                if (mView != null) {
                    mView.hideLoadingLayout();
                    mView.showError("RESPONSE   " + t.getMessage());
                }
            }
        });
    }
}