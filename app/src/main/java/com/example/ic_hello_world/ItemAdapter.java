package com.example.ic_hello_world;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import org.xmlpull.v1.XmlPullParser;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ItemAdapter extends ArrayAdapter<Item> {

    private int tileLayout;

    private Map<Button, Item> buttonContext;


    public ItemAdapter(Context context, ArrayList<Item> items,int tileLayout, Map<Button, Item> buttonContext)
    {
        super(context,0,items);
        this.tileLayout = tileLayout;
        this.buttonContext = buttonContext;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View listItemView = convertView;
        if(listItemView==null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(tileLayout, parent, false);
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

        final Button button = listItemView.findViewById(R.id.item_button);
        buttonContext.put(button,currentItem);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(buttonContext.get(button).getName());
                return;
            }
        });


        return listItemView;
    }
}
