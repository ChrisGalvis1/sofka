package com.sofka.serenitydemo.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com.sofka.serenitydemo.stepdefinitions",
        features = "src/test/resources/features/serenity_demo_conferencias.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunnerMeetingsSerenityDemo {
}
