package com.example.re_cipe.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.re_cipe.Card;
import com.example.re_cipe.R;

import java.util.ArrayList;
import java.util.List;

public class LikedListActivity extends AppCompatActivity {
    private ArrayList<Card> cards = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liked_list);
        initRecyclerView();

    }


    private void initRecyclerView(){
        initCards();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LikedListAdapter adapter = new LikedListAdapter(Glide.with(this), cards, LikedListActivity.this);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initCards(){
        Card card = new Card("Pizza","https://www.monsieur-cuisine.com/fileadmin/_processed_/5/0/csm_23148_Rezeptfoto_01_21d2e4280f.jpg");
        Card card1 = new Card("Lody","https://www.mojewypieki.com/img/images/original/Lody_z_czerwonej_pomara%C5%84czy_2022.jpg");
        cards.add(card1);
        cards.add(card);
        cards.add(card1);
        cards.add(card);
        cards.add(card1);
        cards.add(card);
        cards.add(card1);
        cards.add(card);
        cards.add(card1);
        cards.add(card);
        cards.add(card1);
        cards.add(card);
        cards.add(card1);
        cards.add(card);
        cards.add(card1);
        cards.add(card);
    }
}