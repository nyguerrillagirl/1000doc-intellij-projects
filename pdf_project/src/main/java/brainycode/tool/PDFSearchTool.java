package brainycode.tool;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * PDFSearchTool - processes the pdf books in designated path for searchString.
 * Usage: pdfsearchtool.bat file shall be provided that invokes
 */
public class PDFSearchTool {

    public static boolean validatedFilePath(String filePath){
        File file = new File(filePath);
        return file.exists();
    }

    public static void main(String[] args) {
        Logger.getLogger("org.apache.pdfbox").setLevel(Level.OFF);
        System.setErr(new PrintStream(OutputStream.nullOutputStream()));

        // process arguments
        if (args.length != 2) {
            System.out.println("Usage: pdfsearchtool <filepath> <searchString>");
            System.exit(1);
        }
        String filePath = args[0];
        String searchString = args[1];
        System.out.println("filePath: " + filePath);
        System.out.println("searchString: " + searchString);
        if (!validatedFilePath(filePath)) {
            System.out.println("Invalid file path: " + filePath);
            System.exit(1);
        }

        PDFSearchTool pst = new PDFSearchTool();
        pst.findSearchString(filePath, searchString);
    }

    private void findSearchString(String filePath, String searchString) {
        List<Path> matches = new ArrayList<>();
        Path root =  Paths.get(filePath);
        try (var paths = Files.walk(Paths.get(filePath))) {
            paths.filter(Files::isRegularFile)
                    .filter(p -> p.toString().toLowerCase().endsWith(".pdf"))
                    .forEach(pdfFile -> {
                       if (containsText(pdfFile, searchString)) {
                           System.out.print(".");
                           matches.add(root.relativize(pdfFile));
                       }
                    });

            System.out.println();
            System.out.println("Matches:");
            System.out.println("--------");
            for (Path pdfFile : matches) {
                System.out.println(pdfFile);
            }
        } catch  (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to process folder: " + filePath);
        }
    }

    private boolean containsText(Path pdfFile, String searchString) {
        try (PDDocument document = Loader.loadPDF(pdfFile.toFile())) {
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            return text.contains(searchString);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Unable to process: " + pdfFile.getFileName());
            return false;
        }
    }
}
