package brainycode.example;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;




public class PDFBoxReadProperties {
    public static void main(String[] args) throws Exception {

        // Load an existing document
        PDDocument document = Loader.loadPDF(
                new RandomAccessReadBufferedFile("D://tmp//GameMakerChallenge1.pdf"));

        System.out.println("GameMakerChallenge1.pdf loaded!");

        // Getting the PDDocumentInformation object
        PDDocumentInformation pdd = document.getDocumentInformation();

        // Retrieve the info in the PDF document

        System.out.println("Author of the document is: " + pdd.getAuthor());
        System.out.println("Title of the document is: " + pdd.getTitle());
        System.out.println("Subject of the document is: " + pdd.getSubject());
        System.out.println("Creator of the document is: " + pdd.getCreator());
        System.out.println("Creation date of the document is: " + format(pdd.getCreationDate()));
        System.out.println("Modifcation date of the document is: " + format(pdd.getCreationDate()));
        System.out.println("Keywords of the document is: " + pdd.getKeywords());

        // Closing document
        document.close();
    }

    public static String format(Calendar date) {
        SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yyyy");
        fmt.setCalendar(date);
        String dateFormatted = fmt.format(date.getTime());
        return dateFormatted;
    }
}
