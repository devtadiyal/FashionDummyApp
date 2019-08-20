package com.logzero.necommerce.menselection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;
import com.logzero.necommerce.R;
import com.logzero.necommerce.cart.AddtoCartActivity;
import com.logzero.necommerce.menselection.fragment.JeansFragment;
import com.logzero.necommerce.menselection.fragment.ShirtFragment;
import com.logzero.necommerce.menselection.fragment.WalletFragment;
import com.logzero.necommerce.menselection.fragment.WatchFragment;
import com.logzero.necommerce.notification.NotificationActivity;
import com.logzero.necommerce.womenselection.WomenMainActivity;
import com.logzero.necommerce.womenselection.fragment.PalazzoFragment;
import com.logzero.necommerce.womenselection.CustomAdapter;

import java.util.ArrayList;
import java.util.List;

import ru.nikartm.support.ImageBadgeView;

public class MenMainActivity extends AppCompatActivity {
    private static final String[] COUNTRIES = new String[]{"Men's Fashion",
            "Women's Fashion", "Accessories", "Women's Dress", "Men's Wallet"};
    ViewPager viewPager,viewpager2;
    TabLayout indicator;
    ImageView back;
    Button sort,filter;
    AutoCompleteTextView autoCompleteTextView;
    ImageView notification,search;
    ImageBadgeView cart;
    Integer[] imageId = {R.drawable.menbanner};
    String[] imagesName = {"image1"};
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men_main);

        back =  findViewById(R.id.back);
        viewPager =  findViewById(R.id.viewPager);
        viewpager2 =  findViewById(R.id.viewpager2);
        indicator =  findViewById(R.id.indicator);

        sort =  findViewById(R.id.sort);
        filter =  findViewById(R.id.filter);

        cart =  findViewById(R.id.cart);
        notification =  findViewById(R.id.notification);
        search =  findViewById(R.id.search);
        autoCompleteTextView =  findViewById(R.id.iv_search);
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
                    startActivity(new Intent(MenMainActivity.this, MenMainActivity.class));
                } else if (adapter.getItem(pos).equalsIgnoreCase("Women's Fashion")) {
                    startActivity(new Intent(MenMainActivity.this, WomenMainActivity.class));
                } else if (adapter.getItem(pos).equalsIgnoreCase("Women's Dress")) {
                    startActivity(new Intent(MenMainActivity.this, WomenMainActivity.class));

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
                            startActivity(new Intent(MenMainActivity.this, MenMainActivity.class));
                        } else if (adapter.getItem(0).equalsIgnoreCase("Women's Fashion")) {
                            startActivity(new Intent(MenMainActivity.this, WomenMainActivity.class));
                        } else if (adapter.getItem(0).equalsIgnoreCase("Women's Dress")) {
                            startActivity(new Intent(MenMainActivity.this, WomenMainActivity.class));

                        }
                    }
                }
                return true;
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenMainActivity.this, AddtoCartActivity.class));

            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenMainActivity.this, NotificationActivity.class));

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog dialog = new BottomSheetDialog(
                        MenMainActivity.this);
                dialog.setContentView(R.layout.sort);
                dialog.show();
            }
        });

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog dialog = new BottomSheetDialog(
                        MenMainActivity.this);
                dialog.setContentView(R.layout.filter);

                dialog.show();
            }
        });
        viewPager.setAdapter(new CustomAdapter(this, imageId, imagesName));
        indicator.setupWithViewPager(viewPager, true);

        setupViewPager(viewpager2);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewpager2);
    }

    private void setupViewPager(ViewPager viewPager) {
        MenMainActivity.ViewPagerAdapter adapter = new MenMainActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ShirtFragment(), "T-Shirt");
        adapter.addFragment(new WatchFragment(), "Watches");
        adapter.addFragment(new WalletFragment(), "Wallets");
        adapter.addFragment(new JeansFragment(), "Jeans");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}