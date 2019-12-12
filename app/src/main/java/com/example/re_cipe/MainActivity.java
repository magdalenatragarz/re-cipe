package com.example.re_cipe;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
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

    RecipesDB db = new RecipesDB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        cards = new ArrayList<Card>();

        cards.add(new Card("Chicken Milanese",
                "https://spoonacular.com/recipeImages/618410-556x370.jpg",
                "2 cups arugula/n1-1 1/2 lb. organic chicken breasts/n1/4 cup coconut flour/n2 organic, pasture-raised eggs/n1/4 cup ground flaxseed/n1/2 lemon juiced/n2-3 tbsp oil (I like avocado oil for high heat cooking)/n1/2 tbsp extra-virgin olive oil/nOptional: freshly grated parmesan cheese/nDash freshly ground pepper/nDash Himalayan sea salt/nDash Himalayan sea salt and freshly ground pepper/n1/2 cup tapioca flour/n1 cup tomatoes, chopped/n",
                "In a bowl combine flours, salt, and pepperIn a separate bowl whisk together eggsDip sliced chicken breasts into egg, then dredge in flour mixture- repeat until all chicken is coatedIn a large skillet, heat oil until hotPlace chicken in the skillet and let fry for 5-8 minutes on each side, depending on thicknessFry until chicken is crispy and golden, but juicy in the centerToss arugula and tomatoes with oil, lemon, salt, and pepper- add in optional parmesan and serve"));

        cards.add(new Card("Crock-Pot Beef Fajitas",
                "https://spoonacular.com/recipeImages/617472-556x370.jpg",
                "1 Teaspoon Chili Powder/n1 Tablespoon Cilantro, Chopped/n1.5 to 2 Lbs. Flank Steak, Sliced Thin/n2 Cloves Garlic, Minced/n2 Green Bell Peppers Sliced/n1 Teaspoon Ground Coriander/n1 Teaspoon Ground Cumin/n1 Jalapeno Pepper, Seeded And Chopped/n",
                "Add all ingredients to a 6 quart crock-pot and give everything a quick stir to mix the spices around.Cover and cook on LOW for 8  9 hours.Serve on flour or corn tortillas with your favorite toppings."));

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
                Toast.makeText(MainActivity.this, "Left!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {

                Card selected = (Card) dataObject;
                db.insertRecipe(selected.getText(), selected.getImage(), selected.getIngredients(), selected.getDescription());

            }


            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {

                try {
                    for (int i=0; i<1; i++) {
                        cards.add(new Card(RecipeDAO.getItem()));
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
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
