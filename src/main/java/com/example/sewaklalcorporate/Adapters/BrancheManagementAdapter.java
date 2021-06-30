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


public class BrancheManagementAdapter extends RecyclerView.Adapter<BrancheManagementAdapter.MyViewHolder> {
    Context context;
    public BrancheManagementAdapter(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public BrancheManagementAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.branch_management_adapter, parent, false);
        return new BrancheManagementAdapter.MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull BrancheManagementAdapter.MyViewHolder holder, int position) {
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
            tv_ser_name = itemView.findViewById(R.id.tv_ser_name);
            lin_booking_id = itemView.findViewById(R.id.lin_booking_id);
            lnr_location = itemView.findViewById(R.id.lnr_location);
            lnr_date = itemView.findViewById(R.id.lnr_date);
            tv_booking_id = itemView.findViewById(R.id.tv_booking_id);
            tv_location = itemView.findViewById(R.id.tv_location);
            tv_status = itemView.findViewById(R.id.tv_status);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_msg = itemView.findViewById(R.id.tv_msg);
            linear_msg = itemView.findViewById(R.id.linear_msg);

        }
    }

}
