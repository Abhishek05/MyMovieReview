package com.example.apaul5.mymoviereview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.apaul5.mymoviereview.adapters.MovieArrayAdapter;
import com.example.apaul5.mymoviereview.models.Movie;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MyMovieReview extends AppCompatActivity {

    ArrayList<Movie> movies;

    MovieArrayAdapter movieArrayAdapter;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_movie_review);

        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";

        AsyncHttpClient client = new AsyncHttpClient();

        listView = (ListView) findViewById(R.id.lvMovie);
        movies = new ArrayList<Movie>();
        movieArrayAdapter = new MovieArrayAdapter(this,movies);
        listView.setAdapter(movieArrayAdapter);

        client.get(url , new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                JSONArray movieJsonResult = null;
                try {
                    movieJsonResult = response.getJSONArray("results");
                    movies.addAll(Movie.getMovieList(movieJsonResult));
                    movieArrayAdapter.notifyDataSetChanged();
                    Log.d("DEBUG", movies.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });
    }
}
