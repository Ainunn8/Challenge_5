package org.Binar.Challenge.service;

import net.sf.jasperreports.engine.JRException;
import org.Binar.Challenge.model.Invoice;

import java.io.FileNotFoundException;

public interface InvoiceService {

    byte[] generateInvoice(String username) throws FileNotFoundException, JRException;

    Invoice getInvoiceById(String id);

}
