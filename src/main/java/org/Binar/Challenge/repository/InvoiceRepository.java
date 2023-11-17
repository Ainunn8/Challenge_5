package org.Binar.Challenge.repository;

import org.Binar.Challenge.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {

}
