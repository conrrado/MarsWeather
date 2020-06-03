package com.ccamacho.marsweather.retrofit;

import com.ccamacho.marsweather.model.MarsPhoto;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarsPhotoAPI {

    @GET("rovers/curiosity/photos")
    Observable<MarsPhoto> getMarsPhotos(@Query("earth_date") String earthDate/*, @Query("camera") String camera*/);
}
