package com.nabin.collegerfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.nabin.collegerfinder.Adapter.ItemRecyclerAdapter;
import com.nabin.collegerfinder.Bll.ItemBll;

public class College_List extends AppCompatActivity {
    private RecyclerView item_recycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college__list);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        PopulateRecyclerViewList();

    }
    public void PopulateRecyclerViewList(){
        item_recycleView = findViewById(R.id.arecycleitemlists);
        ItemBll itemBll = new ItemBll();
        ItemRecyclerAdapter itemRecyclerAdapter = new ItemRecyclerAdapter(this,itemBll.getAllItems());
        item_recycleView.setAdapter(itemRecyclerAdapter);
        item_recycleView.setLayoutManager(new LinearLayoutManager(this));
    }
}