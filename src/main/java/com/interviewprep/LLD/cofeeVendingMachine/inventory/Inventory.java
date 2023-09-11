package com.interviewprep.LLD.cofeeVendingMachine.inventory;

import com.interviewprep.LLD.cofeeVendingMachine.items.Item;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by subhash on 28/11/2022.
 */
public class Inventory{

    private Map<Item,Integer> inventoryMap;

    public Inventory() {
        inventoryMap = new HashMap<>();
    }


    public void addItem(Item item, int quantity){

        int availableQuantity = inventoryMap.getOrDefault(item,0);
        inventoryMap.put(item,quantity+availableQuantity);

    }

    public void useItem(Item item, int requiredQuantity) throws Exception {

        int availableQuantity = inventoryMap.getOrDefault(item,0);
        if(requiredQuantity>availableQuantity){
            throw new Exception("Enough item not available in inventory");
        }
        availableQuantity = availableQuantity-requiredQuantity;
        inventoryMap.put(item,availableQuantity);

    }

    public Map<Item,Integer> getInventory(){
        return inventoryMap;
    }


}
