package com.example.sewaklalcorporate.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sewaklalcorporate.Models.getCategoryRequest;
import com.example.sewaklalcorporate.R;

import java.util.ArrayList;
import java.util.List;

public class SpinnerCategoryAdapter extends ArrayAdapter<getCategoryRequest> {

    private List<getCategoryRequest> list;


    // invoke the suitable constructor of the ArrayAdapter class
    public SpinnerCategoryAdapter(@NonNull Context context, ArrayList<getCategoryRequest> arrayList) {
        super(context, 0, arrayList);
        list = arrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        View currentItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_view, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        getCategoryRequest currentNumberPosition = list.get(position);

        // then according to the position of the view assign the desired image for the same
    //    ImageView numbersImage = currentItemView.findViewById(R.id.imageView);
  //      assert currentNumberPosition != null;
       // numbersImage.setImageResource(currentNumberPosition.getNumbersImageId());

        // then according to the position of the view assign the desired TextView 1 for the same
        TextView textView1 = currentItemView.findViewById(R.id.tv_cat_name);
        textView1.setText(currentNumberPosition.getName());

        // then return the recyclable view
        return currentItemView;
    }
    public void addItem(getCategoryRequest item){
        list.add(item);
        notifyDataSetChanged();
    }
}