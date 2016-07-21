package com.telpa.ecommerce.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.telpa.ecommerce.R;
import com.telpa.ecommerce.adapters.RecyclerAdapter;
import com.telpa.ecommerce.utils.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BasketActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    private RecyclerView.LayoutManager recyclerLayoutManager;

    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_basket);
        ButterKnife.bind(BasketActivity.this);

        fcreateTitle("Your Basket");
        fcreateToolbar(this, false, true, false, R.id.include);
        fcreateMenu(this, false);

        recyclerView = (RecyclerView) findViewById(R.id.basketList);

        recyclerView.setHasFixedSize(true);
        recyclerLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(recyclerLayoutManager);

        recyclerView.addItemDecoration(new RecyclerAdapter.SpaceItemDecoration(3));
        recyclerAdapter = new RecyclerAdapter(4, R.layout.item_basket_row);
        recyclerView.setAdapter(recyclerAdapter);

        Button checkOut=(Button) findViewById(R.id.checkoutButton);
        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(BasketActivity.this, "Buy them!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
