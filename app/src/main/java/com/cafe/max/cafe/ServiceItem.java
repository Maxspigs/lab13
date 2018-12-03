package com.cafe.max.cafe;
import java.util.ArrayList;
import java.util.List;

public class ServiceItem {
    private ArrayList<Item> items = new ArrayList<Item>();
    private CafeView vCafe;
    private ListAdpateur adapteur;

    public void initItem(){
        items.add(new Item( "Lait ecreme", 1, R.layout.quantite_text));
        items.add(new Item( R.drawable.sucre, 2, R.layout.quantite_image));
        items.add(new Item("Splenda", 1, R.layout.quantite_text));
        items.add(new Item( R.drawable.sucre_brut, 2, R.layout.quantite_image));
        items.add(new Item("Creme 10%", 1, R.layout.quantite_text));
        items.add(new Item("Chocolat", 3, R.layout.choix_text));
        items.add(new Item( R.drawable.cannelle, 4, R.layout.choix_image));
        items.add(new Item( R.drawable.lait_entier, 2, R.layout.quantite_image));
        items.add(new Item( R.drawable.creme_fouette, 4, R.layout.choix_image));
    }

    public List<Item> getList(){
        return items.subList(0, items.size()-1);
    }

    public Item getItem(int i){
        return items.get(i);
    }

    public void setItem(int i, Item item){
        items.set(i, item);
        notice();
    }

    public void setCafe(CafeView vCafe){
        this.vCafe = vCafe;
    }

    public void notice(){
        int element = items.get(0).count + items.get(4).count + items.get(7).count;
        if(items.get(8).checkbox == true){
            vCafe.setColor(0xffffffff);
        }else if(element >=2 ){
            vCafe.setColor(0xffe2d19e);
        }else if(element == 1){
            vCafe.setColor(0xffceb97b);

        }else{
            vCafe.setColor(0xff000000);
        }
        vCafe.invalidate();
        adapteur.showNotifyDataSetChanged();
    }


    public void setAdapteur(ListAdpateur adapteur){
        this.adapteur = adapteur;
    }
}
