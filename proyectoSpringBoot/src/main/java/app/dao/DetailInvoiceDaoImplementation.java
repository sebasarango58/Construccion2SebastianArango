/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import app.dao.interfaces.DetailInvoiceDao;
import app.dao.repository.DetailInvoiceRepository;
import app.dto.DetailInvoiceDto;
import app.helpers.Helper;
import app.model.DetailInvoice;
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
public class DetailInvoiceDaoImplementation implements DetailInvoiceDao {
    @Autowired
    DetailInvoiceRepository detailInvoiceRepository;
   
    @Override
    public void createDetailInvoice(DetailInvoiceDto detailInvoiceDto) throws Exception {
        DetailInvoice detailInvoice = Helper.parse(detailInvoiceDto);
        detailInvoiceRepository.save(detailInvoice);
    }

}

 