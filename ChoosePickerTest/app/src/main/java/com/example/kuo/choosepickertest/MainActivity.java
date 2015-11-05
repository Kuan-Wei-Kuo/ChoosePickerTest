package com.example.kuo.choosepickertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ChoosePikcer choosePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initChooseItem();
        choosePicker = (ChoosePikcer) findViewById(R.id.choosePicker);
        choosePicker.setChooseItems(chooseItems);
        choosePicker.setFragmentManager(getSupportFragmentManager());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    ArrayList<ChooseItem> chooseItems = new ArrayList<>();

    private void initChooseItem() {

        String[] chooseTexts = {"餐點", "飲料", "零時", "購物", "日常", "帳單", "住房", "車馬", "娛樂",
                "禮物", "髮型", "醫療", "信用卡", "投資", "轉帳", "其他"};

        for(int i = 0 ; i < chooseTexts.length ; i++) {
            ChooseItem chooseItem = new ChooseItem();
            chooseItem.setChooseIcon(R.mipmap.ic_launcher);
            chooseItem.setChooseText(chooseTexts[i]);
            chooseItems.add(chooseItem);
        }
    }
}
