package com.sofka.serenitydemo.stepdefinitions;


import com.sofka.serenitydemo.Pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import com.sofka.serenitydemo.DataPruebas.ClientesData;
import com.sofka.serenitydemo.DataPruebas.PedidoData;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import com.sofka.serenitydemo.validaciones.ValidarSesion;
import com.sofka.serenitydemo.validaciones.VerificarClintes;
import com.sofka.serenitydemo.tasks.*;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;


public class SerenityStepDefinitions {
    @Before
    public void setStage() {
        OnStage.setTheStage((new OnlineCast()));
    }

    @Given("que quiero iniciar sesion con usuario {string} y contrasena {string} en serenity.is")
    public void queQuieroIniciarSesionConUsuarioYContrasenaEnSerenityIs(String strUsuario, String strPassword) {
        OnStage.theActorCalled("miguel").wasAbleTo(
                OpenSerenity.thePage(),
                LoginSerenity.conCredenciales(strUsuario, strPassword)
                //LoginPage.USER(strUsuario)
        );
    }

    /*@Dado("^que quiero iniciar sesion con usuario \"([^\"]*)\" y contrasena \"([^\"]*)\" en serenity\\.is$")
    public void queMiguelQuiereIniciarSesionConYEnSerenityIs(String strUsuario, String strPassword) throws InterruptedException {
        OnStage.theActorCalled("miguel").wasAbleTo(
                OpenSerenity.thePage(),
                LoginSerenity.conCredenciales(strUsuario, strPassword)
                //LoginPage.USER(strUsuario)
        );
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(ValidarSesion.homePage())
        );
    }*/

    @Dado("^que quiero crear un nuevo cliente$")
    public void queMiguelQuiereCrearUnNuevoCliente() {
        OnStage.theActorInTheSpotlight().attemptsTo(SeleccionarCliente.submenu());
    }

    @Cuando("^ingreso los datos del nuevo cliente y hago clic en el botón guardar$")
    public void miguelIngresaLosDatosDelNuevoClienteYDaClicEnElBotonGuardar(DataTable cliente) {
        OnStage.theActorInTheSpotlight().attemptsTo(DiligenciarFormularioClientes.llenarFormulario(ClientesData.setData(cliente).get(0)));
    }

    @Entonces("^debería ver el nuevo cliente en la lista general de cliente registrados en el sistema (.*)$")
    public void miguelDeberaVerElNuevoClienteEnLaListaGeneralDeClienteRegistradosEnElSistema(String valida) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(VerificarClintes.existeCliente(valida))
        );
    }

    @Dado("^que quiero crear un nuevo pedido ingreso los datos del pedido$")
    public void queMiguelQuiereCrearUnNuevoPedidoIngresaLosDatosDelPedido(DataTable data) {
        OnStage.theActorInTheSpotlight().attemptsTo(SeleccionarPedidos.submenuPedidos());
        OnStage.theActorInTheSpotlight().attemptsTo(DiligenciarFormularioPedidos.llenarPedidos(PedidoData.setData(data).get(0)));
    }

    @Cuando("^ingreso los productos del pedido y hago clic en el botón guardarm$")
    public void miguelIngresaLosProductosDelPedidoYDaClicEnElBotonGuardarm(DataTable producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(DiligenciarFormularioProductos.llenarProductos(PedidoData.setData(producto).get(0)));
    }

    @Entonces("^debería ver el nuevo pedido en la lista general de pedidos registrados en el sistema$")
    public void miguelDeberaVerElNuevoPedidoEnLaListaGeneralDePedidosRegistradosEnElSistema() {
        Assert.assertThat(Serenity.getCurrentSession().isEmpty(), IsEqual.equalTo(false));
    }

}
