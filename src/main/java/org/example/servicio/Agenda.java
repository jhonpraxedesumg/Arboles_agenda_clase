package org.example.servicio;

import org.example.Modelo.Contacto;
import org.example.Modelo.NodoContacto;

import java.time.LocalDate;

public class Agenda {
    private NodoContacto raiz;

    public Agenda() {
        this.raiz = null;               //agregar get raiz y set raiz
    }

    public NodoContacto getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoContacto raiz) {
        this.raiz = raiz;
    }

    public void agregarContacto(String nombre, long telefono, String correoElectronico, LocalDate fechaNacimiento) {
        Contacto nuevoContacto = new Contacto(nombre, telefono, correoElectronico, fechaNacimiento);
        if (this.raiz == null) {
            this.raiz = new NodoContacto(nuevoContacto);
        } else {
            this.insertar(this.raiz, nuevoContacto);
        }
    }

    private void insertar(NodoContacto padre, Contacto contacto) {
        if (contacto.getNombre().compareTo(padre.getContacto().getNombre()) < 0) {
            if (padre.getIzdo() == null) {
                padre.setIzdo(new NodoContacto(contacto));
            } else {
                insertar(padre.getIzdo(), contacto);
            }
        } else if (contacto.getNombre().compareTo(padre.getContacto().getNombre()) > 0) {
            if (padre.getDcho() == null) {
                padre.setDcho(new NodoContacto(contacto));
            } else {
                insertar(padre.getDcho(), contacto);
            }
        }
    }
///////////////////////////////////////////////////////////////////////
//    public Contacto buscarContacto(String nombre) {
//        return buscar(this.raiz, nombre);
//    }
//
//    private Contacto buscar(NodoContacto nodo, String nombre) {
//        if (nodo == null) {
//            return null;
//        }
//        if (nombre.equals(nodo.getContacto().getNombre())) {
//            return nodo.getContacto();
//        } else if (nombre.compareTo(nodo.getContacto().getNombre()) < 0) {
//            return buscar(nodo.getIzdo(), nombre);
//        } else {
//            return buscar(nodo.getDcho(), nombre);
//        }
//    }
    ///////////////////////////////////////////////////////////////////////////////
public Contacto buscarContacto(String valor) {
    return buscar(this.raiz, valor);
}

    private Contacto buscar(NodoContacto nodo, String valor) {
        if (nodo == null) {
            return null;
        }
        Contacto contacto = nodo.getContacto();
        if (valor.equals(contacto.getNombre()) || valor.equals(contacto.getTelefono().toString()) || valor.equals(contacto.getCorreoElectronico())) {
            return contacto;
        } else if (valor.compareTo(contacto.getNombre()) < 0) {
            return buscar(nodo.getIzdo(), valor);
        } else {
            return buscar(nodo.getDcho(), valor);
        }
    }
    ///////////////////////////////////////////////
    public void eliminarContacto(String nombre) {
        this.raiz = eliminar(this.raiz, nombre);
    }

    private NodoContacto eliminar(NodoContacto nodo, String nombre) {
        if (nodo == null) {
            return null;
        }
        if (nombre.compareTo(nodo.getContacto().getNombre()) < 0) {
            nodo.setIzdo(eliminar(nodo.getIzdo(), nombre));
        } else if (nombre.compareTo(nodo.getContacto().getNombre()) > 0) {
            nodo.setDcho(eliminar(nodo.getDcho(), nombre));
        } else {
            if (nodo.getIzdo() == null) {
                return nodo.getDcho();
            } else if (nodo.getDcho() == null) {
                return nodo.getIzdo();
            }
            NodoContacto temp = minValorNodo(nodo.getDcho());
            nodo.getContacto().setTelefono(temp.getContacto().getTelefono());
            nodo.getContacto().setNombre(temp.getContacto().getNombre());
            nodo.getContacto().setCorreoElectronico(temp.getContacto().getCorreoElectronico());
            nodo.getContacto().setFechaNacimiento(temp.getContacto().getFechaNacimiento());
            nodo.setDcho(eliminar(nodo.getDcho(), temp.getContacto().getNombre()));
        }
        return nodo;
    }

    private NodoContacto minValorNodo(NodoContacto nodo) {
        NodoContacto actual = nodo;
        while (actual.getIzdo() != null) {
            actual = actual.getIzdo();
        }
        return actual;
    }

    public void mostrarContactos() {
        inOrden(this.raiz);
    }

    private void inOrden(NodoContacto nodo) {
        if (nodo != null) {
            inOrden(nodo.getIzdo());
            System.out.println("Nombre: " + nodo.getContacto().getNombre() +
                    ", Teléfono: " + nodo.getContacto().getTelefono() +
                    ", Correo: " + nodo.getContacto().getCorreoElectronico() +
                    ", Fecha de Nacimiento: " + nodo.getContacto().getFechaNacimiento());
            inOrden(nodo.getDcho());
        }
    }

}
