package com.drovox.osamah.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.drovox.osamah.viewmodel.MainViewModel;
import com.drovox.osamah.view.adapter.ProductsAdapter;
import com.drovox.osamah.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private Context mContext;
    private MainViewModel mViewModel;
    private ActivityMainBinding mBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mContext = MainActivity.this;

        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mBinding.progressBar.setVisibility(View.GONE);
        mBinding.recyclerview.setVisibility(View.GONE);
        mBinding.errorTxtV.setVisibility(View.GONE);

        mBinding.swiperefreshlayout.setOnRefreshListener(this::getProducts);
        getProducts();

    }


    public void getProducts() {
        mBinding.progressBar.setVisibility(View.VISIBLE);
        mBinding.recyclerview.setVisibility(View.GONE);
        mBinding.errorTxtV.setVisibility(View.GONE);

        mViewModel.getProducts().observe(this, apiModel -> {
            mBinding.progressBar.setVisibility(View.GONE);
            mBinding.swiperefreshlayout.setRefreshing(false);
            if (apiModel.getError() != null) {
                mBinding.recyclerview.setVisibility(View.GONE);
                mBinding.errorTxtV.setVisibility(View.VISIBLE);
                mBinding.errorTxtV.setText(apiModel.getError());
                return;
            }
            mBinding.recyclerview.setVisibility(View.VISIBLE);
            mBinding.errorTxtV.setVisibility(View.GONE);

            ProductsAdapter adapter = new ProductsAdapter(apiModel.getResponse().getProducts());
            mBinding.recyclerview.setLayoutManager(new GridLayoutManager(mContext, 2));
            mBinding.recyclerview.setAdapter(adapter);

        });
    }

}