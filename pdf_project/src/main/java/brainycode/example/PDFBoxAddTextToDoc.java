package brainycode.example;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

public class PDFBoxAddTextToDoc {

    public static void main(String[] args) throws Exception {

        PDDocument document = Loader.loadPDF(
                new RandomAccessReadBufferedFile("D://tmp//my_doc5.pdf"));

        // Retrieving the pages of the document
        PDPage page = document.getPage(0);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        // Begin the Content stream
        contentStream.beginText();

        // Setting the font of the Content Stream
        contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 12);

        // Setting the position for the line
        contentStream.newLineAtOffset(25, 500);

        String text = "This is my 'Hello World!'.";

        // Adding text in the form of string
        contentStream.showText(text);

        // Ending the content stream
        contentStream.endText();

        System.out.println("Content added to document my_doc5.pdf");

        // Closing the content stream
        contentStream.close();

        // Saving the document
        document.save("D://tmp//my_doc6.pdf");

        document.close();
    }
}
