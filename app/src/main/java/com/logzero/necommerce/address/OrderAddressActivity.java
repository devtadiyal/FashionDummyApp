package com.logzero.necommerce.address;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListPopupWindow;
import android.widget.ListView;

import com.logzero.necommerce.MainActivity;
import com.logzero.necommerce.R;

public class OrderAddressActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ImageView back;
    EditText state;
    ListPopupWindow listPopupWindow;
    String[] statename = {"Andhra Pradesh", "Arunachal Pradesh",
            "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat"
            , "Haryana", "Himachal Pradesh", "Jammu and Kashmir",
            "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh",
            "Maharashtra", "Manipur", "Meghalaya", "Mizoram",
            "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim",
            "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh",
            "Uttarakhand", "West Bengal", "Andaman and Nicobar",
            "Chandigarh", "Dadra and Nagar Haveli", "Daman and Diu",
            "Lakshadweep", "Delhi", "Puducherry"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_address);

        back = findViewById(R.id.back);
        state = findViewById(R.id.state);
        listPopupWindow = new ListPopupWindow(
                OrderAddressActivity.this);
        listPopupWindow.setAdapter(new ArrayAdapter(
                OrderAddressActivity.this,
                R.layout.custom_dialog, statename));
        listPopupWindow.setAnchorView(state);
        listPopupWindow.setWidth(800);
        listPopupWindow.setHeight(600);

        listPopupWindow.setModal(true);
        listPopupWindow.setOnItemClickListener(
                OrderAddressActivity.this);
        state.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                listPopupWindow.show();
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {
        state.setText(statename[position]);
        listPopupWindow.dismiss();
    }
}
