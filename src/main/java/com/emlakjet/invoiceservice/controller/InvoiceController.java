package com.emlakjet.invoiceservice.controller;

import com.emlakjet.invoiceservice.model.Invoice;
import com.emlakjet.invoiceservice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @PostMapping(value = "/save")
    public ResponseEntity<Void> saveInvoice(@RequestBody Invoice invoice){
        try{
            invoiceService.save(invoice);
            Long id = invoice.getId();
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
            return ResponseEntity.created(location).build();
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    @GetMapping(value = "/invoices")
    public ResponseEntity<List<Invoice>> getInvoices(){
        List<Invoice> invoiceList = invoiceService.getOwners();
        return ResponseEntity.ok(invoiceList);

    }
}
