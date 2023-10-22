package org.Binar.Challenge.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.Binar.Challenge.model.Product;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private String userId;
    private List<Product> products;
    private String shippingAddress;
    private String destination;
}
