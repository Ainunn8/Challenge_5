package org.Binar.Challenge.controller;


import org.Binar.Challenge.model.OrderDetail;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.JMRuntimeException;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/invoice")
@Configuration
public class InvoiceController {

    @GetMapping(value = "/generete-invoice", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity genereteinvoice() throws JRException, FileNotFoundException {
        List <OrderDetail> orderDetails = Arrays.asList(
                OrderDetail.builder().productCode("Mie Goreng").price("Rp. 13.000").quantity(3).build(),
                OrderDetail.builder().productCode("Nasi Goreng").price("Rp. 15.000").quantity(2).build(),
                OrderDetail.builder().productCode("Es Jeruk").price("Rp. 5.000").quantity(5).build()
        );
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("Username", "Nur Ainun");
        dataMap.put("TotalPrice", "Rp. 94.000");
        dataMap.put("orderDetail", orderDetails);
        JasperPrint invoice = JasperFileManager.fillReport(ResourceUtils.getFile("Binar")
                dataMap,
        new JRBeanCollectionDataSource(orderDetails)
        );
        return genereteinvoice();
    }


}
