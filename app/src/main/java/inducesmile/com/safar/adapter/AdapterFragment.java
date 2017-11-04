package inducesmile.com.safar.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import inducesmile.com.safar.Interface.MyOnClickListener;
import inducesmile.com.safar.Models.TableElements;
import inducesmile.com.safar.R;

public class AdapterFragment extends RecyclerView.Adapter<AdapterFragment.AdapterFragmentViewHolder> {
    String TAG = "Test";
    List<TableElements> tables;
    public int id;
    String token;
    Context context;
    MyOnClickListener mListener;



    public AdapterFragment(Context context, MyOnClickListener mListener) {
            tables = new ArrayList<>();
            this.context= context;
            this.mListener=mListener;

    }


    @Override
    public AdapterFragmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_adapter, parent, false);
        return new AdapterFragment.AdapterFragmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterFragmentViewHolder holder, int position) {
        final TableElements productInfo = tables.get(position);
        holder.product_name.setText(productInfo.getTableName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClick(productInfo.getTypeID());
            }
        });

    }

    @Override
    public int getItemCount() {
        return tables.size();
    }
    public void addNewItem(TableElements table) {
        tables.add(table);
        notifyDataSetChanged();
    }

    public class AdapterFragmentViewHolder extends RecyclerView.ViewHolder {
        private TextView product_name;
        private View cardView;

        AdapterFragmentViewHolder(View itemView) {
            super(itemView);
            product_name = (TextView) itemView.findViewById(R.id.product_name);
            cardView = itemView.findViewById(R.id.cardViewSubMenu);
        }
    }
}
