package com.example.ic_hello_world;

import java.util.ArrayList;
import java.util.List;

public class UserItem {

    private String UUID;
    private List<Item> items = new ArrayList<>();

    public UserItem(String UUID) {
        this.UUID = UUID;
    }

    public String getUUID() {
        return UUID;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

}
