package com.cetin.carrentalproject.service.concretes;

import com.cetin.carrentalproject.dto.requestDto.InvoiceCorporateCustomerRequestDto;
import com.cetin.carrentalproject.dto.requestDto.InvoiceIndividualCustomerRequestDto;
import com.cetin.carrentalproject.dto.responseDtos.InvoiceResponseDto;
import com.cetin.carrentalproject.model.CorporateCustomer;
import com.cetin.carrentalproject.model.IndividualCustomer;
import com.cetin.carrentalproject.model.Invoice;
import com.cetin.carrentalproject.repository.*;
import com.cetin.carrentalproject.service.abstracts.InvoiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceManager implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private CorporateCustomerRepository corporateCustomerRepository;
    @Autowired
    private IndividualCustomerRepository individualCustomerRepository;
    @Autowired
    private InvoiceCorporateCustomerRepository invoiceCorporateCustomerRepository;
    @Autowired
    private InvoiceIndividualCustomerRepository invoiceIndividualCustomerRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Integer saveInvoiceCorporateCustomer(InvoiceCorporateCustomerRequestDto invoiceCorporateCustomerRequestDto) {
        Invoice invoiceCorporateCustomer = modelMapper.map(invoiceCorporateCustomerRequestDto, Invoice.class);
        invoiceCorporateCustomer = invoiceCorporateCustomerRepository.save(invoiceCorporateCustomer);
        return invoiceCorporateCustomer.getId();
    }

    @Override
    public Integer saveInvoiceIndividualCustomer(InvoiceIndividualCustomerRequestDto invoiceIndividualCustomerRequestDto) {
        Invoice invoiceIndividualCustomer = modelMapper.map(invoiceIndividualCustomerRequestDto, Invoice.class);
        invoiceIndividualCustomer = invoiceIndividualCustomerRepository.save(invoiceIndividualCustomer);
        return invoiceIndividualCustomer.getId();
    }

    @Override
    public List<InvoiceResponseDto> findAllInvoices() {
        Iterable<Invoice> invoiceList = invoiceRepository.findAll();

        List<InvoiceResponseDto> invoiceResponseDtos = new ArrayList<>();
        for (Invoice invoice : invoiceList) {
            InvoiceResponseDto invoiceResponseDto = modelMapper.map(invoice, InvoiceResponseDto.class);
            invoiceResponseDtos.add(invoiceResponseDto);
        }
        return invoiceResponseDtos;
    }

    @Override
    public List<InvoiceResponseDto> findAllInvoicesByCorporateCustomerId(Integer CorporateCustomerId) {
        CorporateCustomer corporateCustomer = corporateCustomerRepository.findById(CorporateCustomerId).get();
        List<Invoice> invoiceList = invoiceRepository.findAllInvoicesByCorporateCustomerId(corporateCustomer);

        List<InvoiceResponseDto> invoiceResponseDtos = new ArrayList<>();
        for (Invoice invoice : invoiceList) {
            InvoiceResponseDto invoiceResponseDto = modelMapper.map(invoice, InvoiceResponseDto.class);
            invoiceResponseDtos.add(invoiceResponseDto);
        }
        return invoiceResponseDtos;
    }

    @Override
    public List<InvoiceResponseDto> findAllInvoicesByIndividualCustomerId(Integer IndividualCustomerId) {
        IndividualCustomer individualCustomer = individualCustomerRepository.findById(IndividualCustomerId).get();
        List<Invoice> invoiceList = invoiceRepository.findAllInvoicesByIndividualCustomerId(individualCustomer);

        List<InvoiceResponseDto> invoiceResponseDtos = new ArrayList<>();
        for (Invoice invoice : invoiceList) {
            InvoiceResponseDto invoiceResponseDto = modelMapper.map(invoice, InvoiceResponseDto.class);
            invoiceResponseDtos.add(invoiceResponseDto);
        }
        return invoiceResponseDtos;
    }

    @Override
    public boolean deleteInvoiceById(Integer invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId).get();
        invoiceRepository.delete(invoice);
        return true;
    }

}
