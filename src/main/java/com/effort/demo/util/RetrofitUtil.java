package com.effort.demo.util;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

public class RetrofitUtil {

    public static OkHttpClient okHttpClient = null;

    public static <T> T createApiService(Class<T> service, String host) {
        if (okHttpClient == null) {
            okHttpClient = buildOkHttpClient();
        }

        return buildRetrofit(host).create(service);
    }

    private static OkHttpClient buildOkHttpClient() {

        return new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)
                .build();
    }

    private static Retrofit buildRetrofit(String host) {
        return new Retrofit.Builder()
                .baseUrl(host)
                .client(okHttpClient)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

}
