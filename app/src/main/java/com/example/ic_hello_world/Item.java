package com.example.ic_hello_world;

public class Item {

    private String name;
    private Long date;
    private String price;
    private Boolean sold = false;

    public Item(){}
    public Item(String name, long date,String price){
        this.name = name;
        this.date = date;
        this.price = price;
    }

    public Item(String name, long date,String price,boolean sold){
        this.name = name;
        this.date = date;
        this.price = price;
        this.sold = sold;
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

    public Boolean getSold() {
        return sold;
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

    public void setSold(boolean sold){this.sold = sold;}


}
