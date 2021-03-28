package com.example.ic_hello_world;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyItemsActivity extends AppCompatActivity {

    private final Map<Button, Item> buttonContext = new HashMap<>();

private Button mAddItem;
private Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myitems);

        getSupportActionBar().hide();



        //ArrayList<Item> order_history = new ArrayList<>();
        //order_history.add(new Item("cake",1213232,"12"));

        //ItemAdapter adapter2 = new ItemAdapter(this,order_history,R.layout.list_item2);

        //ListView listView2 = (ListView) findViewById(R.id.order_history_list);

        //listView2.setAdapter(adapter2);

        mAddItem = (Button) findViewById(R.id.add_item);
        mAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyItemsActivity.this, NewFoodItem.class);

                startActivity(intent);
                finish();
                return;
            }});

        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        Query query = reference.child("items");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public synchronized void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    List<UserItem> result = new ArrayList<>();
                    for (DataSnapshot uuid : dataSnapshot.getChildren()) {
                        System.out.println(uuid.getKey());
                        UserItem userItem = new UserItem(uuid.getKey());
                        for (DataSnapshot product : uuid.getChildren()) {
                            Item item = new Item(uuid.getKey());
                            System.out.println(product.child("expires").getValue());
                            item.setDate(Long.valueOf(product.child("expires").getValue().toString()));
                            item.setName(product.getKey());
                            item.setPrice(product.child("price").getValue().toString());
                            item.setUuidBuyer(product.child("bought-by").getValue().toString());
                            userItem.addItem(item);
                        }
                        result.add(userItem);
                    }

                    ArrayList<Item> my_pantry = new ArrayList<>();

                    String user_id = FirebaseAuth.getInstance().getCurrentUser().getUid();

                    for(UserItem user : result) {
                        if(user_id.equals(user.getUUID())) {
                            for (Item item : user.getItems()) {
                                //add item details to view
                                my_pantry.add(item);
                            }
                        }
                    }

                    ItemAdapter adapter1 = new ItemAdapter(context,my_pantry,R.layout.list_item2, buttonContext, MyItemsActivity.this);
                    ListView listView1 = (ListView) findViewById(R.id.my_pantry_list);
                    listView1.setAdapter(adapter1);

                }
    }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });}}
