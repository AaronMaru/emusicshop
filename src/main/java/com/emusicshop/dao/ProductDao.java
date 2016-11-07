package com.emusicshop.dao;

import java.util.List;

import com.emusicshop.model.Product;

public interface ProductDao {

	List<Product> getProductList();

    Product getProductByName (String name);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(String name);
}
