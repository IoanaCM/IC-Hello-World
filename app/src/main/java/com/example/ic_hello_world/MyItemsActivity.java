package com.example.ic_hello_world;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MyItemsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myitems);

        ArrayList<Item> my_pantry = new ArrayList<>();
        my_pantry.add(new Item("cake",1213232,"12"));

        ArrayList<Item> order_history = new ArrayList<>();
        order_history.add(new Item("cake",1213232,"12"));

        ItemAdapter adapter1 = new ItemAdapter(this,my_pantry);
        ItemAdapter adapter2 = new ItemAdapter(this,order_history);

        ListView listView1 = (ListView) findViewById(R.id.my_pantry_list);
        ListView listView2 = (ListView) findViewById(R.id.order_history_list);

        listView1.setAdapter(adapter1);
        listView2.setAdapter(adapter2);
    }
    }
