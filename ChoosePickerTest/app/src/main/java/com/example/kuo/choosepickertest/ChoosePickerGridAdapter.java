package com.example.kuo.choosepickertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kuo on 2015/10/20.
 */
public class ChoosePickerGridAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ChooseItem> chooseItems = new ArrayList<>();

    public ChoosePickerGridAdapter(Context context, ArrayList<ChooseItem> chooseItems) {
        this.context = context;
        this.chooseItems = chooseItems;
    }

    @Override
    public int getCount() {
        return chooseItems.size();
    }

    @Override
    public Object getItem(int i) {
        return chooseItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    int oldFocusIndex = 0;

    public void setFocus(int index, boolean i) {
        chooseItems.get(oldFocusIndex).setFocus(false);
        chooseItems.get(index).setFocus(i);
        oldFocusIndex = index;
    }

    public ChooseItem getFocusItem() {
        return chooseItems.get(oldFocusIndex);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, null);
        TextView chooseText = (TextView) convertView.findViewById(R.id.chooseText);
        ImageView chooseIcon = (ImageView) convertView.findViewById(R.id.chooseIcon);
        LinearLayout chooseLayout = (LinearLayout) convertView.findViewById(R.id.chooseLayout);

        ChooseItem chooseItem = chooseItems.get(i);

        chooseText.setText(chooseItem.getChooseText());
        chooseIcon.setBackgroundResource(chooseItem.getChooseIcon());

        if(chooseItem.getFocus()) {
            chooseLayout.setBackgroundColor(context.getResources().getColor(R.color.material_blue_grey_800));
        } else {
            chooseLayout.setBackgroundColor(context.getResources().getColor(android.R.color.transparent));
        }

        return convertView;
    }
}
