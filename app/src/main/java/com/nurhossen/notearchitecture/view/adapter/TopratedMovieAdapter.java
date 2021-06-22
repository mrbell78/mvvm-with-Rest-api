package com.nurhossen.notearchitecture.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nurhossen.notearchitecture.R;
import com.nurhossen.notearchitecture.service.model.Result;

import java.util.List;

public class TopratedMovieAdapter extends RecyclerView.Adapter<TopratedMovieAdapter.Customclass> {

    private Context context;
    private List<Result> movielist;

    public TopratedMovieAdapter(Context context, List<Result> movielist) {
        this.context = context;
        this.movielist = movielist;
    }

    @NonNull
    @Override
    public Customclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mview = LayoutInflater.from(context).inflate(R.layout.mainactivity_items,parent,false);
        return new Customclass(mview);
    }

    @Override
    public void onBindViewHolder(@NonNull Customclass holder, int position) {
        Glide.with(context).load("https://image.tmdb.org/t/p/w500/"+ movielist.get(position).getPosterPath()).into(holder.imgview);
        holder.title.setText(movielist.get(position).getTitle());
        holder.releasedate.setText(movielist.get(position).getReleaseDate().toString());
        holder.rating.setText(movielist.get(position).getVoteAverage().toString());
    }

    @Override
    public int getItemCount() {
        return movielist!=null?movielist.size():0;
    }

    public class Customclass extends RecyclerView.ViewHolder {

        ImageView imgview;
        TextView title, rating, releasedate;
        public Customclass(@NonNull View itemView) {
            super(itemView);
            imgview = itemView.findViewById(R.id.imageview_mainactiviyitems);
            title=itemView.findViewById(R.id.titlename);
            releasedate=itemView.findViewById(R.id.releaseid);
            rating=itemView.findViewById(R.id.rating);
        }
    }
}
