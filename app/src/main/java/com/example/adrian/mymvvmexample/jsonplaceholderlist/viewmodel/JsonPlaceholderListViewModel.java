package com.example.adrian.mymvvmexample.jsonplaceholderlist.viewmodel;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.example.adrian.mymvvmexample.base.BaseViewModel;
import com.example.adrian.mymvvmexample.jsonplaceholderlist.model.JsonPlaceholderListModel;
import com.example.adrian.mymvvmexample.jsonplaceholderlist.model.TestData;
import com.example.adrian.mymvvmexample.jsonplaceholderlist.view.JsonPlaceholderListActivity;
import com.example.adrian.mymvvmexample.jsonplaceholderlist.viewpager.ViewPagerAdapter;

/**
 * Created by Adrian_Czigany on 3/27/2017.
 */

public class JsonPlaceholderListViewModel extends BaseViewModel<JsonPlaceholderListActivity> {

    private JsonPlaceholderListModel jsonPlaceholderListModel;

    private Toolbar toolbar;

    private ViewPager viewPager;

    private TabLayout tabLayout;

    public JsonPlaceholderListViewModel(JsonPlaceholderListActivity jsonPlaceholderListActivity, JsonPlaceholderListModel jsonPlaceholderListModel) {
        super(jsonPlaceholderListActivity);
        this.jsonPlaceholderListModel = jsonPlaceholderListModel;

        init();
    }

    private void init() {
        toolbar = getActivity().getBinding().toolbar;
        viewPager = getActivity().getBinding().viewPager;
        tabLayout = getActivity().getBinding().tabLayout;

        getActivity().setSupportActionBar(toolbar);
        viewPager.setAdapter(new ViewPagerAdapter(getActivity(), TestData.getDataModelList(), TestData.getTitles()));
        tabLayout.setupWithViewPager(viewPager);
    }

}