package com.example.re_cipe;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.re_cipe.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LikedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liked);

        Intent i = getIntent();
        Bundle b = i.getBundleExtra("Bundle");
        String text = b.getString("liked_list_text");

        TextView textView = (TextView) findViewById(R.id.liked_text);
        RecipesDB db = new RecipesDB(this);
        Card card = db.searchByName(text);
        TextView ingredients = (TextView) findViewById(R.id.liked_ingredients);
        TextView description = (TextView) findViewById(R.id.liked_description);
        ImageView image = (ImageView) findViewById(R.id.liked_image);
        textView.setText(text);
        ingredients.setText(card.getIngredients());
        description.setText(card.getDescription());
        Glide.with(this).load(card.getImage()).centerCrop().into(image);


    }

}