package Utilidades;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.itextpdf.text.DocumentException;

import ClasesBase.ClaseBase;
import io.qameta.allure.Attachment;

public class Sprint1Utilities extends ClaseBase {

	public Sprint1Utilities(WebDriver driver) {
		super(driver);
	}

	private static final Logger log = LogManager.getLogger(ClaseBase.class.getName());

	GenerarReportePdf generareportepdf = new GenerarReportePdf();

	public void ValidacionObjeto(boolean valor1, String caso, File rutaCarpeta, String Evidencia, String steps)
			throws Exception {
		/*
		 * try { if (Evidencia.equals("SI")) { // Si el objeto booleano es verdadero
		 * imprimira en evidencias caso exitoso if (valor1 == true){
		 * captureScreen(rutaCarpeta, "La validacion es exitosa  para el caso " + caso);
		 * } // En caso contrario imprimira otro mensaje else {
		 * captureScreen(rutaCarpeta,
		 * "La validacion no es exitosa el elemento a validar no esta presente "); } }
		 * else if (valor1 == true) { //log.info("My Validacion exitosa"); } else {
		 * //log.info("My Validacion fallida"); } } catch (Exception e) {
		 * captureScreen(rutaCarpeta, "ELEMENTO NO VALIDADO" + e);
		 * //generarReportePdf.cerrarPlantilla2(); }
		 */
	}

	// Se valida varios objetos que sea existente al convertirlo en un valor
	// booleano de true o false
	public void ValidacionObjetos(boolean valor1, boolean valor2, String caso, File folderPath, String Evidencia)
			throws IOException, DocumentException

	{
		if (Evidencia.equals("SI")) {
			// ##Ver el metodo validar objeto, se validan varios objetos pero se usa la
			// misma mecanica de validar objeto

			if (valor1 == true && valor2 == true)

			{
				screenshot(folderPath, "La validacion es exitosa  para el caso " + caso);
			} else {
				screenshot(folderPath, "La validacion no es exitosa para los casos ejecutados ");

			}

		} else if (valor1 == true && valor2 == true) {
			log.info("My Validacion exitosa");
		} else {
			log.info("My Validacion fallida");
		}
	}

	// Metodo screenshot
	@Attachment(value = "Screenshot", type = "image/png")

	public byte[] screenshot(File rutaCarpeta, String accion) throws IOException, DocumentException {

		String hora = HoraSistema();

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// String rutaImagen = rutaCarpeta + "\\" + hora + "_"+funcion+".png";

		String rutaImagen = rutaCarpeta + "\\" + hora + ".png";

		FileUtils.copyFile(scrFile, new File(rutaImagen));

		generareportepdf.crearbody(accion, rutaImagen);

		deleteFile(rutaImagen);

		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

	}

	// METODO PARA ELIMINAR ARCHIVO
	public void deleteFile(String rutaImagen) {
		File fichero = new File(rutaImagen);
		fichero.delete();
	}

	// METODO VALIDACIÓN devuelve una respuesta booleana de falso o verdadero que se
	// puede usar para validar objetos
	public static boolean validarElemento(By elementLocation, int time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
			return true;
		} catch (Exception ex) {

			return false;
		}
	}

	public void MetodoIframe(String valor) throws InterruptedException {

		driver.switchTo().frame(valor);

	}

	// METODO PARA DAR TAB Y LUEGO ENTER
	public void tabEnter() throws InterruptedException {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.ENTER).build().perform();
		tiempoEspera(2);
	}

	// METODO PARA DAR TAB
	public void tabulacion(int valor, int condicion) throws InterruptedException {
		Actions action = new Actions(driver);
		for (int i = valor; i < condicion; i++) {
			action.sendKeys(Keys.TAB).build().perform();
		}
	}

	// Metodo de escritura de un valor random numerico

	/**
	 * Write random num.
	 *
	 * @param elementLocation the element location
	 * @param num             the num
	 * @throws InterruptedException
	 */
	public void writeRandomNum(By elementLocation, int num) throws Exception {
		String acta = RandomStringUtils.randomNumeric(num);
		driver.findElement(elementLocation).sendKeys(acta);
		wait(20);
	}

	// CREA UNA LINEA RANDOM DE VALORES NUMERICOS
	public String writeRandomNum2(int num) throws InterruptedException {
		String acta = RandomStringUtils.randomNumeric(num);

		return acta;
	}

}