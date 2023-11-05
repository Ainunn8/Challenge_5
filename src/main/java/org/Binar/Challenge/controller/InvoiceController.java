package org.Binar.Challenge.controller;

import net.sf.jasperreports.engine.JRException;
import org.Binar.Challenge.model.Invoice;
import org.Binar.Challenge.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@RequestMapping(value = "/api/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping(value = "/generate-invoice", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity generateInvoice(@RequestHeader("username") String username) throws JRException, FileNotFoundException {
        return ResponseEntity.ok()
                .body(invoiceService.generateInvoice(username));
    }
    @GetMapping("/{id}")
    public ResponseEntity getInvoice(@PathVariable String id) {
        Invoice invoice = invoiceService.getInvoiceById(id);

        if (invoice == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(invoice);
    }
}
