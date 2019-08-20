package com.logzero.necommerce;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.logzero.necommerce.accessoriesselection.AccessoriesMainActivity;
import com.logzero.necommerce.address.OrderAddressActivity;
import com.logzero.necommerce.cart.AddtoCartActivity;
import com.logzero.necommerce.contactus.ContactUsActivity;
import com.logzero.necommerce.kidselection.KidSelectionActivity;
import com.logzero.necommerce.menselection.MenMainActivity;
import com.logzero.necommerce.notification.NotificationActivity;
import com.logzero.necommerce.productdetail.ProductDetailsActivity;
import com.logzero.necommerce.ui.MediumTextView;
import com.logzero.necommerce.utility.BaseActivity;
import com.logzero.necommerce.utility.CustomTypefaceSpan;
import com.logzero.necommerce.wishlist.WishlistActivity;
import com.logzero.necommerce.womenselection.WomenMainActivity;
import com.logzero.necommerce.womenselection.fragment.DressFragment;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String[] COUNTRIES = new String[]{"Men's Fashion",
            "Women's Fashion", "Accessories", "Women's Dress", "Men's Wallet"};
    AutoCompleteTextView autoCompleteTextView;
    ImageView accessoriesbanner, womenbanner, menbanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(R.anim.slide_left, R.anim.slide_up);

        accessoriesbanner = findViewById(R.id.accessoriesbanner);
        womenbanner = findViewById(R.id.womenbanner);
        menbanner = findViewById(R.id.menbanner);

        accessoriesbanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, KidSelectionActivity.class));

            }
        });

        womenbanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WomenMainActivity.class);
                startActivity(intent);
            }
        });

        menbanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MenMainActivity.class);
                startActivity(intent);
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        drawer.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                        Animation animFadeIn = AnimationUtils.loadAnimation
                                (getApplicationContext(), R.anim.slide_left);
                        drawerView.startAnimation(animFadeIn);
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                        System.out.println("Mew Syaye "+newState);
                    }
                }
        );
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);


        ImageView search = menu.findItem(R.id.action_settings)
                .getActionView().findViewById(R.id.search_icon);

        TextView cross_icon = menu.findItem(R.id.action_settings)
                .getActionView().findViewById(R.id.cross_icon);

        cross_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autoCompleteTextView.setText("");
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);

        autoCompleteTextView = menu.findItem(R.id.action_settings)
                .getActionView().findViewById(R.id.iv_search);
        autoCompleteTextView.setFocusableInTouchMode(true);
        autoCompleteTextView.requestFocus();
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View arg1,
                                    int pos,
                                    long id) {
                if (adapter.getItem(pos).equalsIgnoreCase("Men's Fashion")) {
                    startActivity(new Intent(MainActivity.this, MenMainActivity.class));
                } else if (adapter.getItem(pos).equalsIgnoreCase("Women's Fashion")) {
                    startActivity(new Intent(MainActivity.this, WomenMainActivity.class));
                } else if (adapter.getItem(pos).equalsIgnoreCase("Women's Dress")) {
                    startActivity(new Intent(MainActivity.this, WomenMainActivity.class));

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
                            startActivity(new Intent(MainActivity.this, MenMainActivity.class));
                        } else if (adapter.getItem(0).equalsIgnoreCase("Women's Fashion")) {
                            startActivity(new Intent(MainActivity.this, WomenMainActivity.class));
                        } else if (adapter.getItem(0).equalsIgnoreCase("Women's Dress")) {
                            startActivity(new Intent(MainActivity.this, WomenMainActivity.class));

                        }
                    }
                }
                return true;
            }
        });

        ImageView addtocart = menu.findItem(R.id.action_settings)
                .getActionView().findViewById(R.id.iv_addtocart);
        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddtoCartActivity.class));
            }
        });

        ImageView notification = menu.findItem(R.id.action_settings)
                .getActionView().findViewById(R.id.iv_notification);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NotificationActivity.class));
            }
        });

        return true;
    }


    @Override
    protected void onResume() {
        super.onResume();
        Long tsLong = System.currentTimeMillis()/1000;
        String ts = tsLong.toString();
        Log.d("TIMESTAMP",ts);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        applyFontToMenuItem(item);

        int id = item.getItemId();

        if (id == R.id.nav_women) {
            startActivity(new Intent(this, WomenMainActivity.class));
        } else if (id == R.id.nav_men) {
            startActivity(new Intent(this, MenMainActivity.class));

        } else if (id == R.id.nav_kids) {
            startActivity(new Intent(this, KidSelectionActivity.class));

        }/* else if (id == R.id.nav_home) {

        } */ else if (id == R.id.nav_wishlist) {
            startActivity(new Intent(this, WishlistActivity.class));

        } else if (id == R.id.nav_order) {
            startActivity(new Intent(this, OrderAddressActivity.class));

        } /*else if (id == R.id.nav_faqs) {
            startActivity(new Intent(this, FAQActivity.class));

        }*/ else if (id == R.id.nav_contactus) {
            startActivity(new Intent(this, ContactUsActivity.class));
        } else if (id == R.id.nav_logout) {
            logout();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Poppins-Regular.otf");
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypefaceSpan("", font), 0, mNewTitle.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }

    public void logout() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        // dialog.getWindow().setBackgroundDrawableResource(R.drawable.round_d);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setContentView(R.layout.deletedialog);

        TextView title = dialog.findViewById(R.id.text_dialog);
        title.setText("Are you sure you want to" + "\n" + " Log out ?");
        TextView yes = dialog.findViewById(R.id.btn_dialog_yes);
        TextView no = dialog.findViewById(R.id.btn_dialog_no);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOnline()) {
                    dialog.dismiss();
                    finish();
                   /* Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);*/
                } else {
                    Toast toast = Toast.makeText(MainActivity.this, R.string.no_network, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL, 0, 20);
                    toast.show();
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        if (!dialog.isShowing())
            dialog.show();
    }


}
