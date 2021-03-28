package com.example.ic_hello_world;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ActionBar;
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

import java.util.Calendar;

public class NewFoodItem extends AppCompatActivity {

    private Button mHomeButton;
    private Button mPost;
    private TextView mName, mPrice;
    private CalendarView mDate;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_food_item);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().hide();


        mHomeButton = (Button) findViewById(R.id.returnHome);
        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewFoodItem.this, MainActivity.class);

                startActivity(intent);
                finish();
                return;
            }
        });
        mAuth = FirebaseAuth.getInstance();

        mName = (TextView) findViewById(R.id.foodName);
        mPrice = (TextView) findViewById(R.id.foodPrice);
        mDate = (CalendarView) findViewById(R.id.calendarView);

        mPost = (Button) findViewById(R.id.submitFood);
        final long[] time = new long[1];

        mPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_id = mAuth.getCurrentUser().getUid();
                testAddItem addItem = new testAddItem(user_id);
                final String name = mName.getText().toString();
                final String price = "£" + mPrice.getText().toString();
                final long date = time[0];
                addItem.writeNewItem(name, price, date);
                Intent intent = new Intent(NewFoodItem.this, MainActivity.class);

                startActivity(intent);
                finish();

//                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//                String user_id = mAuth.getCurrentUser().getUid();
//                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
//                databaseReference.child("items").child(user_id).child("someItem").child("expires").setValue("date");
//                databaseReference.child("items").child(user_id).child("someItem").child("quantity").setValue(2);
                return;
            }
        });



        mDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            //show the selected date as a toast
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                Calendar c = Calendar.getInstance();
                c.set(year, month, day);
                time[0] = c.getTimeInMillis();
            }
        });

    }


}