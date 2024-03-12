package com.iehr.rickandmortyapi;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Personaje {
    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("status")
    public String status;
    @SerializedName("species")
    public String species;
    @SerializedName("type")
    public String type;
    @SerializedName("gender")
    public String gender;
    @SerializedName("origin")
    public Origin origin;
    @SerializedName("location")
    public Location location;
    @SerializedName("image")
    public String image;
    @SerializedName("episode")
    public List<String> episodes;
    @SerializedName("url")
    public String url;
    @SerializedName("created")
    public String created;

    public static class Origin {
        @SerializedName("name")
        public String name;
        @SerializedName("url")
        public String url;
    }

    public static class Location {
        @SerializedName("name")
        public String name;
        @SerializedName("url")
        public String url;
    }
}

