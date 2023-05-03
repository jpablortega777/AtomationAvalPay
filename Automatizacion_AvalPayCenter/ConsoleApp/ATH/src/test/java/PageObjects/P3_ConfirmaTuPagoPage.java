package PageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import MapsObjects.P3_ConfirmaTuPago;
import RunPruebas.RunPrincipal;
import Utilidades.Sprint1Utilities;
import io.qameta.allure.Step;

public class P3_ConfirmaTuPagoPage extends P3_ConfirmaTuPago {

	private static Logger log = LogManager.getLogger(RunPrincipal.class.getName());

	public P3_ConfirmaTuPagoPage(WebDriver driver) {
		super(driver);
	}

	Sprint1Utilities sprint1utilities = new Sprint1Utilities(driver);

	@Step("Metodo para ingresar a los Terminos y condiciones")
	public void TerminosYCondiciones(File folderPath, String busqueda,String valor, String detalle,
			String generarEvidencia) throws Exception {

		try {
			assertTrue(isPresent(spanLogoAval, folderPath, "Se valida CP01 - Validación de ambiente (despliegue QA)", "Logo" ));
			sprint1utilities.MetodoIframe("iframe-buscador");
			sendkey(busqueda, txtBusqueda, folderPath, generarEvidencia, "Se ingresa nombre del convenio");
			enter();
			tiempoEspera(3);
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
			click(terminosYCondiciones, folderPath, generarEvidencia, "Se da click en terminos y condiciones");
			jumpPage(folderPath, "Se realiza salto de página y se visualiza el PDF", generarEvidencia);
			tiempoEspera(5);
		} catch (Exception e) {
			// ERROR
			printConsole("Estado del caso: Fallido");
			log.error(e.toString());
			throw new InterruptedException();
		}
	}

	@Step("Metodo para confirmacion boton Volver")
	public void botonVolver(File folderPath, String busqueda,String valor, String detalle,
			String generarEvidencia) throws Exception {
		try {

			assertTrue(isPresent(spanLogoAval, folderPath, "Se valida CP01 - Validación de ambiente (despliegue QA)", "Logo" ));
			sprint1utilities.MetodoIframe("iframe-buscador");
			sendkey(busqueda, txtBusqueda, folderPath, generarEvidencia, "Se ingresa nombre del convenio");
			enter();
			tiempoEspera(4);
			scrollElement(btnPagarServicio, folderPath, generarEvidencia, "Se visualiza el boton Pagar");
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
			click(btnVolver, folderPath, generarEvidencia, "Se da click en el boton volver");
			scrollElement(assertModuloDigitaTusDatosPagos, folderPath, generarEvidencia, "Scroll de visualizacion");
			// ASSERT - SP2_HU02_CP11
			displayed(assertModuloDigitaTusDatosPagos, folderPath, generarEvidencia,
					"Se valida CP11 - Validar que el botón Volver me retorne a la pantalla anterior(Digita tus datos de pago)");
			System.out.println("Se valida el SP2_HU02_CP11");

		} catch (Exception e) {
			// ERROR
			printConsole("Estado del caso: Fallido");
			log.error(e.toString());
			throw new InterruptedException();
		}

	}

	@Step("Metodo para confirmacion boton Pagar")
	public void botonPagar(File folderPath, String busqueda,String valor, String detalle,
			String generarEvidencia) throws Exception {
		try {
			
			assertTrue(isPresent(spanLogoAval, folderPath, "Se valida CP01 - Validación de ambiente (despliegue QA)", "Logo" ));
			sprint1utilities.MetodoIframe("iframe-buscador");
			sendkey(busqueda, txtBusqueda, folderPath, generarEvidencia, "Se ingresa nombre del convenio");
			enter();
			tiempoEspera(3);
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
			scrollElement(assertPaso1Buscar, folderPath, generarEvidencia, "Scroll de visualizacion");

			// ASSERT - SP2_HU02_CP02
			displayed(btnPagar2, folderPath, generarEvidencia,
					"Se valida CP02 - Validar ingreso a paso 3: Confirma tu pago");
			System.out.println("Se valida el SP2_HU02_CP02");

			// ASSERT - SP2_HU02_CP03
			assertEquals(textoValidacion(assertPaso1Buscar, folderPath,
					"Se valida CP03 - Validar barra de progreso del proceso de pago -Paso 1 Busca tu servicio o empresa"),
					"Busca tu servicio o empresa");
			assertEquals(textoValidacion(assertPaso2Digitar, folderPath,
					"Se valida CP03 - Validar barra de progreso del proceso de pago -Paso 2 Digita tus datos de pago"),
					"Digita tus datos de pago");
			assertEquals(
					textoValidacion(assertPaso3Confirmar, folderPath,
							"Se valida CP03 - Validar barra de progreso del proceso de pago -Paso 3 Confirma tu pago"),
					"Confirma tu pago");
			assertEquals(textoValidacion(assertPaso4PagaFacil, folderPath,
					"Se valida CP03 - Validar barra de progreso del proceso de pago -Paso 4 Paga fácil y seguro"),
					"Paga fácil y seguro");
			assertEquals(textoValidacion(assertPaso5Recibe, folderPath,
					"Se valida CP03 - Validar barra de progreso del proceso de pago -Paso 5 Recibe tu comprobante"),
					"Recibe tu comprobante");
			System.out.println("Se valida el SP2_HU02_CP03");

			// ASSERT - SP2_HU02_CP04
			displayed(assertLogo, folderPath, generarEvidencia, "Se valida CP04 - Visualizacion del logo del convenio");
			System.out.println("Se valida el SP2_HU02_CP04");

			// ASSERT - SP2_HU02_CP05
			assertEquals(textoValidacion(assertCampoServicioaPagar, folderPath,
					"Se valida CP05 - Se valida que se encuentra el campo Servicio a pagar: con su respectiva informacion y no es editable"),
					"Servicio a pagar:");
			assertEquals(textoValidacion(assertCampoDigiteCedula, folderPath,
					"Se valida CP05 - Se valida que se encuentra el campo Digite aqui su cedula o nit: con su respectiva informacion y no es editable"),
					"Digite aqui su cedula o nit:");
			assertEquals(textoValidacion(assertCampoValoraPagar, folderPath,
					"Se valida CP05 - Se valida que se encuentra el campo Valor a pagar: con su respectiva informacion y no es editable"),
					"Valor a pagar:");
			assertEquals(textoValidacion(assertCampoCostoTransaccion, folderPath,
					"Se valida CP05 - Se valida que se encuentra el campo Costo de la transacción: con su respectiva informacion y no es editable"),
					"Costo de la transacción:");
			assertEquals(textoValidacion(assertCampoDetallePago, folderPath,
					"Se valida CP05 - Se valida que se encuentra el campo Detalle del pago: con su respectiva informacion y no es editable"),
					"Detalle del pago:");
			System.out.println("Se valida el SP2_HU02_CP05");

			click(btnPagar2, folderPath, generarEvidencia, "Se da click en boton pagar");

			// ASSERT - SP2_HU02_CP09
			assertEquals(textoValidacion(assertTerminosCondiciones, folderPath,
					"Se valida CP09 - Se valida que se encuentra la alerta de que no acepto los terminos y condiciones"),
					"Por favor acepta los términos y condiciones de uso para realizar tu pago.");
			assertEquals(textoValidacion(btnCerrar, folderPath,
					"Se valida CP09 - Se valida que se encuentra el boton Cerrar"), "Cerrar");
			System.out.println("Se valida el SP2_HU02_CP09");

			click(btnCerrar, folderPath, generarEvidencia, "Se da click en Cerrar");

			// ASSERT - SP2_HU02_CP10
			assertEquals(
					textoValidacion(assertMensajePagoAgil, folderPath,
							"Se valida CP10 - Se valida que se encuentra el mensaje informativo de Pago Agil"),
					"Utiliza el Pago Ágil, para que no tengas que diligenciar la información del pago si ya te encuentras registrado en nuestro portal");
			System.out.println("Se valida el SP2_HU02_CP10");

			click(checkbox, folderPath, generarEvidencia, "Se da click en el Checkbox de terminos y condiciones");
			click(btnPagar2, folderPath, generarEvidencia, "Se da click en boton pagar");

			// ASSERT - SP2_HU02_CP12
			assertEquals(
					textoValidacion(assertFormularioPasarela, folderPath,
							"Se valida CP12 - Validar que el botón Pagar se dirija a la pasarela de pagos"),
					"Titular del Medio de Pago");
			System.out.println("Se valida el SP2_HU02_CP12");
		} catch (Exception e) {
			// ERROR
			printConsole("Estado del caso: Fallido");
			log.error(e.toString());
			throw new InterruptedException();
		}
	}

	@Step("Metodo para confirmacion boton Pago Agil")
	public void botonPagoAgil(File folderPath, String busqueda,String valor, String detalle,
			String generarEvidencia) throws Exception {
		try {
			
			assertTrue(isPresent(spanLogoAval, folderPath, "Se valida CP01 - Validación de ambiente (despliegue QA)", "Logo" ));
			sprint1utilities.MetodoIframe("iframe-buscador");
			sendkey(busqueda, txtBusqueda, folderPath, generarEvidencia, "Se ingresa nombre del convenio");
			enter();
			tiempoEspera(3);
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
			click(btnPagoAgil, folderPath, generarEvidencia, "Se da click en el boton Pago Agil");

			// ASSERT - SP2_HU02_CP13
			assertEquals(textoValidacion(assertFormularioPagoAgil, folderPath,
					"Se valida CP13 - Validar que se encuentre el login de pago ágil "), "Pago ágil");
			System.out.println("Se valida el SP2_HU02_CP13");
		} catch (Exception e) {
			// ERROR
			printConsole("Estado del caso: Fallido");
			log.error(e.toString());
			throw new InterruptedException();
		}
	}

}
