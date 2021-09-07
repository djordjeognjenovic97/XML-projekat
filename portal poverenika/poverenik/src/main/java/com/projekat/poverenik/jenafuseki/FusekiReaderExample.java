package com.projekat.poverenik.jenafuseki;

import org.apache.commons.text.StringSubstitutor;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.RDFNode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class FusekiReaderExample {
    //private static final String QUERY_FILEPATH = "src/main/resources/rdf/sparql.rq";
    private FusekiReaderExample(){}

    public static ArrayList<String> executeQuery(Map<String,String> params, String metadataUri) throws IOException {
        FusekiAuthenticationUtilities.ConnectionProperties conn = FusekiAuthenticationUtilities.loadProperties(metadataUri);
        String queryFilepath = "src/main/resources/rdf/";
        if(metadataUri.contains("zalbacutanje")) {
            queryFilepath = queryFilepath + "sparqlZalbacutanje.rq";
        } else if(metadataUri.contains("zalbanaodluku")) {
            queryFilepath = queryFilepath + "sparqlZalbanaodluku.rq";
        }
        else if(metadataUri.contains("resenje")) {
            queryFilepath = queryFilepath + "sparqlResenje.rq";
        }
        String sparqlQueryTemplate = readFile(queryFilepath, StandardCharsets.UTF_8);
        System.out.println("Query: " + sparqlQueryTemplate);
        String sparqlQuery = StringSubstitutor.replace(sparqlQueryTemplate,params,"{{","}}");
        System.out.println("Query: " + sparqlQuery);
        QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint,sparqlQuery);
        ResultSet results = query.execSelect();

        String varName;
        RDFNode varValue;
        ArrayList<String> foundFakultete = new ArrayList<>();
        while(results.hasNext()){
            // A single answer from a SELECT query
            QuerySolution querySolution = results.next();
            Iterator<String> variableBindings = querySolution.varNames();
            // Retrieve variable bindings
            while(variableBindings.hasNext()){
                varName = variableBindings.next();
                varValue = querySolution.get(varName);
                System.out.println(varName + ": " + varValue);
                if(varName.contains("broj_predmeta") || varName.contains("broj_resenja")){
                    String value = varValue.toString();
                    foundFakultete.add(value);
                }
            }
        }
        ResultSetFormatter.outputAsXML(System.out,results);
        query.close();
        return foundFakultete;
    }

    public static void executeQueryforJSON(Map<String,String> params,String metadataUri,String id) throws IOException {
        FusekiAuthenticationUtilities.ConnectionProperties conn = FusekiAuthenticationUtilities.loadProperties(metadataUri);
        String queryFilepath="src/main/resources/rdf/";
        if(metadataUri.contains("zalbacutanje")) {
            queryFilepath = queryFilepath + "sparqlZalbacutanje.rq";
        } else if(metadataUri.contains("zalbanaodluku")) {
            queryFilepath = queryFilepath + "sparqlZalbanaodluku.rq";
        }
        else if(metadataUri.contains("resenje")) {
            queryFilepath = queryFilepath + "sparqlResenje.rq";
        }
        String sparqlQueryTemplate = readFile(queryFilepath, StandardCharsets.UTF_8);
        System.out.println("Query: " + sparqlQueryTemplate);
        String sparqlQuery = StringSubstitutor.replace(sparqlQueryTemplate,params,"{{","}}");
        System.out.println("Query: " + sparqlQuery);
        QueryExecution query = QueryExecutionFactory.sparqlService(conn.queryEndpoint,sparqlQuery);
        ResultSet results = query.execSelect();

        ResultSetFormatter.outputAsJSON(new FileOutputStream(new File("src/main/resources/json/"+id)),results);
        query.close();
    }

    public static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded,encoding);
    }
}
