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


public class PromocinalOfferAdapter extends RecyclerView.Adapter<PromocinalOfferAdapter.MyViewHolder> {
    Context context;
    String tv_booking_id;
    public PromocinalOfferAdapter(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public PromocinalOfferAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.promosinal_ofr_adapter, parent, false);
        return new PromocinalOfferAdapter.MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull PromocinalOfferAdapter.MyViewHolder holder, int position) {


        //   Picasso.with(context).load(dertailApps.get(position).getUrl()).into(image);
    }
    @Override
    public int getItemCount() {
  //      return bookingFetchResultList.size();
               return 10;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_booking_id, tv_location,
                tv_status, tv_date, tv_msg,  tv_ser_name;
        LinearLayout linear_msg, lin_booking_id, lnr_location, lnr_date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


        }
    }

}
