package org.Binar.Challenge.service;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.Binar.Challenge.model.Invoice;
import org.Binar.Challenge.model.response.OrderDetail;
import org.Binar.Challenge.repository.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class InvoiceServiceImpl implements InvoiceService{

    private final InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public byte[] generateInvoice(String username) throws FileNotFoundException, JRException {
        log.info("Generating invoice for {}", username);
        List<OrderDetail> orderDetails = Arrays.asList(
                OrderDetail.builder().productName("Mie Goreng").price("Rp. 13.000").quantity(3L).build(),
                OrderDetail.builder().productName("Nasi Goreng").price("Rp. 15.000").quantity(2L).build(),
                OrderDetail.builder().productName("Es Jeruk").price("Rp. 5.000").quantity(5L).build()
        );

        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("username", "Nur Ainun");
        parameterMap.put("finalPrice", "Rp. 94.000");
        parameterMap.put("orderDetail", orderDetails);
        JasperPrint invoice = JasperFillManager.fillReport(
                JasperCompileManager.compileReport(ResourceUtils.getFile("classpath:invoice_v2.jrxml").getAbsolutePath()),
                parameterMap,
                new JRBeanCollectionDataSource(orderDetails)
        );

        return JasperExportManager.exportReportToPdf(invoice);
    }

    @Override
    public Invoice getInvoiceById(String id) {
        return invoiceRepository.findById(id).orElse(null);
    }
}
