package com.platzi.silmood.the_fm.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.platzi.silmood.the_fm.BuildConfig;
import com.platzi.silmood.the_fm.domain.Artist;
import com.platzi.silmood.the_fm.io.deserializer.ArtistInfoResponseDeserializer;
import com.platzi.silmood.the_fm.io.deserializer.HypedArtistsResponseDeserializer;
import com.platzi.silmood.the_fm.io.deserializer.TopArtistDeserializer;
import com.platzi.silmood.the_fm.io.model.HypedArtistResponse;
import com.platzi.silmood.the_fm.io.model.TopArtistsResponse;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import rx.Observable;


public class LastFmApiAdapter {

    private static LastFmApiService API_SERVICE;

    public static LastFmApiService getApiService () {

        if(API_SERVICE == null){
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(ApiConstants.BASE_URL)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .setConverter(buildLastFmApiGsonConverter())
                    .build();

            API_SERVICE = adapter.create(LastFmApiService.class);
        }

        return API_SERVICE;

    }

    private static GsonConverter buildLastFmApiGsonConverter() {
        Gson gsonConf = new GsonBuilder()
                .registerTypeAdapter(HypedArtistResponse.class, new HypedArtistsResponseDeserializer())
                .registerTypeAdapter(TopArtistsResponse.class, new TopArtistDeserializer())
                .create();

        return new GsonConverter(gsonConf);
    }

    public static Observable<HypedArtistResponse> getHypedArtist(){
        return getApiService().getHypedArtists(obtainApiKey());
    }

    public static Observable<TopArtistsResponse> getTopArtist(){
        return getApiService().getTopArtists(obtainApiKey());
    }

    private static String obtainApiKey (){
        return BuildConfig.LAST_FM_API_KEY;
    }

}
