package com.example.sewaklalcorporate.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sewaklalcorporate.Activities.BookingDetailsActivity;
import com.example.sewaklalcorporate.Activities.SupportActivity;
import com.example.sewaklalcorporate.Adapters.ImageAdapter;
import com.example.sewaklalcorporate.Adapters.PromocinalOfferAdapter;
import com.example.sewaklalcorporate.Adapters.SupportAdapter;
import com.example.sewaklalcorporate.R;

public class HomeFragment extends Fragment {
CardView card_pending_booking, card_total_booking, card_active_booking,
        card_complete_booking, card_runnijng_ofr;
RecyclerView recyclewView;
    ViewPager mViewPager;
PromocinalOfferAdapter promocinalOfferAdapter;
    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        card_pending_booking = view.findViewById(R.id.card_pending_booking);
        card_total_booking = view.findViewById(R.id.card_total_booking);
        card_active_booking = view.findViewById(R.id.card_active_booking);
        card_complete_booking = view.findViewById(R.id.card_complete_booking);
        card_runnijng_ofr = view.findViewById(R.id.card_runnijng_ofr);
        recyclewView = view.findViewById(R.id.recyclewView);
        promocinalOfferAdapter = new PromocinalOfferAdapter(getContext());
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclewView.setLayoutManager(horizontalLayoutManagaer);
        recyclewView.setLayoutManager(horizontalLayoutManagaer);
        recyclewView.setAdapter(promocinalOfferAdapter);
        mViewPager = view.findViewById(R.id.viewPage);
        ImageAdapter adapterView = new ImageAdapter(getContext());
        mViewPager.setAdapter(adapterView);
        card_pending_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), BookingDetailsActivity.class);
                i.putExtra("name","Pending Booking");
                startActivity(i);
            }
        });
        card_total_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), BookingDetailsActivity.class);
                i.putExtra("name","Total Booking");
                startActivity(i);
            }
        });
        card_active_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), BookingDetailsActivity.class);
                i.putExtra("name","Active Booking");
                startActivity(i);
            }
        });
        card_complete_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), BookingDetailsActivity.class);
                i.putExtra("name","Completed Booking");
                startActivity(i);
            }
        });

        card_runnijng_ofr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), BookingDetailsActivity.class);
                i.putExtra("name","Running Offer's");
                startActivity(i);
            }
        });

        return view;
    }
}