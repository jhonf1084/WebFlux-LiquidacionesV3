package com.liquidaciones.infraestructura.entrypoints.empleadoEntryPoint.dto;

import com.liquidaciones.domain.model.empleado.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class EmpleadoDTO {

    @Id
    private Integer id_empleado;
    private Integer documento;
    private String nombre_apellidos;
    private LocalDate fecha_contrato;


    //Consultar si este metodo debe ser statico
    public Empleado toDomain() {
        return new Empleado(
                IdEmpleado.builder().value(id_empleado).build(),
                Documento.builder().value(documento).build(),
                NombreApellidos.builder().value(nombre_apellidos).build(),
                FechaContrato.builder().value(fecha_contrato).build());
    }


    public static EmpleadoDTO fromDomain(Empleado empleado) {
        return new EmpleadoDTO(
                empleado.getId_empleado().getValue(),
                empleado.getDocumento().getValue(),
                empleado.getNombre_apellidos().getValue(),
                empleado.getFecha_contrato().getValue());
    }


    public EmpleadoDTO(Integer id_empleado, Integer documento, String nombre_apellidos, LocalDate fecha_contrato) {
        this.id_empleado = id_empleado;
        this.documento = documento;
        this.nombre_apellidos = nombre_apellidos;
        this.fecha_contrato = fecha_contrato;
    }

    public Integer getId_empleado() {
        return id_empleado;
    }

    public Integer getDocumento() {
        return documento;
    }

    public String getNombre_apellidos() {
        return nombre_apellidos;
    }

    public LocalDate getFecha_contrato() {
        return fecha_contrato;
    }
}
