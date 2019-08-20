package com.logzero.necommerce.buynow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.logzero.necommerce.MainActivity;
import com.logzero.necommerce.R;
import com.logzero.necommerce.checkout.CheckoutActivity;
import com.logzero.necommerce.thanks.ThanksActivity;
import com.logzero.necommerce.wishlist.WishlistActivity;

import org.w3c.dom.Text;

public class PaymentActivity extends AppCompatActivity {
    ImageView back;
    TextView paynow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        back = findViewById(R.id.back);
        paynow = findViewById(R.id.paynow);

        paynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PaymentActivity.this, ThanksActivity.class));
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
