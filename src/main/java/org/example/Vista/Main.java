package org.example.Vista;

import org.example.Modelo.Contacto;
import org.example.servicio.Agenda;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        // Agregar contactos
//        agenda.agregarContacto("Mario", "123456789");
//        agenda.agregarContacto("Link", "987654321");
//        agenda.agregarContacto("Peach", "456789123");

        agenda.agregarContacto("Ana", 123456789L, "ana@example.com", LocalDate.of(1990, 5, 10));
        agenda.agregarContacto("Beatriz", 987654321L, "beatriz@example.com", LocalDate.of(1988, 8, 15));
        agenda.agregarContacto("Carlos", 456789123L, "carlos@example.com", LocalDate.of(1992, 2, 20));

        // Mostrar contactos
        System.out.println("Contactos en la agenda:");
        agenda.mostrarContactos();

        // Buscar un contacto
        System.out.println("\nBuscando el contacto de Link:");
        Contacto contacto = agenda.buscarContacto("Link");
        if (contacto != null) {
            System.out.println("Nombre: " + contacto.getNombre() + ", Teléfono: " + contacto.getTelefono());
        } else {
            System.out.println("Contacto no encontrado.");
        }

        // Eliminar un contacto
        System.out.println("\nEliminando el contacto de Peach.");
        agenda.eliminarContacto("Peach");

        // Mostrar contactos después de la eliminación
        System.out.println("Contactos en la agenda después de eliminar a Alice:");
        agenda.mostrarContactos();
    }
}
