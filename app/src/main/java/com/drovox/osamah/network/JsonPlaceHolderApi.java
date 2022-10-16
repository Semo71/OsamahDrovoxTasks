package com.drovox.osamah.network;


import com.drovox.osamah.model.ProductModel;

import retrofit2.Call;
import retrofit2.http.GET;


public interface JsonPlaceHolderApi {

    @GET("products")
    Call<ProductModel> getProducts();

}


