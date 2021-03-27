package com.example.ic_hello_world;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewFoodItem  extends AppCompatActivity {

    private Button mPost;
    private TextView mName,mPrice;
    private CalendarView mDate;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_food_item);

        mAuth = FirebaseAuth.getInstance();

        mName = (TextView) findViewById(R.id.foodName);
        mPrice = (TextView) findViewById(R.id.foodPrice);
        mDate = (CalendarView) findViewById(R.id.calendarView);

        mPost = (Button) findViewById(R.id.submitFood);


        mPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_id = mAuth.getCurrentUser().getUid();
                testAddItem addItem = new testAddItem(user_id);
                final String name = mName.getText().toString();
                final String price = mPrice.getText().toString();
                final long date = mDate.getDate();
                addItem.writeNewItem(name,price,date);
//                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//                String user_id = mAuth.getCurrentUser().getUid();
//                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
//                databaseReference.child("items").child(user_id).child("someItem").child("expires").setValue("date");
//                databaseReference.child("items").child(user_id).child("someItem").child("quantity").setValue(2);
                return;
            }});

    }

    }
}