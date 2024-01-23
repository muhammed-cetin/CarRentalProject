package com.cetin.carrentalproject.controller;

import com.cetin.carrentalproject.dto.requestDto.InvoiceCorporateCustomerRequestDto;
import com.cetin.carrentalproject.dto.requestDto.InvoiceIndividualCustomerRequestDto;
import com.cetin.carrentalproject.dto.responseDtos.InvoiceResponseDto;
import com.cetin.carrentalproject.service.abstracts.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Invoices")
public class InvoicesController {

    private InvoiceService invoiceService;

    @Autowired
    public InvoicesController(InvoiceService invoiceService) {
        super();
        this.invoiceService = invoiceService;
    }

    @PostMapping("/saveInvoiceCorporateCustomer")
    public ResponseEntity<Integer> saveInvoiceCorporateCustomer(@RequestBody InvoiceCorporateCustomerRequestDto invoiceCorporateCustomerRequestDto) {
        Integer invoiceId = invoiceService.saveInvoiceCorporateCustomer(invoiceCorporateCustomerRequestDto);
        return new ResponseEntity<>(invoiceId, HttpStatus.OK);
    }

    @PostMapping("/saveInvoiceIndividualCustomer")
    public ResponseEntity<Integer> saveInvoiceIndividualCustomer(@RequestBody InvoiceIndividualCustomerRequestDto invoiceIndividualCustomerRequestDto) {
        Integer invoiceId = invoiceService.saveInvoiceIndividualCustomer(invoiceIndividualCustomerRequestDto);
        return new ResponseEntity<>(invoiceId, HttpStatus.OK);
    }

    @GetMapping("/findAllInvoices")
    public ResponseEntity<List<InvoiceResponseDto>> findAllInvoices() {
        List<InvoiceResponseDto> invoiceResponseDtos = invoiceService.findAllInvoices();
        return new ResponseEntity<>(invoiceResponseDtos, HttpStatus.OK);
    }

    @GetMapping("/findAllInvoicesByCorporateCustomerId")
    public ResponseEntity<List<InvoiceResponseDto>> findAllInvoicesByCorporateCustomerId(@RequestParam Integer corporateCustomerId) {
        List<InvoiceResponseDto> invoiceResponseDtos = invoiceService.findAllInvoicesByCorporateCustomerId(corporateCustomerId);
        return new ResponseEntity<>(invoiceResponseDtos, HttpStatus.OK);
    }

    @GetMapping("/findAllInvoicesByIndividualCustomerId")
    public ResponseEntity<List<InvoiceResponseDto>> findAllInvoicesByIndividualCustomerId(@RequestParam Integer individualCustomerId) {
        List<InvoiceResponseDto> invoiceResponseDtos = invoiceService.findAllInvoicesByIndividualCustomerId(individualCustomerId);
        return new ResponseEntity<>(invoiceResponseDtos, HttpStatus.OK);
    }

    @DeleteMapping("/deleteInvoiceById")
    public ResponseEntity<Boolean> deleteInvoiceById(@RequestParam Integer invoiceId) {
        boolean delete = invoiceService.deleteInvoiceById(invoiceId);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }
}
