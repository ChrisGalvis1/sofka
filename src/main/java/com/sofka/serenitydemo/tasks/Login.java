package com.sofka.serenitydemo.tasks;

import com.sofka.serenitydemo.Pages.LoginPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login implements Task {
    static WebDriver driver;

    String userName;
    String password;


    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public static Login on(String userName, String password) {
        return Tasks.instrumented(Login.class, userName, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            WebElement name = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/form/div[1]/div/div/div[1]/input"));
            name.sendKeys(userName);

            Thread.sleep(10000);

            WebElement  pass =  driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/form/div[1]/div/div/div[2]/input"));
            pass.sendKeys(password);
            Thread.sleep(10000);
            Serenity.setSessionVariable("resultado").to(true);

        }catch (Exception e){
            e.printStackTrace();
            Serenity.setSessionVariable("resultado").to(false);
        }
        finally {
            /*driver.close();*/
        }


        actor.attemptsTo(Click.on(LoginPage.BUTTONSIGNIN));
    }
}
