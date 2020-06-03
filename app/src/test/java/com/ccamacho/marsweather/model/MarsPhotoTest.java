package com.ccamacho.marsweather.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MarsPhotoTest {

    MarsPhoto marsPhoto;
    List<MarsPhoto.Photo> photoList;

    @Before
    public void setup() {
        marsPhoto = new MarsPhoto();
        photoList = new ArrayList<>();
    }

    @Test
    public void getPhotos() {
        marsPhoto.setPhotos(photoList);
        Assert.assertNotNull(marsPhoto.getPhotos());
    }

    @Test
    public void setPhotos() {
        marsPhoto.setPhotos(photoList);
        Assert.assertEquals(marsPhoto.getPhotos(), photoList);
    }
}