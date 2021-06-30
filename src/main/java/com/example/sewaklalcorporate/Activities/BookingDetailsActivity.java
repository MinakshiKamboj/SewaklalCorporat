package com.example.sewaklalcorporate.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sewaklalcorporate.Adapters.BookingDetailsAdapter;
import com.example.sewaklalcorporate.R;

public class BookingDetailsActivity extends BaseAppCompatActivity {
    protected Toolbar toolbar;
    String name;
    RecyclerView recyclewView;
    BookingDetailsAdapter bookingDetailsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);
        name = getIntent().getStringExtra("name");
        recyclewView = findViewById(R.id.recyclewView);
        bookingDetailsAdapter = new BookingDetailsAdapter(BookingDetailsActivity.this  );
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclewView.setLayoutManager(mLayoutManager);
        recyclewView.setAdapter(bookingDetailsAdapter);
        initToolBar(name, true);
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