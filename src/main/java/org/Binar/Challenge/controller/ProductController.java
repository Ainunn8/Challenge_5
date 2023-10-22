package org.Binar.Challenge.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.Binar.Challenge.model.Product;
import org.Binar.Challenge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/Product")
@Slf4j

public class ProductController {

    @Autowired
    ProductService productService;

    // Menambahkan produk baru

    @GetMapping(produces = "application/json")
    @Operation(summary = "Api to get all product")
    public List<Product> getProduct() {
        return productService.getAllProducts();
    }
    @PostMapping("/add-product")
    public ResponseEntity addProduct(@RequestBody Product  product) {
        productService.addNewProduct(Product.builder()
                .productCode(product.getProductCode())
                .name(product.getName())
                .price(product.getPrice())
                .merchantCode(product.getMerchantCode())
                .build());
        return ResponseEntity.status(HttpStatus.CREATED).body("Product added successfully");
    }

    // Mengupdate detail produk
    @PutMapping("/update")
    public ResponseEntity updateProduct(@RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(product);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    //Menghapus produk
    @DeleteMapping("/delete/{product}")
    public ResponseEntity deleteProduct(@PathVariable String productCode) {
        productService.deleteProduct(productCode);
        return ResponseEntity.ok("Product deleted successfully");
    }

    // Menampilkan produk yang tersedia
    @GetMapping("/detail")
    public List<Product> getAllProducts() {
        List<Product> openMerchants = productService.getAllProducts();
        return getAllProducts();
    }

    @GetMapping(value = "/detail")
    @Operation(summary = "Getting detail of one product by product code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product found"),
            @ApiResponse(responseCode = "404", description = "Inputted product code not found")
    })


    private List<?> testWildCard(){
        return Arrays.asList("String", 40);
    }

}
