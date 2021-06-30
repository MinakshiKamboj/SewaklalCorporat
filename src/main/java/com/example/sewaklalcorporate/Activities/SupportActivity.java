package com.example.sewaklalcorporate.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.sewaklalcorporate.Adapters.BrancheManagementAdapter;
import com.example.sewaklalcorporate.Adapters.SupportAdapter;
import com.example.sewaklalcorporate.R;

public class SupportActivity extends BaseAppCompatActivity {
    RecyclerView recyclewView;
    LinearLayout linear_add_branch;
    protected Toolbar toolbar;
    SupportAdapter supportAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        recyclewView = findViewById(R.id.recyclewView);
        linear_add_branch = findViewById(R.id.linear_add_branch);
        supportAdapter = new SupportAdapter(SupportActivity.this  );
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclewView.setLayoutManager(mLayoutManager);
        recyclewView.setAdapter(supportAdapter);
        initToolBar("Branch Management", true);
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