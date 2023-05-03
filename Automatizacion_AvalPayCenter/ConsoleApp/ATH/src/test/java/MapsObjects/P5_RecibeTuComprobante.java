package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClasesBase.ClaseBase;

public class P5_RecibeTuComprobante extends ClaseBase {

	public P5_RecibeTuComprobante(WebDriver driver) {
		super(driver);
	}

	protected By spanLogoAval = By.xpath("//span[@class='clientes logoPortal']");
	protected By txtBusqueda = By.xpath("//input[@id='search']");
	protected By btnPagarServicio = By.xpath("//a[normalize-space()='Pagar']");
	protected By campoCedula = By.xpath("//input[@id='Digite aqui su Cedula o Nit']");
	protected By campoConfirmarCedula = By.xpath("//input[@id='Confirmar Digite aqui su Cedula o Nit']");
	protected By campoValorPagar = By.xpath("//input[@id='Valor a pagar']");
	protected By campoDetalle = By.xpath("//textarea[@id='Detalle del pago']");
	protected By btnContinuar = By.xpath("//button/p[normalize-space()='Continuar']");
	protected By checkbox = By.xpath("//div[@class='checkbox__container']");
	protected By btnPagar2 = By.xpath("//p[normalize-space()='Pagar']");
	
	protected By txtMedioDePago = By.xpath("//p[normalize-space()='Medio de pago']");
	protected By campoTipoDocumento = By.xpath("//select[@name='documentTypeHolder']");
	protected By campoTipoDocumentoPrimerOpcion = By.xpath("//option[text()=' Cedula de Ciudadania ']");
	protected By campoNumeroDocumento = By.xpath("//input[@name='documentNumberHolder']");
	protected By campoNombreCompleto = By.xpath("//input[@name='nameHolder']");
	protected By campoCorreo = By.xpath("//input[@name='emailHolder']");
	protected By campoConfirmarCorreo = By.xpath("//input[@name='emailConfirmationHolder']");
	protected By campoPais = By.xpath("//select[@name='countryTypeHolder']");
	protected By campoPaisPrimerOpcion = By.xpath("//option[text()='Colombia']");
	protected By campoMovil = By.xpath("//input[@name='movilHolder']");
	protected By campoConfirmacionMovil = By.xpath("//input[@name='movilConfirmationHolder']");
	protected By metodoPagoPse = By.xpath("//input[@ng-reflect-value='PSE']");
	protected By campoSeleccionBanco = By.xpath("//select[@name='bankPse']");
	protected By campoSeleccionBancoOpcion = By.xpath("//select/option[text()='BANCO UNION COLOMBIANO']");
	protected By btnPagar3 = By.xpath("//button[@id='btn-pasarela-pagar-pse']");
	protected By campoEmail = By.xpath("//input[@id='PNEMail']");
	protected By btnIrAlBanco = By.xpath("//input[@id='btnSeguir']");
	protected By btnPay = By.xpath("//input[@id='btnPay']");

	protected By assertModuloRecibeTuComprobante = By.xpath("//div[@class='doing stepper__body-container']/div/p[text()=' Recibe tu comprobante ']");
	protected By assertTransaccionAprobada = By.xpath("//img[@src='../../assets/images/img-alert-ok.png']");


}
