package com.drovox.osamah;

import android.util.Log;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.CacheControl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCaller {

    private static volatile ApiCaller uniqueInstance;

    public static ApiCaller getInstance() {
        if (uniqueInstance == null) {
            synchronized (ApiCaller.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new ApiCaller();
                }
            }
        }
        return uniqueInstance;
    }

    private static final String BASE_URL = "https://dummyjson.com/";
    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getHttpOkClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public Retrofit getRetrofit() {
        return retrofit;
    }

    private OkHttpClient getHttpOkClient() {
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        okhttp3.OkHttpClient.Builder client = new okhttp3.OkHttpClient.Builder();
        client.addInterceptor(logInterceptor);
        return client.build();
    }


}
