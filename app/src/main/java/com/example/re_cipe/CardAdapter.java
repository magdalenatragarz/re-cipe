package com.example.re_cipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CardAdapter extends ArrayAdapter<Card>{

    Context context;

    public CardAdapter(Context context, int resourceId, List<Card> cards){
        super(context, resourceId, cards);
    }

    public View getView(int position, View convertedView, ViewGroup parent){
        Card card = getItem(position);
        if(convertedView == null) {
            convertedView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item, parent, false);
        }

        TextView text = (TextView) convertedView.findViewById(R.id.text);
        ImageView image = (ImageView) convertedView.findViewById(R.id.image);

        text.setText(card.getText());
        Glide.with(getContext()).load(card.getImage()).centerCrop().into(image);
        return convertedView;
    }

}
