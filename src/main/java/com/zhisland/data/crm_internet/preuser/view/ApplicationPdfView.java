/**
 * 
 */
package com.zhisland.data.crm_internet.preuser.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

/**
 * 入岛申请表PDF
 * 
 * @author muzongyan
 *
 */
public class ApplicationPdfView extends AbstractPdfView {

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.web.servlet.view.document.AbstractPdfView#buildPdfDocument(java.util.Map,
     * com.lowagie.text.Document, com.lowagie.text.pdf.PdfWriter, javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        Paragraph header = new Paragraph(new Chunk("Generate Pdf USing Spring Mvc", FontFactory.getFont(
                FontFactory.HELVETICA, 30)));
        Paragraph by = new Paragraph(new Chunk("Author ", FontFactory.getFont(FontFactory.HELVETICA, 20)));

        document.add(header);
        document.add(by);

    }

}
