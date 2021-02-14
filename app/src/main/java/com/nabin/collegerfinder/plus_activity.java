package com.nabin.collegerfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.nabin.collegerfinder.Adapter.ItemRecyclerAdapter;
import com.nabin.collegerfinder.Bll.PlusBll;

public class plus_activity extends AppCompatActivity {
    private RecyclerView PlusRecyclerView;
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
        PlusRecyclerView = findViewById(R.id.Engineer);
        PlusBll plusBll = new PlusBll();
        ItemRecyclerAdapter itemRecyclerAdapter = new ItemRecyclerAdapter(this, plusBll.getAllItems());
        PlusRecyclerView.setAdapter(itemRecyclerAdapter);
        PlusRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}