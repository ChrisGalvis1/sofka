package com.sofka.serenitydemo.tasks;

import com.sofka.serenitydemo.interactions.SelectUnit;
import com.sofka.serenitydemo.DataPruebas.PedidoData;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static com.sofka.serenitydemo.Pages.PedidosPage.*;


public class DiligenciarFormularioProductos implements Task {

    private final PedidoData producto;
    private final Interaction waitUntilVisible = WaitUntil.the(LBL_PEDIDO, isVisible()).forNoMoreThan(30).seconds();
    private final String HOLA = "hola";

    public DiligenciarFormularioProductos(PedidoData producto) {
        this.producto = producto;
    }

    public static DiligenciarFormularioProductos llenarProductos(PedidoData productos) {
        return new DiligenciarFormularioProductos(productos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SELECT_PRODUCTO),
                SelectUnit.fromList(SELECT_PRODUCTO_UL, producto.getProducto())
        );

        Enter.theValue(producto.getPrecio()).into(INPUT_PRECIO);

        actor.attemptsTo(
                Enter.keyValues(producto.getCantidad()).into(INPUT_CANTIDA),
                Click.on(BUTTON_GUARDAR_PRODUCTOS)
        );

        actor.attemptsTo(
                Click.on(BUTTON_GUARDAR_PEDIDO),
                waitUntilVisible
        );

        Serenity.recordReportData().withTitle(HOLA).andContents(producto.getPrecio());
    }
}