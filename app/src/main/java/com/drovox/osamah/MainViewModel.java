package com.drovox.osamah;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


public class MainViewModel extends ViewModel {

    public LiveData<ApiModel<ProductModel>> getProducts() {
        return  ProductsRepository.getInstance().getProducts();
    }

}
