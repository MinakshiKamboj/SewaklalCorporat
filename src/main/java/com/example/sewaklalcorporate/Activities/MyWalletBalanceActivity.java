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
import com.example.sewaklalcorporate.Adapters.MyWalletBalanceAdapter;
import com.example.sewaklalcorporate.Adapters.SupportAdapter;
import com.example.sewaklalcorporate.R;

public class MyWalletBalanceActivity extends BaseAppCompatActivity {
    RecyclerView recyclewView;
    LinearLayout linear_add_money;
    protected Toolbar toolbar;
    MyWalletBalanceAdapter myWalletBalanceAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wallet_balance);
        recyclewView = findViewById(R.id.recyclewView);
        linear_add_money = findViewById(R.id.linear_add_money);
        myWalletBalanceAdapter = new MyWalletBalanceAdapter(MyWalletBalanceActivity.this  );
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclewView.setLayoutManager(mLayoutManager);
        recyclewView.setAdapter(myWalletBalanceAdapter);
        initToolBar("My Wallet Balance", true);
        linear_add_money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MyWalletBalanceActivity.this, AddWalletBallenceActivity.class);
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