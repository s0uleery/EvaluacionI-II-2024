package cl.ucn.main;

import cl.ucn.modelo.Asistente;
import cl.ucn.modelo.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ticketmaster");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        // Crear un nuevo evento y guardarlo en la BD
//        entityManager.getTransaction().begin();
//        Evento evento = new Evento("Concierto de Rock", "2024-12-15", "Estadio Nacional");
//        entityManager.persist(evento);
//        entityManager.getTransaction().commit();
//
//        // Crear asistentes
//        Asistente asistente1 = new Asistente("Juan Pérez", "juan@example.com");
//        Asistente asistente2 = new Asistente("María López", "maria@example.com");
//
//        // Agregar asistentes al evento
//        evento.agregarAsistente(asistente1);
//        evento.agregarAsistente(asistente2);
//
//        // Actualizar el evento
//        evento.actualizarEvento("Concierto de Pop", "2024-12-18", "Estadio Nacional");
//
//        entityManager.close();
//        entityManagerFactory.close();
    }
}
