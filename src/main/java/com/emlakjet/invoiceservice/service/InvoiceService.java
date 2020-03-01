package com.emlakjet.invoiceservice.service;

import com.emlakjet.invoiceservice.dto.InvoiceDto;
import com.emlakjet.invoiceservice.entity.Invoice;
import com.emlakjet.invoiceservice.repository.InvoiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Invoice invoiceSave(InvoiceDto invoiceDto) {
        Invoice invoice = modelMapper.map(invoiceDto, Invoice.class);
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> getInvoice() {
        return invoiceRepository.findAll();
    }


}
