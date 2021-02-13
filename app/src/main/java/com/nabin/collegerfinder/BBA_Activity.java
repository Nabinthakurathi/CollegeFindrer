package com.nabin.collegerfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.nabin.collegerfinder.Adapter.ItemRecyclerAdapter;
import com.nabin.collegerfinder.Bll.bbaBll;

public class BBA_Activity extends AppCompatActivity {
    private RecyclerView item_recycleView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_b_a_);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        PopulateRecyclerViewList();
    }
    public void PopulateRecyclerViewList(){
        item_recycleView1 = findViewById(R.id.wineList);
        bbaBll bbaBll = new bbaBll();
        ItemRecyclerAdapter itemRecyclerAdapter = new ItemRecyclerAdapter(this,bbaBll.getAllItems());
        item_recycleView1.setAdapter(itemRecyclerAdapter);
        item_recycleView1.setLayoutManager(new LinearLayoutManager(this));
    }
}