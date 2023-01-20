package com.example.billing.service;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Properties;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;

@Service
public class BillingService implements BillingInterface {

    static double wsDiscountRate = 0.0;
    static double reDiscountRate = 0.0;
    static double totalPrice = 0.0;
    int quantity=20;


    static String para ="";
    public  void  generatePDFWholesaler(String whname,int pid,String pname,int price,double gst)  {
        Document doc = new Document();

        try {
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("/Users/vasunthra/Downloads/billing/src/main/java/bill.pdf"));
            System.out.println("PDF created.");
            doc.open();
            //adds paragraph to the PDF file
            doc.add(new Paragraph("PRODUCT BILL" + "\n" +"Wholesaler Name"+ "Product ID" + "Product Name" + "MRP"+"Qty"+"GST"));

            if (quantity > 10 && quantity <= 50) {
                wsDiscountRate += (price * quantity * 0.1);
            }
            else if (quantity > 50 && quantity <= 100) {
                wsDiscountRate += (price * quantity * 0.2);
            }
            else if (quantity > 100) {
                wsDiscountRate += (price * quantity * 0.3);
            }
            totalPrice = (wsDiscountRate+(totalPrice*(gst/100)));

            para += whname + " " +pid+" "+pname+" "+price+" "+quantity+" "+gst+"%\n";

            doc.add(new Paragraph( para));
            doc.add(new Paragraph("GST: "+ gst));
            doc.add(new Paragraph("Total amount: "+totalPrice));
            System.out.println("PDF GENERATED");

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

    public  void  generatePDFRetailer(String rname,int pid,String pname,int price,double gst)  {
        Document doc = new Document();

        try {
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("/Users/vasunthra/Downloads/billing/src/main/java/billing.pdf"));
            System.out.println("PDF created.");
            doc.open();
            //adds paragraph to the PDF file
            doc.add(new Paragraph("PRODUCT BILL" + "\n" +"Retailer Name"+ "Product ID" + "Product Name" + "MRP"+"Qty"+"GST"));

            if (quantity > 10 && quantity <= 50) {
                reDiscountRate += (price * quantity * 0.05);
            }
            else if (quantity > 50 && quantity <= 100) {
                reDiscountRate += (price * quantity * 0.1);
            }
            else if (quantity > 100) {
                reDiscountRate += (price * quantity * 0.15);
            }
            totalPrice = (reDiscountRate+(totalPrice*(gst/100)));

            para += rname + " " +pid+" "+pname+" "+price+" "+quantity+" "+gst+"%\n";

            doc.add(new Paragraph( para));
            doc.add(new Paragraph("GST: "+ gst));
            doc.add(new Paragraph("Total amount: "+totalPrice));
            System.out.println("PDF GENERATED");

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
    public void sendEmail(){
        // email ID of Recipient.
        String recipient = "vasunthrat@gmail.com";

        // email ID of  Sender.
        String sender = "vasunthrat@gmail.com";

        // using host as localhost
        String host = "127.0.0.1";

        // Getting system properties
        Properties properties = System.getProperties();

        // Setting up mail server
        properties.setProperty("mail.smtp.host", host);

        // creating session object to get properties
        javax.mail.Session session = javax.mail.Session.getDefaultInstance(properties);

        try
        {
            // MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From Field: adding senders email to from field.
            message.setFrom(new InternetAddress(sender));

            // Set To Field: adding recipient's email to from field.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

            // Set Subject: subject of the email
            message.setSubject("This is Subject");

            // set body of the email.
            message.setText("This is a test mail");

            // Send email.
            Transport.send(message);
            System.out.println("Mail successfully sent");
        }
        catch (MessagingException mex)
        {
            mex.printStackTrace();
        }
    }
    }





