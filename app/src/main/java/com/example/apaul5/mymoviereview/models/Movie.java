package com.example.apaul5.mymoviereview.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by apaul5 on 5/20/16.
 */
public class Movie {
    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", this.posterPath);
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    String posterPath;
    String originalTitle;
    String overview;

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", this.backdropPath);
    }

    String backdropPath;

    public Movie(JSONObject jsonObject) throws JSONException{
        this.posterPath = jsonObject.getString("poster_path");
        this.originalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.backdropPath = jsonObject.getString("backdrop_path");
    }

    public static ArrayList<Movie> getMovieList(JSONArray array){
        ArrayList<Movie> results = new ArrayList<Movie>();
        try {
            if (array != null) {
                Log.d("DEBUG" , "getMovieList: jsonMovieArray.length =" + array.length());
                for (int i = 0; i < array.length(); i++) {
                    JSONObject jsonObj=array.getJSONObject(i);
                    //   Log.d(TAG, "getMovieList: jsonObj =" + jsonObj);
                    if(jsonObj!=null) {
                        //  Log.d(TAG, "getMovieList: jsonObj =" + jsonObj.toString());
                        Movie movieObj=new Movie(jsonObj);
                        //  Log.d(TAG, "getMovieList: movieObj =" + jsonObj);
                        results.add(movieObj);
                    }
                }
            }
            Log.d("DEBUG" , "getMovieList: movieArrayList.lenght =" + results.size());

        }catch (JSONException e){
            e.printStackTrace();
        }

        return results;
    }
}
