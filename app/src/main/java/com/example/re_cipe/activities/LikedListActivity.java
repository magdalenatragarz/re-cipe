package com.example.re_cipe.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.re_cipe.Card;
import com.example.re_cipe.R;
import com.example.re_cipe.RecipesDB;

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
        RecipesDB db = new RecipesDB(this);
        Cursor c = db.getAllRecipes();

        System.out.println("LIKED ACTIVITY");

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            Card card = new Card( c.getString( c.getColumnIndex("name")), c.getString( c.getColumnIndex("image_url")), c.getString( c.getColumnIndex("content_url")), c.getString( c.getColumnIndex("description")));
            cards.add(card);
            System.out.println(c.getString( c.getColumnIndex("name")));
        }
    }

    private List<Card> getLiked() {
        return cards;
    }
}