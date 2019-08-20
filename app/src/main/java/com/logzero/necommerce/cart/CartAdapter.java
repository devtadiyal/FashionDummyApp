package com.logzero.necommerce.cart;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.logzero.necommerce.R;
import com.logzero.necommerce.productdetail.ProductDetailsActivity;
import com.logzero.necommerce.womenselection.fragment.ShoesModel;
import java.util.ArrayList;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private ArrayList<ShoesModel> android;
    private Context context;

    public CartAdapter(Context context, ArrayList<ShoesModel> android) {
        this.android = android;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.cartlist, viewGroup, false);
        return new CartAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CartAdapter.ViewHolder viewHolder, int i) {

        viewHolder.productname.setText(android.get(i).getName());
        viewHolder.productsubtitle.setText(android.get(i).getSubtitle());
        viewHolder.price.setText(android.get(i).getPrice());
        viewHolder.discountprice.setText(android.get(i).getPrice());
        Glide.with(context).load(android.get(i).getImage()).into(viewHolder.productimage);


    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView productname, productsubtitle,
                price, discountprice,edit,remove;
        LinearLayout opendetails;
        ImageView productimage;

        public ViewHolder(View view) {
            super(view);

            productname = view.findViewById(R.id.productname);
            productsubtitle = view.findViewById(R.id.productsubtitle);
            price = view.findViewById(R.id.price);
            discountprice = view.findViewById(R.id.discountprice);
            productimage = view.findViewById(R.id.productimage);
            opendetails = view.findViewById(R.id.opendetails);
            remove = view.findViewById(R.id.remove);
            edit = view.findViewById(R.id.edit);

            remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    android.remove(0);
                    notifyDataSetChanged();
                }
            });

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            opendetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }
    }
}
