package com.logzero.necommerce.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatEditText;

public class PoppinsLightEdittext extends AppCompatEditText {
    public PoppinsLightEdittext(Context context) {
        super(context);
    }
    public PoppinsLightEdittext(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public PoppinsLightEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init() {
        try {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Poppins-Light.otf");
            setTypeface(tf, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
