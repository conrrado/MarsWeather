package com.ccamacho.marsweather.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MarsPhoto {

    private List<Photo> photos;

    public MarsPhoto() {}

    public MarsPhoto(List<Photo> photos) {
        this.photos = photos;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public class Photo {

        private int id;

        @SerializedName("img_src")
        private String source;

        public Photo(int id, String source) {
            this.id = id;
            this.source = source;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }
    }

}
