package com.example.re_cipe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RecipeDAO {

    public static RecipeDTO getItem() throws InterruptedException, ExecutionException, JSONException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<JSONObject> callable = RecipeRestClient::load;
        Future<JSONObject> future = executorService.submit(callable);
        JSONObject result = future.get();
        executorService.shutdown();

        return convert(result);
    }

    private static RecipeDTO convert(JSONObject object) throws JSONException {

        JSONObject recipe = getRecipe(object);

        String name = getName(recipe);
        String imageUrl = getImageUrl(recipe);
        String description = getDescription(recipe);
        String ingredients = getIngredients(recipe);

        return new RecipeDTO(name, ingredients, description, imageUrl);
    }

    private static JSONObject getRecipe(JSONObject object) throws JSONException{
        return object.getJSONArray("recipes").getJSONObject(0);
    }

    private static String getName(JSONObject object) throws JSONException {
        return object.getString("title");
    }

    private static String getIngredients(JSONObject object) throws JSONException {
        JSONArray ingredients = object.getJSONArray("extendedIngredients");

        StringBuilder ingredientsBuilder = new StringBuilder();
        for (int i = 0; i < ingredients.length(); i++) {
            JSONObject ingredientObject = ingredients.getJSONObject(i);
            String ingredient = ingredientObject.getString("original");
            ingredientsBuilder.append(ingredient).append( "/n");
        }
        return ingredientsBuilder.toString();
    }

    private static String getDescription(JSONObject object) throws JSONException {
        return object.getString("instructions");
    }

    private static String getImageUrl(JSONObject object) throws JSONException {
        return object.getString("image");
    }

}
