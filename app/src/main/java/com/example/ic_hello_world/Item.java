package com.example.ic_hello_world;

public class Item {

    private String name;
    private Long date;
    private String price;
    private String uuidOwner;
    private String uuidBuyer ="";

    public Item(String uuidOwner){
        this.uuidOwner = uuidOwner;
    }


    public String getName() {
        return name;
    }

    public Long getDate() {
        return date;
    }

    public String getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUuidOwner() {
        return uuidOwner;
    }

    public String getUuidBuyer() {
        return uuidBuyer;
    }

    public void setUuidBuyer(String uuidBuyer) {
        this.uuidBuyer = uuidBuyer;
    }
}
