package com.sofka.serenitydemo.stepdefinitions;

import com.sofka.serenitydemo.tasks.GoTo;
import com.sofka.serenitydemo.tasks.Login;
import com.sofka.serenitydemo.Pages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class StepDefinitionMeetingsSerenityDemo {

    @Managed(driver = "chrome")
    private WebDriver web;
    private Actor actor = Actor.named("Sofka");
    private LoginPage home;

    @Before
    public void setUp() {
        actor.can(BrowseTheWeb.with(web));
    }

    @Given("it is required to enter the serenity demo page and log in with {string} and {string}")
    public void openSerenityDemo(String userName, String password) {
        actor.wasAbleTo(GoTo.link(home));
        actor.attemptsTo(Login.on(userName,password));
    }
    @When("a new business unit is created with the data {string} {string}")
    public void createBusinessUnit(String name, String parentUnit) {

    }
    @When("schedule a new meeting with the data {string}, {string}, {string},{string},{string},{string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void scheduleNewMeeting(String meetingName, String meetingType, String meetingNumber, String startDate, String startHour, String endDate, String endHour, String location, String unit, String organizatedBy, String reporter, String invited1, String invited2, String invited3) {

    }
    @Then("validate that the meeting is created with name {string}")
    public void validateMeetingCreated(String meetingName) {
        if (Boolean.valueOf(String.valueOf(actor.recall("resultado")))==true){
            System.out.println("test"+String.valueOf(actor.recall("resultado"+"exitoso")));
        }else {
            System.out.println("test"+String.valueOf(actor.recall("resultado"+"fallido")));
        }

    }
}
