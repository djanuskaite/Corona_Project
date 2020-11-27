package com.corona.coronazp20t;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class SearchActivity extends AppCompatActivity {


    private static final String URL = "https://covid19-api.weedmark.systems/api/v1/stats";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        try {
            readJSONFromAPI(URL);
        } catch (IOException e) {
            System.out.println("Ivyko ivedimo - isvedimo klaida");
            System.out.println("Daugiau informacijos: " + e.getMessage());
        } catch (JSONException e) {
            System.out.println("Ivyko klaida nuskaitant JSON");
            System.out.println("Daugiau informacijos: " + e.getMessage());
        }
    }
    public static void readJSONFromAPI(String URL) throws IOException, JSONException {
        JSONObject json = JSON.readJsonFromUrl(URL);
        System.out.println(json.toString());
    }
}

