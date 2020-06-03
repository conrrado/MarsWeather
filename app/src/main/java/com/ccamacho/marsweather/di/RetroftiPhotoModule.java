package com.ccamacho.marsweather.di;

import com.ccamacho.marsweather.retrofit.MarsPhotoAPI;

import dagger.Module;
import dagger.Provides;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetroftiPhotoModule {

    private String photoBaseURL = "http://mars-photos.herokuapp.com/api/v1/";

    @Provides
    public MarsPhotoAPI getRetrofitMarsPhotoConfig() {
        return new Retrofit.Builder()
                .baseUrl(photoBaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(MarsPhotoAPI.class);
    }
}
