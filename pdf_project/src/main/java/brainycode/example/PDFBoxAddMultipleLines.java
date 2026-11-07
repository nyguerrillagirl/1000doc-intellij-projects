package brainycode.example;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.File;

public class PDFBoxAddMultipleLines {

    public static void main(String[] args) throws Exception {
        // Loading an existing document
        PDDocument document = Loader.loadPDF(
                new RandomAccessReadBufferedFile("D://tmp//my_doc5.pdf"));

        // Retrieving the pages of the document
        PDPage page = document.getPage(0);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        // Begin the content stream
        contentStream.beginText();

        // Setting the font to the content stream
        contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.COURIER_BOLD_OBLIQUE), 12);

        // Setting the leading
        contentStream.setLeading(14.5f);

        // Setting the position for the line
        contentStream.newLineAtOffset(25, 725);

        String text1 = "This is an example of adding text to a page in the pdf document.";
        String text2 = "We can add as many lines";
        String text3 = "as we want like this using the ShowText()  method of the ContentStream class";

        // Adding text in the form of string
        contentStream.showText(text1);
        contentStream.newLine();
        contentStream.showText(text2);
        contentStream.newLine();
        contentStream.showText(text3);

        // Ending the content stream
        contentStream.endText();

        System.out.println("Content added.");

        // Closing the content stream
        contentStream.close();

        // Saving the document
        document.save(new File("D://tmp//my_doc7.pdf"));

        // Close the document
        document.close();
    }
}
