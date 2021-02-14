package com.nabin.collegerfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.nabin.collegerfinder.Api.UsersApi;
import com.nabin.collegerfinder.Bll.CartBll;
import com.nabin.collegerfinder.Url.url;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CollegeDetails_activity extends AppCompatActivity {
    ImageView imgMain1;
    TextView tvdname, tvdprice, tvdesc;
    Context mcontext;
    public static String id = null;
    String itemid = "";
    String Image = "";
    private FloatingActionButton fav;
    Button buttonCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_details_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        imgMain1 = findViewById(R.id.ImgMain1);
        tvdesc = findViewById(R.id.tvdes);
        tvdprice = findViewById(R.id.tvprice);
        tvdname = findViewById(R.id.tvname);
        buttonCart = findViewById(R.id.Cart);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String imgPath = url.imagePath + (bundle.getString("image"));

            itemid = bundle.getString("_id");
            String Images = bundle.getString("image");
            Picasso.get().load(url.base_url + "uploads/" + Images).into(imgMain1);
            tvdname.setText(bundle.getString("CollegeName"));
            tvdprice.setText(" " + bundle.getString("Location"));
            tvdesc.setText(bundle.getString("detail"));


        }
        buttonCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userid = id;
                String itemID = itemid;
                CartBll CartBll = new CartBll();
                if (CartBll.checkcart(userid, itemID)) {
                    Register();
                    Snackbar.make(view, "Added to Cart", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                } else {
                    fav.setEnabled(false);
                    Snackbar.make(view, "Already Added! Check cart", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

            }
    private void Register() {

        String userid = id;
        String itemID = itemid;
        String itemName = tvdname.getText().toString();
        String price = tvdprice.getText().toString();
        String disc = tvdesc.getText().toString();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UsersApi user1 = retrofit.create(UsersApi.class);
    }
    private class AddtoCartOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

        }
    }
}