package es.rufflecol.lara.shopproductsorter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

import es.rufflecol.lara.shopproductsorter.model.Product;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String currencySymbol;
    private List<Product> products;

    public RecyclerAdapter(String currencySymbol, List<Product> products) {
        this.currencySymbol = currencySymbol; /** Initialising the currencySymbol instance field **/
        this.products = products; /** Initialising the products instance field **/
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
        Product product = products.get(position);
        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        holder.productName.setText(product.getName());
        holder.productPrice.setText(currencySymbol + decimalFormat.format(product.getPrice()));
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
        return products.size();
    }
}