package brainycode.example;

import org.apache.pdfbox.pdmodel.PDDocument;

public class PDFBoxCreateSaveDoc {

    public static void main(String[] args) throws Exception {

        // Creating PDF Document object
        PDDocument document = new PDDocument();

        // Saving the document
        document.save("D://tmp//my_doc.pdf");

        System.out.println("PDF created.");

        // Closing the document
        document.close();
    }
}
