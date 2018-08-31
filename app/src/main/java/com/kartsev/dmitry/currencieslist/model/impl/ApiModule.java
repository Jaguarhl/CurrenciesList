package com.kartsev.dmitry.currencieslist.model.impl;

import com.kartsev.dmitry.currencieslist.model.interfaces.ApiInterface;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiModule {

    private static final boolean ENABLE_AUTH = false;

    public ApiModule() {
    }

    public static ApiInterface getApiInterface() {

        OkHttpClient httpClient = new OkHttpClient();

//        httpClient.interceptors().add(new Interceptor() {
//            @Override
//            public Response intercept(Interceptor.Chain chain) throws IOException {
//                Request original = chain.request();
//                Request request = original.newBuilder()
//                        .header("Authorization", "Basic " + AUTH_64)
//                        .method(original.method(), original.body())
//                        .build();
//
//                return chain.proceed(request);
//            }
//        });


        Retrofit.Builder builder = new Retrofit.Builder().
                baseUrl("http://phisix-api3.appspot.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        if (ENABLE_AUTH) builder.client(httpClient);

        ApiInterface apiInterface = builder.build().create(ApiInterface.class);
        return apiInterface;
    }
}
