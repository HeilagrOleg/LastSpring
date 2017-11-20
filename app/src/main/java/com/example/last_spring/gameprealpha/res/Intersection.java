package com.example.last_spring.gameprealpha.res;

import android.widget.ImageButton;
import android.widget.ImageView;

public class Intersection {

    private String name;
    private ImageButton imageButton;
    private ImageView imageView;

    public Intersection(String name, ImageButton imageButton) {
        this.name = name;

        this.imageButton = imageButton;
    }

    public Intersection(String name, ImageButton imageButton, ImageView imageView) {
        this.name = name;
        this.imageButton = imageButton;
        this.imageView = imageView;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public String getName() {
        return name;
    }


    public ImageButton getImageButton() {
        return imageButton;
    }
}
