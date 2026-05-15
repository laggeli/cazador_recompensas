package ar.edu.unahur.obj2.zona;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.profugos.IProfugo;

public class Zona {
    private String nombre;
    private List<IProfugo> profugos = new ArrayList<>();

    public Zona(String nombre) { this.nombre = nombre; }

    public void agregarProfugo(IProfugo profugo) { profugos.add(profugo); }

    public String getNombre() { return nombre; }

    public List<IProfugo> getProfugos() { return profugos; }
}