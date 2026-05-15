package ar.edu.unahur.obj2.reporteria;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ar.edu.unahur.obj2.cazadores.Cazador;
import ar.edu.unahur.obj2.profugos.IProfugo;

public class Reporteria {
    private static Reporteria instance;
    private List<Cazador> cazadores = new ArrayList<>();
    private Reporteria() {}

    public static Reporteria getInstance() {
        if (instance == null) { instance = new Reporteria(); }
        return instance;
    }

    public void agregarCazador(Cazador cazador) { cazadores.add(cazador); }

    public List<IProfugo> todosLosCapturados() { return cazadores.stream().flatMap(c -> c.getCapturados().stream()).toList(); }

    public IProfugo getProfugoMasHabil() { return todosLosCapturados().stream().max(Comparator.comparing(IProfugo::getHabilidad)).orElseThrow(); }

    public Cazador getCazadorConMasCapturas() { return cazadores.stream().max(Comparator.comparing(Cazador::getCantidadDeCapturados)).orElseThrow(); }

    public void limpiar() { cazadores.clear(); }
}