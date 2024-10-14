/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import app.dao.interfaces.InvoiceDao;
import app.dao.repository.InvoiceRepository;
import app.dto.InvoiceDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.helpers.Helper;
import app.model.Invoice;
import app.model.Person;
import app.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastian
 */
@Getter
@Setter
@NoArgsConstructor
@Service
public class InvoiceDaoImplementation implements InvoiceDao {
    @Autowired
    InvoiceRepository invoiceRepository;

    @Override
    public void createInvoice(InvoiceDto invoiceDto) throws Exception {
        Invoice invoice = Helper.parse(invoiceDto);
		invoiceRepository.save(invoice); 
    }

    @Override
    public void updateInvoice(InvoiceDto invoiceDto) throws Exception {
        Invoice invoice = Helper.parse(invoiceDto);
        invoiceRepository.save(invoice);
    }


    @Override
    public InvoiceDto findByPersonId(PersonDto personDto) throws Exception {
            Person person = Helper.parse(personDto);
            Invoice invoice= invoiceRepository.findByPersonId(person);
	return Helper.parse(invoice);
    }
   
}


//findbyPersonId
//findbyUserId



