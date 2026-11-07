package brainycode.example;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class PDFBoxLoadPdf {

    public static void main(String[] args) throws Exception {
        // Loading an existing document
        PDDocument document = Loader.loadPDF(
                new RandomAccessReadBufferedFile("D://tmp//my_doc2.pdf"));

        System.out.println("PDF loaded!");

        // Adding another blank page to the document
        document.addPage(new PDPage());

        // Saving the document
        document.save("D://tmp//my_doc3.pdf");

        // Closing the document
        document.close();
    }
}
