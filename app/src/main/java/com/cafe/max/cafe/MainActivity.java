 package com.cafe.max.cafe;

 import android.graphics.Color;
 import android.support.annotation.Nullable;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;
 import android.widget.ListView;

 public class MainActivity extends AppCompatActivity {

     private ListAdpateur listAdpateur;
     private CafeView cafeView;
     private ServiceItem serviceItem;

     @Override
     protected void onCreate(@Nullable Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         ListView listView = findViewById(R.id.listView);
         listAdpateur = new ListAdpateur(this);
         serviceItem = new ServiceItem();
         serviceItem.initItem();
         listAdpateur.addAll(serviceItem.getList());
         listAdpateur.setItemService(serviceItem);
         listView.setAdapter(listAdpateur);
         serviceItem.setAdapteur(listAdpateur);
         cafeView = findViewById(R.id.canvasView);
         cafeView.setColor(Color.BLACK);
         serviceItem.setCafe(cafeView);
     }
 }
