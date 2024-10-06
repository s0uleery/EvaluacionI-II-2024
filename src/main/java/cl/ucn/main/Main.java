package cl.ucn.main;

import cl.ucn.modelo.Asistente;
import cl.ucn.modelo.Evento;
import jakarta.persistence.*;
import com.jcabi.log.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.ArrayList;
import java.util.List;


public class Main {

    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("ticketmaster");

    private static final org.apache.logging.log4j.Logger fileLogger =
            LogManager.getLogger(" ");

    public static void main(String[] args) {


        // Cargamos los datos a nuestra base de datos
        EntityManager em = entityManagerFactory.createEntityManager();

        // ********* Eliminar un Evento para un Asistente ************
        // ***********************************************************

        // Obtenemos las informaciones del asistente 217638392
        em.getTransaction().begin();
        long rut = 217638392;
        Asistente asistente = em.find(Asistente.class, rut);
        Logger.info(Main.class,"El asistente " + asistente.getNombre() + " con email " + asistente.getEmail());
        Logger.info(Main.class, "Asiste a los siguientes eventos:");
        List<Evento> eventoAsiste = asistente.getEventos();
        for (Evento evento : eventoAsiste) {
            Logger.info(Main.class, evento.getNombre());
        }
        Logger.info(Main.class, "Actualiza eliminando el festival de jazz del asistente");
        Evento eventoRemueve = em.find(Evento.class, 3);
        asistente.getEventos().remove(eventoRemueve);
        eventoRemueve.getAsistentes().remove(asistente);
        em.merge(asistente);
        Logger.info(Main.class, "Ahora solo asistirá a: ");
        for (Evento evento : eventoAsiste) {
            Logger.info(Main.class, evento.getNombre());
        }
        em.getTransaction().commit();
        // ***********************************************************

        // ***************** Ingresa un nuevo Evento *****************
        // ***********************************************************
        int ultimoEvento = 0;
        Query query = em.createNativeQuery("select max(id) from Evento");
        try {
            ultimoEvento = (int) query.getSingleResult();
        }catch (NoResultException e){
            Logger.info(Main.class, "No existen resultados");
        }

        int id = ultimoEvento+1;
        em.getTransaction().begin();
        Evento evento = new Evento();
        evento.setId(id);
        evento.setFecha("2024-10-25");
        evento.setNombre("Alice in Chains");
        evento.setLugar("Parque Ohiggins");
        em.persist(evento);
        em.getTransaction().commit();
        Logger.info(Main.class, "Se ha ingresado el evento N° " + evento.getId() + " Nombre: " + evento.getNombre());
        // ***********************************************************

        // ************* Asociar un Evento con Asistente *************
        // ***********************************************************
        em.getTransaction().begin();
        rut = 64389216;
        asistente = em.find(Asistente.class, rut);
        Evento evento2 = em.find(Evento.class, 4);
        asistente.getEventos().add(evento2);
        evento2.setAsistentes(new ArrayList<>());
        evento2.getAsistentes().add(asistente);
        em.merge(asistente);
        em.getTransaction().commit();
        Logger.info(Main.class, "Se ha asociado el evento N° " + evento2.getId() + " con " + asistente.getNombre());
        // ***********************************************************

        // ******************* Actualizar un evento ******************
        // ***********************************************************
        em.getTransaction().begin();
        id = 1;
        evento2 = em.find(Evento.class, id);
        evento2.setLugar("Estadio Santa Laura");
        em.merge(evento2);
        em.getTransaction().commit();
        // ***********************************************************

        fileLogger.info("******************************* RESUMEN ******************************* ");
        List<Asistente> asistentes  = em.createQuery("from Asistente a", Asistente.class).getResultList();
        for (Asistente asistente2 : asistentes) {
            fileLogger.info("{} , {} , {}", asistente2.getRut(), asistente2.getNombre(), asistente2.getEmail());
            for (Evento evento1 : asistente2.getEventos()) {
                fileLogger.info("  ->  {} , {} , {} , {}", evento1.getId(), evento1.getNombre(), evento1.getFecha(), evento1.getLugar());
            }
        }
        em.close();
    }
}
