package com.tim15.sluzbenik.jenafuseki;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class FusekiWriterExample {
    private static final String RDF_FILEPATH = "src/main/resources/rdf/";
    private static final String GRAPH_URI = "metadata";

    public static void saveRDF(String filepath, String metdataUri) throws IOException {
        System.out.println("[INFO] Loading triples from an RDF/XML to a model...");
        FusekiAuthenticationUtilities.ConnectionProperties conn = FusekiAuthenticationUtilities.loadProperties(metdataUri);

        Model model = ModelFactory.createDefaultModel();
        model.read(RDF_FILEPATH+filepath);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        model.write(out, SparqlUtil.NTRIPLES);
        System.out.println("[INFO] Rendering model as RDF/XML...");
        model.write(System.out, SparqlUtil.RDF_XML);

        UpdateRequest request = UpdateFactory.create();
        UpdateProcessor processor = UpdateExecutionFactory.createRemote(request,conn.updateEndpoint);
        processor.execute();
        System.out.println("[INFO] Writing the triples to a named graph \"" + metdataUri + "\".");
        String sparqlUpdate = SparqlUtil.insertData(conn.dataEndpoint +metdataUri,
                new String(out.toByteArray()));
        System.out.println(sparqlUpdate);

        UpdateRequest update = UpdateFactory.create(sparqlUpdate);
        processor = UpdateExecutionFactory.createRemote(update,conn.updateEndpoint);
        processor.execute();

    }
}
