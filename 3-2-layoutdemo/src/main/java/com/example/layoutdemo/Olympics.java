package com.example.layoutdemo;

public class Olympics {

    // store the resource ID of fruit image
    private int OlympicsImage;

    // store the string representing the Olympics name
    private String OlympicsSport;

    public Olympics(int OlympicsImage, String OlympicsSport) {
        this.OlympicsImage = OlympicsImage;
        this.OlympicsSport = OlympicsSport;
    }

    public int getOlympicsImage() {
        return OlympicsImage;
    }

    public String getOlympicsSport() {
        return OlympicsSport;
    }

}
