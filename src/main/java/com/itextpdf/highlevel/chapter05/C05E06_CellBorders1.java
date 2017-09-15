/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2017 iText Group NV
    Authors: iText Software.

    For more information, please contact iText Software at this address:
    sales@itextpdf.com
 */
/*
 * This example was written by Bruno Lowagie
 * in the context of the book: iText 7 building blocks
 */
package com.itextpdf.highlevel.chapter05;

import java.io.File;
import java.io.IOException;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.DashedBorder;
import com.itextpdf.layout.border.DottedBorder;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.VerticalAlignment;
import com.itextpdf.test.annotations.WrapToTest;

/**
 * @author Bruno Lowagie (iText Software)
 */
@WrapToTest
public class C05E06_CellBorders1 {
    
    public static final String DEST = "results/chapter05/cell_borders1.pdf";
       
    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C05E06_CellBorders1().createPdf(DEST);
    }
    
    public void createPdf(String dest) throws IOException {
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        
        // Initialize document
        Document document = new Document(pdf);
        
        Table table = new Table(UnitValue.createPercentArray(new float[]{2, 1, 1}));
        table.setWidthPercent(80)
            .setHorizontalAlignment(HorizontalAlignment.CENTER)
            .setTextAlignment(TextAlignment.CENTER);
        table.addCell(new Cell(1, 3)
            .add("Cell with colspan 3")
            .setVerticalAlignment(VerticalAlignment.MIDDLE)
            .setBorder(new DashedBorder(0.5f)));
        table.addCell(new Cell(2, 1)
            .add("Cell with rowspan 2")
            .setVerticalAlignment(VerticalAlignment.MIDDLE)
            .setBorderBottom(new DottedBorder(0.5f))
            .setBorderLeft(new DottedBorder(0.5f)));
        table.addCell(new Cell()
            .add("row 1; cell 1")
            .setBorder(new DottedBorder(Color.ORANGE, 0.5f)));
        table.addCell(new Cell()
            .add("row 1; cell 2"));
        table.addCell(new Cell()
            .add("row 2; cell 1")
            .setBorderBottom(new SolidBorder(2)));
        table.addCell(new Cell()
            .add("row 2; cell 2")
            .setBorderBottom(new SolidBorder(2)));
        document.add(table);
        
        document.close();
    }
}