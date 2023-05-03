package PageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import MapsObjects.P3_ConfirmaTuPago;
import MapsObjects.P5_RecibeTuComprobante;
import RunPruebas.RunPrincipal;
import Utilidades.Sprint1Utilities;
import io.qameta.allure.Step;

public class P5_RecibeTuComprobantePage extends P5_RecibeTuComprobante {

	private static Logger log = LogManager.getLogger(RunPrincipal.class.getName());

	public P5_RecibeTuComprobantePage(WebDriver driver) {
		super(driver);
	}

	Sprint1Utilities sprint1utilities = new Sprint1Utilities(driver);

	@Step("Metodo para ReeferenciaPago")
	public void referenciaPago(File folderPath, String busqueda, String valor, String detalle, String generarEvidencia,
			String numeroDocumento, String nombreCompleto, String correo, String confirmacionCorreo, String movil,
			String confirmacionMovil, String email) throws Exception {

		try {
			assertTrue(isPresent(spanLogoAval, folderPath, "Se valida CP01 - Validación de ambiente (despliegue QA)",
					"Logo"));
			sprint1utilities.MetodoIframe("iframe-buscador");

			// ASSERT - SP3_HU04_CP10
			displayed(txtBusqueda, folderPath, generarEvidencia,
					"Se valida CP10 - Validar que se muestre la opción de búsqueda del servicio o empresa(convenio)");
			System.out.println("Se valida el SP3_HU04_CP10");

			sendkey(busqueda, txtBusqueda, folderPath, generarEvidencia, "Se ingresa nombre del convenio");
			enter();
			scrollElement(btnPagarServicio, folderPath, generarEvidencia, "Scroll de visualizacion");
			click(btnPagarServicio, folderPath, generarEvidencia, "Se da click en boton Pagar");
			scrollWeb(400, 0, folderPath, generarEvidencia, 2, "Scroll de visualizacion");
			sprint1utilities.MetodoIframe("iframe-nofacturador");
			String documento2 = sprint1utilities.writeRandomNum2(4);
			sendkey(documento2, campoCedula, folderPath, generarEvidencia, "Se ingresa el numero de cedula o nit");
			sendkey(documento2, campoConfirmarCedula, folderPath, generarEvidencia,
					"Se confirma el numero de cedula o nit");
			sendkey(valor, campoValorPagar, folderPath, generarEvidencia, "Se ingresa el valor a pagar");
			sendkey(detalle, campoDetalle, folderPath, generarEvidencia, "Se ingresa el detalle");
			scrollElement(btnContinuar, folderPath, generarEvidencia, "Scroll de visualizacion");
			click(btnContinuar, folderPath, generarEvidencia, "Se da click en el boton Continuar");
			click(checkbox, folderPath, generarEvidencia, "Se da click en el Checkbox de terminos y condiciones");
			click(btnPagar2, folderPath, generarEvidencia, "Se da click en boton pagar");

			click(campoTipoDocumento, folderPath, generarEvidencia, "Se da click en el campo Tipo de Documento");
			click(campoTipoDocumentoPrimerOpcion, folderPath, generarEvidencia,
					"Se da click en la primera opcion de Tipo de Documento");
			sendkey(numeroDocumento, campoNumeroDocumento, folderPath, generarEvidencia,
					"Se ingresa el Numero de Documento");
			sendkey(nombreCompleto, campoNombreCompleto, folderPath, generarEvidencia, "Se ingresa el Nombre Completo");
			sendkey(correo, campoCorreo, folderPath, generarEvidencia, "Se ingresa el Correo Electrónico");
			sendkey(confirmacionCorreo, campoConfirmarCorreo, folderPath, generarEvidencia,
					"Se ingresa la Confirmación de Correo Electrónico");
			click(campoPais, folderPath, generarEvidencia, "Se da click en el campo Pais");
			click(campoPaisPrimerOpcion, folderPath, generarEvidencia, "Se da click en la primera opcion de Pais");
			sendkey(movil, campoMovil, folderPath, generarEvidencia, "Se ingresa el Móvil para notificaciones");
			sendkey(confirmacionMovil, campoConfirmacionMovil, folderPath, generarEvidencia,
					"Se ingresa la Confirmacion Móvil");
			scrollElement(txtMedioDePago, folderPath, generarEvidencia, "Se visualiza los medios de pago");
			click(metodoPagoPse, folderPath, generarEvidencia, "Se da click en el metodo de pago PSE");
			click(campoSeleccionBanco, folderPath, generarEvidencia, "Se da click en el campo Seleccion de Banco");
			click(campoSeleccionBancoOpcion, folderPath, generarEvidencia, "Se da click en el Banco UNION COLOMBIANO");
			click(btnPagar3, folderPath, generarEvidencia, "Se da click en el boton Pagar");
			sendkey(email, campoEmail, folderPath, generarEvidencia, "Se ingresa el correo registrado en PSE");
			click(btnIrAlBanco, folderPath, generarEvidencia, "Se da click en el boton Ir Al Banco");
			scrollElement(btnPay, folderPath, generarEvidencia, "Se visualiza el boton Pay");
			click(btnPay, folderPath, generarEvidencia, "Se da click en el boton Pay");

			// ASSERT - SP3_HU04_CP11
			displayed(assertModuloRecibeTuComprobante, folderPath, generarEvidencia,
					"Se valida CP11 - Validar que en la barra de progreso se encuentre en el paso (Recibe tu comprobante)");
			System.out.println("Se valida el SP3_HU04_CP11");
			
			scrollElement(assertTransaccionAprobada, folderPath, generarEvidencia, "Scroll de visualizacion");

			// ASSERT - SP3_HU04_CP02
			displayed(assertTransaccionAprobada, folderPath, generarEvidencia,
					"Se valida CP02 - : Validar que se genere el comprobante cuando la transacción se realiza con el pago exitoso con usuario no logueado)");
			System.out.println("Se valida el SP3_HU04_CP02");

		} catch (Exception e) {
			// ERROR
			printConsole("Estado del caso: Fallido");
			log.error(e.toString());
			printConsole(e.toString());
			throw new InterruptedException();
		}
	}

}
