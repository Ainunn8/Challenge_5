package org.Binar.Challenge.service;

import org.Binar.Challenge.model.Product;

import java.util.List;

public interface ProductService {
    //Menambahkan product baru
    Product addNewProduct(Product product);

    // Mengupdate detail product
    Product updateProduct(Product product);

    // Menghapus product berdasarkan productCode
    void deleteProduct(String productCode);

    // Menampilkan semua produk yang tersedia
    List<Product> getAllProducts();
}
