package casaquinta.fichaclinica.backend.service;


import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;

import casaquinta.fichaclinica.backend.model.entity.Sesion;
import casaquinta.fichaclinica.backend.controller.SendEmail;
@Service
public class ITextPdfService  {

    @Autowired
    private final SendEmail sendEmail;

    ITextPdfService(SendEmail email){
        this.sendEmail =email;
    }

    public void createPdfSesion (Sesion sesion, String correo) throws FileNotFoundException, DocumentException, MessagingException{
        // Creamos un nuevo documento de Itext
        Document document = new Document();
        //Abrimos un Stream a memoria donde guardaremos el documento
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //Abrimos la api de Itext para escribir el pdf 
        PdfWriter.getInstance(document, outputStream);

        // PdfWriter.getInstance(document, new FileOutputStream(Long.toString(sesion.getId())+".pdf"));
        //Abrimos el documento
        // document.open();

        rellenarPdf(sesion, document);
        // document.add(parrafo);

        //Cerramos el documento
        // document.close();

        byte [] bytes = outputStream.toByteArray();
        DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
        this.sendEmail.enviarMIME(correo,"prueba","Hola, esta es una prueba",sesion.getFecha().toString(),dataSource);

    }

    public void rellenarPdf(Sesion sesion, Document document) throws DocumentException{
        //Abrimos el documento
        document.open();
        Paragraph parrafo = new Paragraph();

        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        
        //Informacion fecha
        parrafo.add(new Chunk("Fecha: " + sesion.getFecha().toString() + ".\n \n", font));
        
        //Informacion profesional
        parrafo.add(new Chunk("Profesional: " + sesion.getProfesional() + ".\n \n", font));

        //Informacion especialidad (terapia realizada)
        parrafo.add(new Chunk("Especialidad: " + sesion.getTipo_sesion() + ".\n \n", font));

        //Informacion formato 
        if(sesion.getFormato_presencial()){
            parrafo.add(new Chunk("Formato sesión: Presencial.\n \n", font));
        }else{
             parrafo.add(new Chunk("Formato sesión: Online.\n \n", font));
        }

        //Informacion acompañado
        if(sesion.getAcompanado()){
            parrafo.add(new Chunk("Acompañado: Con acompañante.\n \n", font));
        }else{
            parrafo.add(new Chunk("Acompañado: Sin acompañante.\n \n", font));
        }
    
        //Informacion objetivo/actividad
        parrafo.add(new Chunk("Objetivo/Actividad: \n" + sesion.getObjetivo_actividad() + ".\n \n", font));

        //Informacion indicacion a cuidadores
        parrafo.add(new Chunk("Indicacion a cuidadores: \n" + sesion.getIndicacion_cuidadores() + ".\n \n", font));

        //Informacion observaciones
        parrafo.add(new Chunk("Observaciones: \n" + sesion.getObservaciones() + ".\n \n", font));
        //Añadimos informacion al documento
        document.add(parrafo);
        //Cerramos el documento
        document.close();
        
    }


}
