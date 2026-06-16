package com.interviewprep.lld.cofeeVendingMachine;

import com.interviewprep.lld.cofeeVendingMachine.inventory.Inventory;
import com.interviewprep.lld.cofeeVendingMachine.items.Coffe;
import com.interviewprep.lld.cofeeVendingMachine.items.Item;
import com.interviewprep.lld.cofeeVendingMachine.items.Milk;
import com.interviewprep.lld.cofeeVendingMachine.products.Cappuccino;
import com.interviewprep.lld.cofeeVendingMachine.products.Expresso;
import com.interviewprep.lld.cofeeVendingMachine.products.Latte;
import com.interviewprep.lld.cofeeVendingMachine.products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by subhash on 28/11/2022.
 */
public class MainApplication {

    private Inventory itemInventory;

    public MainApplication(){
        this.itemInventory = new Inventory();
    }

    private double makeProduct(String name, List<Item> addOns) throws Exception{

        double price = 0;
        Product p = new Expresso();
        if(name.equals("Expresso")){

            p = new Expresso();
            price = p.getBasePrice();
        }
        if(name.equals("Cappuccino")){

            p = new Cappuccino();
            price = p.getBasePrice();
        }
        if(name.equals("Latte")){

            p = new Latte();
            price = p.getBasePrice();
        }
        for(Item item : addOns){
            p.addIngredients(item,1);
            price = price+item.getPrice();
        }

        p.getIngredeinets().forEach((key,value)->{
            try {
                itemInventory.useItem(key,value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return price;

    }

    public void showInventory(){
        Map<Item,Integer> inventory = itemInventory.getInventory();
        inventory.forEach((key,value)->{
            System.out.print(key);
            System.out.println(" Quantity =  "+value);
        });
    }
    public static void main(String[] args) throws Exception {

        MainApplication mainApplication = new MainApplication();

        mainApplication.itemInventory.addItem(new Coffe(),10);
        mainApplication.itemInventory.addItem(new Coffe(),10);
        mainApplication.itemInventory.addItem(new Coffe(),10);
        mainApplication.itemInventory.addItem(new Milk(),10);
        mainApplication.itemInventory.addItem(new Milk(),10);

        System.out.println(mainApplication.makeProduct("Expresso", new ArrayList<>()));
        mainApplication.showInventory();


    }


}
