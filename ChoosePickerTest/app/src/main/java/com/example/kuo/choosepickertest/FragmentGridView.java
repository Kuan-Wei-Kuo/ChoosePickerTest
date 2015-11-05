package com.example.kuo.choosepickertest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Kuo on 2015/11/4.
 */
public class FragmentGridView extends Fragment {

    private ChooseGridView chooseGridView;
    private ChoosePickerGridAdapter choosePickerGridAdapter;
    private ArrayList<ChooseItem> chooseItems = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gridview, container, false);
        view.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
        //findView(view);
        //initView();

        return  view;
    }

    private void findView(View view) {
        chooseGridView = (ChooseGridView) view.findViewById(R.id.chooseGridView);
    }

    private void initView() {

        choosePickerGridAdapter = new ChoosePickerGridAdapter(getActivity(), chooseItems);

        chooseGridView.setNumColumns(5);
        chooseGridView.setAdapter(choosePickerGridAdapter);
        chooseGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(view.getContext(), "" + i, Toast.LENGTH_SHORT).show();

                choosePickerGridAdapter.setFocus(i, true);
                choosePickerGridAdapter.notifyDataSetChanged();

            }
        });

    }

    public void setChooseItems(ArrayList<ChooseItem> chooseItems) {
        this.chooseItems = chooseItems;
    }

    public void addChooseItems(ChooseItem chooseItem) {
        this.chooseItems.add(chooseItem);
    }
}
