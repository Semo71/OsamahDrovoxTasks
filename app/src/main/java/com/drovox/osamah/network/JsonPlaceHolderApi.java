package com.drovox.osamah.network;


import com.drovox.osamah.model.ProductModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * JsonPlaceHolderApi is an interface that holds all https requests
 */
public interface JsonPlaceHolderApi {

    @GET("products")
    Call<ProductModel> getProducts();

}


