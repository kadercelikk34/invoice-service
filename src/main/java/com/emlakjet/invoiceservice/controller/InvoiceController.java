package com.emlakjet.invoiceservice.controller;

import com.emlakjet.invoiceservice.dto.InvoiceDto;
import com.emlakjet.invoiceservice.entity.Invoice;
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
    private InvoiceService invoiceService;

    @PostMapping(value = "/invoiceSave")
    public ResponseEntity<Void> invoiceSave(@RequestBody InvoiceDto invoiceDto){
        try{
            invoiceService.invoiceSave(invoiceDto);
            Long id = invoiceDto.getId();
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
            return ResponseEntity.created(location).build();
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    @GetMapping(value = "/invoices")
    public ResponseEntity<List<Invoice>> getInvoices(){
        List<Invoice> invoiceList = invoiceService.getInvoice();
        return ResponseEntity.ok(invoiceList);

    }
}
