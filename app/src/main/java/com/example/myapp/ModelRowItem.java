package com.example.myapp;

public class ModelRowItem {

    private int imageId;
    private String title;
    private int desc;

    public ModelRowItem(int imageId, String title, int desc) {
        this.imageId = imageId;
        this.title = title;
        this.desc = desc;
    }

    public int getImage() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDesc() {
        return desc;
    }

    public void setDesc(int desc) {
        this.desc = desc;
    }
}
