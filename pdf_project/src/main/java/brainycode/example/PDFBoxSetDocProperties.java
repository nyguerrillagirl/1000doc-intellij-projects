package brainycode.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class PDFBoxSetDocProperties {
    public static void main(String[] args) throws Exception {
        // Creating PDF Document object
        PDDocument document = new PDDocument();

        // Creating a blank page
        PDPage page = new PDPage();

        // Adding the blank page to the document
        document.addPage(page);

        // Creating the PDDocumentInformation object
        PDDocumentInformation pdd = document.getDocumentInformation();

        // Setting the author of the document
        pdd.setAuthor("Lorraine Figueroa");

        // Setting the title of the document
        pdd.setTitle("Sample document");

        // Setting the creator of the document
        pdd.setCreator("BRAINYCODE");

        // Setting the subject of the document
        pdd.setSubject("Learning all about PDFBox");

        // Setting the created date of the document
        Calendar date = new GregorianCalendar();
        pdd.setCreationDate(date);

        // Setting the keywords for the document
        pdd.setKeywords("sample, first example, my pdf");

        // Saving the document
        document.save("D://tmp//my_doc5.pdf");

        System.out.println("Properties added to my_doc5.pdf");

        // Closing the document
        document.close();
    }
}
