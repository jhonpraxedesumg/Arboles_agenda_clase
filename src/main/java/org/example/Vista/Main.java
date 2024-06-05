package org.example.Vista;

import org.example.Modelo.Contacto;
import org.example.servicio.Agenda;
import org.example.servicio.Persistencia;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        //agenda.buscarContacto("praxedes");

        // Agregar contactos
//        agenda.agregarContacto("Mario", "123456789");
//        agenda.agregarContacto("Link", "987654321");
//        agenda.agregarContacto("Peach", "456789123");

        agenda.agregarContacto("praxedes", 767766767, "praxedes@gmail.com.com", LocalDate.of(1994, 8, 27));
        agenda.agregarContacto("amilcar", 585758585, "amilcar@.gmailcom", LocalDate.of(1962, 2, 12));
        agenda.agregarContacto("salazar", 877587866, "salazar@gmail.com.com", LocalDate.of(1942, 6, 13));

        // Mostrar contactos
        System.out.println("Contactos en la agenda:");
        agenda.mostrarContactos();

        Persistencia.guardarAgenda(agenda);
        System.out.println("GUARDADA");

        agenda = new Agenda();
        agenda = Persistencia.cargarAgenda();

        System.out.println("contactos despues de cargados  ");
        agenda.mostrarContactos();
//
//        // Buscar un contacto
//        System.out.println("\nBuscando el contacto de Link:");
//        Contacto contacto = agenda.buscarContacto("Link");
//        if (contacto != null) {
//            System.out.println("Nombre: " + contacto.getNombre() + ", Teléfono: " + contacto.getTelefono());
//        } else {
//            System.out.println("Contacto no encontrado.");
//        }

        // Eliminar un contacto
//        System.out.println("\nEliminando el contacto de salazar.");
//        agenda.eliminarContacto("Peach");
//
//        // Mostrar contactos después de la eliminación
//        System.out.println("Contactos en la agenda después de eliminar a praxedes:");
//        agenda.mostrarContactos();
    }
}
