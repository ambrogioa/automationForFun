package org.nttData.common;



import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import org.openqa.selenium.WebDriver;
import java.lang.reflect.Constructor;



public class CreatePage {

    private static WebDriver driver;

    public static void readDriver(WebDriver driver){
        CreatePage.driver = driver;
    }
}
