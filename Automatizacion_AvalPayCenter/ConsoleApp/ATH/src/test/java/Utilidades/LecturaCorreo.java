package Utilidades;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;

public class LecturaCorreo {

	static Properties props = new Properties();
	static Part contenidoCorreo = null;
	public static String cuerpoCorreo = null;
	
	public static String leerCorreo(String correoOutlook, String passOutlook)
    {		
		Properties prop = new Properties();
		// DESHABILITAOS TLS
		prop.setProperty("mail.pop3.starttls.enable","false");
		// SSL
		prop.setProperty("mail.pop3.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		prop.setProperty("mail.pop3.socketFactory.fallback","false");
		// PUERTO 955 PARA CONECTARSE
		prop.setProperty("mail.pop3.port","995");
		prop.setProperty("mail.pop3.socketFactory.port","995");
				
		Session sesion = Session.getInstance(prop);
//		sesion.setDebug(true);
		
//		String mensajeCorreo = null;
		try {
						
			// STORE Y FOLDER PARA LEER EL CORREO
			Store store = sesion.getStore("pop3");
			store.connect("outlook.office365.com",correoOutlook,passOutlook);
			Folder folder = store.getFolder("INBOX");
			folder.open(Folder.READ_ONLY);
			
			// SE OBTIENEN LOS MENSAJES
			Message [] mensajes = folder.getMessages();
			
			// FROM Y SUBJECT DE CADA MENSAJE
			for (int i=(mensajes.length-1);i<mensajes.length;i++)
			{
			   // SE IMPRIME EL REMITENTE DEL CORREO QUE SE ESTA LEYENDO
			   System.out.println("From:"+mensajes[i].getFrom()[0].toString());
			   // SE IMPRIME EL ASUNTO DEL CORREO QUE SE ESTA LEYENDO
			   System.out.println("Subject:"+mensajes[i].getSubject());
			   // SE EXTRAE EL CONTENIDO DEL CORREO MEDIANTE ESTE METODO
			   analizaParteDeMensaje(mensajes[i]);
			   
			}
			
            folder.close(false);
            store.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			e.toString();
			System.out.println("FALLÓ LA LECTURA DEL CORREO, EL ERROR ES: ###" + e);
		}
		
		return cuerpoCorreo;			
    }
	

	 private static void analizaParteDeMensaje(Part unaParte) throws MessagingException, IOException
	    {
		 	
	          // SI ES MULTIPARTE, SE ANALIZAN CADA UNA DE LAS PARTES
	            if (unaParte.isMimeType("multipart/*"))
	            {
	                Multipart multi;
	                multi = (Multipart) unaParte.getContent();

	                for (int j = 0; j < multi.getCount(); j++)
	                {
	                    analizaParteDeMensaje(multi.getBodyPart(j));
	                }

            }
	            else
	            {
	              // SI ES TEXTO, SE ESCRIBE EL TEXTO.
	                if (unaParte.isMimeType("text/*"))
	                {
	                    System.out.println("Texto " + unaParte.getContentType());
	                    
	                    cuerpoCorreo = unaParte.getContent().toString();
	                    System.out.println(unaParte.getContent());
	                    
	                    System.out.println("---------------------------------");
	                    
	                   // return cuerpoCorreo;
	                }
	                
	                    else
	                    {
	                      // SI NO ES ALGUNA DE LAS ANTERIORES, SE ESCRIBE ESTO.
	                        System.out.println("EMAIL NO LEIDO" + unaParte.getContentType());
	                        System.out.println("---------------------------------");
	                    }
	                }            
				//return cuerpoCorreo;
	    }
	 
	
	 
	 public static String obtenerCodigo(String correoOutlook, String passOutlook)
	    {
		 String lecturaVector = null;
	        try
	        {
	            String lecturaCorreo = leerCorreo(correoOutlook, passOutlook);
	  			 lecturaCorreo = lecturaCorreo.replace("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">{username}, su codigo de verificacion es `","");
	  			 lecturaCorreo = lecturaCorreo.replace("`" ,"");
	  			 lecturaVector = lecturaCorreo.trim();
	  			//return lecturaVector;
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        return lecturaVector;
	    }
	 
}
	