package org.Binar.Challenge.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.Binar.Challenge.model.Product;
import org.Binar.Challenge.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddProduct() {
        // Buat objek Product yang akan digunakan dalam pengujian
        Product newProduct = new Product();
        newProduct.setProductCode("NG001");
        newProduct.setName("Nasi Goreng");
        newProduct.setPrice(15000.0);
        newProduct.setMerchantCode("M001");

        // Panggil metode yang akan diuji
        ResponseEntity responseEntity = productController.addProduct(newProduct);

        // Verifikasi bahwa metode addNewProduct pada productService telah dipanggil dengan benar
        verify(productService, times(1)).addNewProduct(newProduct);

        // Verifikasi bahwa respon sesuai dengan yang diharapkan
        assertEquals(ResponseEntity.status(HttpStatus.CREATED).body("Product added successfully"), responseEntity);
    }
}
