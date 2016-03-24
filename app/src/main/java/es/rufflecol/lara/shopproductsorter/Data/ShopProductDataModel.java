package es.rufflecol.lara.shopproductsorter.Data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShopProductDataModel {

    @SerializedName("currencySymbol")
    private String currencySymbol;

    @SerializedName("products")
    private List<ShopProductData> products;

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public List<ShopProductData> getProducts() {
        return products;
    }

    public void setProducts(List<ShopProductData> products) {
        this.products = products;
    }

}