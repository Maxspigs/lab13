package com.cafe.max.cafe;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdpateur extends ArrayAdapter<Item> {
    Context context;
    private ServiceItem serviceItem;

    public ListAdpateur(@NonNull Context context){
        super(context, R.layout.quantite_text);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        int type = serviceItem.getItem(position).type;
        if(convertView == null){
            int typeLayout = serviceItem.getItem(position).typeLayout;
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(typeLayout, parent, false);

            if(type == 1){
                TextView count = convertView.findViewById(R.id.quantite1);
                Button moins = convertView.findViewById(R.id.moins1);
                Button plus = convertView.findViewById(R.id.plus1);
                count.setText(String.valueOf(serviceItem.getItem(position).count));

                plus.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Item item1 = serviceItem.getItem(position);
                        item1.count++;
                        serviceItem.setItem(position, item1);
                    }
                });

                moins.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Item item1 = serviceItem.getItem(position);
                        if(item1.count != 0) {
                            item1.count--;
                            serviceItem.setItem(position, item1);
                        }
                        serviceItem.setItem(position, item1);
                    }
                });
                TextView titre = convertView.findViewById(R.id.item_text1);
                titre.setText(serviceItem.getItem(position).text);

            } else if (type == 2){
                TextView count = convertView.findViewById(R.id.quantite2);
                Button moins = convertView.findViewById(R.id.moins2);
                Button plus = convertView.findViewById(R.id.plus2);
                count.setText(String.valueOf(serviceItem.getItem(position).count));
                plus.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Item item1 = serviceItem.getItem(position);
                        item1.count++;
                        serviceItem.setItem(position, item1);
                    }
                });
                moins.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Item item1 = serviceItem.getItem(position);
                        if(item1.count != 0) {
                            item1.count--;
                            serviceItem.setItem(position, item1);
                        }
                    }
                });
                ImageView imageView = convertView.findViewById(R.id.imageView2);
                imageView.setBackgroundResource(serviceItem.getItem(position).image);

            } else if (type == 3){
                CheckBox checkbox = convertView.findViewById(R.id.switch3);
                checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        Item item1 = serviceItem.getItem(position);
                        item1.checkbox = b;
                        serviceItem.setItem(position, item1);
                    }
                });
                TextView titre = convertView.findViewById(R.id.item_text3);
                titre.setText(serviceItem.getItem(position).text);

            } else if (type == 4){
                CheckBox checkbox = convertView.findViewById(R.id.switch4);
                checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        Item item1 = serviceItem.getItem(position);
                        item1.checkbox = b;
                        serviceItem.setItem(position, item1);
                    }
                });
                ImageView imageView = convertView.findViewById(R.id.imageView4);
                imageView.setBackgroundResource(serviceItem.getItem(position).image);
            }

            convertView.setTag(serviceItem.getItem(position).tag);

        } else if(type == 1){
            TextView number = convertView.findViewById(R.id.quantite1);
            if(number != null){
                number.setText(String.valueOf(serviceItem.getItem(position).count));
            }

        } else if(type == 2){
            TextView number = convertView.findViewById(R.id.quantite2);
            if(number != null) {
                number.setText(String.valueOf(serviceItem.getItem(position).count));
            }
        }
        return convertView;
    }

    public void setItemService(ServiceItem serviceItem){
        this.serviceItem = serviceItem;
    }

    public void showNotifyDataSetChanged() {
        notifyDataSetChanged();
    }
}
