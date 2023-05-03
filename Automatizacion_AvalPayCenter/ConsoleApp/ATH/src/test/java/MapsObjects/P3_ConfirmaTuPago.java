package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClasesBase.ClaseBase;



public class P3_ConfirmaTuPago extends ClaseBase {

	public P3_ConfirmaTuPago(WebDriver driver) {
		super(driver);
	}

	// PARA AMBIENTE QA.AVALPAY

	// BUSCADOR PRINCIPAL
	protected By txtServicio = By.xpath("//td[normalize-space()='Aulas Amigas']");
	protected By btnBusqueda = By.xpath("//div[@class='lupa']");

	//////////////////HU02///////////////////////////////
	protected By spanLogoAval = By.xpath("//span[@class='clientes logoPortal']");
	protected By txtBusqueda = By.xpath("//input[@id='search']");
	protected By btnPagarServicio = By.xpath("//a[normalize-space()='Pagar']");
	protected By campoCedula = By.xpath("//input[@id='Digite aqui su Cedula o Nit']");
	protected By campoConfirmarCedula = By.xpath("//input[@id='Confirmar Digite aqui su Cedula o Nit']");
	protected By campoValorPagar = By.xpath("//input[@id='Valor a pagar']");
	protected By campoDetalle = By.xpath("//textarea[@id='Detalle del pago']");
	protected By btnContinuar = By.xpath("//button/p[normalize-space()='Continuar']");
	protected By btnPagar2 = By.xpath("//p[normalize-space()='Pagar']");
	protected By btnCerrar = By.xpath("//button/p[text()=' Cerrar ']");
	protected By checkbox = By.xpath("//div[@class='checkbox__container']");
	protected By btnVolver = By.xpath("//button/p[text()=' Volver ']");
	protected By btnPagoAgil = By.xpath("//button/p[text()=' Pago Ágil ']");
	protected By terminosYCondiciones = By.xpath("//a/b[text()=' términos y condiciones ']");


	protected By assertPaso1Buscar = By.xpath("//p[normalize-space()='Busca tu servicio o empresa']");
	protected By assertPaso2Digitar = By.xpath("(//p[normalize-space()='Digita tus datos de pago'])[1]");
	protected By assertPaso3Confirmar = By.xpath("//p[normalize-space()='Confirma tu pago']");
	protected By assertPaso4PagaFacil = By.xpath("//p[normalize-space()='Paga fácil y seguro']");
	protected By assertPaso5Recibe = By.xpath("//p[normalize-space()='Recibe tu comprobante']");
	protected By assertLogo = By.xpath("//img[@class='agreement-logo']");
	protected By assertCampoServicioaPagar = By.xpath("//p[normalize-space()='Servicio a pagar:']");
	protected By assertCampoDigiteCedula = By.xpath("//p[normalize-space()='Digite aqui su cedula o nit:']");
	protected By assertCampoValoraPagar = By.xpath("//p[normalize-space()='Valor a pagar:']");
	protected By assertCampoCostoTransaccion = By.xpath("//p[normalize-space()='Costo de la transacción:']");
	protected By assertCampoDetallePago = By.xpath("//p[normalize-space()='Detalle del pago:']");
	protected By assertTerminosCondiciones = By.xpath("//p[normalize-space()='Por favor acepta los términos y condiciones de uso para realizar tu pago.']");
	protected By assertMensajePagoAgil = By.xpath("//p[@class='msj-pago-agil']");
	protected By assertFormularioPasarela = By.xpath("//p[normalize-space()='Titular del Medio de Pago']");
	protected By assertModuloDigitaTusDatosPagos = By.xpath("//div[@class='doing stepper__body-container']/div/p[text()=' Digita tus datos de pago ']");
	protected By assertFormularioPagoAgil = By.xpath("//div/h3[text()='Pago ágil']");



	// DATOS DE PAGO
	protected By txtNombreServicio = By.xpath("//label[@id='nombreConvenio']");
	protected By txtDocumento = By.xpath("//input[@id='referenciaPagoFact']");
	protected By txtConfirmCedula = By.xpath("//input[@id='confirmReferenciaFact']");
	protected By txtValor = By.xpath("//input[@id='valorPago']");
	protected By txtDetallePago = By.xpath("//textarea[@id='comentarios']");
	//protected By btnContinuar = By.xpath("//input[@id='btn-continuar']");
	protected By btnCancelar = By.xpath("//a[@id='btn-cancelar']");

	// CONFIRMAR PAGO
	protected By divConfirmarPago = By.xpath("//div[@class='contenidoPP2 confirmar']");
	protected By labelTerminos = By.xpath("//label[@for='msjAceptoCondiciones']");
//	protected By labelTerminos = By.xpath("//label[@class='focusCheckBox']");
	protected By col2Terminos = By.xpath("//div[@class='col2 confirmacion-pago']");
	protected By rowTerminos = By.xpath("//div[@class='row termsAndConditions']");
	protected By checkTerminos = By.xpath("//input[@id='msjAceptoCondiciones']");
	protected By linkTerminos = By.xpath("//span[normalize-space()='términos y condiciones']");
	protected By btnPagar = By.xpath("//input[@id='btn-pagar']");
	
	
	
	//AMBIENTE QA
	protected By txtValidar = By.xpath("(//*[@class='form__name'])[2]/p");
	
	protected By TxtDocumento2 = By.xpath("//*[@id='Digite aqui su Cedula o Nit']");

	protected By TxtConfirmeCedula2 = By.xpath("//*[@id='Confirmar Digite aqui su Cedula o Nit']");
	protected By TxtPagar = By.xpath("//*[@id='Valor a pagar']");
	protected By TxtDetallePago = By.xpath("//*[@id='Detalle del pago']");
	protected By btnContinuar2 = By.xpath("/html/body/apc-root/apc-billers/div/div/div[8]/apc-button[2]/button");
	protected By btnCancelar2 = By.xpath("/html/body/apc-root/apc-billers/div/div/div[8]/apc-button[1]/button");
	
	
	
	
	
	
	
	
	

}
