package com.nabin.collegerfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.nabin.collegerfinder.Adapter.ItemRecyclerAdapter;
import com.nabin.collegerfinder.Bll.ItBll;

public class it_Activity extends AppCompatActivity {
    private RecyclerView BeerRecyclerView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it_);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        mContext = this;
        PopulateRecyclerViewList();
    }
    public void PopulateRecyclerViewList(){
        BeerRecyclerView = findViewById(R.id.beerlist);
        ItBll itBll = new ItBll();
        ItemRecyclerAdapter itemRecyclerAdapter = new ItemRecyclerAdapter(this,itBll.getAllItems());
        BeerRecyclerView.setAdapter(itemRecyclerAdapter);
        BeerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}