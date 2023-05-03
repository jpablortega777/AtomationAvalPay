package PageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MapsObjects.P2_DigitaTusDatos;
import RunPruebas.RunPrincipal;
import Utilidades.Sprint1Utilities;
import io.qameta.allure.Step;

public class P2_DigitaTusDatosPage extends P2_DigitaTusDatos {

	private static Logger log = LogManager.getLogger(RunPrincipal.class.getName());

	public P2_DigitaTusDatosPage(WebDriver driver) {
		super(driver);
	}

	Sprint1Utilities sprint1utilities = new Sprint1Utilities(driver);

	@Step("Metodo para busqueda")
	public void busqueda(File folderPath, String busqueda, String generarEvidencia) throws Exception {
		assertTrue(
				isPresent(spanLogoAval, folderPath, "Se valida CP01 - Validación de ambiente (despliegue QA)", "Logo"));
		sprint1utilities.MetodoIframe("iframe-buscador");
		sendkey(busqueda, txtBusqueda, folderPath, generarEvidencia, "Se busca el elemento");
		click(btnBusqueda, folderPath, generarEvidencia, "Se da click en boton busqueda");
		enter();
	}

	@Step("Metodo para busqueda boton Cancelar")
	public void formularioCancelar(File folderPath, String busqueda, String valor, String detalle,
			String generarEvidencia) throws Exception {
		try {

			assertTrue(isPresent(spanLogoAval, folderPath, "Se valida CP01 - Validación de ambiente (despliegue QA)",
					"Logo"));
			sprint1utilities.MetodoIframe("iframe-buscador");
			sendkey(busqueda, txtBusqueda, folderPath, generarEvidencia, "Se busca el elemento");
			click(btnBusqueda, folderPath, generarEvidencia, "Se da click en boton busqueda");
			enter();
			scrollElement(txtServicio, folderPath, generarEvidencia, "Se ubica el elemento");
			click(btnPagarServicio, folderPath, generarEvidencia, "Se da click en boton pagar");
			scrollElement(linkInicio, folderPath, generarEvidencia, "Se ubica el elemento");
			visibilityOfElementLocated((By.id("iframe-nofacturador")), 30);

			sprint1utilities.MetodoIframe("iframe-nofacturador");
			assertTrue(isPresent(imgPaso2Activo, folderPath,
					"Se valida CP02 - Validar ingreso a paso 2: digita tus datos -Pago no facturador", "Paso 2"));
			assertTrue(isPresent(txtPaso2, folderPath, "Se valida CP03 - Validar barra de progreso del proceso de pago",
					"Barra de Progreso"));
			assertEquals(
					textoValidacion(txtMediosDePago, folderPath,
							"Se valida CP04 - Validar medios de pago configurados para el convenio"),
					"Recuerda que este pago lo puedes realizar a través de los siguientes medios:");
			assertTrue(isPresent(logoConvenio, folderPath, "Se valida CP05 - Visualizar  el logo del  convenio",
					"Logo Convenio"));
			assertEquals(
					textoValidacion(txtNombreServicio, folderPath, "Se valida CP06 - Validar campo Servicio a pagar"),
					busqueda);

			String documento2 = sprint1utilities.writeRandomNum2(4);
			sendkey(documento2, txtDocumento, folderPath, generarEvidencia, "Se ingresa numero de documento");
			assertTrue(isPresent(txtDocumento, folderPath, "Se valida CP07 - Validar campo Referencia principal",
					"Referencia Principal"));
			sendkey(documento2, txtConfirmCedula, folderPath, generarEvidencia, "Se confirma numero de documento");
			assertTrue(isPresent(txtConfirmCedula, folderPath,
					"Se valida CP08 - Validar campo confirmar referencia principal", "Confirmar Referencia Principal"));
			sendkey(valor, txtValor, folderPath, generarEvidencia, "Se ingresa valor a pagar");
			assertTrue(isPresent(txtValor, folderPath, "Se valida CP11 - Validar  campo  Valor  a pagar", "Valor"));
			sendkey(detalle, txtDetallePago, folderPath, generarEvidencia, "Se ingresa detalle del pago");
			scrollElement(txtNombreServicio, folderPath, generarEvidencia, "Se ubica el elemento");
			click(btnCancelar, folderPath, generarEvidencia, "Se da click en boton cancelar");
			assertTrue(isPresent(h1Titulo, folderPath, "Se valida CP14 - Validar funcionalidad  botón Cancelar",
					"Botón Cancelar"));

		} catch (Exception e) {
			// ERROR
			printConsole("Estado del caso: Fallido");
			log.error(e.toString());
			throw new InterruptedException();
		}
	}

	@Step("Metodo para confirmacion boton Continuar")
	public void formularioContinuar(File folderPath, String busqueda, String valor, String detalle,
			String generarEvidencia) throws Exception {

		try {

			assertTrue(isPresent(spanLogoAval, folderPath, "Se valida CP01 - Validación de ambiente (despliegue QA)",
					"Logo"));
			sprint1utilities.MetodoIframe("iframe-buscador");
			sendkey(busqueda, txtBusqueda, folderPath, generarEvidencia, "Se busca el elemento");
			click(btnBusqueda, folderPath, generarEvidencia, "Se da click en boton busqueda");
			enter();
			scrollElement(txtServicio, folderPath, generarEvidencia, "Se ubica el elemento");
			click(btnPagarServicio, folderPath, generarEvidencia, "Se da click en boton pagar");
			scrollElement(linkInicio, folderPath, generarEvidencia, "Se ubica el elemento");
			visibilityOfElementLocated((By.id("iframe-nofacturador")), 30);

			sprint1utilities.MetodoIframe("iframe-nofacturador");
			assertTrue(isPresent(imgPaso2Activo, folderPath,
					"Se valida CP02 - Validar ingreso a paso 2: digita tus datos -Pago no facturador", "Paso 2"));
			assertTrue(isPresent(txtPaso2, folderPath, "Se valida CP03 - Validar barra de progreso del proceso de pago",
					"Barra de Progreso"));
			assertEquals(
					textoValidacion(txtMediosDePago, folderPath,
							"Se valida CP04 - Validar medios de pago configurados para el convenio"),
					"Recuerda que este pago lo puedes realizar a través de los siguientes medios:");
			assertTrue(isPresent(logoConvenio, folderPath, "Se valida CP05 - Visualizar  el logo del  convenio",
					"Logo Convenio"));
			assertEquals(
					textoValidacion(txtNombreServicio, folderPath, "Se valida CP06 - Validar campo Servicio a pagar"),
					busqueda);

			String documento2 = sprint1utilities.writeRandomNum2(4);
			sendkey(documento2, txtDocumento, folderPath, generarEvidencia, "Se ingresa numero de documento");
			assertTrue(isPresent(txtDocumento, folderPath, "Se valida CP07 - Validar campo Referencia principal",
					"Referencia Principal"));
			sendkey(documento2, txtConfirmCedula, folderPath, generarEvidencia, "Se confirma numero de documento");
			assertTrue(isPresent(txtConfirmCedula, folderPath,
					"Se valida CP08 - Validar campo confirmar referencia principal", "Confirmar Referencia Principal"));
			sendkey(valor, txtValor, folderPath, generarEvidencia, "Se ingresa valor a pagar");
			assertTrue(isPresent(txtValor, folderPath, "Se valida CP11 - Validar  campo  Valor  a pagar", "Valor"));
			sendkey(detalle, txtDetallePago, folderPath, generarEvidencia, "Se ingresa detalle del pago");
			scrollElement(txtNombreServicio, folderPath, generarEvidencia, "Se ubica el elemento");
			click(btnContinuar, folderPath, generarEvidencia, "Se da click en boton continuar");
			assertTrue(isPresent(txtPaso3, folderPath, "Se valida CP15 - Validar funcionalidad  botón Continuar",
					"Botón Continuar"));
		} catch (Exception e) {
			// ERROR
			printConsole("Estado del caso: Fallido");
			log.error(e.toString());
			throw new InterruptedException();
		}
	}

}
