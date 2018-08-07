package com.page;

import com.generalActions.RyanairGeneralActions;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;

@DefaultUrl("https://www.ryanair.com/es/es/")
public class RyanairSearchPage extends PageObject {

    private JavascriptExecutor js = (JavascriptExecutor) this.getDriver();

    //ATRIBUTOS
    @CacheLookup
    // botones de ida y vuelta
    @FindBy(xpath = "//*[@id=\"lbl-flight-search-type-one-way\"]")
    private WebElementFacade idaButton;
    @FindBy(xpath = "//*[@id=\"lbl-flight-search-type-return\"]")
    private WebElementFacade idaVueltaButton;

    // campos de aeropuesto de salida y llegada
    @FindBy(css = "input[placeholder='Aeropuerto de salida']")
    private WebElementFacade sourceTextfield;
    @FindBy(css = "input[placeholder='Aeropuerto de destino']")
    private WebElementFacade destinyTextfield;

    // campos de fecha de ida
    @FindBy(css = "input[aria-label='Vuelo de ida: - DD']")
    private WebElementFacade destinyTextfieldD;
    @FindBy(css = "input[aria-label='Vuelo de ida: - MM']")
    private WebElementFacade destinyTextfieldM;
    @FindBy(css = "input[aria-label='Vuelo de ida: - YYYY']")
    private WebElementFacade destinyTextFieldA;

    // campos de fecha de ida
    @FindBy(css = "input[aria-label='Vuelo de vuelta: - DD']")
    private WebElementFacade destinyTextfieldD1;
    @FindBy(css = "input[aria-label='Vuelo de vuelta: - MM']")
    private WebElementFacade destinyTextfieldM1;
    @FindBy(css = "input[aria-label='Vuelo de vuelta: - YYYY']")
    private WebElementFacade destinyTextFieldA1;

    // campos bomo pasajeros
    @FindBy(xpath = "//*[@id=\"row-dates-pax\"]/div[2]/div[2]/div[2]/div/div[1]")
    private WebElementFacade firstClickAdults;
    @FindBy(xpath = "//*[@id=\"row-dates-pax\"]/div[2]/div[3]/div/div/div[2]/popup-content/div[6]/div/div[3]/core-inc-dec/button[2]")
    private WebElementFacade secondClickAdults;
    @FindBy(xpath = "//*[@id=\"search-container\"]/div[1]/div/form/div[4]/button[2]")

    // boton de vamos
    private WebElementFacade vamosButton;
    @FindBy(xpath = "//*[@id=\"search-container\"]/div[1]/div/div/div[2]/div/label/span")
    private WebElementFacade aceptarCondiciones;
    @FindBy(xpath = "//*[@id=\"home\"]/cookie-pop-up/div/div[2]")
    private WebElementFacade cookiesPopup;
    @FindBy(xpath ="/html/body/rooms-root/rooms-nav-header/div/div/div[1]/rooms-home-link/a/img")
    private WebElementFacade logoRooms;
    @FindBy(css = "li[ng-message='dateAvailable']")
    private WebElementFacade error;

    //CONSTRUCTOR
    public RyanairSearchPage(WebDriver driver) {
        super(driver);
        max(driver);
    }

    public static void max(WebDriver driver){
        driver.manage().window().maximize();
    }


    @WhenPageOpens
    public void waitUnitlLogoAppears() {
        $("#home").waitUntilVisible();
    }

    public void  selectTheDirection(String direccion) {
        js.executeScript("window.scrollBy(0,500)");
        Assert.assertTrue("Fail in direction selection", RyanairGeneralActions.checkDirection(idaButton, idaVueltaButton, direccion,"click"));
    }

    public void typeSourceCity (String searchRequest) {
        Assert.assertTrue("Fail while typing source airport", RyanairGeneralActions.typeSourceCity(sourceTextfield, searchRequest,"type"));
    }

    public void typeDestinyCity (String searchRequest) {
        Assert.assertTrue("Fail while typing destiny airport", RyanairGeneralActions.typeSourceCity(destinyTextfield, searchRequest,"type"));
    }

    public void typeDateTrip (String fechaBuscada) {
        Assert.assertTrue("Fail while typing from date", RyanairGeneralActions.typeDateTrip(destinyTextfieldD, destinyTextfieldM, destinyTextFieldA, destinyTextfieldD1, destinyTextfieldM1, destinyTextFieldA1, fechaBuscada, "type"));
    }

    public void typeDateTripReturn(String fechaVuelta) {
        Assert.assertTrue("Fail while typing finale date", RyanairGeneralActions.typeDateTripReturn(destinyTextfieldD, destinyTextfieldM, destinyTextFieldA, destinyTextfieldD1, destinyTextfieldM1, destinyTextFieldA1, fechaVuelta, "type"));
    }

    public void selectNumberOfAdults(String adults) {
        Assert.assertTrue("Fail while selecting the number of adults", RyanairGeneralActions.selectNumberOfAdults(firstClickAdults, secondClickAdults, adults, "click"));
    }

   public void selectGo() {
       Assert.assertTrue("Fail while click in go button", RyanairGeneralActions.selectGo(vamosButton, "click"));
   }

    public void closeCookiesPolitics () {
        Assert.assertTrue("Fail while click in cookies", RyanairGeneralActions.selectGo(cookiesPopup, "click"));
    }

    public void tabToResult () {
        Assert.assertTrue("Fail while tab in result page", RyanairGeneralActions.tabToResult(logoRooms, this.getDriver()));
    }
}
