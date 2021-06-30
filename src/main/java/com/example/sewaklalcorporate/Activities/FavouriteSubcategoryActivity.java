package com.example.sewaklalcorporate.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.sewaklalcorporate.Adapters.BrancheManagementAdapter;
import com.example.sewaklalcorporate.Adapters.FavouriteSubcategoryAdapter;
import com.example.sewaklalcorporate.R;

public class FavouriteSubcategoryActivity extends BaseAppCompatActivity {
    protected Toolbar toolbar;
    RecyclerView recyclewView;
    FavouriteSubcategoryAdapter favouriteSubcategoryAdapter;
    LinearLayout linear_fav_sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_subcategory);
        initToolBar("Favourite Subcategory", true);
        recyclewView = findViewById(R.id.recyclewView);
        linear_fav_sub = findViewById(R.id.linear_fav_sub);
        linear_fav_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FavouriteSubcategoryActivity.this, AddFavouriteSubcategoryActivity.class);
                startActivity(i);
                finish();
            }
        });
        favouriteSubcategoryAdapter = new FavouriteSubcategoryAdapter(FavouriteSubcategoryActivity.this  );
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclewView.setLayoutManager(mLayoutManager);
        recyclewView.setAdapter(favouriteSubcategoryAdapter);
    }
    public void initToolBar(String title,boolean backpress) {
        toolbar = findViewById(R.id.toolbar);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(backpress);
        getSupportActionBar().setHomeAsUpIndicator(getHomeIcon());
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimary));
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));
        toolbar.setSubtitleTextColor(ContextCompat.getColor(this, R.color.white));
    }
}