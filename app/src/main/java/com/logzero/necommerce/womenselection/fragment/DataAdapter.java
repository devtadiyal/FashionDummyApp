package com.logzero.necommerce.womenselection.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.logzero.necommerce.R;
import com.logzero.necommerce.productdetail.ProductDetailsActivity;

import java.util.ArrayList;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<ShoesModel> android;
    private Context context;
    String fragname;
    int count = 1;

    public DataAdapter(Context context, ArrayList<ShoesModel> android,String fragname) {
        this.android = android;
        this.context = context;
        this.fragname = fragname;
    }



    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.commonlist, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.productname.setText(android.get(i).getName());
        viewHolder.productsubtitle.setText(android.get(i).getSubtitle());
        viewHolder.price.setText(android.get(i).getPrice());
        viewHolder.discountprice.setText(android.get(i).getPrice());
        viewHolder.discountprice.setPaintFlags(viewHolder.discountprice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        Glide.with(context).load(android.get(i).getImage()).into(viewHolder.productimage);

        viewHolder.opendetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i == 0) {
                   Intent intent = new Intent(context, ProductDetailsActivity.class);
                   intent.putExtra("frag",fragname);
                   context.startActivity(intent);
                }
            }
        });

        viewHolder.increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i == 0) {
                    if (count >= 1) {
                        count--;
                        viewHolder.quantity.setText(String.valueOf(count));
                    }
                }
            }
        });

        viewHolder.decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i == 0) {
                    count++;
                    viewHolder.quantity.setText(String.valueOf(count));
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView productname, productsubtitle, quantity, price, discountprice;
        private Button increment, decrement;
        LinearLayout opendetails, linearLayout;
        ImageView productimage;

        public ViewHolder(View view) {
            super(view);

            productname = view.findViewById(R.id.productname);
            productsubtitle = view.findViewById(R.id.productsubtitle);
            quantity = view.findViewById(R.id.quantity);
            price = view.findViewById(R.id.price);
            discountprice = view.findViewById(R.id.discountprice);
            increment = view.findViewById(R.id.increment);
            decrement = view.findViewById(R.id.decrement);
            productimage = view.findViewById(R.id.productimage);
            opendetails = view.findViewById(R.id.opendetails);

        }
    }

}