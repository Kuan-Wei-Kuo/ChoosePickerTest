package com.example.kuo.choosepickertest;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by Kuo on 2015/11/5.
 */
public class ChoosePikcer extends LinearLayout {

    private ArrayList<ChooseItem> chooseItems = new ArrayList<>();
    private ViewPagerAdapter viewPagerAdapter;
    private ArrayList<Fragment> fragmentList = new ArrayList<>();
    private ArrayList<String> titleList = new ArrayList<>();

    private FragmentManager fragmentManager;

    public ChoosePikcer(Context context) {
        super(context);
    }

    public ChoosePikcer(Context context, AttributeSet attrs) {
        super(context, attrs);
        onCreateView();
    }

    private void onCreateView() {

        setOrientation(VERTICAL);
        onCreateViewPager();

    }

    ViewPager viewPager;
    private void onCreateViewPager() {

        ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;

        viewPager = new ViewPager(getContext());
        viewPager.setId(0);
        viewPager.setLayoutParams(layoutParams);
        this.addView(viewPager);

        Log.d("ChoosePicjer", "Created ViewPager");
    }

    private void onCreateCircleView() {

        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(HORIZONTAL);

        for(int i = 0 ; i < fragmentList.size() ; i++) {
            CircleView circleView = new CircleView(getContext());
        }

        this.addView(linearLayout);
    }

    private void initListItem() {

        int size = chooseItems.size();
        int fragmentSize = size / 10;

        addTenItemFragment(fragmentSize);

        if(size - (fragmentSize*10)  != 0) {
            FragmentGridView fragmentGridView = new FragmentGridView();
            for(int i = fragmentSize*10 ; i < size; i++) {
                fragmentGridView.addChooseItems(chooseItems.get(i));
            }
            fragmentList.add(fragmentGridView);
            titleList.add("Pager-" + fragmentSize);
        }
    }

    private void addTenItemFragment(int size) {
        for(int i = 0 ; i < size ; i++) {
            FragmentGridView fragmentGridView = new FragmentGridView();
            for(int j = i * 10 ; j < (i * 10) + 10 ; j++) {
                fragmentGridView.addChooseItems(chooseItems.get(j));
            }
            fragmentList.add(fragmentGridView);
            titleList.add("Pager-" + i);
        }
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
        //initListItem();
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        ArrayList<String> titleList = new ArrayList<>();

        fragmentList.add(new FragmentGridView());
        fragmentList.add(new FragmentGridView());
        titleList.add("Pager-0");
        titleList.add("Pager-1");

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(fragmentManager, fragmentList, titleList);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(viewPagerAdapter);
        Log.d("fragmentList", fragmentList.size() + "");
    }

    public void setChooseItems(ArrayList<ChooseItem> chooseItems) {
        this.chooseItems = chooseItems;
    }

    public ArrayList<ChooseItem> getChooseItems() {
        return chooseItems;
    }

    public ChooseItem getChooseItems(int index) {
        return chooseItems.get(index);
    }

    public int getSize() {
        return chooseItems.size();
    }
}
