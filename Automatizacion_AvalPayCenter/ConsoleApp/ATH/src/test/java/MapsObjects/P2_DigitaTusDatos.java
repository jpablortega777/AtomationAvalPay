package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClasesBase.ClaseBase;


public class P2_DigitaTusDatos extends ClaseBase {

	public P2_DigitaTusDatos(WebDriver driver) {
		super(driver);
	}
	
	//PARA AMBIENTE 10.130
	
	//CAMPOS BUSCADOR PRINCIPAL
	protected By spanLogoAval = By.xpath("//span[@class='clientes logoPortal']");
	protected By h1Titulo = By.xpath("//h1[normalize-space()='Búsqueda para Pagos']");
	protected By txtBusqueda = By.xpath("//input[@id='search']");
	protected By btnBusqueda = By.xpath("//div[@class='search__button']");
	protected By txtServicio = By.xpath("//*[text()[contains(.,'Aulas amigas')]]");
	protected By btnPagarServicio = By.xpath("//a[normalize-space()='Pagar']");
	
	//CAMPOS PASO 2
	protected By linkInicio = By.xpath("(//li[@class='first expanded'])[1]");
	protected By imgPaso2Activo = By.xpath("//div[@class='doing stepper__body-container']");
	protected By txtPaso2 = By.xpath("//div[@class='doing stepper-title']/p[text()[contains(.,'Digita tus datos de pago')]]");
	protected By txtMediosDePago = By.xpath("//p[contains(text(),'Recuerda que este pago lo puedes realizar a través')]");
	protected By divMediosDePago = By.xpath("//div[contains(@class,'methods-payments')]");
	protected By tooltipDetallePago = By.xpath("//div[@class='tooltip']");
	protected By logoConvenio = By.xpath("//div[@class='billers__body-logo']");
	
	//CAMPOS FORMULARIO
	protected By txtNombreServicio= By.xpath("//div[@class='agreement__value']");
	protected By txtDocumento= By.xpath("//input[@id='Digite aqui su Cedula o Nit']");
	protected By txtConfirmCedula= By.xpath("//input[@id='Confirmar Digite aqui su Cedula o Nit']");
	protected By txtValor= By.xpath("//input[@id='Valor a pagar']");
	protected By txtDetallePago= By.xpath("//textarea[@id='Detalle del pago']");
	protected By btnContinuar= By.xpath("//button/p[contains(text(),'Continuar')]");
	protected By btnCancelar= By.xpath("//button/p[contains(text(),'Cancelar')]");
	
	protected By txtPaso3 = By.xpath("//div[@class='doing stepper-title']/p[text()[contains(.,'Confirma tu pago')]]");
	
	
	//PARA AMBIENTE QA.AVALPAY - BUSQUEDA
//	protected By spanLogoAval = By.xpath("//span[@class='clientes logoPortal']");
//	protected By h1Titulo = By.xpath("//h1[normalize-space()='Búsqueda para Pagos']");
//	protected By txtBusqueda = By.xpath("//*/form/div/div[1]/input[@type='text']");
//	protected By btnBusqueda = By.xpath("//div[@class='lupa']");
//	protected By txtServicio = By.xpath("//td[normalize-space()='Aulas Amigas']");
//	protected By btnPagarServicio = By.xpath("//a[normalize-space()='Pagar']");
	
//	protected By txtBusqueda2 = By.xpath("//input[@id='search']");
//	//PARA AMBIENTE QA.AVALPAY - DATOS DE PAGO
//	
//	//ELEMENTOS PARA ASSERTION
//	protected By linkInicio = By.xpath("(//li[@class='first expanded'])[1]");
//	protected By imgPaso2Activo = By.xpath("//div[@class='estado-paso paso1 digitarPago active']");
//	protected By txtPaso2 = By.xpath("//h2[normalize-space()='Digita tus datos de pago']");
//	protected By txtMediosDePago = By.xpath("//p[contains(text(),'Recuerda que este pago lo puedes realizar a través')]");
//	protected By divMediosDePago = By.xpath("//div[contains(@class,'tr_medios_pago')]");
//	protected By tooltipDetallePago = By.xpath("//div[@class='ico ayuda sprite-clientes objIco ayudaWeb']");
//	protected By logoConvenio = By.xpath("//div[@class='imagenConvPago cuadricula']");
//	
//	//CAMPOS FORMULARIO
//	protected By txtNombreServicio= By.xpath("//label[@id='nombreConvenio']");
//	protected By txtDocumento= By.xpath("//input[@id='referenciaPagoFact']");
//	protected By txtConfirmCedula= By.xpath("//input[@id='confirmReferenciaFact']");
//	protected By txtValor= By.xpath("//input[@id='valorPago']");
//	protected By txtDetallePago= By.xpath("//textarea[@id='comentarios']");
//	protected By btnContinuar= By.xpath("//input[@id='btn-continuar']");
//	protected By btnCancelar= By.xpath("//a[@id='btn-cancelar']");
	
	//DIV RECUADRO CONFIRMAR PAGO
//	protected By divConfirmarPago = By.xpath("//div[@class='contenidoPP2 confirmar']");
	
}	
