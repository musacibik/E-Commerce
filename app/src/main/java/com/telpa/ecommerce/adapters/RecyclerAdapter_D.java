package com.telpa.ecommerce.adapters;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.telpa.ecommerce.R;
import com.telpa.ecommerce.models.Product;

import java.util.ArrayList;


/**
 * Created by volkan on 14.07.2016.
 */

public class RecyclerAdapter_D extends RecyclerView.Adapter<RecyclerAdapter_D.ViewHolder> {

    private int amountOfData;
    private int id;
    private ArrayList<Product> products;
    public RecyclerAdapter_D(int amountOfData, int id,ArrayList<Product> products) {
        this.amountOfData = amountOfData;
        this.id = id;
        this.products=products;

    }

    @Override
    public RecyclerAdapter_D.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(id, parent, false);

        RecyclerAdapter_D.ViewHolder viewHolder = new RecyclerAdapter_D.ViewHolder(v);
        new SpaceItemDecoration(300);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //TODO
//      holder.productName.setText(products.get(position).getName());
        holder.productName.setText("Name " + position);
        holder.price.setText("$50");
        holder.image.setImageResource(R.drawable.ic_circle_white);

    }

    @Override
    public int getItemCount() {
        return amountOfData;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView productName;
        public TextView price;
        public ImageButton image;

        public ViewHolder(View v) {
            super(v);

            productName = (TextView) v.findViewById(R.id.productName);
            price = (TextView) v.findViewById(R.id.price);
            image = (ImageButton) v.findViewById(R.id.imageButton);
        }
    }

    public static class SpaceItemDecoration extends RecyclerView.ItemDecoration {

        int space = 0;

        public SpaceItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;


        }
    }

}
