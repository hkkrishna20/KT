import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.POIXMLProperties.CoreProperties;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextShape;



public class test {

	public static void main(String[] args) throws Exception {
		String string = null;
        try {
            PDFParser pdfParser = new PDFParser(new RandomAccessFile(new File("C:\\Users\\HDMI\\Downloads\\Har_Krishna.pdf"), "r"));
            pdfParser.parse();
            PDDocument pdDocument = new PDDocument(pdfParser.getDocument());
            PDFTextStripper pdfTextStripper = new PDFLayoutTextStripper();
            string = pdfTextStripper.getText(pdDocument);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        };
        System.out.println(string);
        
        
        
//        try {

            FileInputStream fis = new FileInputStream("D:\\galería personal\\educativo\\Mtech\\Mtech1stSem\\SA\\Architectural Styles.pptx");
            XMLSlideShow pptxshow = new XMLSlideShow(fis);
            readPPT(pptxshow);
            /*List<XSLFSlide> slide2 = pptxshow.getSlides();
            for (int i = 0; i < slide2.size(); i++) {
                System.out.println(i);
                try {
                    XSLFNotes mynotes = slide2.get(i).getNotes();
                    for (XSLFShape shape : mynotes) {
                        if (shape instanceof XSLFTextShape) {
                            XSLFTextShape txShape = (XSLFTextShape) shape;
                            for (XSLFTextParagraph xslfParagraph : txShape.getTextParagraphs()) {
                                System.out.println(xslfParagraph.getText());
                            }
                        }
                    }
                } catch (Exception e) {

                }

            }
        } catch (IOException e) {

        }*/
	}
	public static void readPPT(XMLSlideShow ppt) {
        CoreProperties props = ppt.getProperties().getCoreProperties();
        String title = props.getTitle();
        
        for (XSLFSlide slide: ppt.getSlides()) {
        	List<XSLFShape> shapes = slide.getShapes();
        	for (XSLFShape shape: shapes) {
        		if (shape instanceof XSLFTextShape) {
        	        XSLFTextShape textShape = (XSLFTextShape)shape;
        	        String text = textShape.getText();
        	        System.out.println("" + text);
        		}
        	}
        }	 
	}	
}

