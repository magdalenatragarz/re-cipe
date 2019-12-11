package com.example.re_cipe;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.re_cipe.activities.LikedListActivity;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CardAdapter cardAdapter;
    private int i;

    ListView cardView;
    List<Card> cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cards = new ArrayList<Card>();
        cards.add(new Card("php","https://www.monsieur-cuisine.com/fileadmin/_processed_/5/0/csm_23148_Rezeptfoto_01_21d2e4280f.jpg"));
        cards.add(new Card("c", "https://www.mojewypieki.com/img/images/original/Lody_z_czerwonej_pomara%C5%84czy_2022.jpg"));

        cardAdapter = new CardAdapter(this, R.layout.item, cards);

        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);

        flingContainer.setAdapter(cardAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                cards.remove(0);
                cardAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //TODO:
                // Are we doing something on the left?
                // if not leave blank
                Toast.makeText(MainActivity.this, "Left!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                //TODO:
                // Add to 'liked' database here
                // dataObject will be useful
                Toast.makeText(MainActivity.this, "Right!", Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                //TODO:
                // Ask for more data here

                try {
                    RecipeDTO x = RecipeDAO.getItem();
                    cards.add(new Card(x.getName(), x.getImageUrl()));
                } catch (Exception e) {
                    System.out.println("NIE PYK PYK");
                }

                cardAdapter.notifyDataSetChanged();
                Log.d("LIST", "notified");
                i++;
            }

            @Override
            public void onScroll(float scrollProgressPercent) {

            }
        });


        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                goToLikedList();
            }

        });


    }
    public void goToLikedList (){
        Intent intent = new Intent(MainActivity.this, LikedListActivity.class);
        startActivity(intent);
        return;
    }
    public void goToLiked (){
        Intent intent = new Intent(MainActivity.this, LikedActivity.class);
        startActivity(intent);
        return;
    }
}
