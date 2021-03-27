package com.example.ic_hello_world;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewFoodItem  extends AppCompatActivity {

    private Button mPost;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_food_item);

        mAuth = FirebaseAuth.getInstance();



        mPost = (Button) findViewById(R.id.submitFood);

        mPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_id = mAuth.getCurrentUser().getUid();
                testAddItem addItem = new testAddItem(user_id);
                addItem.writeNewItem("fromHere",2,"date");
//                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//                String user_id = mAuth.getCurrentUser().getUid();
//                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
//                databaseReference.child("items").child(user_id).child("someItem").child("expires").setValue("date");
//                databaseReference.child("items").child(user_id).child("someItem").child("quantity").setValue(2);
                return;
            }});

    }


}
