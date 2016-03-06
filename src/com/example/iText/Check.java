package com.example.iText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.ContentByteUtils;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.rtf.RtfWriter2;


public class Check {
    public static void main(String[] args) throws FileNotFoundException, IOException, DocumentException {

        PdfReader reader = new PdfReader("/home/susana/Documentos/test.pdf");
        int n = reader.getNumberOfPages();
        System.out.println("total no of pages:::" + n);

        Document document = new Document();

        RtfWriter2.getInstance(document, new FileOutputStream("/home/susana/Documentos/file.docx"));
        System.out.println("file created");
        document.open();
        byte[] bytes;
        for (int i = 1; i <= n; i++) {

            bytes = ContentByteUtils.getContentBytesForPage(reader, i);

            String s = new String(bytes);
            document.add(new Paragraph(s));

            document.newPage();


        }

        document.close();
    }
}
