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
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Card> cards = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liked_list);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(LikedListActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new LikedListAdapter(Glide.with(this), getLiked(), LikedListActivity.this);
        recyclerView.setAdapter(adapter);

        RecipesDB db = new RecipesDB(this);
        Cursor c = db.getAllRecipes();

        System.out.println("LIKED ACTIVITY");

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            Card card = new Card( c.getString( c.getColumnIndex("name")), c.getString( c.getColumnIndex("image_url")), c.getString( c.getColumnIndex("content_url")), c.getString( c.getColumnIndex("description")));
            cards.add(card);
            System.out.println(c.getString( c.getColumnIndex("name")));
        }
        adapter.notifyDataSetChanged();

    }

    private List<Card> getLiked() {
        return cards;
    }
}