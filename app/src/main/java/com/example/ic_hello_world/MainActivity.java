package com.example.ic_hello_world;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button mLogOut;
    private Button mAddItem;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    private Context theContext = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mLogOut = (Button) findViewById(R.id.log_out);
        mLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);

                startActivity(intent);
                finish();
                return;
                            }});
            mAddItem = (Button) findViewById(R.id.add_item);
        mAddItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, NewFoodItem.class);

                    startActivity(intent);
                    finish();
                    return;
                }
        });

        //

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

                    final ArrayList<Item> items = new ArrayList<Item>();


                    for(UserItem user : result) {
                        for (Item item : user.getItems()) {
                            //add item details to view
                            items.add(item);
                        }
                    }

                    ItemAdapter adapter = new ItemAdapter(theContext,items);
                    ListView listView = (ListView) findViewById(R.id.items_list);

                    listView.setAdapter(adapter);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        //


    }


}