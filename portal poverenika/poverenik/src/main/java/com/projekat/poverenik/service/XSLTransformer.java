package com.projekat.poverenik.service;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

@Component
public class XSLTransformer {
    private String fopPath = "src/main/resources/conf/fop.xconf";
    public String convertXMLtoHTML(String xslFilePath, Document xml, String htmlFile) {

        String xmlString = XMLToString(xml);

        TransformerFactory factory = TransformerFactory.newInstance();
        StreamSource xslStream = new StreamSource(new File(xslFilePath));

        StreamSource in = new StreamSource(new StringReader(xmlString));
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        Result out = new StreamResult(outStream);

        try {
            Transformer transformer = factory.newTransformer(xslStream);
            transformer.transform(in, out);

            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(htmlFile));
            outputStream.write(outStream.toByteArray());
            System.out.println("[INFO] File \""  + "\" generated successfully.");
            outputStream.close();

            return outStream.toString();
        } catch (TransformerException | IOException e) {
            e.printStackTrace();
        }
        return "";

    }

    public String XMLToString(Document doc) {
        try {
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            return sw.toString();
        } catch (Exception ex) {
            throw new RuntimeException("Error converting to String", ex);
        }
    }

    public void generatePDf(String sourceStr, String xslt_fo_TemplatePath, String pdfFile) throws Exception {
        File xslFile = new File(xslt_fo_TemplatePath);

        StreamSource transformSource = new StreamSource(xslFile);

        StreamSource source = new StreamSource(new StringReader(sourceStr));
        FopFactory fopFactory = FopFactory.newInstance(new File(fopPath));
        FOUserAgent userAgent = fopFactory.newFOUserAgent();

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer xslFoTransformer = tf.newTransformer(transformSource);

        Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, userAgent, outStream);

        Result res = new SAXResult(fop.getDefaultHandler());

        xslFoTransformer.transform(source, res);

        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(pdfFile));
        outputStream.write(outStream.toByteArray());
        System.out.println("[INFO] File \""  + "\" generated successfully.");
        outputStream.close();
    }

}
