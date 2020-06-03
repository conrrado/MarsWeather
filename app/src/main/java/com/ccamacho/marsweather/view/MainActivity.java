package com.ccamacho.marsweather.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.ccamacho.marsweather.R;
import com.ccamacho.marsweather.databinding.ActivityMainBinding;
import com.ccamacho.marsweather.viewmodel.MarsWeatherViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ActivityMainBinding binding;
    private MarsWeatherViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MarsWeatherViewModel.class);

        viewModel.getLatestMarsWeather();
        receiveWeatherStatus();
        receivePhoto();
    }

    private void receiveWeatherStatus() {
        viewModel.weatherStatusMutableLiveData.observe(this, weatherStatus ->
                binding.setWeatherStatus(weatherStatus));
    }

    private void receivePhoto() {
        viewModel.photoUrlLiveData.observe(this, photo -> {
            binding.setPhoto(photo);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_refresh) {
            viewModel.getMarsPhoto();
        }
        return super.onOptionsItemSelected(item);
    }

}
