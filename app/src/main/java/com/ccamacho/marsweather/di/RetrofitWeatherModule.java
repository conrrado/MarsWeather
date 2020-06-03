package com.ccamacho.marsweather.di;

import com.ccamacho.marsweather.retrofit.MarsAPI;

import dagger.Module;
import dagger.Provides;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitWeatherModule {

    private String weatherBaseURL = "https://api.mars.spacexcompanion.app/v1/";
    private String photoBaseURL = "http://mars-photos.herokuapp.com/api/v1/";

    @Provides
    public MarsAPI getRetrofitMarsConfig() {
        return new Retrofit.Builder()
                .baseUrl(weatherBaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(MarsAPI.class);
    }
}
