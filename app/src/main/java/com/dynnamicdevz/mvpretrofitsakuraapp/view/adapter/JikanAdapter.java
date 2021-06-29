package com.dynnamicdevz.mvpretrofitsakuraapp.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dynnamicdevz.mvpretrofitdigimonapp.databinding.JikanListItemBinding;
import com.dynnamicdevz.mvpretrofitsakuraapp.model.data.JikanResult;
import java.util.ArrayList;
import java.util.List;
public class JikanAdapter extends RecyclerView.Adapter<JikanAdapter.JikanViewHolder> {

    public JikanAdapter() {
    }
    @NonNull
    @Override
    public JikanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        JikanListItemBinding binding = JikanListItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new JikanViewHolder(binding);
    }

    private List<JikanResult> results = new ArrayList<>();

    public void setResults(List<JikanResult> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull JikanAdapter.JikanViewHolder holder, int position) {

        JikanResult result = results.get(position);

        Glide.with(holder.itemView)
                .applyDefaultRequestOptions(RequestOptions.centerCropTransform())
                .load(result.getImageUrl())
                .into(holder.binding.posterImageview);

        holder.binding.synopsisTextview.setText(result.getSynopsis());
        holder.binding.titleTextview.setText(result.getTitle());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class JikanViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView synopsis;
        RelativeLayout parentLayout;

        JikanListItemBinding binding;

        public JikanViewHolder(JikanListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
