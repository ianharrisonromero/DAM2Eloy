package com.example.recyclerviewsactivity;

public class GalleryGameModel {
    private int gameId;
    private int gamePhoto; // Assuming this is an image resource ID
    private String gameUserCreator;
    private String dateTime;

    public GalleryGameModel(int gameId, int gamePhoto, String gameUserCreator, String dateTime) {
        this.gameId = gameId;
        this.gamePhoto = gamePhoto;
        this.gameUserCreator = gameUserCreator;
        this.dateTime = dateTime;
    }

    // Getters and setters
    // Getter method for gamePhoto
    public int getGamePhoto() {
        return gamePhoto;
    }

    public String getGameUserCreator() {
        return gameUserCreator;
    }
}
