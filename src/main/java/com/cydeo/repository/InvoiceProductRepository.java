package com.cydeo.repository;

import com.cydeo.entity.Invoice;
import com.cydeo.entity.InvoiceProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceProductRepository extends JpaRepository<InvoiceProduct, Long> {
    InvoiceProduct findInvoiceProductById(Long id);
    List<InvoiceProduct> findAllInvoiceProductByProductId(Long id);
    List<InvoiceProduct> findAllByInvoice(Invoice invoice);
}
