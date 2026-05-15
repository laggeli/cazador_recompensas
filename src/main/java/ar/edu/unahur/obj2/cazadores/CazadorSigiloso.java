package ar.edu.unahur.obj2.cazadores;

import ar.edu.unahur.obj2.profugos.IProfugo;

public class CazadorSigiloso extends Cazador {
    @Override
    public Boolean condicionCaptura(IProfugo profugo) { return profugo.getHabilidad() < 50; }

    @Override
    public void consecuenciaIntidimacion(IProfugo profugo) { profugo.reducirHabilidad(5); }
}