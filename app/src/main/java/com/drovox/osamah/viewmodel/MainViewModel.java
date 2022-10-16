package com.drovox.osamah.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.drovox.osamah.model.ApiModel;
import com.drovox.osamah.model.ProductModel;
import com.drovox.osamah.network.ProductsRepository;


public class MainViewModel extends ViewModel {

    public LiveData<ApiModel<ProductModel>> getProducts() {
        return  ProductsRepository.getInstance().getProducts();
    }

}
