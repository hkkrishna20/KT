import java.io.FileInputStream;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
public class BasicTextExtractor {
   public static void main(String[] args) {
      try {
        FileInputStream fis = new FileInputStream("C:\\Users\\HDMI\\Downloads\\Doc7e17.docx");
	XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
	XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
	System.out.println(extractor.getText());
      } catch(Exception ex) {
	ex.printStackTrace();
      } 
   }
} 