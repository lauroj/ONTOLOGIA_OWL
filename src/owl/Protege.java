/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owl;

/**
 *
 * @author Jorge
 */
import com.hp.hpl.jena.ontology.*;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import java.util.List;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Protege {
     public static List<String> lista1=new ArrayList<>();
     public static List<String> lista2=new ArrayList<>();
     public static List<String> lista3=new ArrayList<>();
     public static List<String> lista4=new ArrayList<>();
   
    public  static void llenarConsola() {
        OntModel unl = ModelFactory.createOntologyModel();
        //unl.read("http://www.semanticweb.org/jorge/ontologies/2014/5/untitled-ontology-10"); 
        try {
            InputStream file = new FileInputStream("ontologia.owl");
            unl.read(file, "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }        
        Iterator<OntClass> clases = unl.listClasses();
         while (clases.hasNext()) {      
             if(clases.next().getLocalName()!=null){
            lista1.add("\n"+clases.next().getLocalName());
                }       
         }
        Iterator<Individual> individuos = unl.listIndividuals();
        while (individuos.hasNext()) {            
            lista2.add("\n"+individuos.next().getLocalName());
        }
       Iterator<ObjectProperty> relaciones = unl.listObjectProperties();
        while (relaciones.hasNext()) {
               lista3.add("\n"+relaciones.next().getLocalName());
            }  
        Iterator<DatatypeProperty> propiedades = unl.listDatatypeProperties();
         while (propiedades.hasNext()) {      
             
            lista4.add("\n"+propiedades.next().getLocalName());
                       
         }
        
    }
}
