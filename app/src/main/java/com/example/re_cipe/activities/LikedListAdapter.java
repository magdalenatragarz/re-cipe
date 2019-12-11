package com.example.re_cipe.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.re_cipe.Card;
import com.example.re_cipe.R;

import java.util.List;

public class LikedListAdapter extends RecyclerView.Adapter<LikedListViewHolder> {
    private final RequestManager glide;
    private List<Card> cards;
    private Context context;

    public LikedListAdapter(RequestManager glide, List<Card> cards, Context context){
        this.glide = glide;
        this.cards = cards;
        this.context = context;
    }

    @NonNull
    @Override
    public LikedListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.liked_list_item, null, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutView.setLayoutParams(layoutParams);

        return new LikedListViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull LikedListViewHolder holder, int position) {
        holder.text.setText(cards.get(position).getText());
        glide.load(cards.get(position).getImage()).centerCrop().into(holder.image);

    }

    @Override
    public int getItemCount() {
        return cards.size();
    }
}
