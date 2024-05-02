package com.sofka.serenitydemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import com.sofka.serenitydemo.Pages.SerenityPage;

public class SeleccionarPedidos implements Task {
    public static SeleccionarPedidos submenuPedidos() {
        return Tasks.instrumented(SeleccionarPedidos.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SerenityPage.LABEL_MENU_VIENTO_NORTE)
        );

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actor.attemptsTo(
                Click.on(SerenityPage.LABEL_SUBMENU_PEDIDOS)
        );

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        actor.attemptsTo(
                Click.on(SerenityPage.BTN_NUEVO_PEDIDOS)
        );

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
