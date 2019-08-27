package com.logzero.necommerce.networking;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {

    public static final String BASE_URL = "http://development-review.net/ecommerce/wp-json/";
    public static String message = "OK";
    private static Retrofit retrofit;
    private static ApiClient mInstance = null;
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private static HttpLoggingInterceptor logging = new HttpLoggingInterceptor();


    public static Retrofit getClient() {
        message = "OK";
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(new MyInterceptor());
        httpClient.addNetworkInterceptor(chain -> {
            Request request = chain.request().newBuilder().build();
            Response response = chain.proceed(request);
            message = response.message();
            return response;
        });

        if (retrofit == null) {

            httpClient.readTimeout(45, TimeUnit.SECONDS)
                    .connectTimeout(45, TimeUnit.SECONDS);
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient.build())
                    .build();

        }

        return retrofit;
    }
    static class MyInterceptor implements Interceptor {
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            String stringurl = request.url().toString();
            stringurl = stringurl.replace("%25", "%");

            Request newRequest = new Request.Builder()
                    .url(stringurl)
                    .build();

            return chain.proceed(newRequest);
        }
    }
}