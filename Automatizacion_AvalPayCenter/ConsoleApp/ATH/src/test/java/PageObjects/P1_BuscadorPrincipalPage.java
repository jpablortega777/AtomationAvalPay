package PageObjects;

import java.io.File;

import org.openqa.selenium.WebDriver;

import MapsObjects.P1_BuscadorPrincipal;
import io.qameta.allure.Step;

public class P1_BuscadorPrincipalPage extends P1_BuscadorPrincipal{

	public P1_BuscadorPrincipalPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Ingreso a la pagina")
	public P1_BuscadorPrincipalPage abrirAvalPayCenter(String url) {
		driver.get(url);
		return new P1_BuscadorPrincipalPage(driver);
	}
	
	
	@Step("Metodo para busqueda")
	public void busqueda(File folderPath, String busqueda) throws Exception {
		sendkey(busqueda, txtBuscarEmpresa, folderPath, "Se busca el elemento", busqueda);
		//assertEquals(textoValidacion(txtBusqueda, folderPath, "SE valida busqueda CP"),"txt");
		click(btnBusqueda, folderPath, "Se da click en boton busqueda", busqueda);
		//scrollElement(txtServicio);
		click(btnPagarServicio, folderPath, "Se da click en boton pagar", busqueda);
	}

}
