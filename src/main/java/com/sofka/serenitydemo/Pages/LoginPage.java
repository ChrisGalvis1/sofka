package com.sofka.serenitydemo.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

/*@DefaultUrl("https://serenity.is/demo/")
public class LoginPage extends PageObject {
    public static final Target USER = Target.the(" enter user name")
            .located(By.name("Username"));
    public static final Target PASSWORD = Target.the("enter password")
            .located(By.name("Password"));
    public static final Target BUTTONSIGNIN = Target.the("button sign in")
            .located(By.id("StartSharp_Membership_LoginPanel0_LoginButton"));
}*/

@DefaultUrl("https://serenity.is/demo/")
public class LoginPage extends PageObject {
    public static final Target USER = Target.the(" enter user name")
            .located(By.name("Username"));
    public static final Target PASSWORD = Target.the("enter password")
            .located(By.name("Password"));
    public static final Target BUTTONSIGNIN = Target.the("button sign in")
            .located(By.id("StartSharp_Membership_LoginPanel0_LoginButton"));
}
