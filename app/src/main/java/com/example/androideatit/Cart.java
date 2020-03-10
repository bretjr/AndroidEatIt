package com.example.androideatit;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Cart extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    TextView totalText;
    Button btnPlaceOrder;

    FirebaseDatabase database;
    DatabaseReference request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Firebase
        database = FirebaseDatabase.getInstance();
        request = database.getReference("Requests");

        // Init
        recyclerView = findViewById(R.id.listCart);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        
        totalText = findViewById(R.id.total);
        btnPlaceOrder = findViewById(R.id.btnPlaceOrder);
        
        loadListFood();
    }

    private void loadListFood() {
    }
}
