package com.example.ic_hello_world;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Queries {

    public synchronized void getItems() {
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
                            Item item = new Item();
                            System.out.println(product.child("expires").getValue());
                            item.setDate(Long.valueOf(product.child("expires").getValue().toString()));
                            item.setName(product.getKey());
                            item.setPrice(product.child("price").getValue().toString());
                            userItem.addItem(item);
                        }
                        result.add(userItem);
                    }
                    //Do rendering to screen
                    System.out.println(result);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



}
