package RunPruebas;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ClasesBase.ClaseBase;
import PageObjects.P1_BuscadorPrincipalPage;
import PageObjects.P2_DigitaTusDatosPage;
import PageObjects.P3_ConfirmaTuPagoPage;
import PageObjects.P5_RecibeTuComprobantePage;
import Utilidades.ExcelUtilidades;
import Utilidades.GenerarReportePdf;
import Utilidades.LecturaCorreo;
import Utilidades.MyScreenRecorder;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class RunPrincipal {

	Logger log = LogManager.getLogger(RunPrincipal.class.getName());
	// INSTANCIAS
	public static WebDriver driver;
	static ClaseBase clasebase;

	// PAGE -->

	static MyScreenRecorder recorder;
	static P1_BuscadorPrincipalPage buscadorprincipalpage;
	static P2_DigitaTusDatosPage digitatusdatospage;
	static P3_ConfirmaTuPagoPage confirmatupagopage;
	static P5_RecibeTuComprobantePage recibeTuComprobante;

	// PDF -->
	static GenerarReportePdf generarPDF;

	// LEER CORREO -->
	static LecturaCorreo leerCorreo;

	// PROPERTIES -->
	static String rutaEvidencia;
	static String url;
	static String analyst;
	static String urlYopmail;

	@BeforeMethod
	public void beforeClass() throws IOException, AWTException {

		// PROPERTIES
		Properties propiedades = new Properties();
		InputStream entrada = null;
		entrada = new FileInputStream("./data.properties");
		propiedades.load(entrada);

		// CLASE BASE
		clasebase = new ClaseBase(driver);

		// INSTANCIAR LAS CLASES DE LAS PAGINAS
		buscadorprincipalpage = new P1_BuscadorPrincipalPage(driver);
		digitatusdatospage = new P2_DigitaTusDatosPage(driver);
		confirmatupagopage = new P3_ConfirmaTuPagoPage(driver);
		recibeTuComprobante = new P5_RecibeTuComprobantePage(driver);

		// INSTANCIAR LA CLASE DE GENERAR PDF
		generarPDF = new GenerarReportePdf();
		// SETIAR LA IMAGEN DEL ENCABEZADO PARA REPORTE PDF
		generarPDF.setRutaImagen(propiedades.getProperty("rutaImagenReporteBMC"));

		// LEER CORREO
		leerCorreo = new LecturaCorreo();

		// PROPERTIES
		rutaEvidencia = propiedades.getProperty("rutaEvidencia");
		url = propiedades.getProperty("url");
		analyst = propiedades.getProperty("analystNL");
		urlYopmail = propiedades.getProperty("urlYopmail");

	}

	// DEFINE RUTA DONDE SE UBICA ARCHIVO PROPERTIES
	String rutaRunPrincipal = ".data.properties";

	/************************************************************************************
	 * HU1
	 *************************************************************************************/

	// DATAPROVIDER DEL SPRINT1_HU01
	@DataProvider(name = "hu1")
	public Object[][] datosHU01() throws Exception {
		try {

			Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/dataAvalPayCenter.xlsx", "HU1");
			return arreglo;

		} catch (Exception e) {
			System.out.println(e);
			log.error(e.toString());
		}
		return null;
	}

	@Severity(SeverityLevel.NORMAL)
	@Story("AvalPayCenter ")
	@Description("CP14 - Validar funcionalidad  botón Cancelar")
	@Test(priority = 1, dataProvider = "hu1")
	public void CasoDePrueba673853(String hu, String idCaso, String generarEvidencia, String busqueda, String valor,
			String detalle) throws Exception {

		// OBTENER EL NOMBRE DEL TEST - (ScreenShot's)
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

		if (idCaso.equals("673853")) {

			driver = ClaseBase.inicializar("Chrome");
			// ELIMINA LAS EVIDENCIAS DE CASOS ANTERIORES
			ClaseBase.eliminarCarpeta(rutaEvidencia);
			// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = clasebase.crearCarpeta(nomTest, rutaEvidencia);
			// IMPRIMIR RUTA
			System.out.println("Ruta de la carpeta:" + rutaCarpeta);

			// INICIAR LA CREACION DE EVIDENCIAS
			generarPDF.crearPlantilla(nomTest, rutaCarpeta, generarEvidencia, url);
			MyScreenRecorder.startRecording(nomTest, rutaCarpeta, generarEvidencia);

			// INICIO DE LOG
			// log.info("Comienza el proceso de automatizacion de " + nomTest);
			// System.out.println("COMIENZA EL PROCESO DE AUTOMATIZACION " + nomTest);

			// LLAMADO DE METODOS ->>
			buscadorprincipalpage.abrirAvalPayCenter(url);
			digitatusdatospage.formularioCancelar(rutaCarpeta, busqueda, valor, detalle, generarEvidencia);

			// CONFIRMACION ESTADO DE CASO
			System.out.println("Estado del caso: Exitoso");
			// log.info("Finaliza el proceso de automatizacion de " + nomTest);
			// System.out.println("FINALIZA EL PROCESO DE AUTOMATIZACION " + nomTest);

			// FINALIZAR GENERACION DE EVIDENCIAS
			MyScreenRecorder.stopRecording();
			generarPDF.cerrarPlantilla();

		} else {
		}

	}

	@Severity(SeverityLevel.NORMAL)
	@Story("AvalPayCenter ")
	@Description("CP15 - Validar funcionalidad  botón Continuar")
	@Test(priority = 1, dataProvider = "hu1")
	public void CasoDePrueba673854(String hu, String idCaso, String generarEvidencia, String busqueda, String valor,
			String detalle) throws Exception {

		// OBTENER EL NOMBRE DEL TEST - (ScreenShot's)
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

		if (idCaso.equals("673854")) {

			driver = ClaseBase.inicializar("Chrome");
			// ELIMINA LAS EVIDENCIAS DE CASOS ANTERIORES
			ClaseBase.eliminarCarpeta(rutaEvidencia);
			// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = clasebase.crearCarpeta(nomTest, rutaEvidencia);
			// IMPRIMIR RUTA
			System.out.println("Ruta de la carpeta:" + rutaCarpeta);

			// INICIAR LA CREACION DE EVIDENCIAS
			generarPDF.crearPlantilla(nomTest, rutaCarpeta, generarEvidencia, url);
			MyScreenRecorder.startRecording(nomTest, rutaCarpeta, generarEvidencia);

			// INICIO DE LOG
			// log.info("Comienza el proceso de automatizacion de " + nomTest);
			// System.out.println("COMIENZA EL PROCESO DE AUTOMATIZACION " + nomTest);

			// LLAMADO DE METODOS ->>
			buscadorprincipalpage.abrirAvalPayCenter(url);
			digitatusdatospage.formularioContinuar(rutaCarpeta, busqueda, valor, detalle, generarEvidencia);

			// CONFIRMACION ESTADO DE CASO
			System.out.println("Estado del caso: Exitoso");
			// log.info("Finaliza el proceso de automatizacion de " + nomTest);
			// System.out.println("FINALIZA EL PROCESO DE AUTOMATIZACION " + nomTest);

			// FINALIZAR GENERACION DE EVIDENCIAS
			MyScreenRecorder.stopRecording();
			generarPDF.cerrarPlantilla();

		} else {
		}

	}

	/************************************************************************************
	 * HU2
	 *************************************************************************************/

	// DATAPROVIDER DEL SPRINT2_HU02
	@DataProvider(name = "hu2")
	public Object[][] datosSP2_HU02() throws Exception {
		try {

			Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/dataAvalPayCenter.xlsx", "HU2");
			return arreglo;

		} catch (Exception e) {
			System.out.println(e);
			log.error(e.toString());
		}
		return null;
	}

	@Severity(SeverityLevel.NORMAL)
	@Story("AvalPayCenter ")
	@Description("CP08 - Validar la selección de términos y condiciones (LINK)")
	@Test(priority = 1, dataProvider = "hu2")
	public void CasoDePrueba695181(String hu, String idCaso, String generarEvidencia, String busqueda, String valor,
			String detalle) throws Exception {

		// OBTENER EL NOMBRE DEL TEST - (ScreenShot's)
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

		if (idCaso.equals("695181")) {

			driver = ClaseBase.inicializar("Chrome");

			// ELIMINA LAS EVIDENCIAS DE CASOS ANTERIORES
			ClaseBase.eliminarCarpeta(rutaEvidencia);
			// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = clasebase.crearCarpeta(nomTest, rutaEvidencia);
			// IMPRIMIR RUTA
			System.out.println("Ruta de la carpeta:" + rutaCarpeta);

			// INICIAR LA CREACION DE EVIDENCIAS
			generarPDF.crearPlantilla(nomTest, rutaCarpeta, generarEvidencia, url);
			MyScreenRecorder.startRecording(nomTest, rutaCarpeta, generarEvidencia);

			// INICIO DE LOG
			log.info("Comienza el proceso de automatizacion de " + nomTest);
			System.out.println("COMIENZA EL PROCESO DE AUTOMATIZACION " + nomTest);

			// LLAMADO DE METODOS ->>
			buscadorprincipalpage.abrirAvalPayCenter(url);
			confirmatupagopage.TerminosYCondiciones(rutaCarpeta, busqueda, valor, detalle, generarEvidencia);

			// CONFIRMACION ESTADO DE CASO
			System.out.println("Estado del caso: Exitoso");
			log.info("Finaliza el proceso de automatizacion de " + nomTest);
			System.out.println("FINALIZA EL PROCESO DE AUTOMATIZACION " + nomTest);

			// FINALIZAR GENERACION DE EVIDENCIAS
			MyScreenRecorder.stopRecording();
			generarPDF.cerrarPlantilla();

		} else {

		}

	}

	@Severity(SeverityLevel.NORMAL)
	@Story("AvalPayCenter ")
	@Description("CP11 - Validar que el botón Volver me retorne a la pantalla anterior")
	@Test(priority = 1, dataProvider = "hu2")
	public void CasoDePrueba675449(String hu, String idCaso, String generarEvidencia, String busqueda, String valor,
			String detalle) throws Exception {

		// OBTENER EL NOMBRE DEL TEST - (ScreenShot's)
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

		if (idCaso.equals("675449")) {

			driver = ClaseBase.inicializar("Chrome");

			// ELIMINA LAS EVIDENCIAS DE CASOS ANTERIORES
			ClaseBase.eliminarCarpeta(rutaEvidencia);
			// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = clasebase.crearCarpeta(nomTest, rutaEvidencia);
			// IMPRIMIR RUTA
			System.out.println("Ruta de la carpeta:" + rutaCarpeta);

			// INICIAR LA CREACION DE EVIDENCIAS
			generarPDF.crearPlantilla(nomTest, rutaCarpeta, generarEvidencia, url);
			MyScreenRecorder.startRecording(nomTest, rutaCarpeta, generarEvidencia);

			// INICIO DE LOG
			log.info("Comienza el proceso de automatizacion de " + nomTest);
			System.out.println("COMIENZA EL PROCESO DE AUTOMATIZACION " + nomTest);

			// LLAMADO DE METODOS ->>
			buscadorprincipalpage.abrirAvalPayCenter(url);
			confirmatupagopage.botonVolver(rutaCarpeta, busqueda, valor, detalle, generarEvidencia);

			// CONFIRMACION ESTADO DE CASO
			System.out.println("Estado del caso: Exitoso");
			log.info("Finaliza el proceso de automatizacion de " + nomTest);
			System.out.println("FINALIZA EL PROCESO DE AUTOMATIZACION " + nomTest);

			// FINALIZAR GENERACION DE EVIDENCIAS
			MyScreenRecorder.stopRecording();
			generarPDF.cerrarPlantilla();

		} else {

		}

	}

	@Severity(SeverityLevel.NORMAL)
	@Story("AvalPayCenter ")
	@Description("CP12 - Validar que el botón Pagar se dirija a la pasarela de pagos")
	@Test(priority = 2, dataProvider = "hu2")
	public void CasoDePrueba675450(String hu, String idCaso, String generarEvidencia, String busqueda, String valor,
			String detalle) throws Exception {

		// OBTENER EL NOMBRE DEL TEST - (ScreenShot's)
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

		if (idCaso.equals("675450")) {

			driver = ClaseBase.inicializar("Chrome");

			// ELIMINA LAS EVIDENCIAS DE CASOS ANTERIORES
			ClaseBase.eliminarCarpeta(rutaEvidencia);
			// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = clasebase.crearCarpeta(nomTest, rutaEvidencia);
			// IMPRIMIR RUTA
			System.out.println("Ruta de la carpeta:" + rutaCarpeta);

			// INICIAR LA CREACION DE EVIDENCIAS
			generarPDF.crearPlantilla(nomTest, rutaCarpeta, generarEvidencia, url);
			MyScreenRecorder.startRecording(nomTest, rutaCarpeta, generarEvidencia);

			// INICIO DE LOG
			log.info("Comienza el proceso de automatizacion de " + nomTest);
			System.out.println("COMIENZA EL PROCESO DE AUTOMATIZACION " + nomTest);

			// LLAMADO DE METODOS ->>
			buscadorprincipalpage.abrirAvalPayCenter(url);
			confirmatupagopage.botonPagar(rutaCarpeta, busqueda, valor, detalle, generarEvidencia);

			// CONFIRMACION ESTADO DE CASO
			System.out.println("Estado del caso: Exitoso");
			log.info("Finaliza el proceso de automatizacion de " + nomTest);
			System.out.println("FINALIZA EL PROCESO DE AUTOMATIZACION " + nomTest);

			// FINALIZAR GENERACION DE EVIDENCIAS
			MyScreenRecorder.stopRecording();
			generarPDF.cerrarPlantilla();

		} else {

		}

	}

	@Severity(SeverityLevel.NORMAL)
	@Story("AvalPayCenter ")
	@Description("CP13 - Validar que el botón Pago Ágil se Dirija al login de pago ágil cuando no se ha iniciado sesión")
	@Test(priority = 3, dataProvider = "hu2")
	public void CasoDePrueba675452(String hu, String idCaso, String generarEvidencia, String busqueda, String valor,
			String detalle) throws Exception {

		// OBTENER EL NOMBRE DEL TEST - (ScreenShot's)
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

		if (idCaso.equals("675452")) {

			driver = ClaseBase.inicializar("Chrome");

			// ELIMINA LAS EVIDENCIAS DE CASOS ANTERIORES
			ClaseBase.eliminarCarpeta(rutaEvidencia);
			// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = clasebase.crearCarpeta(nomTest, rutaEvidencia);
			// IMPRIMIR RUTA
			System.out.println("Ruta de la carpeta:" + rutaCarpeta);

			// INICIAR LA CREACION DE EVIDENCIAS
			generarPDF.crearPlantilla(nomTest, rutaCarpeta, generarEvidencia, url);
			MyScreenRecorder.startRecording(nomTest, rutaCarpeta, generarEvidencia);

			// INICIO DE LOG
			log.info("Comienza el proceso de automatizacion de " + nomTest);
			System.out.println("COMIENZA EL PROCESO DE AUTOMATIZACION " + nomTest);

			// LLAMADO DE METODOS ->>
			buscadorprincipalpage.abrirAvalPayCenter(url);
			confirmatupagopage.botonPagoAgil(rutaCarpeta, busqueda, valor, detalle, generarEvidencia);

			// CONFIRMACION ESTADO DE CASO
			System.out.println("Estado del caso: Exitoso");
			log.info("Finaliza el proceso de automatizacion de " + nomTest);
			System.out.println("FINALIZA EL PROCESO DE AUTOMATIZACION " + nomTest);

			// FINALIZAR GENERACION DE EVIDENCIAS
			MyScreenRecorder.stopRecording();
			generarPDF.cerrarPlantilla();

		} else {

		}

	}

	/************************************************************************************
	 * HU4
	 *************************************************************************************/

	// DATAPROVIDER DEL SPRINT3_HU04
	@DataProvider(name = "hu4")
	public Object[][] datosSP3_HU04() throws Exception {
		try {

			Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/dataAvalPayCenter.xlsx", "HU4");
			return arreglo;

		} catch (Exception e) {
			System.out.println(e);
			log.error(e.toString());
		}
		return null;
	}

	@Severity(SeverityLevel.NORMAL)
	@Story("AvalPayCenter ")
	@Description("CP16 - Validar el campo Referencia mostrado en el comprobante de pago")
	@Test(priority = 1, dataProvider = "hu4")
	public void CasoDePrueba677025(String hu, String idCaso, String generarEvidencia, String busqueda, String valor,
			String detalle, String numeroDocumento, String nombreCompleto, String correo, String confirmacionCorreo,
			String movil, String confirmacionMovil,String email) throws Exception {

		// OBTENER EL NOMBRE DEL TEST - (ScreenShot's)
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

		if (idCaso.equals("677025")) {

			driver = ClaseBase.inicializar("Chrome");

			// ELIMINA LAS EVIDENCIAS DE CASOS ANTERIORES
			ClaseBase.eliminarCarpeta(rutaEvidencia);
			// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = clasebase.crearCarpeta(nomTest, rutaEvidencia);
			// IMPRIMIR RUTA
			System.out.println("Ruta de la carpeta:" + rutaCarpeta);

			// INICIAR LA CREACION DE EVIDENCIAS
			generarPDF.crearPlantilla(nomTest, rutaCarpeta, generarEvidencia, url);
			MyScreenRecorder.startRecording(nomTest, rutaCarpeta, generarEvidencia);

			// INICIO DE LOG
			log.info("Comienza el proceso de automatizacion de " + nomTest);
			System.out.println("COMIENZA EL PROCESO DE AUTOMATIZACION " + nomTest);

			// LLAMADO DE METODOS ->>
			buscadorprincipalpage.abrirAvalPayCenter(url);
			recibeTuComprobante.referenciaPago(rutaCarpeta, busqueda, valor, detalle, generarEvidencia, numeroDocumento,
					nombreCompleto, correo, confirmacionCorreo, movil, confirmacionMovil,email);

			// CONFIRMACION ESTADO DE CASO
			System.out.println("Estado del caso: Exitoso");
			log.info("Finaliza el proceso de automatizacion de " + nomTest);
			System.out.println("FINALIZA EL PROCESO DE AUTOMATIZACION " + nomTest);

			// FINALIZAR GENERACION DE EVIDENCIAS
			MyScreenRecorder.stopRecording();
			generarPDF.cerrarPlantilla();

		} else {

		}

	}

	@AfterMethod
	public void afterClass() {
		if (driver != null) {
			driver.quit();
		}
	}

}
