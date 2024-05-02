package com.sofka.serenitydemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Browser;
import net.serenitybdd.screenplay.actions.Open;
import com.sofka.serenitydemo.Pages.SerenityPage;

public class OpenSerenity implements Task {
    private SerenityPage serenityPage;

    public static OpenSerenity thePage() {
        return Tasks.instrumented(OpenSerenity.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn(serenityPage),
                Browser.maximize()
        );
    }
}
