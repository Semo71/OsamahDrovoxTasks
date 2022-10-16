package com.drovox.osamah;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.drovox.osamah.databinding.CardviewProductBinding;
import java.util.List;


public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.MyViewHolder> {

    private Context mContext;
    private final List<ProductsItem> mData;

    public ProductsAdapter(List<ProductsItem> data) {
        mData = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        mContext = viewGroup.getContext();
        CardviewProductBinding binding = CardviewProductBinding.inflate(LayoutInflater.from(mContext), viewGroup, false);
        return new MyViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        ProductsItem model = mData.get(position);
        Glide.with(mContext).load(model.getImages().get(0)).into(holder.mBinding.productImgV);
        holder.mBinding.titleTxtV.setText(model.getTitle());
        holder.mBinding.priceTxtV.setText(model.getPrice() + " SAR");
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        CardviewProductBinding mBinding;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mBinding = CardviewProductBinding.bind(itemView);
        }
    }

}
