package es.rufflecol.lara.shopproductsorter;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import es.rufflecol.lara.shopproductsorter.model.Product;
import es.rufflecol.lara.shopproductsorter.model.ShopFeed;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToolbarLRC toolbar = (ToolbarLRC) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ShopFeed shopFeed = readShopFeedFromFile();
        String currencySymbol = shopFeed.getCurrencySymbol();
        List<Product> products = shopFeed.getProducts();
        RecyclerAdapter adapter = new RecyclerAdapter(currencySymbol, products); /** Instantiating the RecyclerAdapter and passing through two parameters **/
        recyclerView.setAdapter(adapter);
    }

    private ShopFeed readShopFeedFromFile() {
        String json = readJsonFromFile();
        Gson gson = new Gson();
        ShopFeed shopFeed = gson.fromJson(json, ShopFeed.class);
        return shopFeed;
    }

    private String readJsonFromFile() {
        String returnValue = "";

        AssetManager assetManager = getAssets();
        try {
            InputStream inputStream = assetManager.open("ShopProductFeed.json");

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString;
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                returnValue = stringBuilder.toString();
            }
        } catch (FileNotFoundException exception) {
            Log.e("Login activity", "File not found: " + exception.toString());
        } catch (IOException exception) {
            Log.e("Login activity", "Cannot read file: " + exception.toString());
        }
        return returnValue;
    }
}