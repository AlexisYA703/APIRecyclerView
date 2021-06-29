package com.dynnamicdevz.mvpretrofitsakuraapp.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dynnamicdevz.mvpretrofitdigimonapp.databinding.MovieListItemBinding;
import com.dynnamicdevz.mvpretrofitsakuraapp.model.data.MovieResult;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    public MovieAdapter() {
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieListItemBinding binding = MovieListItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new MovieViewHolder(binding);
    }

    private List<MovieResult> results = new ArrayList<>();

    public void setResults(List<MovieResult> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {

        MovieResult result = results.get(position);

        Glide.with(holder.itemView)
                .applyDefaultRequestOptions(RequestOptions.centerCropTransform())
                .load(result.getPosterPath())
                .into(holder.binding.posterImageview);

        holder.binding.synopsisTextview.setText(result.getOverview());
        holder.binding.titleTextview.setText(result.getTitle());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        MovieListItemBinding binding;

        public MovieViewHolder(MovieListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
