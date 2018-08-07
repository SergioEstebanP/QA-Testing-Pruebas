package com.page;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Set;

@DefaultUrl("https://www.ryanair.com/es/es/")
public class RyanairSearchPage extends PageObject {

    JavascriptExecutor js = (JavascriptExecutor) this.getDriver();
    WebDriver driver2 = this.getDriver();
    //ATRIBUTOS
    @CacheLookup
    // botones de ida y vuelta
    @FindBy(xpath = "//*[@id=\"lbl-flight-search-type-one-way\"]")
    private WebElement idaButton;
    @FindBy(xpath = "//*[@id=\"lbl-flight-search-type-return\"]")
    private WebElement idaVueltaButton;

    // campos de aeropuesto de salida y llegada
    @FindBy(css = "input[placeholder='Aeropuerto de salida']")
    private WebElement sourceTextfield;
    @FindBy(css = "input[placeholder='Aeropuerto de destino']")
    private WebElement destinyTextfield;

    // campos de fecha de ida
    @FindBy(css = "input[aria-label='Vuelo de ida: - DD']")
    private WebElement destinyTextfieldD;
    @FindBy(css = "input[aria-label='Vuelo de ida: - MM']")
    private WebElement destinyTextfieldM;
    @FindBy(css = "input[aria-label='Vuelo de ida: - YYYY']")
    private WebElement destinyTextFieldA;

    // campos de fecha de ida
    @FindBy(css = "input[aria-label='Vuelo de vuelta: - DD']")
    private WebElement destinyTextfieldD1;
    @FindBy(css = "input[aria-label='Vuelo de vuelta: - MM']")
    private WebElement destinyTextfieldM1;
    @FindBy(css = "input[aria-label='Vuelo de vuelta: - YYYY']")
    private WebElement destinyTextFieldA1;

    // campos bomo pasajeros
    @FindBy(xpath = "//*[@id=\"row-dates-pax\"]/div[2]/div[2]/div[2]/div/div[1]")
    private WebElement firstClickAdults;
    @FindBy(xpath = "//*[@id=\"row-dates-pax\"]/div[2]/div[3]/div/div/div[2]/popup-content/div[6]/div/div[3]/core-inc-dec/button[2]")
    private WebElement secondClickAdults;
    @FindBy(xpath = "//*[@id=\"search-container\"]/div[1]/div/form/div[4]/button[2]")

    // boton de vamos
    private WebElement vamosButton;
    @FindBy(xpath = "//*[@id=\"search-container\"]/div[1]/div/div/div[2]/div/label/span")
    private WebElement aceptarCondiciones;
    @FindBy(xpath = "//*[@id=\"home\"]/cookie-pop-up/div/div[2]")
    private WebElement cookiesPopup;
    @FindBy(xpath ="/html/body/rooms-root/rooms-nav-header/div/div/div[1]/rooms-home-link/a/img")
    private WebElement logoRooms;
    @FindBy(css = "div[class='direct']")
    private WebElement fly;
    @FindBy(css = "li[ng-message='dateAvailable']")
    private WebElement error;

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

    public void  selectDirection() {
        element(idaButton).waitUntilClickable();
        element(idaButton).click();
        js.executeScript("window.scrollBy(0,1000)");
    }

    public void  selectTheDirection(String direccion) {
        System.out.printf("-%s-", direccion);
        if (direccion.equals("ida")) {
            element(idaButton).waitUntilClickable();
            element(idaButton).click();
            js.executeScript("window.scrollBy(0,1000)");
        }else {
            element(idaVueltaButton).waitUntilClickable();
            element(idaVueltaButton).click();
            js.executeScript("window.scrollBy(0,1000)");
        }
    }

    public void typeSourceCity (String searchRequest) {
        element(sourceTextfield).clear();
        element(sourceTextfield).typeAndEnter(searchRequest);
    }

    public void typeDestinyCity (String searchRequest) {
        element(destinyTextfield).clear();
        element(destinyTextfield).typeAndEnter(searchRequest);
    }

    public void typeDateTrip (String fechaBuscada) {
        esperarCamposFecha();
        if (fechaBuscada.equals("")) {
            LocalDate date = LocalDate.now();
            System.out.println(date);
            rellenarCampos(date);
        }else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
            LocalDate date = LocalDate.parse(fechaBuscada, formatter);
            rellenarCampos(date);
        }

    }

    public void typeDateTripReturn(String fechaVuelta) {
        esperarCamposFecha();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(fechaVuelta, formatter);
        rellenarCampos(date);
    }

    public void rellenarCampos (LocalDate date) {
        String dia = Integer.toString(date.getDayOfMonth());
        String mes = Integer.toString(date.getMonthValue());
        String year = Integer.toString(date.getYear());

        element(destinyTextfieldD).typeAndTab(dia);
        element(destinyTextfieldM).typeAndTab(mes);
        element(destinyTextFieldA).typeAndTab(year);
    }

    public void esperarCamposFecha () {
        element(destinyTextfieldD).waitUntilClickable();
        element(destinyTextfieldM).waitUntilClickable();
        element(destinyTextFieldA).waitUntilClickable();
        element(destinyTextfieldD).clear();
        element(destinyTextfieldM).clear();
        element(destinyTextFieldA).clear();
    }

    public void selectNumberOfAdults(String adults) {
        element(firstClickAdults).waitUntilClickable().click();
        for (int i=1;i<Integer.parseInt(adults);i++)
            element(secondClickAdults).waitUntilClickable().click();
    }

   public void selectGo() {
       element(vamosButton).waitUntilClickable().click();
   }
    public boolean selectGoValid() {
        try {
            element(error).isVisible();
            return false;
        } catch (Exception e) {
            System.out.println(e);
        }
        element(vamosButton).waitUntilClickable().click();
        return true;
   }
    public void closeCookiesPolitics () {
        element(cookiesPopup).waitUntilEnabled().click();
    }

    public void closeWindow () {
        element(logoRooms).waitUntilVisible();
        Set<String> handles = driver2.getWindowHandles(); // Gets all the available windows
        for(String handle : handles) {
            driver2.switchTo().window(handle); // switching back to each window in loop
            if(driver2.getTitle().equals("Ryanair")); // Compare title and if title matches stop loop and return true
        }
    }

    public boolean verifyResults () {
        while (!isDisplayed(fly)) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return true;
    }

    public static boolean isDisplayed(WebElement element) {
        try {
            if(element.isDisplayed())
                return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
        return false;
    }

}
