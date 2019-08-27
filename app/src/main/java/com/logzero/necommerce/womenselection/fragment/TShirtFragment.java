package com.logzero.necommerce.womenselection.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.logzero.necommerce.R;
import com.logzero.necommerce.allproductmodel.AllProduct;
import com.logzero.necommerce.allproductmodel.AllProductImp;
import com.logzero.necommerce.allproductmodel.AllProductsPresenter;
import com.logzero.necommerce.utility.Data;
import com.logzero.necommerce.utility.ItemClickListener;
import com.logzero.necommerce.womenselection.AllProductAdapter;
import com.woocommerse.OAuth1.services.HMACSha1SignatureService;
import com.woocommerse.OAuth1.services.TimestampServiceImpl;

import java.util.ArrayList;
import java.util.List;


public class TShirtFragment extends Fragment implements AllProductsPresenter.View{
    RecyclerView recyclerView;
    AllProductImp allProductImp;
    List<AllProduct> allProducts;
    public TShirtFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tshirt, container,
                false);
        recyclerView = view.findViewById(R.id.rv);
        allProductImp = new AllProductImp(this);
        getallproductrequest();
        initViews();


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(),
                recyclerView, new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {


            }

            @Override
            public void onLongClick(View view, int position) {
                //Toast.makeText(context, String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        }));
    return view;
    }

    private void initViews() {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager =
                new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);
       // ArrayList<ShoesModel> androidVersions = prepareData();


    }

    private ArrayList<ShoesModel> prepareData() {

        ArrayList<ShoesModel> android_version = new ArrayList<>();
        for (int i = 0; i < Data.boots_image.length; i++) {
            ShoesModel androidVersion = new ShoesModel();
            androidVersion.setName(Data.boot_name[i]);
            androidVersion.setImage(Data.boots_image[i]);
            androidVersion.setSubtitle(Data.boot_subtitle[i]);
            androidVersion.setPrice(Data.boot_price[i]);
            android_version.add(androidVersion);
        }
        return android_version;
    }

    @Override
    public void getAllProducts(List response) {
        AllProductAdapter adapter = new AllProductAdapter(getContext(),
                response,"TShirtFragment");
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void errorProducts(String error) {

    }

    @Override
    public void showError(String response) {

    }

    @Override
    public void showLoadingLayout() {

    }

    @Override
    public void hideLoadingLayout() {

    }

    public static class RecyclerTouchListener implements
            RecyclerView.OnItemTouchListener {

        private ItemClickListener clicklistener;
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(Context context, final RecyclerView recycleView, final ItemClickListener clicklistener) {
            this.clicklistener = clicklistener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recycleView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clicklistener != null) {
                        clicklistener.onLongClick(child, recycleView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clicklistener != null && gestureDetector.onTouchEvent(e)) {
                clicklistener.onClick(child, rv.getChildAdapterPosition(child));
            }
            return false;
        }


        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }
    public void getallproductrequest() {

        final String nonce = new TimestampServiceImpl().getNonce();
        final String timestamp = new TimestampServiceImpl().getTimestampInSeconds();

        // GENERATED NONCE and TIME STAMP
        Log.d("nonce", nonce);
        Log.d("time", timestamp);

        String firstEncodedString = Data.METHORD + "&"
                + Data.encodeUrl(Data.BASE_URL);
        Log.d("firstEncodedString", firstEncodedString);

        String parameterString = "oauth_consumer_key=" + Data.COSTUMER_KEY +
                "&oauth_nonce=" + nonce +
                "&oauth_signature_method=HMAC-SHA1" +
                "&" + "oauth_timestamp=" + timestamp +
                "&oauth_version=1.0";
        String secoundEncodedString = "&" + Data.encodeUrl(parameterString);

        Log.d("secoundEncodedString", secoundEncodedString);


        String baseString = firstEncodedString + secoundEncodedString;

        //THE BASE STRING AND COSTUMER_SECRET KEY IS USED FOR GENERATING SIGNATURE
        Log.d("baseString", baseString);

        String signature = new HMACSha1SignatureService().getSignature(baseString, Data.COSTUMER_SECRET, "");
        Log.d("SignatureBefore", signature);

        //Signature is encoded before parsing (ONLY FOR THIS EXAMPLE NOT NECESSARY FOR LIB LIKE RETROFIT,OKHTTP)
        signature = Data.encodeUrl(signature);

        Log.d("SignatureAfter ENCODING", signature);

        final String finalSignature = signature;//BECAUSE I PUT IN SIMPLE THREAD NOT NECESSARY


        new Thread() {
            @Override
            public void run() {

                //  THIS IS A VERY BASIC EXAMPLE OF PARSING USER CAN USE ANY LATEST METHORD RETROFIT,OKHTTP,VOLLEY ETC
                String filterid = "filter[categories]=gedgets";
                filterid = Data.encodeUrl(filterid);

                String parseUrl = Data.BASE_URL + "?" + "&" +
                        "oauth_signature_method=HMAC-SHA1" +
                        "&oauth_consumer_key=" + Data.COSTUMER_KEY + "" +
                        "&oauth_version=1.0" +
                        "&oauth_timestamp=" + timestamp + "" +
                        "&oauth_nonce=" + nonce + "" +
                        "&oauth_signature=" + finalSignature;

                System.out.println("PARSE URL " + parseUrl);


                allProductImp.allproduct(
                        Data.COSTUMER_KEY,
                        "HMAC-SHA1",
                        timestamp,
                        nonce,
                        "1.0",
                        finalSignature);
                // getJSON(parseUrl);

            }
        }.start();


    }
}
