package com.sofka.serenitydemo.validaciones;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

//import static userinterface.SerenityLoginPage.HOME_LOGO;
import static com.sofka.serenitydemo.Pages.SerenityLoginPage.HOME_LOGO;

public class ValidarSesion implements Question<Boolean> {

    public static ValidarSesion homePage() {
        return new ValidarSesion();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return HOME_LOGO.resolveFor(actor).isDisplayed();
    }
}
