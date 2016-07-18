package com.telpa.ecommerce.activities;

import android.os.Bundle;

import com.telpa.ecommerce.R;
import com.telpa.ecommerce.helper.BaseActivity;
import com.telpa.ecommerce.tabsliders.TabHelper;
import com.telpa.ecommerce.tabsliders.TabOne;
import com.telpa.ecommerce.tabsliders.TabTwo;

import java.util.ArrayList;
import java.util.List;


public class CategoryB extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_b);
        fcreateTitle("My Store");
        fcreateToolbar(this, true, true);
        fcreateMenu(this);
        List<TabHelper> tabHelperList = new ArrayList<>();
        tabHelperList.add(new TabTwo().getTabTwo("Category A"));
        tabHelperList.add(new TabTwo().getTabTwo("Category B"));
        tabHelperList.add(new TabTwo().getTabTwo("Category C"));

        fcreateTabMenu(tabHelperList);
    }
}