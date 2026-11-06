package brainycode.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;

public class PDFBoxAddPagesSaveDoc {

    public static void main(String[] args) {
        // Create PDF document
        PDDocument doc = null;
        try {
            doc = new PDDocument();
            for (int i=0; i < 10; i++) {
                // Create a blank page
                PDPage blankPage = new PDPage();

                // Add the blank page to the document
                doc.addPage(blankPage);
            }
            // Save the document
            doc.save("D://tmp//my_doc2.pdf");

            System.out.println("PDF created!");

            // Closing the document
            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
