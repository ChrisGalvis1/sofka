package com.sofka.serenitydemo.tasks;

import com.sofka.serenitydemo.interactions.SelectUnit;
import com.sofka.serenitydemo.DataPruebas.ClientesData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static com.sofka.serenitydemo.Pages.ClientesPage.*;

public class DiligenciarFormularioClientes implements Task {

    private final ClientesData cliente;

    public DiligenciarFormularioClientes(ClientesData cliente) {
        this.cliente = cliente;
    }

    public static DiligenciarFormularioClientes llenarFormulario(ClientesData clientes) {
        return new DiligenciarFormularioClientes(clientes);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Enter.theValue(cliente.getId()).into(INPUT_ID),


                Enter.theValue(cliente.getEmpresa()).into(INPUT_NOMBRE_EMPRESA),
                Enter.theValue(cliente.getEmpresa()).into(INPUT_NOMBRE_CONTACTO),
                Enter.theValue(cliente.getEmpresa()).into(INPUT_TITULO_CONTACTO),


                Enter.theValue(cliente.getEmpresa()).into(SELECT_REPRESENTANTE),
                Hit.the(Keys.ENTER).into(SELECT_REPRESENTANTE),


                Enter.theValue(cliente.getEmpresa()).into(INPUT_DIRECCION),

                Click.on(SELECT_PAIS),
                SelectUnit.on(SELECT_PAIS_UL, cliente.getPais()),

                Click.on(SELECT_CIUDAD),
                SelectUnit.on(SELECT_CIUDAD_UL, cliente.getCiudad()),

                Enter.theValue(cliente.getEmpresa()).into(INPUT_REGION),
                Enter.theValue(cliente.getEmpresa()).into(INPUT_CODIGO_POSTAL),
                Enter.theValue(cliente.getEmpresa()).into(INPUT_TELEFONO),
                Enter.theValue(cliente.getEmpresa()).into(INPUT_FAX),

                Enter.theValue(cliente.getEmpresa()).into(DATE_FECHA_ULTIMO_CONTACTO),
                Click.on(SELECT_ULTIMO_CONTACTO_POR),
                SelectUnit.on(SELECT_ULTIMO_CONTACTO_POR_UL, cliente.getuContactoPor()),

                Enter.theValue(cliente.getEmpresa()).into(INPUT_EMAIL),
                Click.on(CHECK_BOLETIN),

                Scroll.to(BUTTON_GUARDAR),


                WaitUntil.the(ID_CLIENTES_TABLE, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}