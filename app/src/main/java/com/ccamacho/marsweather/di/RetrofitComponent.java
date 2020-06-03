package com.ccamacho.marsweather.di;

import com.ccamacho.marsweather.viewmodel.MarsWeatherViewModel;

import dagger.Component;

@Component(modules = {RetroftiPhotoModule.class, RetrofitWeatherModule.class})
public interface RetrofitComponent {

    void inject(MarsWeatherViewModel viewModel);
}
