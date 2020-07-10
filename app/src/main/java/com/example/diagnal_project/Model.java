package com.example.diagnal_project;

public class Model {
    String name;
     int Image;

    public Model(String title, int image) {
        name = title;
        Image = image;
    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String title) {
        name = title;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
