package org.Binar.Challenge.repository;

import org.Binar.Challenge.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.text.ParseException;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

//    Product findProductBy(String productCode);

    @Query(nativeQuery = true, value ="insert into product (productCode, name , price, merchantCode)" +
            "value (:productCode, :name, :price, :merchantCode)")
    void addNewProduct(
            @Param("productCode") String productCode,
            @Param("name") String name,
            @Param("prtice") double price,
            @Param("merchantCode") String merchantCode
    );
    @Query(nativeQuery = true, value = "delete from product where productCode = :productCode")
    void deleteProduct(@Param("productCode") String productCode);
    List<Product> getMenu();
}
