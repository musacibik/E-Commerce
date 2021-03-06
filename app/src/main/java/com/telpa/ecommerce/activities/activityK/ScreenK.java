package com.telpa.ecommerce.activities.activityK;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.telpa.ecommerce.ECommerceApp;
import com.telpa.ecommerce.R;
import com.telpa.ecommerce.adapters.RecyclerAdapter;
import com.telpa.ecommerce.adapters.RecyclerAdapter_KLComment;
import com.telpa.ecommerce.adapters.ViewPagerAdapterK;
import com.telpa.ecommerce.interfaces.IBasket;
import com.telpa.ecommerce.interfaces.ICategory;
import com.telpa.ecommerce.interfaces.IProduct;
import com.telpa.ecommerce.models.Comment;
import com.telpa.ecommerce.models.Product;
import com.telpa.ecommerce.network.APIService;
import com.telpa.ecommerce.utils.BaseActivity;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScreenK extends BaseActivity implements IScreenKView {
    //TODO
    public TextView productName;
    public TextView price;
    public TextView description;
    public RatingBar ratingBar;
    public TextView reviewsCount;
    @Inject
    IBasket basket;
    @Inject
    APIService service;
    @Inject
    IProduct product;
    @Inject
    ICategory category;
    @BindView(R.id.searchButton)
    ImageButton searchButton;
    @BindView(R.id.basketButton)
    ImageButton basketButtonMenu;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.radio_text)
    RadioGroup group;
    @BindView(R.id.radio_l_2)
    RadioGroup group2;
    @BindView(R.id.button2)
    Button addbasket;
    @BindView(R.id.button)
    Button addfavorite;
    ViewPager pager;
    private IScreenKPresenter screenKPresenter;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    private RecyclerView.LayoutManager recyclerLayoutManager;
    private ArrayList<Comment> comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_k);
        screenKPresenter=new ScreenKPresenter(this,getApplication());
        ((ECommerceApp) getApplication()).getComponent().inject(this);
        ButterKnife.bind(this);
        screenKPresenter.RadioGroup(group,group2);
        //TODO
        fcreateTitle("");
        fcreateToolbar(this, true, true, false, R.id.toolbar);
        fcreateMenu(this, true);

        pager = (ViewPager) findViewById(R.id.viewPagerK);
        pager.setAdapter(new ViewPagerAdapterK(getSupportFragmentManager(), 4));
/*
        TitlePageIndicator titlePageIndicator = (TitlePageIndicator)findViewById(R.id.viewPagerIndicatorK);
        titlePageIndicator.setViewPager(pager);
  */
        CirclePageIndicator mIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        mIndicator.setViewPager(pager);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_k);
        recyclerView.setHasFixedSize(true);

        recyclerLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(recyclerLayoutManager);

        recyclerView.addItemDecoration(new RecyclerAdapter.SpaceItemDecoration(10));
        recyclerAdapter = new RecyclerAdapter_KLComment(ScreenK.this,screenKPresenter.fillList().size(), R.layout.item_l_comment, screenKPresenter.fillList());
        recyclerView.setAdapter(recyclerAdapter);


        //TODO
        productName = (TextView) findViewById(R.id.bigProductName);
        price = (TextView) findViewById(R.id.bigPrice);
        description = (TextView) findViewById(R.id.description);
        reviewsCount=(TextView) findViewById(R.id.reviews);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        Product product=(Product) getIntent().getSerializableExtra("product");

        productName.setText(product.getName());
        price.setText("$"+product.getPrice());
        description.setText(product.getDescripton());
        reviewsCount.setText(""+product.getReviews());
        ratingBar.setRating(product.getRating());


    }


    @OnClick({R.id.searchButton, R.id.basketButton,R.id.button2,R.id.button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.searchButton:
                break;
            case R.id.basketButton:
                break;
            case R.id.button2:
                ShowAddBasket();
                break;
            case R.id.button:
                ShowAddFavorite();
                break;

        }
    }

    @Override
    public void ShowAddBasket() {

        service.addBasket(10,screenKPresenter.basketitem());
    }

    @Override
    public void ShowAddFavorite() {
        service.addFavorites(10,screenKPresenter.favoritem());
    }
}
