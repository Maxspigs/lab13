package com.cafe.max.cafe;

import android.view.View;

public class Item {
    String tag;
    int count;
    int image;
    String text;
    boolean checkbox;
    int type;
    int typeLayout;

    public Item(int image, int type, int typeLayout) {
        super();
        this.tag = tag;
        this.image = image;
        text = "";
        this.type = type;
        this.typeLayout = typeLayout;
        count = 0;
        checkbox = false;
    }

    public Item(String text, int type, int typeLayout) {
        super();
        this.text = text;
        image = -1;
        this.type = type;
        this.typeLayout = typeLayout;
        count = 0;
        checkbox = false;
    }

    public void onClickPlus(View v){
        count++;
    }

    public void onClickMoins(View v){
        count--;
    }


}
