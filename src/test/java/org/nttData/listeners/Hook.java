package org.nttData.listeners;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.nttData.common.CreatePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class Hook {


    public static WebDriver browserDriver; // Driver di un generico browser che andremo poi a specializzare.
    private String browser; // Tipo di brower da passare come parametro
    private String url = "https://the-internet.herokuapp.com/login";


    @Before // Operazione iniziale da eseguire ad ogni esecuzione di scenario di test.
    public void startBrowser() {

        this.browser = System.getProperty("browser"); // In questo modo definisco i parametri esterni

        // Gestione dei vari browser
        switch (browser) {
            case "firefox" -> firefox();
            case "chrome" -> chrome();

        }

    }

    // Inizializzazione del driver per firefox
    protected void firefox() {
        WebDriverManager.firefoxdriver().setup(); //Inizializzo il driver, in questo caso è il driver per Firefox
        FirefoxOptions options = new FirefoxOptions(); //Oggetto di tipo FirefoxOptions per impostare le opzioni del browser
        options.addArguments("-private"); //Aggiungo all'oggetto options l'opzione browse incognito
        browserDriver = new FirefoxDriver(); //Assegno all'oggetto browserDriver il driver per Firefox
        browserDriver.manage().window().maximize(); //Maximizo il browser
        browserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //Wait implicito di default (Viene usato questo nel tag @FindBy)
        browserDriver.get(url); //Navigo al link passato come parametro
        CreatePage.readDriver(browserDriver);
        System.out.println("firefoxDriver started");
    }

    // inizializzazione del driver per chrome
    protected void chrome() {
        WebDriverManager.chromedriver().setup(); //Inizializzo il driver, in questo caso è il driver per Firefox
        ChromeOptions options = new ChromeOptions(); //Oggetto di tipo ChromeOptions per impostare le opzioni del browser
        options.addArguments("--incognito"); //Aggiungo all'oggetto options l'opzione browse incognito
        browserDriver = new ChromeDriver(); // Assegno all'oggetto browserDriver il driver per Chrome
        browserDriver.manage().window().maximize(); //Maximizo il browser
        browserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //Wait implicito di default (Viene usato questo nel tag @FindBy)
        browserDriver.get(url); //Navigo al link passato come parametro
        CreatePage.readDriver(browserDriver);
        System.out.println("chromeDriver started");
    }

    // Operazione finale da eseguire ad ogni esecuzione di scenario di test.
    @After
    public void closeBrowser(Scenario scenarios) { //Uso gli oggetti Scenario di cucumber per avere informazioni sugli scenari di test

        if(scenarios.isFailed()) { //Verifico se lo scenario è fallito, in quel caso prima di chiudere il browser aggiungo una loggata con il nome dello scenario fallito
            System.out.println(scenarios.getName());
        }
        browserDriver.quit();
    }

}
