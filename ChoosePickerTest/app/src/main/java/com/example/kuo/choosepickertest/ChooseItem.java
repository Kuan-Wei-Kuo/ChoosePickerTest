package com.example.kuo.choosepickertest;

/**
 * Created by Kuo on 2015/10/20.
 */
public class ChooseItem {

    private String chooseText = "";
    private int chooseIcon = 0;
    private boolean isFocus = false;

    public void setChooseIcon(int chooseIcon) {
        this.chooseIcon = chooseIcon;
    }

    public void setChooseText(String chooseText) {
        this.chooseText = chooseText;
    }

    public void setFocus(boolean isFocus) {
        this.isFocus = isFocus;
    }

    public String getChooseText() {
        return chooseText;
    }

    public int getChooseIcon() {
        return chooseIcon;
    }

    public boolean getFocus() {
        return isFocus;
    }
}
