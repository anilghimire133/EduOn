package com.example.eduonmenu;

import com.google.gson.annotations.SerializedName;

public class Food {

  @SerializedName("name")
  private String name;
  @SerializedName("price")
  private String price;
  @SerializedName("imageUrl")
  private String imageUrl;
  @SerializedName("category")
  private String categoty;

  public Food(String name, String price, String imageUrl, String categoty) {
    this.name = name;
    this.price = price;
    this.imageUrl = imageUrl;
    this.categoty = categoty;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPrice() {
    return price;
  }

  public void setDesc(String desc) {
    this.price = desc;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getCategoty() {
    return categoty;
  }

  public void setCategoty(String categoty) {
    this.categoty = categoty;
  }

  @Override
  public String toString() {
    return "Food{" +
        "name='" + name + '\'' +
        ", price='" + price + '\'' +
        ", imageUrl='" + imageUrl + '\'' +
        ", categoty='" + categoty + '\'' +
        '}';
  }
}

