package com.example.tailoredtech.tecnovanza.model;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by Daniyal on 12/24/2016.
 */

public class News implements Serializable {


    private String description;
    private String name;
    private String city;
    private String time;
    private String comments;
    private String img;
    private String pimg;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }

    public static News initialiseFromJSON(JSONObject response) {
        Gson gson = new Gson();
        String json = response.toString();
        News news = gson.fromJson(json, News.class);
        return news;
    }
}
