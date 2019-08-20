package com.logzero.necommerce.contactus;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.logzero.necommerce.R;
import com.logzero.necommerce.utility.BaseActivity;


public class ContactUsActivity extends BaseActivity {
    ImageView back;
    TextView submit;
    LinearLayout l;
    EditText message,name,email,number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        back = findViewById(R.id.back);
        submit = findViewById(R.id.submit);
        message = findViewById(R.id.message);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        number = findViewById(R.id.number);
        l = findViewById(R.id.l);



        message.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    if (isOnline())
                    {
                        if(message.getText().toString().length()!=0)
                        {
                            showProgress("Please wait...");
                            hideKeyboard();

                        }
                        else{
                            Toast toast = Toast.makeText(ContactUsActivity.this,"Please enter message", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL, 0, 20);
                            toast.show();
                        }
                    }
                    else
                    {
                        Toast toast = Toast.makeText(ContactUsActivity.this,R.string.no_network, Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL, 0, 20);
                        toast.show();
                    }
                }
                return false;
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOnline())
                {
                    if(message.getText().toString().length()!=0)
                    {
                        showProgress("Please wait...");
                        hideKeyboard();

                    }
                    else{
                        Toast toast = Toast.makeText(ContactUsActivity.this,"Please enter message", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL, 0, 20);
                        toast.show();                    }
                }
                else
                {
                    Toast toast = Toast.makeText(ContactUsActivity.this,R.string.no_network, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER | Gravity.CENTER_VERTICAL, 0, 20);
                    toast.show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                hideKeyboard(ContactUsActivity.this);
            }
        });

        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard(ContactUsActivity.this);
            }
        });

        message.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                if (message.hasFocus()) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    switch (event.getAction() & MotionEvent.ACTION_MASK){
                        case MotionEvent.ACTION_SCROLL:
                            v.getParent().requestDisallowInterceptTouchEvent(false);
                            return true;
                    }
                }
                return false;
            }
        });
    }
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
