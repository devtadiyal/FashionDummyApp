package com.logzero.necommerce.utility;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.logzero.necommerce.R;
import java.util.List;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;


/**
 * Created by day on 07/04/19.
 */

public class BaseActivity extends AppCompatActivity {
    int previously_selected_layout = 0;
    private ProgressDialog progressDialog;
    private Toast currentToast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*Window window = getWindow();
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);*/
        String DEFAULT_MESSAGE = "Please wait...";
        progressDialog = new ProgressDialog(this, R.style.MyThemeDD);
        //progressDialog.setMessage(DEFAULT_MESSAGE);

        //hideSoftKeyboard();
    }



    public boolean isAppRunning(final Context context, final String packageName) {
        final ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        final List<ActivityManager.RunningAppProcessInfo> procInfos = activityManager.getRunningAppProcesses();
        if (procInfos != null)
        {
            for (final ActivityManager.RunningAppProcessInfo processInfo : procInfos) {
                if (processInfo.processName.equals(packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void showProgress(String message, boolean isCancelable) {
        if (!isFinishing()) {
            //progressDialog.setMessage("");
            progressDialog.setIndeterminate(true);
            //here is the trick:
            //progressDialog.setIndeterminateDrawable(getResources().getDrawable(R.drawable.spin, null));
            progressDialog.setCancelable(isCancelable);
            progressDialog.show();
        }

    }

    public void showProgress(String message) {
        showProgress(message, false);
    }

    public void showProgressDialog(String message) {
        showProgress(message);
    }

    public void dismissProgress() {
        try {
            if (progressDialog != null) {
                if (progressDialog.isShowing())
                    progressDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setView(View view) {
        ((View) view.getParent()).setSelected(true);
        View v1 = findViewById(previously_selected_layout);
        if (v1 != null) {
            v1.setSelected(false);
        }
        previously_selected_layout = ((View) view.getParent()).getId();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(base));
    }

    public boolean popFragment() {
        Log.e("test", "pop fragment: " + getSupportFragmentManager().getBackStackEntryCount());
        boolean isPop = false;
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            isPop = true;
            // getChildFragmentManager().executePendingTransactions();
            getSupportFragmentManager().popBackStack();
            //  getChildFragmentManager().popBackStackImmediate();
            //getChildFragmentManager().
        }
        return isPop;
    }


    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate();
        } else {
            super.onBackPressed();
        }
    }


    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }


    /**
     * method to hide keyboard
     *****/
    public void hideKeyboard(Context context, View view) {
        try {
            InputMethodManager methodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            methodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch (Exception e) {
            Log.v("Exception", e.getMessage());
        }

    }

    /**
     * method to hide keyboard
     *****/
    public void hideKeyboard() {
        if(getCurrentFocus()!=null && getCurrentFocus().getWindowToken()!=null)
        {
            InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * method to show keyboard
     *****/
    public void showKeyboard(Context context) {
        InputMethodManager methodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        methodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    public void showDialog(Activity activity, String title, String msg) {
        final Dialog dialog = new Dialog(activity);
        //  dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setTitle(title);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.alertdialog);

        TextView title1 = dialog.findViewById(R.id.title);
        title1.setText(title);

        TextView text = dialog.findViewById(R.id.text_dialog);
        text.setText(msg);

        Button dialogButton = dialog.findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        if (!dialog.isShowing())
            dialog.show();
    }

    public void showBackDialog(Activity activity, String title, String msg) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.alertdialog);

        TextView title1 = dialog.findViewById(R.id.title);
        title1.setText(title);

        TextView text = dialog.findViewById(R.id.text_dialog);
        text.setText(msg);

        Button dialogButton = dialog.findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                //startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                //finish();
            }
        });
        if (!dialog.isShowing())
            dialog.show();
    }

    public void Toast(Activity activity,int message){
        currentToast = Toast.makeText(activity, message, Toast.LENGTH_SHORT);
        currentToast.show();
    }


    public void showLoadingLayout() {
        showProgressDialog("Please wait...");

    }

    public void hideLoadingLayout() {
        dismissProgress();
    }
    public void showError(String response) {
        if(!TextUtils.isEmpty(response))
            Toast.makeText(this, response, Toast.LENGTH_SHORT).show();
    }
}