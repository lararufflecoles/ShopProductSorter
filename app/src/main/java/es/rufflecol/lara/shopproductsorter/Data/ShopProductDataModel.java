package es.rufflecol.lara.shopproductsorter.Data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShopProductDataModel {

    @SerializedName("currencySymbol")
    private String currencySymbol;

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    @SerializedName("products")
    private List<ShopProductData> products;

    public List<ShopProductData> getProducts() {
        return products;
    }
}
