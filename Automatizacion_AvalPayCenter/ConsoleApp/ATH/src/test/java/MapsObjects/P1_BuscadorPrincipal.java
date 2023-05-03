package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClasesBase.ClaseBase;



public class P1_BuscadorPrincipal extends ClaseBase
{

	public P1_BuscadorPrincipal(WebDriver driver) {
		super(driver);
	}
		
	/*
	// PARA AMBIENTE 10.130.1.205
	protected By btnRegistrarme = By.xpath("//*[@id='viewns_Z7_2G0EHH01NOCPE0QJ53FUI41CC3_:ns_Z7_2G0EHH01NOCPE0QJ53FUI41CC3_j_id581271260_22a57f71']/div[2]/div/a");
	protected By txtBusqueda = By.xpath("//*[@id='search']");
	protected By btnBusqueda = By.xpath("/html/body/apc-root/apc-search-agreements/div/div/apc-searcher/div/div[2]");
	protected By btnQuePuedoPagar = By.xpath("//*[@id='btn-qppagar']");
	protected By btnMenu = By.xpath("//*[@id='mobileClose']");
	protected By btnClientes = By.xpath("//*[@id='menu-container']/div[1]/ul/li[1]/a/div/h2");
	protected By btnRecaudadores = By.xpath("//*[@id='menu-container']/div[1]/ul/li[2]/a/div"); 
	protected By btnSugerencias = By.xpath("//*[@id='foot-container']/div[2]/div[1]/div[3]/a"); 
	protected By btnPagarPosibleConvenio = By.xpath("/html/body/apc-root/apc-search-agreements/div/div/apc-table/div/div[3]/div[2]/div[1]/div[4]/a");
	*/
	

	//PARA AMBIENTE QA.AVALPAY
	protected By txtBusqueda = By.xpath("//*/form/div/div[1]/input[@type='text']");
	protected By btnBusqueda = By.xpath("//div[@class='lupa']");
	protected By txtServicio = By.xpath("//td[normalize-space()='Aulas Amigas']");
	protected By btnPagarServicio = By.xpath("//a[normalize-space()='Pagar']");
	
	//ELEMENTOS DE AMBIENTE  QA SEGUNDA BARRA 
	protected By btnBusqueda2 = By.xpath("/html/body/apc-root/apc-search-agreements/div/div/apc-searcher/div/div[2]");
	protected By btnPagarServicio2 = By.xpath("//body/apc-root/apc-search-agreements/div/div/apc-table/div/div[3]/div[2]/div/div[4]/a");
	protected By btnOpcionesAvanzadas = By.xpath("//*[@id='details-button']");
	protected By btnLinkIngreso = By.xpath("//*[@id='proceed-link']");
		
	protected By btnBuscar2 = By.xpath("/html/body/apc-root/apc-search-agreements/div/div/apc-searcher/div/div[2]");
	protected By txtBuscarEmpresa = By.xpath("//input[@id='search']");
	
	
	protected By txtBuscarEmpresa3 = By.cssSelector("#search");
	
	
	
	//#search
	
	
	
	
	
}
