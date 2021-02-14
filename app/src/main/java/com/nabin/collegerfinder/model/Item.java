package com.nabin.collegerfinder.model;

public class Item {
    private String CollegeName;
    private int Location;
    private String detail;
    private String image;

    public Item(String itemname, int price, String detail, String image) {
        this.CollegeName = itemname;
        this.Location = price;
        this.detail = detail;
        this.image = image;
    }

    public String getItemName() {
        return CollegeName;
    }

    public void setItemName(String itemname) {
        this.CollegeName = itemname;
    }

    public int getPrice() {
        return Location;
    }

    public void setPrice(int price) {
        this.Location = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
