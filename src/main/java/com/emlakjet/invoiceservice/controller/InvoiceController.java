package com.emlakjet.invoiceservice.controller;

import com.emlakjet.invoiceservice.dto.InvoiceDto;
import com.emlakjet.invoiceservice.entity.Invoice;
import com.emlakjet.invoiceservice.entity.InvoiceStatus;
import com.emlakjet.invoiceservice.service.InvoiceService;
import com.emlakjet.invoiceservice.validator.InvoiceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private InvoiceValidator invoiceValidator;


    @GetMapping("/invoice")
    public String invoice(Model model) {
        model.addAttribute("invoiceForm", new Invoice());

        return "invoiceCreated";
    }

    @PostMapping("/invoiceSave")
    public String invoiceSave(@ModelAttribute("invoiceForm") InvoiceDto invoiceForm, BindingResult bindingResult, RedirectAttributes redirectAttributes, Authentication authentication) {
        invoiceValidator.validate(invoiceForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "invoiceCreated";
        }

        Invoice invoice = invoiceService.invoiceSave(invoiceForm, authentication);

        redirectAttributesMessage(redirectAttributes, invoice);
        return "redirect:/invoice/" + invoice.getId();


    }

    @GetMapping(value = "/invoice/{id}")
    public String getInvoiceDetails(@PathVariable("id") Long id, Model model) {


        Invoice invoice = invoiceService.findById(id);
        if (invoice == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "User not found");
        }
        model.addAttribute("invoice", invoice);

        return "invoiceDetails";

    }

    @GetMapping(value = {"/invoicesList"})
    public ModelAndView getInvoiceList() {
        ModelAndView map = new ModelAndView("invoiceList");
        map.addObject("lists", invoiceService.getInvoiceList());

        return map;
    }

    private RedirectAttributes redirectAttributesMessage(RedirectAttributes redirectAttributes, Invoice invoice) {
        if (invoice.getInvoiceStatus().equals(InvoiceStatus.NOT_APPROWED)) {
            redirectAttributes.addFlashAttribute("msg", invoice.getUser().getFirstName() + " " + invoice.getUser().getLastName() + " " + invoice.getId() + ". işlemi reddedilir");
            redirectAttributes.addFlashAttribute("css", "danger");
            return redirectAttributes;
        }
        redirectAttributes.addFlashAttribute("msg", invoice.getUser().getFirstName() + " " + invoice.getUser().getLastName() + " " + invoice.getId() + ". işlemi kabul edilir");
        redirectAttributes.addFlashAttribute("css", "success");
        return redirectAttributes;
    }

}
