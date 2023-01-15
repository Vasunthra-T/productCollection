import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.lang.String;
import java.util.List;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class GstCalculation {
    static double wsDiscountRate = 0.0;
    static double reDiscountRate = 0.0;
    static String billHeader = "";
    static double totalPrice = 0.0;


    public static void calculateGSTWS(ArrayList<Wholesaler> wholeSalerDetails) {
        ArrayList<Product> pr = new ArrayList<>();
        billHeader = "Whole Saler";
        wholeSalerDetails.forEach((ws) -> {
            ws.wholesaler_product_list.forEach((item) -> {
                totalPrice += item.getPrice() * item.getStock();
                if (item.getStock() > 10 && item.getStock() < 50) {
                    wsDiscountRate += (item.getPrice() * item.getStock() * 0.1);
                }
                if (item.getStock() > 50 && item.getStock() < 100) {
                    wsDiscountRate += (item.getPrice() * item.getStock() * 0.2);
                }
                if (item.getStock() > 100) {
                    wsDiscountRate += (item.getPrice() * item.getStock() * 0.3);
                }

                pr.add(item);
            });
        });
        generatePDF(pr,wsDiscountRate);
    }

    public static void calculateGSTRE(ArrayList<Retailer> retailerDetails) {
        ArrayList<Product> pr = new ArrayList<>();
        billHeader = "Retailer";
        retailerDetails.forEach((re) -> {
            re.retailer_product_list.forEach((item) -> {
                totalPrice += item.getPrice() * item.getStock();

                if (item.getStock() > 10 && item.getStock() < 50) {
                    reDiscountRate += (item.getPrice() * item.getStock() * 0.05);
                }
                if (item.getStock() > 50 && item.getStock() < 100) {
                    reDiscountRate += (item.getPrice() * item.getStock() * 0.1);
                }
                if (item.getStock() > 100) {
                    reDiscountRate += (item.getPrice() * item.getStock() * 0.15);
                }
                pr.add(item);

            });
        });
        generatePDF(pr,reDiscountRate);

    }
    static String para ="";
    public static void  generatePDF(ArrayList<Product> pr,double discount)  {
        Document doc = new Document();

        try {
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("/Users/vasunthra/Documents/training/GST/src/Billing.pdf"));
            System.out.println("PDF created.");
            doc.open();
            //adds paragraph to the PDF file
            doc.add(new Paragraph("PRODUCT BILL" + "\n" + "PRODUCT_ID" + "   " + "QUANTITY" + "   " + "PRICE"));

            pr.forEach((eachPr)->{
                para += eachPr.getId() +" "+eachPr.getStock()+" "+(eachPr.getStock()* eachPr.getPrice())+"\n\n";
            });

                doc.add(new Paragraph( para));
                doc.add(new Paragraph("Amount: "+totalPrice));
                doc.add(new Paragraph("Discount: "+discount));
                doc.add(new Paragraph("GST(18%): "+ (totalPrice*0.18)));
                doc.add(new Paragraph("Total amount: "+(totalPrice-discount+(totalPrice*0.18))));

            //close the PDF file
            doc.close();
            //closes the writer
            writer.close();
        } catch(DocumentException e)
        {
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();

        }
    }


}
