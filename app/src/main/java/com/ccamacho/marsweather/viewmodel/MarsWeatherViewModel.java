package com.ccamacho.marsweather.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ccamacho.marsweather.di.DaggerRetrofitComponent;
import com.ccamacho.marsweather.model.MarsPhoto;
import com.ccamacho.marsweather.model.WeatherStatus;
import com.ccamacho.marsweather.retrofit.MarsAPI;
import com.ccamacho.marsweather.retrofit.MarsPhotoAPI;

import java.util.Random;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MarsWeatherViewModel extends ViewModel {

    private static final String TAG = MarsWeatherViewModel.class.getSimpleName();

    @Inject
    MarsAPI marsAPI;

    @Inject
    MarsPhotoAPI marsPhotoAPI;

    public MutableLiveData<WeatherStatus> weatherStatusMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<MarsPhoto.Photo> photoUrlLiveData = new MutableLiveData<>();

    public MarsWeatherViewModel() {
        DaggerRetrofitComponent.create().inject(this);
    }

    public void getLatestMarsWeather() {
        marsAPI.getLatest()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(weatherStatus -> {
                    weatherStatus.setSeason(weatherStatus.getSeason().toUpperCase());
                    return weatherStatus;
                })
                .subscribe(weatherStatus -> weatherStatusMutableLiveData.setValue(weatherStatus));
    }

    public void getMarsPhoto() {
        String date, camera;
        date = "2020-5-29";
        camera = "fhaz";
        marsPhotoAPI.getMarsPhotos(date/*, camera*/)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(marsPhoto -> {
                    Random random = new Random();
                    int randomNumber = random.nextInt(marsPhoto.getPhotos().size());
                    MarsPhoto.Photo photo = marsPhoto.getPhotos().get(randomNumber);
                    Log.d(TAG, photo.getSource());
                    photoUrlLiveData.setValue(photo);
                });
    }



    /*
    new Observer<WeatherStatus>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull WeatherStatus weatherStatus) {
                        Log.d(TAG, weatherStatus.getSeason());
                        weatherStatusMutableLiveData.setValue(weatherStatus);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d(TAG, Objects.requireNonNull(e.getMessage()));
                    }

                    @Override
                    public void onComplete() {

                    }
                }
     */
}
