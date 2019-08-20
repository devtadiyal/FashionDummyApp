package com.logzero.necommerce.cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.logzero.necommerce.R;
import com.logzero.necommerce.checkout.CheckoutActivity;
import com.logzero.necommerce.utility.Data;
import com.logzero.necommerce.womenselection.fragment.DataAdapter;
import com.logzero.necommerce.womenselection.fragment.ShoesModel;

import java.util.ArrayList;

public class AddtoCartActivity extends AppCompatActivity {

    ImageView back;
    Button buynow;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addto_cart);

        back = findViewById(R.id.back);
        recyclerView = findViewById(R.id.rc);
        initViews();

        buynow = findViewById(R.id.buynow);
        buynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddtoCartActivity.this, CheckoutActivity.class));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void initViews() {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager =
                new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<ShoesModel> androidVersions = prepareData();
        CartAdapter adapter = new CartAdapter(this,
                androidVersions);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<ShoesModel> prepareData() {

        ArrayList<ShoesModel> android_version = new ArrayList<>();
        for (int i = 0; i < Data.addtocart_image.length; i++) {
            ShoesModel androidVersion = new ShoesModel();
            androidVersion.setName(Data.addtocart_name[i]);
            androidVersion.setImage(Data.addtocart_image[i]);
            androidVersion.setSubtitle(Data.addtocart_subtitle[i]);
            androidVersion.setPrice(Data.addtocart_price[i]);
            android_version.add(androidVersion);
        }

        return android_version;
    }
}
