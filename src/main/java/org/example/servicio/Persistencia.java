package org.example.servicio;

import org.example.Modelo.NodoContacto;

import java.io.*;

public class Persistencia {
    private  static final String ARCHIVO_DATOS = "C:\\Users\\Praxe\\IdeaProjects\\AgendaTree\\agenda.dat";

    public static void guardarAgenda(Agenda agenda){
        try{
            NodoContacto c = agenda.getRaiz();

            FileOutputStream fileOut =new FileOutputStream(ARCHIVO_DATOS);
            ObjectOutputStream Out = new ObjectOutputStream(fileOut);
            Out.writeObject(agenda.getRaiz());
            Out.close();
            fileOut.close();
            System.out.println("agenda guardada en el archivo"+ARCHIVO_DATOS);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static Agenda cargarAgenda(){
        Agenda agenda = new Agenda();
        try{
            FileInputStream fileIn = new FileInputStream(ARCHIVO_DATOS);
            ObjectInputStream in =new ObjectInputStream(fileIn);
            NodoContacto raiz = (NodoContacto) in.readObject();
            agenda.setRaiz(raiz);
            in.close();
            fileIn.close();
            System.out.println("agenda cargada desde el archivo"+ARCHIVO_DATOS);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return agenda;
    }
}

