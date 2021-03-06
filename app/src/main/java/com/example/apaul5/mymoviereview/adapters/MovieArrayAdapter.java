package com.example.apaul5.mymoviereview.adapters;


import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apaul5.mymoviereview.R;
import com.example.apaul5.mymoviereview.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by apaul5 on 5/21/16.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    private static class ViewHolder {
        ImageView ivView;
        TextView txTitle;
        TextView txDesc;
    }


    public MovieArrayAdapter(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = getItem(position);
        /*if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);

        }


        ImageView imageView = (ImageView)convertView.findViewById(R.id.ivMovie);
        imageView.setImageResource(0);

        TextView txTitle = (TextView)convertView.findViewById(R.id.txTitle);
        TextView txDesc = (TextView)convertView.findViewById(R.id.txDesc);

        txTitle.setText(movie.getOriginalTitle());
        txDesc.setText(movie.getOverview());

        int orientation = getContext().getResources().getConfiguration().orientation;
        if(orientation== Configuration.ORIENTATION_LANDSCAPE){
            Picasso.with(getContext()).load(movie.getBackdropPath()).into(imageView);
            Log.d("DEBUG", "Configuration.ORIENTATION_LANDSCAPE"+ Configuration.ORIENTATION_LANDSCAPE);
        }else{
            Picasso.with(getContext()).load(movie.getPosterPath()).into(imageView);
            Log.d("DEBUG", "Configuration.ORIENTATION_PORTRAIT"+ Configuration.ORIENTATION_PORTRAIT);
        }*/


        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);

            viewHolder.txTitle = (TextView)convertView.findViewById(R.id.txTitle);
            viewHolder.txDesc = (TextView)convertView.findViewById(R.id.txDesc);

            viewHolder.ivView = (ImageView)convertView.findViewById(R.id.ivMovie);
            viewHolder.ivView .setImageResource(0);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data into the template view using the data object
        viewHolder.txTitle.setText(movie.getOriginalTitle());
        viewHolder.txDesc.setText(movie.getOverview());

        int orientation = getContext().getResources().getConfiguration().orientation;
        if(orientation== Configuration.ORIENTATION_LANDSCAPE){
            Picasso.with(getContext()).load(movie.getBackdropPath()).into(viewHolder.ivView);
            Log.d("DEBUG", "Configuration.ORIENTATION_LANDSCAPE"+ Configuration.ORIENTATION_LANDSCAPE);
        }else{
            Picasso.with(getContext()).load(movie.getPosterPath()).into(viewHolder.ivView);
            Log.d("DEBUG", "Configuration.ORIENTATION_PORTRAIT"+ Configuration.ORIENTATION_PORTRAIT);
        }


        return convertView;
    }
}
