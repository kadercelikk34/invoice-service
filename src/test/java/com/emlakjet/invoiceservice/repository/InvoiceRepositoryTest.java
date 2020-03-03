package com.emlakjet.invoiceservice.repository;

import com.emlakjet.invoiceservice.entity.Invoice;
import com.emlakjet.invoiceservice.entity.InvoiceStatus;
import com.emlakjet.invoiceservice.entity.User;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@DataJpaTest
public class InvoiceRepositoryTest {

    @Autowired
    private InvoiceRepository invoiceRepository;


    @Test
    public void testGetInvoiceList() {
        List<Invoice> invoiceList = invoiceRepository.findAll();
        List<String> billingNoList = invoiceList.stream().map(a -> a.getBillingNo()).collect(Collectors.toList());
        MatcherAssert.assertThat(billingNoList, Matchers.containsInAnyOrder("TR00", "TR01", "TR02", "TR03", "TR04", "TR05"));
    }

    @Test
    public void testGetInvoice() {
        Optional<Invoice> optionalSupplier = invoiceRepository.findById(1L);
        MatcherAssert.assertThat(optionalSupplier.get().getProductName(), Matchers.equalTo("Usb Disc"));
    }

    @Test
    public void testInvoiceSave() {
        Invoice invoice = new Invoice();
        invoice.setAmount(20L);
        invoice.setProductName("Hard Disc");
        invoice.setBillingNo("TR07");
        invoice.setInvoiceStatus(InvoiceStatus.APPROVED);
        User user = new User();
        user.setId(1L);
        invoice.setUser(user);
        Invoice saveInvoice = invoiceRepository.save(invoice);
        MatcherAssert.assertThat(saveInvoice.getBillingNo(), Matchers.equalTo(invoice.getBillingNo()));
    }
}
