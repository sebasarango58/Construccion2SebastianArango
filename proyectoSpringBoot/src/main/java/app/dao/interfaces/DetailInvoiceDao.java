/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.dao.interfaces;

import app.dto.DetailInvoiceDto;

/**
 *
 * @author Sebastian
 */
public interface DetailInvoiceDao {
    public void createDetailInvoice (DetailInvoiceDto detailInvoiceDto) throws Exception;
}
