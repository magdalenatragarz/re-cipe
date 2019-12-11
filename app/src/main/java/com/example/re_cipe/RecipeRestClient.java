package com.example.re_cipe;

import com.loopj.android.http.*;
import org.json.JSONObject;
import cz.msebera.android.httpclient.Header;

public class RecipeRestClient  {

    private static JSONObject result;
    private static final String URL = "https://api.spoonacular.com/recipes/random?apiKey=627a441f172c42ba9d77f24e72fb2560";

    public static JSONObject load(){
        new SyncHttpClient().get(URL, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                result = response;
                System.out.println(response);
            }
        });
        return result;
    }
}