package brainycode.example;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.InputStream;

public class PDFBoxAddImageKeepExistingText {
    public static void main(String[] args) throws Exception {
        // Loading existing document:
        PDDocument document = Loader.loadPDF(
                new RandomAccessReadBufferedFile("D://tmp//my_doc7.pdf"));

        // Retrieving the page
        PDPage page = document.getPage(0);

        // Load image as a resource stream
        InputStream imageStream =
                PDFBoxAddImageToDoc.class.getResourceAsStream("/house2-red-1.png");

        // Creating PDImageXObject object
        PDImageXObject pdImage =
                PDImageXObject.createFromByteArray(
                        document,
                        imageStream.readAllBytes(),
                        "house2-red-1.png");

        // Creating the PDPageContentStream object
        PDPageContentStream contents = new PDPageContentStream(document, page,
                PDPageContentStream.AppendMode.APPEND, true);

        // Drawing the image in the PDF Document
        contents.drawImage(pdImage, 70, 250);

        System.out.println("Image inserted to pdf document.");

        contents.close();
        document.save("D://tmp//my_doc9.pdf");
        document.close();
    }
}
