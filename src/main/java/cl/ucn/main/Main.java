package cl.ucn.main;

import cl.ucn.modelo.Asistente;
import cl.ucn.modelo.Evento;
import jakarta.persistence.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class Main {

    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("ticketmaster");

    protected static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {


        // Cargamos los datos a nuestra base de datos
        EntityManager em = entityManagerFactory.createEntityManager();

        // Se realizará un cambio de evento para un asistente.
        // Obtenemos las informaciones del asistente juan.perez@ucn.cl
        Asistente asistente = null;
        String email = "juan.perez@ucn.cl";
        String jpql = "SELECT u from Asistente u WHERE u.email = :email";
        TypedQuery<Asistente> query = em.createQuery(jpql, Asistente.class);
        query.setParameter("email", email);
        try {
            asistente = query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
        }
        finally {
            em.close();
        }

        logger.info("Hello World!");



//
//        // Actualizar el evento
//        evento.actualizarEvento("Concierto de Pop", "2024-12-18", "Estadio Nacional");
//
//        entityManager.close();
//        entityManagerFactory.close();
    }
}
