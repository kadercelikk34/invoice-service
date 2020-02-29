package com.emlakjet.invoiceservice.service;

import com.emlakjet.invoiceservice.model.Invoice;
import com.emlakjet.invoiceservice.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;

    public Invoice save(Invoice invoice){
       return  invoiceRepository.save(invoice);
    }
    public List<Invoice> getOwners(){
        return invoiceRepository.findAll();
    }
}
