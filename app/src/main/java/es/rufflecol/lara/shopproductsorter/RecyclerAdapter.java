package es.rufflecol.lara.shopproductsorter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import es.rufflecol.lara.shopproductsorter.Data.ShopProductData;
import es.rufflecol.lara.shopproductsorter.Data.ShopProductDataModel;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<ShopProductData> data;
    private String getCurrencySymbol;

    public RecyclerAdapter(String getCurrencySymbol, List<ShopProductData> dataArgs) {
        this.getCurrencySymbol = getCurrencySymbol;
        this.data = dataArgs;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ShopProductData shopProductData = data.get(position);
        holder.productName.setText(shopProductData.getName());
        holder.productPrice.setText(getCurrencySymbol + shopProductData.getPrice());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView productName;
        public TextView productPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            this.productName = (TextView) itemView.findViewById(R.id.product_name);
            this.productPrice = (TextView) itemView.findViewById(R.id.product_price);
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
