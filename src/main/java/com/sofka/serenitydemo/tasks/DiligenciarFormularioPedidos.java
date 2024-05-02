package com.sofka.serenitydemo.tasks;


import com.sofka.serenitydemo.interactions.SelectUnit;
import com.sofka.serenitydemo.DataPruebas.PedidoData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

import static com.sofka.serenitydemo.Pages.PedidosPage.SELECT_CLIENTE_UL;
import static com.sofka.serenitydemo.Pages.PedidosPage.SELECT_EMPLEADO_UL;

public class DiligenciarFormularioPedidos implements Task {

    private final PedidoData pedido;
    private final Target clienteTarget = Target.the("Cliente").locatedBy("#cliente");
    private final Target fechaPedidoTarget = Target.the("Fecha de Pedido").locatedBy("#fechaPedido");
    private final Target fechaEnvioTarget = Target.the("Fecha de Envío").locatedBy("#fechaEnvio");
    private final Target empleadoTarget = Target.the("Empleado").locatedBy("#empleado");
    private final Target productosButtonTarget = Target.the("Botón Productos").locatedBy("#productosButton");

    public DiligenciarFormularioPedidos(PedidoData pedido) {
        this.pedido = pedido;
    }

    public static DiligenciarFormularioPedidos llenarPedidos(PedidoData pedidos) {
        return net.serenitybdd.screenplay.Tasks.instrumented(DiligenciarFormularioPedidos.class, pedidos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(clienteTarget)
        );

        actor.attemptsTo(
                SelectUnit.on(SELECT_CLIENTE_UL, pedido.getCliente())
        );

        actor.attemptsTo(
                Enter.theValue(pedido.getfPedido()).into(fechaPedidoTarget)
        );

        actor.attemptsTo(
                Enter.theValue(pedido.getfEnvio()).into(fechaEnvioTarget)
        );

        actor.attemptsTo(
                Click.on(empleadoTarget)
        );

        actor.attemptsTo(
                SelectUnit.on(SELECT_EMPLEADO_UL, pedido.getEmpleado())
        );

        actor.attemptsTo(
                Click.on(productosButtonTarget)
        );
    }
}