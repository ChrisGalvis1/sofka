package com.sofka.serenitydemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSerenity implements Task {
    private String strUsuario;
    private String strPassword;

    public LoginSerenity(String strUsuario, String strPassword) {
        this.strUsuario = strUsuario;
        this.strPassword = strPassword;
        //this.strUsuario = "usuario1";
        //this.strPassword = "contraseña";
    }

    public static LoginSerenity conCredenciales(String strUsuario, String strPassword) {
        return Tasks.instrumented(LoginSerenity.class, strUsuario, strPassword);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = new ChromeDriver();
        WebElement usernameInput = driver.findElement(By.id("username"));

        // Enter the username
        usernameInput.sendKeys("myusername");

        // Find the password input field
        WebElement passwordInput = driver.findElement(By.id("password"));

        // Enter the password
        passwordInput.sendKeys("mypassword");

        // Find the login button
        WebElement loginButton = driver.findElement(By.id("login-button"));

        // Click the login button
        loginButton.click();

    }
}
