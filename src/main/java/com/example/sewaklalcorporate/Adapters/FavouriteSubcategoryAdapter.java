package com.example.sewaklalcorporate.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sewaklalcorporate.R;

public class FavouriteSubcategoryAdapter  extends RecyclerView.Adapter<FavouriteSubcategoryAdapter.MyViewHolder> {
    Context context;
    String tv_booking_id;
    public FavouriteSubcategoryAdapter(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public FavouriteSubcategoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_subcategory_adapter, parent, false);
        return new FavouriteSubcategoryAdapter.MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull FavouriteSubcategoryAdapter.MyViewHolder holder, int position) {
        //   Picasso.with(context).load(dertailApps.get(position).getUrl()).into(image);
    }
    @Override
    public int getItemCount() {
        //      return bookingFetchResultList.size();
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }

}
