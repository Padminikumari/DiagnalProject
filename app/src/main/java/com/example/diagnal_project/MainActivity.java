package com.example.diagnal_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView gridView;
    List<Model> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);

        gridView = findViewById(R.id.grid_view);


        list.add(new Model("The Birds", R.drawable.poster1));
        list.add(new Model("The Birds", R.drawable.poster2));
        list.add(new Model("The Birds", R.drawable.poster3));
        list.add(new Model("The Birds", R.drawable.poster4));
        list.add(new Model("The Birds", R.drawable.poster5));
        list.add(new Model("The Birds", R.drawable.poster6));
        list.add(new Model("The Birds", R.drawable.poster7));
        list.add(new Model("The Birds", R.drawable.poster8));
        list.add(new Model("The Birds", R.drawable.poster1));
        list.add(new Model("The Birds", R.drawable.poster2));
        list.add(new Model("The Birds", R.drawable.poster3));
        list.add(new Model("The Birds", R.drawable.poster4));
        list.add(new Model("The Birds", R.drawable.poster5));
        list.add(new Model("The Birds", R.drawable.poster6));
        list.add(new Model("The Birds", R.drawable.poster7));
        list.add(new Model("The Birds", R.drawable.poster8));
      //  loadJSONFromAsset();
        getViewData();
        getListOfDataModel();
    }
    public String loadJSONFromAsset() {
        String json = null;
        try {

            InputStream is = getAssets().open("CONTENTLISTINGPAGE-PAGE1.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }
    private void getListOfDataModel() {


        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray countries=obj.getJSONArray("PageClass");
            for (int i=0;i<countries.length();i++){
                JSONObject jsonObject=countries.getJSONObject(i);
                Toast.makeText(this, ""+jsonObject.getString("CONTENTLISTINGPAGE-PAGE1"), Toast.LENGTH_SHORT).show();
               // String code=jsonObject.getString("code");
               // String nameAr=jsonObject.getString("nameAr");
              //  String nameEn=jsonObject.getString("nameEn");
               // countryList.add(new Country(code,nameAr,nameEn));
            }
          //  DBHelper.getInstance(activity).insertCountries(countryList);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getViewData() {
        gridView.setLayoutManager(new GridLayoutManager(MainActivity.this, 3, RecyclerView.VERTICAL, false));
        GridviewAdapter myAdapter = new GridviewAdapter((ArrayList<Model>) list);
        gridView.setAdapter(myAdapter);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            getViewData();
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            gridView.setLayoutManager(new GridLayoutManager(MainActivity.this, 7, RecyclerView.VERTICAL, false));
            GridviewAdapter myAdapter = new GridviewAdapter((ArrayList<Model>) list);
            gridView.setAdapter(myAdapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.search_bar) {

        }
        return true;
    }
}
