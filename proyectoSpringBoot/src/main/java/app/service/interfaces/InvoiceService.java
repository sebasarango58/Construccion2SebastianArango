/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.service.interfaces;

import app.dto.DetailInvoiceDto;
import app.dto.InvoiceDto;


/**
 *
 * @author Sebastian
 */
public interface InvoiceService {
    public void createInvoice(InvoiceDto invoiceDto, DetailInvoiceDto detailInvoiceDto) throws Exception;
}
