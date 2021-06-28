package seleniumgluecode;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class Test {
    private ChromeDriver driver;

    @Given("^El usuario se encuentre en la pagina inicial de \"([^\"]*)\" y llene los campos \"([^\"]*)\" y \"([^\"]*)\"$")
    public void el_usuario_se_encuentre_en_la_pagina_inicial_de_y_llene_los_campos_y(String arg1, String arg2, String arg3) throws Throwable {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        //Credentials
        String username = "standard_user";
        String password = "secret_sauce";

        //Locator by ID
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));

        sleep(2000);
        usernameInput.sendKeys(username);
        sleep(2000);
        passwordInput.sendKeys(password);
        sleep(7000);
        loginBtn.click();

    }

    @When("^ingrese, seleccione el producto \"([^\"]*)\" y dar click sobre el$")
    public void ingrese_seleccione_el_producto_y_dar_click_sobre_el(String arg1) throws Throwable {
        WebElement ProductLocator = driver.findElement(By.xpath("//* [contains(text(),'Sauce Labs Fleece Jacket')]"));
        sleep(5000);
        ProductLocator.click();
    }

    @Then("^Cuando sea encontrado, agregalo al carrito$")
    public void cuando_sea_encontrado_agregalo_al_carrito() throws Throwable {
        WebElement CartLocator = driver.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket"));
        CartLocator.click();
        WebElement ShowCartLocator = driver.findElement(By.className("shopping_cart_badge"));
        sleep(2000);
        ShowCartLocator.click();
    }

}
