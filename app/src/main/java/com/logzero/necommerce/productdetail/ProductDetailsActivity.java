package com.logzero.necommerce.productdetail;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.logzero.necommerce.R;
import com.logzero.necommerce.buynow.PaymentActivity;
import com.logzero.necommerce.cart.AddtoCartActivity;
import com.logzero.necommerce.checkout.CheckoutActivity;
import com.logzero.necommerce.menselection.MenMainActivity;
import com.logzero.necommerce.notification.NotificationActivity;
import com.logzero.necommerce.womenselection.CustomAdapter;
import com.logzero.necommerce.womenselection.WomenMainActivity;

import ru.nikartm.support.ImageBadgeView;


public class ProductDetailsActivity extends AppCompatActivity {
    private int flag = 0;
    private static final String[] COUNTRIES = new String[]{"Men's Fashion",
            "Women's Fashion", "Accessories", "Women's Dress", "Men's Wallet"};
    AutoCompleteTextView autoCompleteTextView;
    ImageView back,notification,search;
    ImageBadgeView cart;
    TextView addtocart, buynow;
    ViewPager viewPager;
    RelativeLayout rel_viewpager;
    Button xxlarge, xlarge, large, medium, small;
    ImageView iv_fav, shareproduct, expanded_image;
    TextView discountprice;
    TabLayout indicator;
    Integer[] womentshirt = {R.drawable.wtshirt1, R.drawable.wtshirt2, R.drawable.wtshirt3,
            R.drawable.wtshirt4, R.drawable.wtshirt5};
    Integer[] mentshirt = {R.drawable.fmtshirt1, R.drawable.fmtshirt2, R.drawable.fmtshirt3,
            R.drawable.fmtshirt4, R.drawable.fmtshirt5};
    Integer[] womendress = {R.drawable.wfdress1, R.drawable.wfdress2, R.drawable.wfdress3,
            R.drawable.wfdress4, R.drawable.wfdress5};
    Integer[] womenpalazzo = {R.drawable.fpalazzo1, R.drawable.fpalazzo2, R.drawable.fpalazzo3,
            R.drawable.fpalazzo4, R.drawable.fpalazzo5};
    Integer[] womentunics = {R.drawable.ftunics1, R.drawable.ftunics2, R.drawable.ftunics3,
            R.drawable.ftunics4};
    Integer[] menwatch = {R.drawable.fmenwatch1, R.drawable.fmenwatch2, R.drawable.fmenwatch3,
            R.drawable.fmenwatch4};
    Integer[] menwallet = {R.drawable.fmenwallet1, R.drawable.fmenwallet2, R.drawable.fmenwallet3,
            R.drawable.fmenwallet4};
    Integer[] menjeans = {R.drawable.fmenjeans1, R.drawable.fmenjeans2, R.drawable.fmenjeans3,
            R.drawable.fmenjeans4, R.drawable.fmenjeans5};
    Integer[] kidtshirt = {R.drawable.fkidtshirt1, R.drawable.fkidtshirt2, R.drawable.fkidtshirt3,
            R.drawable.fkidtshirt4};
    Integer[] kidjeans = {R.drawable.fkidjeans1, R.drawable.fkidjeans2, R.drawable.fkidjeans3};
    Integer[] kidclothes = {R.drawable.fkidcloth1, R.drawable.fkidcloth2, R.drawable.fkidcloth3,
            R.drawable.fkidcloth4,R.drawable.fkidcloth5};
    Integer[] kidtshort = {R.drawable.fkidskirt1, R.drawable.fkidskirt2, R.drawable.fkidskirt3,
            R.drawable.fkidskirt4};
    String[] imagesName = {"image1", "image2", "image3", "image4", "image5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Bundle bundle = getIntent().getExtras();
        String fragmnetname = bundle.getString("frag");

        rel_viewpager = findViewById(R.id.rel_viewpager);
        expanded_image = findViewById(R.id.expanded_image);
        addtocart = findViewById(R.id.addtocart);
        buynow = findViewById(R.id.buynow);
        discountprice = findViewById(R.id.discountprice);
        xxlarge = findViewById(R.id.xxlarge);
        xlarge = findViewById(R.id.xlarge);
        large = findViewById(R.id.large);
        medium = findViewById(R.id.medium);
        small = findViewById(R.id.small);
        shareproduct = findViewById(R.id.shareproduct);
        iv_fav = findViewById(R.id.iv_fav);

        back = findViewById(R.id.back);
        viewPager = findViewById(R.id.viewPager);
        indicator = findViewById(R.id.indicator);
        discountprice.setPaintFlags(discountprice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        cart =  findViewById(R.id.cart);
        notification =  findViewById(R.id.notification);
        search =  findViewById(R.id.search);
        autoCompleteTextView =  findViewById(R.id.iv_search);
        back =  findViewById(R.id.back);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);

        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View arg1,
                                    int pos,
                                    long id) {
                if (adapter.getItem(pos).equalsIgnoreCase("Men's Fashion")) {
                    startActivity(new Intent(ProductDetailsActivity.this, MenMainActivity.class));
                } else if (adapter.getItem(pos).equalsIgnoreCase("Women's Fashion")) {
                    startActivity(new Intent(ProductDetailsActivity.this, WomenMainActivity.class));
                } else if (adapter.getItem(pos).equalsIgnoreCase("Women's Dress")) {
                    startActivity(new Intent(ProductDetailsActivity.this, WomenMainActivity.class));

                }
            }
        });

        //Shows drop down list on touch
        autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return false;
            }
        });

        //close button visibility for autocomplete text view selection
        autoCompleteTextView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                search.setVisibility(View.GONE);
                // cross_icon.setVisibility(View.VISIBLE);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                search.setVisibility(View.VISIBLE);
                //    cross_icon.setVisibility(View.GONE);

            }

        });

        autoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0) {
                    search.setVisibility(View.GONE);
                    //  cross_icon.setVisibility(View.VISIBLE);

                } else {
                    search.setVisibility(View.VISIBLE);
                    //  cross_icon.setVisibility(View.GONE);

                }
            }


            @Override
            public void afterTextChanged(final Editable editable) {

            }
        });


        autoCompleteTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    //do Whatever you Want to do
                    if (adapter.getItem(0) != null) {
                        if (adapter.getItem(0).equalsIgnoreCase("Men's Fashion")) {
                            startActivity(new Intent(ProductDetailsActivity.this, MenMainActivity.class));
                        } else if (adapter.getItem(0).equalsIgnoreCase("Women's Fashion")) {
                            startActivity(new Intent(ProductDetailsActivity.this, WomenMainActivity.class));
                        } else if (adapter.getItem(0).equalsIgnoreCase("Women's Dress")) {
                            startActivity(new Intent(ProductDetailsActivity.this, WomenMainActivity.class));

                        }
                    }
                }
                return true;
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProductDetailsActivity.this, AddtoCartActivity.class));

            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProductDetailsActivity.this, NotificationActivity.class));

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



        if (fragmnetname.equalsIgnoreCase("TShirtFragment")) {
            viewPager.setAdapter(new CustomAdapter(this, womentshirt, imagesName));
            indicator.setupWithViewPager(viewPager, true);

        } else if (fragmnetname.equalsIgnoreCase("ShirtFragment")) {
            viewPager.setAdapter(new CustomAdapter(this, mentshirt, imagesName));
            indicator.setupWithViewPager(viewPager, true);
        } else if (fragmnetname.equalsIgnoreCase("DressFragment")) {
            viewPager.setAdapter(new CustomAdapter(this, womendress, imagesName));
            indicator.setupWithViewPager(viewPager, true);
        } else if (fragmnetname.equalsIgnoreCase("TosTunicsFragment")) {
            viewPager.setAdapter(new CustomAdapter(this, womentunics, imagesName));
            indicator.setupWithViewPager(viewPager, true);
        } else if (fragmnetname.equalsIgnoreCase("PalazzoFragment")) {
            viewPager.setAdapter(new CustomAdapter(this, womenpalazzo, imagesName));
            indicator.setupWithViewPager(viewPager, true);
        } else if (fragmnetname.equalsIgnoreCase("WatchFragment")) {
            viewPager.setAdapter(new CustomAdapter(this, menwatch, imagesName));
            indicator.setupWithViewPager(viewPager, true);
        } else if (fragmnetname.equalsIgnoreCase("WalletFragment")) {
            viewPager.setAdapter(new CustomAdapter(this, menwallet, imagesName));
            indicator.setupWithViewPager(viewPager, true);
        } else if (fragmnetname.equalsIgnoreCase("JeansFragment")) {
            viewPager.setAdapter(new CustomAdapter(this, menjeans, imagesName));
            indicator.setupWithViewPager(viewPager, true);
        }else if (fragmnetname.equalsIgnoreCase("KidTshirtFragment")) {
            viewPager.setAdapter(new CustomAdapter(this, kidtshirt, imagesName));
            indicator.setupWithViewPager(viewPager, true);
        }
        else if (fragmnetname.equalsIgnoreCase("KidJeansFragment")) {
            viewPager.setAdapter(new CustomAdapter(this, kidjeans, imagesName));
            indicator.setupWithViewPager(viewPager, true);
        }
        else if (fragmnetname.equalsIgnoreCase("KidShortsFragment")) {
            viewPager.setAdapter(new CustomAdapter(this, kidtshort, imagesName));
            indicator.setupWithViewPager(viewPager, true);
        }
        else if (fragmnetname.equalsIgnoreCase("KidClothSetFragment")) {
            viewPager.setAdapter(new CustomAdapter(this, kidclothes, imagesName));
            indicator.setupWithViewPager(viewPager, true);
        }

        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProductDetailsActivity.this,
                        "Item added to cart", Toast.LENGTH_LONG).show();


            }
        });

        buynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProductDetailsActivity.this, CheckoutActivity.class));
            }
        });

        small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                small.setBackgroundColor(getResources().getColor(R.color.red));
                small.setTextColor(getResources().getColor(R.color.white));
                medium.setBackgroundColor(getResources().getColor(R.color.medium));
                large.setBackgroundColor(getResources().getColor(R.color.medium));
                xlarge.setBackgroundColor(getResources().getColor(R.color.medium));
                xxlarge.setBackgroundColor(getResources().getColor(R.color.medium));
            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                medium.setBackgroundColor(getResources().getColor(R.color.red));
                medium.setTextColor(getResources().getColor(R.color.white));
                small.setBackgroundColor(getResources().getColor(R.color.medium));
                large.setBackgroundColor(getResources().getColor(R.color.medium));
                xlarge.setBackgroundColor(getResources().getColor(R.color.medium));
                xxlarge.setBackgroundColor(getResources().getColor(R.color.medium));

            }
        });
        large.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                large.setBackgroundColor(getResources().getColor(R.color.red));
                large.setTextColor(getResources().getColor(R.color.white));
                medium.setBackgroundColor(getResources().getColor(R.color.medium));
                small.setBackgroundColor(getResources().getColor(R.color.medium));
                xlarge.setBackgroundColor(getResources().getColor(R.color.medium));
                xxlarge.setBackgroundColor(getResources().getColor(R.color.medium));

            }
        });
        xlarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xlarge.setBackgroundColor(getResources().getColor(R.color.red));
                xlarge.setTextColor(getResources().getColor(R.color.white));
                medium.setBackgroundColor(getResources().getColor(R.color.medium));
                large.setBackgroundColor(getResources().getColor(R.color.medium));
                small.setBackgroundColor(getResources().getColor(R.color.medium));
                xxlarge.setBackgroundColor(getResources().getColor(R.color.medium));

            }
        });
        xxlarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xxlarge.setBackgroundColor(getResources().getColor(R.color.red));
                xxlarge.setTextColor(getResources().getColor(R.color.white));
                medium.setBackgroundColor(getResources().getColor(R.color.medium));
                large.setBackgroundColor(getResources().getColor(R.color.medium));
                xlarge.setBackgroundColor(getResources().getColor(R.color.medium));
                small.setBackgroundColor(getResources().getColor(R.color.medium));

            }
        });


        iv_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == 0) {
                    flag = 1; // 1 => Button ON
                    //Toast(ProductDetailsActivity.this,R.string.no_network);
                    iv_fav.setImageResource(R.drawable.heartdisable);
                } else {
                    flag = 0; // 0 => Button OFF
                    iv_fav.setImageResource(R.drawable.heart1);

                }
            }
        });
        shareproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is the share content body";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
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