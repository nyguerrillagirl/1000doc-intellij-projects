package brainycode.example;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdmodel.PDDocument;

public class PDFBoxRemovePageSaveDoc {

    public static void main(String[] args) throws Exception {
        // Loading an existing document
        PDDocument document = Loader.loadPDF(
                new RandomAccessReadBufferedFile("D://tmp//my_doc3.pdf"));
        // Listing the number of existing pages
        int noOfPages = document.getNumberOfPages();
        System.out.println("Number of pages: " + noOfPages);
        // Remove the pages
        document.removePage(2);
        System.out.println("Removed the third page.");

        // Saving the document
        document.save("D://tmp//my_doc4.pdf");

        // Closing the document
        document.close();
        System.out.println("PDFBoxRemovePageSaveDoc completed!");
    }
}
