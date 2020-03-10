package com.example.androideatit.ViewHolder;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.androideatit.Interface.ItemClickListener;
import com.example.androideatit.Model.Order;
import com.example.androideatit.R;

import java.text.Format;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView cartItemName, cartItemPrice;
    public ImageView cartItemCount;

    private ItemClickListener itemClickListener;

    public CartViewHolder(@NonNull View itemView, TextView cartItemName) {
        super(itemView);
        this.cartItemName = cartItemName;
    }

    public CartViewHolder(@NonNull View itemView) {
        super(itemView);

        cartItemName = itemView.findViewById(R.id.cart_item_name);
        cartItemPrice = itemView.findViewById(R.id.cart_item_price);
        cartItemCount = itemView.findViewById(R.id.cart_item_count);
    }

    @Override
    public void onClick(View v) {

    }
}

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {

    private List<Order> listData = new ArrayList<>();
    private Context context;

    public CartAdapter(List<Order> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.cart_layout, parent, false);
        return new CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

        //set drawable for quantity
        TextDrawable drawable = TextDrawable.builder()
                .buildRound("" + listData.get(position).getQuantity(), Color.RED);
        holder.cartItemCount.setImageDrawable(drawable);

        Locale locale = new Locale("en", "US");
        Format format = NumberFormat.getCurrencyInstance(locale);
        int price = (Integer.parseInt(listData.get(position).getPrice()))
                * (Integer.parseInt(listData.get(position).getQuantity()));

        //set texts
        holder.cartItemName.setText(listData.get(position).getProductName());
        holder.cartItemPrice.setText(format.format(price));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}
