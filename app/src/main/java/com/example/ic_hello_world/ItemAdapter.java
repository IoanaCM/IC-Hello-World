package com.example.ic_hello_world;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ItemAdapter extends ArrayAdapter<Item> {


    public ItemAdapter(Context context, ArrayList<Item> items)
    {
        super(context,0,items);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View listItemView = convertView;
        if(listItemView==null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Item currentItem = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.item_name);
        nameTextView.setText(currentItem.getName());

        TextView priceTextView = (TextView) listItemView.findViewById(R.id.item_price);
        priceTextView.setText("Price:\n" + currentItem.getPrice());

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.item_date);
        String selectedDate = sdf.format(new Date(currentItem.getDate()));
        dateTextView.setText("Expiry Date:\n" + selectedDate);


        return listItemView;
    }
}
