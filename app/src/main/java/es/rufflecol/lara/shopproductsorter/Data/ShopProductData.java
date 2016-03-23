package es.rufflecol.lara.shopproductsorter.Data;

import com.google.gson.annotations.SerializedName;

public class ShopProductData {

    @SerializedName("name")
    private String name;

    @SerializedName("price")
    private String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
