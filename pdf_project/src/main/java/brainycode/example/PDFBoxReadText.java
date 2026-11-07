package brainycode.example;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFBoxReadText {

    public static void main(String[] args) throws Exception {

        // Loading an existing document
        PDDocument document = Loader.loadPDF(
                new RandomAccessReadBufferedFile("D://tmp//my_doc7.pdf"));

        // Instantiate PDFTextStripper class
        PDFTextStripper pdfStripper = new PDFTextStripper();

        // Retrieving text from PDF document
        String text = pdfStripper.getText(document);
        System.out.println(text);

        // Closing the document
        document.close();
    }
}
