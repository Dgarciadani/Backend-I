package com.digitalhouse.junit.ejercicio1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PersonaTest {

    Persona persona;
    Persona persona1;
    Persona persona2;

    @BeforeEach
    void doBefore() {
        persona = new Persona("Javier", "Test");
        persona.setEdad(LocalDate.of(1980, 4, 12));
        persona.setEmail("dgarciadani@gmail.com");
        persona1 = new Persona("Vale", "Nov");
        persona1.setEdad(LocalDate.of(2003, 9, 20));
        persona2 = new Persona("Tito", "Perez");
        persona2.setEdad(LocalDate.of(2019, 12, 04));
    }

    @Test
    void getNombreCompleto() {

        assertEquals("Javier, Test", persona.calcularNombreCompleto());
        assertEquals("Vale, Nov", persona1.calcularNombreCompleto());
        assertEquals("Tito, Perez", persona2.calcularNombreCompleto());
    }

    @Test
    void getEsMayorDe18() {
        assertTrue(persona.esMayorDeEdad()); //SIMPLIFICACION DE ASSERT BUSCA TRUE
        assertFalse(persona1.esMayorDeEdad()); //SIMPLIFICACION DE ASSERT BUSCA FALSE
        assertEquals(persona2.esMayorDeEdad(), false);
    }
    @Test
    void getEmail(){
        assertEquals("dgarciadani@gmail.com",persona.getEmail());
        
    }
}
