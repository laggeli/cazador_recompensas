package ar.edu.unahur.obj2.cazadores;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.profugos.IProfugo;
import ar.edu.unahur.obj2.zona.Zona;

public abstract class Cazador {
    private Double experiencia = 0.0;
    private List<IProfugo> capturados = new ArrayList<>();

    public void capturar(Zona zona) {
        List<IProfugo> capturadosDeLaZona = new ArrayList<>();
        List<IProfugo> intimidados = new ArrayList<>();

        for (IProfugo profugo : zona.getProfugos()) {
            if (puedeCapturar(profugo)) {
                capturadosDeLaZona.add(profugo);
                capturados.add(profugo);
            } else {
                intimidar(profugo);
                intimidados.add(profugo);
            }
        }

        zona.getProfugos().removeAll(capturadosDeLaZona);
        sumarExperiencia(intimidados, capturadosDeLaZona);
    }

    public Boolean puedeCapturar(IProfugo profugo) { return experiencia > profugo.getInocencia() && condicionCaptura(profugo); }

    public void intimidar(IProfugo profugo) {
        profugo.reducirInocencia(2);
        consecuenciaIntidimacion(profugo);
    }

    public abstract Boolean condicionCaptura(IProfugo profugo);

    public abstract void consecuenciaIntidimacion(IProfugo profugo);

    public void sumarExperiencia(List<IProfugo> intimados, List<IProfugo> capturados) {
        Integer minimoHabilidad = intimados.stream().mapToInt(IProfugo::getHabilidad).min().orElse(0);
        Integer profugosCapturados = capturados.size();
    
        experiencia += minimoHabilidad + (2 * profugosCapturados);
    }

    public List<IProfugo> getCapturados() { return capturados; }

    public Integer getCantidadDeCapturados() { return capturados.size(); }

    public void setExperiencia(Double experiencia) { this.experiencia = experiencia; }
}