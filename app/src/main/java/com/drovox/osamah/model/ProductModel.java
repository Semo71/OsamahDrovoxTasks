package com.drovox.osamah.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProductModel{

	@SerializedName("total")
	private int total;

	@SerializedName("limit")
	private int limit;

	@SerializedName("skip")
	private int skip;

	@SerializedName("products")
	private List<ItemModel> products;

	public int getTotal(){
		return total;
	}

	public int getLimit(){
		return limit;
	}

	public int getSkip(){
		return skip;
	}

	public List<ItemModel> getProducts(){
		return products;
	}
}