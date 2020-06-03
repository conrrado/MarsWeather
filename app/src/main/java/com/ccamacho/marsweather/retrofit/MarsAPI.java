package com.ccamacho.marsweather.retrofit;

import com.ccamacho.marsweather.model.WeatherStatus;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface MarsAPI {

    @GET("weather/latest")
    Observable<WeatherStatus> getLatest();
}
