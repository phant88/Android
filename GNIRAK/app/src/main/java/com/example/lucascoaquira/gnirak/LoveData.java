package com.example.lucascoaquira.gnirak;

import java.util.ArrayList;

/**
 * Created by Lucas Coaquira on 06/04/2015.
 */
public class LoveData {
    private String title;
    private String description;
    private Integer imageID;

    public LoveData(String title, String description, Integer imageID) {
        this.title = title;
        this.description = description;
        this.imageID = imageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }
}
