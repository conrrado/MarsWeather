package com.ccamacho.marsweather.util;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ccamacho.marsweather.R;

public class ImageUtil {

    public static CircularProgressDrawable getProgressDrawable(Context context) {
        CircularProgressDrawable progressDrawable = new CircularProgressDrawable(context);
        progressDrawable.setStrokeWidth(10f);
        progressDrawable.setCenterRadius(50f);
        progressDrawable.start();
        return progressDrawable;
    }

    public static void setImageView(ImageView image, String url) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(getProgressDrawable(image.getContext()))
                .error(R.drawable.mars)
                .fitCenter();
        Glide.with(image.getContext())
                .setDefaultRequestOptions(requestOptions)
                .load(url)
                .into(image);
    }

    @BindingAdapter("image_url")
    public static void bindingImageSource(View view, String imageUrl) {
        setImageView((ImageView) view, imageUrl);
    }
}
