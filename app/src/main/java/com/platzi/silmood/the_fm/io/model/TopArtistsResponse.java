package com.platzi.silmood.the_fm.io.model;

import com.google.gson.annotations.SerializedName;
import com.platzi.silmood.the_fm.domain.Artist;

import java.util.ArrayList;


public class TopArtistsResponse {

    @SerializedName(JsonKeys.ARTISTS_RESPONSE)
    private MainResponse mainResponse;

    public ArrayList<Artist> getArtists(){
        return  mainResponse.artists;
    }

    public void setArtists(ArrayList<Artist> artists) {
        mainResponse.artists = artists;
    }

    private class MainResponse {

        private ArrayList<Artist> artists;

    }
}
