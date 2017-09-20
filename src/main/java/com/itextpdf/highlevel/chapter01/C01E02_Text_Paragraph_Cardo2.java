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
package com.itextpdf.highlevel.chapter01;

import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.test.annotations.WrapToTest;

import java.io.File;
import java.io.IOException;

/**
 * @author Bruno Lowagie (iText Software)
 */
@WrapToTest
public class C01E02_Text_Paragraph_Cardo2 {
    
    public static final String DEST = "results/chapter01/text_paragraph_cardo%s.pdf";
    
    public static final String REGULAR = "src/main/resources/fonts/Cardo-Regular.ttf";
    public static final String BOLD = "src/main/resources/fonts/Cardo-Bold.ttf";
    public static final String ITALIC = "src/main/resources/fonts/Cardo-Italic.ttf";
    
    protected PdfFont font;
    protected PdfFont bold;
    protected PdfFont italic;
    
    public static void main(String args[]) throws IOException {
        File file = new File(String.format(DEST, 1));
        file.getParentFile().mkdirs();
        C01E02_Text_Paragraph_Cardo2 app = new C01E02_Text_Paragraph_Cardo2();
        FontProgram fontProgram = FontProgramFactory.createFont(REGULAR);
        FontProgram boldProgram = FontProgramFactory.createFont(BOLD);
        FontProgram italicProgram = FontProgramFactory.createFont(ITALIC);
        for (int i = 0; i < 3; ) {
            app.font = PdfFontFactory.createFont(fontProgram, PdfEncodings.WINANSI, true);
            app.bold = PdfFontFactory.createFont(boldProgram, PdfEncodings.WINANSI, true);
            app.italic = PdfFontFactory.createFont(italicProgram, PdfEncodings.WINANSI, true);
            app.createPdf(String.format(DEST, ++i));
        }
    }
    
    public void createPdf(String dest) throws IOException {
        // Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));

        // Initialize document
        Document document = new Document(pdf);
        
        // Add content
        Text title = new Text("The Strange Case of Dr. Jekyll and Mr. Hyde").setFont(bold);
        Text author = new Text("Robert Louis Stevenson").setFont(font);
        Paragraph p = new Paragraph().setFont(italic).add(title).add(" by ").add(author);
        document.add(p);
        
        //Close document
        document.close();
    }
}