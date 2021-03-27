package com.example.ic_hello_world;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class testAddItem {

    private FirebaseAuth mAuth;

    public testAddItem(FirebaseAuth mAuth) {
        this.mAuth = mAuth;
    }

    String user_id = mAuth.getCurrentUser().getUid();

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    public void writeNewItem(String item, Integer quantity, String date) {
        databaseReference.child("items").child(user_id).child(item).child("expires").setValue(date);
        databaseReference.child("items").child(user_id).child(item).child("quantity").setValue(quantity);
        System.out.println(user_id);
    }

}
