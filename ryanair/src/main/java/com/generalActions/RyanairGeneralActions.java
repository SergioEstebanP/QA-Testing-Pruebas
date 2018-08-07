package com.generalActions;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Set;

public class RyanairGeneralActions {

    private static boolean soloIda = false;

    public RyanairGeneralActions () {
        super();
    }

    public static boolean checkDirection (WebElementFacade webElement1, WebElementFacade webElement2, String direction, String action) {
        try {
            switch (action) {
                case "click":
                    if (direction.equals("ida")){
                        soloIda = true;
                        webElement1.waitUntilClickable();
                        webElement1.click();
                    } else {
                        soloIda = false;
                        webElement2.waitUntilClickable();
                        webElement2.click();
                    }
                    return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static boolean typeSourceCity (WebElementFacade webElement, String cityName, String action) {
        try {
            switch (action) {
                case "type":
                    webElement.clear();
                    webElement.typeAndEnter(cityName);
                    return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static boolean typeDateTripOnce (WebElementFacade webE1, WebElementFacade webE2, WebElementFacade webE3, WebElementFacade webE4, WebElementFacade webE5, WebElementFacade webE6, String fecha, String action) {
        System.out.println(soloIda);
        try {
            if (action.equals("type")) {
                esperarCamposFecha(webE1, webE2, webE3, webE4, webE5, webE6);
                if (soloIda) {
                    LocalDate date = null;
                    if (fecha.equals("")) {
                        date = LocalDate.now();
                    } else {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
                        date = LocalDate.parse(fecha, formatter);
                        soloIda = true;
                    }
                    rellenarCampos(date, webE1, webE2, webE3, webE4, webE5, webE6);
                    return true;
                } else {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
                    LocalDate date = null;
                    date = LocalDate.now();
                    soloIda = true;
                    rellenarCampos(date, webE1, webE2, webE3, webE4, webE5, webE6);
                    soloIda = false;
                    date = LocalDate.parse(fecha, formatter);
                    rellenarCampos(date, webE1, webE2, webE3, webE4, webE5, webE6);
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    private static void esperarCamposFecha (WebElementFacade webE1, WebElementFacade webE2, WebElementFacade webE3, WebElementFacade webE4, WebElementFacade webE5, WebElementFacade webE6) {
        if (soloIda) {
            webE1.waitUntilClickable();
            webE2.waitUntilClickable();
            webE3.waitUntilClickable();
            webE1.clear();
            webE2.clear();
            webE3.clear();
        }else{
            webE4.waitUntilClickable();
            webE5.waitUntilClickable();
            webE6.waitUntilClickable();
            webE4.clear();
            webE5.clear();
            webE6.clear();
        }
    }

    private static void rellenarCampos (LocalDate date, WebElementFacade webE1, WebElementFacade webE2, WebElementFacade webE3, WebElementFacade webE4, WebElementFacade webE5, WebElementFacade webE6) {
        String dia = Integer.toString(date.getDayOfMonth());
        String mes = Integer.toString(date.getMonthValue());
        String year = Integer.toString(date.getYear());

        if (soloIda){
            webE1.typeAndTab(dia);
            webE2.typeAndTab(mes);
            webE3.typeAndTab(year);
        }else {
            webE4.typeAndTab(dia);
            webE5.typeAndTab(mes);
            webE6.typeAndTab(year);
        }
    }

    public static boolean selectNumberOfAdults (WebElementFacade webE1, WebElementFacade webE2, String numberOfAdults, String action) {
        try {
            webE1.waitUntilClickable();
            switch (action) {
                case "click":
                    webE1.click();
                    for (int i=1;i<Integer.parseInt(numberOfAdults);i++)
                        webE2.click();
                    return true;
            }
        } catch (Exception e) { return false;}
        return false;
    }

    public static boolean selectGo (WebElementFacade webE, String action) {
        try {
            webE.waitUntilEnabled();
            if (action.equals("click")) { webE.click(); return true;}
        } catch (Exception e) { return false;}
        return false;
    }

    public static boolean tabToResult (WebElementFacade webE, WebDriver driver) {
        try {
            webE.waitUntilVisible();
            Set<String> handles = driver.getWindowHandles();
            for(String handle : handles) {
                driver.switchTo().window(handle);
                if(driver.getTitle().equals("Ryanair"));
            }
            return true;
        } catch (Exception e) { return false; }
    }
}
