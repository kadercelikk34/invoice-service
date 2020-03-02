package com.emlakjet.invoiceservice.service;

import com.emlakjet.invoiceservice.dto.InvoiceDto;
import com.emlakjet.invoiceservice.entity.Invoice;
import com.emlakjet.invoiceservice.entity.InvoiceStatus;
import com.emlakjet.invoiceservice.entity.User;
import com.emlakjet.invoiceservice.repository.InvoiceRepository;
import com.emlakjet.invoiceservice.InvoiceServiceProperties;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private InvoiceServiceProperties i̇nvoiceServiceProperties;

    public Invoice invoiceSave(InvoiceDto invoiceDto, Authentication authentication) {
        User user = getUser(authentication);
        invoiceDto.setUser(user);
        invoiceDto.setInvoiceStatus(getInvoiceStatus(user.getId(), invoiceDto.getAmount()));
        Invoice invoice = modelMapper.map(invoiceDto, Invoice.class);
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> getInvoiceList() {
        return invoiceRepository.findAll();
    }

    public Invoice findById(Long id) {
        Optional<Invoice> optionalSupplier = invoiceRepository.findById(id);

        return optionalSupplier.orElse(null);
    }

    private User getUser(Authentication authentication) {
        UserDetails userDetail = (UserDetails) authentication.getPrincipal();
        User user = userService.findByUsername(userDetail.getUsername());
        return user;
    }

    private InvoiceStatus getInvoiceStatus(Long userId, Long amount) {
        Long totalAmount = invoiceRepository.getAmounts(userId);
        Long creditLimit = i̇nvoiceServiceProperties.getCreditLimit();
        Long differenceAmount = creditLimit - totalAmount;
        if (differenceAmount >= amount) {
            return InvoiceStatus.APPROVED;
        } else {
            return InvoiceStatus.NOT_APPROWED;

        }
    }

}
