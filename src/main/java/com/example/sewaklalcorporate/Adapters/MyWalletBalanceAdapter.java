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


public class MyWalletBalanceAdapter extends RecyclerView.Adapter<MyWalletBalanceAdapter.MyViewHolder> {
    Context context;
    public MyWalletBalanceAdapter(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public MyWalletBalanceAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_wallet_blns_adapter, parent, false);
        return new MyWalletBalanceAdapter.MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull MyWalletBalanceAdapter.MyViewHolder holder, int position) {
        //   Picasso.with(context).load(dertailApps.get(position).getUrl()).into(image);
    }
    @Override
    public int getItemCount() {
  //      return bookingFetchResultList.size();
               return 10;
    }
   /* public void filteredListed(List<BookingFetchResult> responseResult) {
        bookingFetchResultList = responseResult;
        notifyDataSetChanged();
    }*/
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_booking_id, tv_location,
                tv_status, tv_date, tv_msg,  tv_ser_name;
        LinearLayout linear_msg, lin_booking_id, lnr_location, lnr_date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}