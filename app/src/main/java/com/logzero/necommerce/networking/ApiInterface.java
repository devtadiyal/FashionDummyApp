package com.logzero.necommerce.networking;


import com.logzero.necommerce.allproductmodel.AllProduct;
import com.woocommerse.OAuth1.OauthConstants.OAuthConstants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;


public interface ApiInterface {

  /* // http://development-review.net/ecommerce/wp-json/wc/v3/products?
    // oauth_consumer_key=ck_48a6faf3ff255051a18ee235da4bddbaf31231f1&
    // oauth_signature_method=HMAC-SHA1&oauth_timestamp=1566796913&
    // oauth_nonce=UaqBVJ&
    // oauth_version=1.0&
    // oauth_signature=Efi9RQI2cVcev6YMwzQQg20uk38=&
    // filter[limit]=-1*/
    @GET("wc/v3/products?")
    //@Headers({"Content-type: application/json; charset=utf-8"})
    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    Call<List<AllProduct>> getAllProducts(@Query("oauth_consumer_key") String key,
                                          @Query("oauth_signature_method") String sig,
                                          @Query("oauth_timestamp") String timS,
                                          @Query("oauth_nonce") String nonc,
                                          @Query("oauth_version") String vers,
                                          @Query("oauth_signature") String signature
    );

}
