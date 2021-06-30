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

import com.example.sewaklalcorporate.Adapters.BookingDetailsAdapter;
import com.example.sewaklalcorporate.Adapters.BrancheManagementAdapter;
import com.example.sewaklalcorporate.R;

public class BranchManagementActivity extends BaseAppCompatActivity {
    protected Toolbar toolbar;
    RecyclerView recyclewView;
    BrancheManagementAdapter brancheManagementAdapter;
    LinearLayout linear_add_branch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_management);
        recyclewView = findViewById(R.id.recyclewView);
        linear_add_branch = findViewById(R.id.linear_add_branch);
        brancheManagementAdapter = new BrancheManagementAdapter(BranchManagementActivity.this  );
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclewView.setLayoutManager(mLayoutManager);
        recyclewView.setAdapter(brancheManagementAdapter);
        initToolBar("Branch Management", true);
        linear_add_branch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BranchManagementActivity.this, AddBranchActivity.class);
                startActivity(i);
            }
        });
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