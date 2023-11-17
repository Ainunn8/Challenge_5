package org.Binar.Challenge.service;

import lombok.extern.slf4j.Slf4j;
import org.Binar.Challenge.model.Product;
import org.Binar.Challenge.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements  ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addNewProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {

        return productRepository.save(product);
    }


    @Override
    public void deleteProduct(String productCode) {
        productRepository.deleteById(productCode);
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Product> getProductDetails(String productCode) {
        log.info("Getting product detail info of {}", productCode);
        return (List<Product>) Optional.ofNullable(productRepository.findById(productCode))
                .map(product->Product.builder()
                        .productCode(product.get().getProductCode())
                        .name(product.get().getName())
                        .price(product.get().getPrice())
                        .merchantCode(product.get().getMerchantCode())
                        .build())
                .orElse(null);
    }


}
