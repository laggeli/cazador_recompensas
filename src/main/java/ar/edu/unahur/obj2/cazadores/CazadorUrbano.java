package ar.edu.unahur.obj2.cazadores;

import ar.edu.unahur.obj2.profugos.IProfugo;

public class CazadorUrbano extends Cazador {
    @Override
    public Boolean condicionCaptura(IProfugo profugo) { return !profugo.esNervioso(); }

    @Override
    public void consecuenciaIntidimacion(IProfugo profugo) { profugo.dejarDeEstarNervioso(); }
}