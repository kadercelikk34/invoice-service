package com.emlakjet.invoiceservice.service;

import com.emlakjet.invoiceservice.entity.Invoice;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
public class InvoiceServiceTest {

    @Mock
    InvoiceService invoiceService;

    @Test
    public void testGetIinvoice() {
        Invoice invoice = invoiceService.findById(1L);
        MatcherAssert.assertThat(invoice.getProductName(), Matchers.equalTo("Usb Disc"));
    }

    @Test
    public void testGetInvoiceList() {
        List<Invoice> invoiceList = invoiceService.getInvoiceList();
        List<String> billingNoList = invoiceList.stream().map(a -> a.getBillingNo()).collect(Collectors.toList());
        MatcherAssert.assertThat(billingNoList, Matchers.containsInAnyOrder("TR00", "TR01", "TR02", "TR03", "TR04", "TR05"));
    }

}
