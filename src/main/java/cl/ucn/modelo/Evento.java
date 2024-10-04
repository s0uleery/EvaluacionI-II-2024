package cl.ucn.modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String fecha;
    private String lugar;

    @ManyToMany
    @JoinTable(
            name = "evento_asistente",
            joinColumns = @JoinColumn(name = "id_evento"),
            inverseJoinColumns = @JoinColumn(name = "id_asistente"))
    private List<Asistente> asistentes;


    public void actualizarEvento(String nuevoNombre, String nuevaFecha, String nuevoLugar) {
        this.nombre = nuevoNombre;
        this.fecha = nuevaFecha;
        this.lugar = nuevoLugar;

        for (Asistente asistente : asistentes) {
            asistente.notificarCambio(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public List<Asistente> getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(List<Asistente> asistentes) {
        this.asistentes = asistentes;
    }

    public void agregarAsistente(Asistente asistente) {
        asistentes.add(asistente);
    }

}
