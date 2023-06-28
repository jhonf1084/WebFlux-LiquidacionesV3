package com.liquidaciones.domain.usecase;


import com.liquidaciones.domain.model.empleado.Empleado;
import com.liquidaciones.domain.model.gateways.EmpleadoRepository;
import com.liquidaciones.infraestructura.entrypoints.empleadoEntryPoint.dto.EmpleadoDTO;
import lombok.AllArgsConstructor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@AllArgsConstructor
public class EmpleadoUseCase {

    private final EmpleadoRepository empleadoRepository;

    public Mono<Empleado> crearEmpleado (EmpleadoDTO empleadoDTO) {
        Empleado empleado = empleadoDTO.toDomain();
        return empleadoRepository.saveEmpleado(empleado);
    }

    public Mono<Empleado> getEmpleadoById(Integer id_empleado) {
        return empleadoRepository.findByIdEmpleado(id_empleado);
    }

    public Mono<Empleado> actualizarEmpleado(EmpleadoDTO empleadoDTO) {
        Empleado empleado = empleadoDTO.toDomain();
        return empleadoRepository.updateEmpleado(empleado);
    }

    public Mono<Empleado> eliminarEmpleado(Integer id_empleado) {

        return empleadoRepository.deleteEmpleado(id_empleado);
    }


    public Flux<Empleado> getEmpleados() {

        return empleadoRepository.findAllEmpleados();
    }

}
