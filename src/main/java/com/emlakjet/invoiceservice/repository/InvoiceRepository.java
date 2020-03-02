package com.emlakjet.invoiceservice.repository;

import com.emlakjet.invoiceservice.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    @Query("SELECT sum(amount) FROM Invoice invoice WHERE invoice.user.id = 1 and invoice.invoiceStatus='APPROVED'")
    Long getAmounts(@Param("userId") Long userId);
}
