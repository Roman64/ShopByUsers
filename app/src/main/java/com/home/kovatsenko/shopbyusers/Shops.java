package com.home.kovatsenko.shopbyusers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Shops implements Serializable {

    private static HashMap<Integer, ArrayList<String>> shop;
    private static Shops instance;
    private static int id;

    private Shops(){
        id = 1;
        shop = new HashMap<>();
        String name = "Apple";
        String address = "г. Саратов, ТЦ \"Happy-Moll\"";
        String boss = "Роман Коваценко";

        ArrayList<String> info = new ArrayList<>();
        info.add(name);
        info.add(address);
        info.add(boss);

        shop.put(id,info);
    }

    public static Shops getInstance(){
        if (null == instance){
            instance = new Shops();
        }
        return instance;
    }

    public static void addShop(String shopName, String address, String boss) {
        if (shopName != null) {
            ArrayList<String> info = new ArrayList<>();
            info.add(shopName);
            info.add(address);
            info.add(boss);

            id += 1;
            shop.put(id,info);
        }
    }

    public static void addShop(String shopName) {
        addShop(shopName, "Неизвестно", "Kovatsenko Roman");
    }

    public static String getShopName(String key) {
        if (shop.containsKey(key)) {
            return shop.get(key).get(0);
        } else return "Неизвестно";
    }

    public static String getShopAddress(String key) {
        if (shop.containsKey(key)) {
            return shop.get(key).get(1);
        } else return "Неизвестно";
    }

    public static String getShopBoSS(String key) {
        if (shop.containsKey(key)) {
            return shop.get(key).get(2);
        } else return "Неизвестно";
    }


    public static HashMap<Integer, ArrayList<String>> getUsersMap() {
        return shop;
    }


}

