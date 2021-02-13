package com.nabin.collegerfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.nabin.collegerfinder.Adapter.ItemRecyclerAdapter;
import com.nabin.collegerfinder.Bll.EngineerBll;

public class engeer_activity extends AppCompatActivity {
    private RecyclerView EngineerRecyclerView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engeer_activity);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        mContext = this;
        PopulateRecyclerViewList();
    }
    public void PopulateRecyclerViewList(){
        EngineerRecyclerView = findViewById(R.id.Engineer);
        EngineerBll engineerBll = new EngineerBll();
        ItemRecyclerAdapter itemRecyclerAdapter = new ItemRecyclerAdapter(this,engineerBll.getAllItems());
        EngineerRecyclerView.setAdapter(itemRecyclerAdapter);
        EngineerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}