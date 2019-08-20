package com.logzero.necommerce.womenselection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;
import com.logzero.necommerce.MainActivity;
import com.logzero.necommerce.R;
import com.logzero.necommerce.cart.AddtoCartActivity;
import com.logzero.necommerce.menselection.MenMainActivity;
import com.logzero.necommerce.notification.NotificationActivity;
import com.logzero.necommerce.womenselection.fragment.PalazzoFragment;
import com.logzero.necommerce.womenselection.fragment.DressFragment;
import com.logzero.necommerce.womenselection.fragment.TShirtFragment;
import com.logzero.necommerce.womenselection.fragment.TosTunicsFragment;

import java.util.ArrayList;
import java.util.List;

import ru.nikartm.support.ImageBadgeView;

public class WomenMainActivity extends AppCompatActivity {
    private static final String[] COUNTRIES = new String[]{"Men's Fashion",
            "Women's Fashion", "Accessories", "Women's Dress", "Men's Wallet"};
    ViewPager viewPager, viewpager2;
    LinearLayout sizechart;
    Button sort, filter;
    TabLayout indicator;
    AutoCompleteTextView autoCompleteTextView;
    ImageView back, notification, search;
    ImageBadgeView cart;
    Integer[] imageId = {R.drawable.womenboot};
    String[] imagesName = {"image1"};
    private TabLayout tabLayout;
    private int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_main);


        viewPager = findViewById(R.id.viewPager);
        viewpager2 = findViewById(R.id.viewpager2);
        indicator = findViewById(R.id.indicator);
        sort = findViewById(R.id.sort);
        filter = findViewById(R.id.filter);
        cart = findViewById(R.id.cart);
        notification = findViewById(R.id.notification);
        search = findViewById(R.id.search);
        autoCompleteTextView = findViewById(R.id.iv_search);
        back = findViewById(R.id.back);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);

        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View arg1,
                                    int pos, long id) {
                if (adapter.getItem(pos).equalsIgnoreCase("Men's Fashion")) {
                    startActivity(new Intent(WomenMainActivity.this, MenMainActivity.class));
                } else if (adapter.getItem(pos).equalsIgnoreCase("Women's Fashion")) {
                    startActivity(new Intent(WomenMainActivity.this, WomenMainActivity.class));
                } else if (adapter.getItem(pos).equalsIgnoreCase("Women's Dress")) {
                    startActivity(new Intent(WomenMainActivity.this, WomenMainActivity.class));

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
                System.out.println("" + editable.toString());
            }
        });


        autoCompleteTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    //do Whatever you Want to do
                    System.out.println("ADAPTER " + adapter);
                    if (adapter.getItem(0) != null) {
                        if (adapter.getItem(0).equalsIgnoreCase("Men's Fashion")) {
                            startActivity(new Intent(WomenMainActivity.this, MenMainActivity.class));
                        } else if (adapter.getItem(0).equalsIgnoreCase("Women's Fashion")) {
                            startActivity(new Intent(WomenMainActivity.this, WomenMainActivity.class));
                        } else if (adapter.getItem(0).equalsIgnoreCase("Women's Dress")) {
                            startActivity(new Intent(WomenMainActivity.this, WomenMainActivity.class));

                        }
                    }
                }
                return true;
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WomenMainActivity.this, AddtoCartActivity.class));

            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WomenMainActivity.this, NotificationActivity.class));

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
                        WomenMainActivity.this);
                dialog.setContentView(R.layout.sort);
                dialog.show();
            }
        });

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog dialog = new BottomSheetDialog(
                        WomenMainActivity.this);
                dialog.setContentView(R.layout.filter);
                TextView size = dialog.findViewById(R.id.size);
                TextView custrating = dialog.findViewById(R.id.custrating);
                TextView price = dialog.findViewById(R.id.price);
                LinearLayout sizechart = dialog.findViewById(R.id.sizechart);
                LinearLayout customer = dialog.findViewById(R.id.customer);
                RelativeLayout prierange = dialog.findViewById(R.id.prierange);

                price.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (flag == 0) {
                            flag = 1; // 1 => Button ON
                            prierange.setVisibility(View.VISIBLE);

                        } else {
                            flag = 0; // 0 => Button OFF
                            prierange.setVisibility(View.GONE);
                        }
                    }
                });
                final CrystalRangeSeekbar rangeSeekbar = dialog.findViewById(R.id.rangeSeekbar1);

// get min and max text view
                final TextView tvMin = dialog.findViewById(R.id.textMin1);
                final TextView tvMax = dialog.findViewById(R.id.textMax1);

// set listener
                rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
                    @Override
                    public void valueChanged(Number minValue, Number maxValue) {
                        tvMin.setText(String.valueOf(minValue));
                        tvMax.setText(String.valueOf(maxValue));
                    }
                });

// set final value listener
                rangeSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
                    @Override
                    public void finalValue(Number minValue, Number maxValue) {
                        Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
                    }
                });


                custrating.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (flag == 0) {
                            flag = 1; // 1 => Button ON
                            customer.setVisibility(View.VISIBLE);

                        } else {
                            flag = 0; // 0 => Button OFF
                            customer.setVisibility(View.GONE);
                        }
                    }
                });

                size.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (flag == 0) {
                            flag = 1; // 1 => Button ON
                            sizechart.setVisibility(View.VISIBLE);

                        } else {
                            flag = 0; // 0 => Button OFF
                            sizechart.setVisibility(View.GONE);
                        }
                    }
                });
                dialog.show();
            }
        });

        viewPager.setAdapter(new CustomAdapter(this, imageId, imagesName));
        indicator.setupWithViewPager(viewPager, true);
        setupViewPager(viewpager2);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewpager2);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TShirtFragment(), "T-shirt");
        adapter.addFragment(new DressFragment(), "Dress");
        adapter.addFragment(new TosTunicsFragment(), "Tunics");
        adapter.addFragment(new PalazzoFragment(), "Palazzo");
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
