package cl.ucn.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Asistente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;

    @ManyToMany(mappedBy = "asistentes")
    List<Evento> eventos;



    public void notificarCambio(Evento evento) {
        System.out.println("Notificación: El evento " + evento.getNombre() +
                " ha sido actualizado. Nueva fecha: " + evento.getFecha());
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}