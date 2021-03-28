package com.example.ic_hello_world;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class testAddItem {

    private String user_id;

    public testAddItem(String user_id) {
        this.user_id = user_id;
    }

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    public void writeNewItem(String item, String price, Long date) {
        databaseReference.child("items").child(user_id).child(item).child("expires").setValue(date);
        databaseReference.child("items").child(user_id).child(item).child("price").setValue(price);
        databaseReference.child("items").child(user_id).child(item).child("bought-by").setValue("null");
    }

}
