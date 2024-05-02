package com.sofka.serenitydemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.core.pages.PageObject;

public class GoTo implements Task {
    PageObject page;

    public GoTo(PageObject page) {
        this.page = page;
    }

    public static GoTo link(PageObject page) {
        return Tasks.instrumented(GoTo.class, page);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(page));
    }
}
