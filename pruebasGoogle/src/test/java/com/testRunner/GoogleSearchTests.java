package com.testRunner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by operador on 14/12/2016.
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber-report.json"},
        glue = {"com.stepDefinitions"}
)
public class GoogleSearchTests {

    /**
     * Sets proxy configuration if the property -DuseProxy is added to Gradle test task
     */
    @BeforeClass
    public static void setProxy() {

        //de esto te olvidas raul
        if (System.getProperty("useProxy") != null) {
            String proxyAlten = "192.168.10.53";
            String proxyAdidas = "10.127.254.16";
            String proxyPort = "8080";
            String ip = "";
            try (final DatagramSocket socket = new DatagramSocket()) {
                socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
                ip = socket.getLocalAddress().getHostAddress();
            } catch (Exception e) {
                e.getStackTrace();
            }
            if (ip.contains("192.168.10")) {
                System.setProperty("http.proxyHost", proxyAlten);
                System.setProperty("http.proxyPort", proxyPort);
                System.setProperty("https.proxyHost", proxyAlten);
                System.setProperty("https.proxyPort", proxyPort);
            } else if (ip.contains("10.129")) {
                System.setProperty("http.proxyHost", proxyAdidas);
                System.setProperty("http.proxyPort", proxyPort);
                System.setProperty("https.proxyHost", proxyAdidas);
                System.setProperty("https.proxyPort", proxyPort);
            }
        }
    }

}
