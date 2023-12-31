package com.liquidaciones.infraestructura.entrypoints;

import com.liquidaciones.infraestructura.entrypoints.empleadoEntryPoint.CargoHandler;
import com.liquidaciones.infraestructura.entrypoints.empleadoEntryPoint.EmpleadoHandler;
import com.liquidaciones.infraestructura.entrypoints.empleadoEntryPoint.LiquidacionHandler;
import com.liquidaciones.infraestructura.entrypoints.empleadoEntryPoint.SalarioHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
@Configuration
public class ApiRoutes {

    @Value("${PATH_BASE}")
    private String pathBase;

    String param = "/{id}";


    @Bean
    public RouterFunction<ServerResponse> empleadoFunctionalEndpoints(EmpleadoHandler empleadoHandler) {

        return RouterFunctions
                .route(POST(pathBase.concat("/empleado")).and(accept(MediaType.APPLICATION_JSON)), empleadoHandler::crearEmpleado)
                .andRoute(GET(pathBase.concat("/empleado").concat(param)).and(accept(MediaType.APPLICATION_JSON)), empleadoHandler::getEmpleadoById)
                .andRoute(PUT(pathBase.concat("/empleado").concat(param)).and(accept(MediaType.APPLICATION_JSON)), empleadoHandler::actualizarEmpleado)
                .andRoute(DELETE(pathBase.concat("/empleado").concat(param)).and(accept(MediaType.APPLICATION_JSON)), empleadoHandler::eliminarEmpleado)
                .andRoute(GET(pathBase.concat("/empleado")).and(accept(MediaType.APPLICATION_JSON)), empleadoHandler::getEmpleados);
    }


    @Bean
    public RouterFunction<ServerResponse> salarioFunctionalEndpoints(SalarioHandler salarioHandler) {

        return RouterFunctions
                .route(POST(pathBase.concat("/salario")).and(accept(MediaType.APPLICATION_JSON)), salarioHandler::crearSalario)
                .andRoute(GET(pathBase.concat("/salario").concat(param)).and(accept(MediaType.APPLICATION_JSON)), salarioHandler::getSalarioById)
                .andRoute(PUT(pathBase.concat("/salario").concat(param)).and(accept(MediaType.APPLICATION_JSON)), salarioHandler::actualizarSalario)
                .andRoute(DELETE(pathBase.concat("/salario").concat(param)).and(accept(MediaType.APPLICATION_JSON)), salarioHandler::eliminarSalario)
                .andRoute(GET(pathBase.concat("/salario")).and(accept(MediaType.APPLICATION_JSON)), salarioHandler::getSalarios);
    }


    @Bean
    public RouterFunction<ServerResponse> cargoFunctionalEndpoints(CargoHandler cargoHandler) {

        return RouterFunctions
                .route(POST(pathBase.concat("/cargo")).and(accept(MediaType.APPLICATION_JSON)), cargoHandler::crearCargo)
                .andRoute(GET(pathBase.concat("/cargo").concat(param)).and(accept(MediaType.APPLICATION_JSON)), cargoHandler::getCargoById)
                .andRoute(PUT(pathBase.concat("/cargo").concat(param)).and(accept(MediaType.APPLICATION_JSON)), cargoHandler::actualizarCargo)
                .andRoute(DELETE(pathBase.concat("/cargo").concat(param)).and(accept(MediaType.APPLICATION_JSON)), cargoHandler::eliminarCargo)
                .andRoute(GET(pathBase.concat("/cargo")).and(accept(MediaType.APPLICATION_JSON)), cargoHandler::getCargos);
    }


    @Bean
    public RouterFunction<ServerResponse>liquidacionFunctionalEndpoints(LiquidacionHandler liquidacionHandler) {

        return RouterFunctions
                .route(POST(pathBase.concat("/liquidacion")).and(accept(MediaType.APPLICATION_JSON)), liquidacionHandler::crearLiquidacion)
                .andRoute(GET(pathBase.concat("/liquidacion").concat(param)).and(accept(MediaType.APPLICATION_JSON)), liquidacionHandler::getLiquidacionById)
                .andRoute(PUT(pathBase.concat("/liquidacion").concat(param)).and(accept(MediaType.APPLICATION_JSON)), liquidacionHandler::actualizarLiquidacion)
                .andRoute(DELETE(pathBase.concat("/liquidacion").concat(param)).and(accept(MediaType.APPLICATION_JSON)), liquidacionHandler::eliminarLiquidacion)
                .andRoute(GET(pathBase.concat("/liquidacion")).and(accept(MediaType.APPLICATION_JSON)), liquidacionHandler::getLiquidaciones);
    }

}
