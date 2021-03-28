package com.example.ic_hello_world;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseQuery {

    private String buyerUUID;
    private String ownerUUID;

    public FirebaseQuery(String buyerUUID, String ownerUUID) {
        this.buyerUUID = buyerUUID;
        this.ownerUUID = ownerUUID;
    }

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    public void buyItem(String item) {
        databaseReference.child("items").child(ownerUUID).child(item).child("bought-by").setValue(buyerUUID);
    }

    public void deleteItem(String item) {
        System.out.println(ownerUUID);
        databaseReference.child("items").child(ownerUUID).child(item).setValue(null);
    }

}
