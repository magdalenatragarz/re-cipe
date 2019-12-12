package com.example.re_cipe.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.re_cipe.LikedActivity;
import com.example.re_cipe.R;

public class LikedListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView text;
    public ImageView image;
    public LikedListViewHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);

        text = (TextView) itemView.findViewById(R.id.liked_list_text);
        image = (ImageView) itemView.findViewById(R.id.liked_list_image);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(itemView.getContext(), LikedActivity.class);
        Bundle b = new Bundle();
        b.putString("liked_list_text", text.getText().toString());
        intent.putExtras(b);
        view.getContext().startActivity(intent);
    }

}
