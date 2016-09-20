package com.ramadhan.robby.indoorgarden.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Defines the data structure for ShoppingListItem objects.
 */
public class Modules {
    private int plantId;
    private String plantName;
    private String plantDate;

    /**
     * Required public constructor
     */
    public Modules() {
    }

    /**
     * Use this constructor to create new ShoppingListItem.
     * Takes shopping list item name and list item owner email as params
     *
     * @param
     * @param
     */
    public Modules (int plantId, String plantName, String plantDate) {
        this.plantId = plantId;
        this.plantName = plantName;
        this.plantDate = plantDate;
    }

    public int getId () {
        return plantId ;
    }

    public String getPlantName() {
        return plantName;
    }

    public String getPlantDate() {
        return plantDate;
    }

    public Modules(int tanaman){
        switch (tanaman){
            case 1 : plantName = "Lettuce"; break;
            case 2 : plantName = "Basella"; break;
            case 3 : plantName = "Cabbage"; break;
            default: plantName = "Lettuce";
        }

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        this.plantDate = format.format(new Date()).toString() ;
    }
}
