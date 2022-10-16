package com.drovox.osamah.network;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.drovox.osamah.model.ApiModel;
import com.drovox.osamah.model.ProductModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ProductsRepository is a Singleton class that hold all the products api calls
 */
public class ProductsRepository {

    private static ProductsRepository mRepository;

    private final JsonPlaceHolderApi mJsonPlaceHolderApi = ApiCaller.getInstance().getRetrofit().create(JsonPlaceHolderApi.class);

    public static ProductsRepository getInstance() {
        if (mRepository == null) {
            mRepository = new ProductsRepository();
        }
        return mRepository;
    }


    public MutableLiveData<ApiModel<ProductModel>> getProducts() {

        final MutableLiveData<ApiModel<ProductModel>> mutableLiveData = new MutableLiveData<>();
        mJsonPlaceHolderApi.getProducts().enqueue(new Callback<ProductModel>() {
            @Override
            public void onResponse(@NonNull Call<ProductModel> call, @NonNull Response<ProductModel> response) {
                if (response.isSuccessful())
                    mutableLiveData.setValue(new ApiModel<>(response.body()));
                else
                    mutableLiveData.setValue(new ApiModel<>("Error Code " + response.code()));
            }

            @Override
            public void onFailure(@NonNull Call<ProductModel> call, @NonNull Throwable t) {
                mutableLiveData.setValue(new ApiModel<>(t.getMessage()));
            }
        });
        return mutableLiveData;
    }

}
