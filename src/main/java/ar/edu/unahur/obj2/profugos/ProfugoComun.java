package ar.edu.unahur.obj2.profugos;

import ar.edu.unahur.obj2.excepciones.ValidarAtributoException;

public class ProfugoComun implements IProfugo {
    private Integer inocencia;
    private Integer habilidad;
    private Boolean nervioso;

    public ProfugoComun(Integer inocencia, Integer habilidad, Boolean nervioso) {
        this.inocencia = validarInocencia(inocencia);
        this.habilidad = validarHabilidad(habilidad);
        this.nervioso = nervioso;
    }

    private Integer validarHabilidad(Integer habilidad) { 
        if (habilidad < 1 || habilidad > 100) { throw new ValidarAtributoException("La habilidad debe estar entre 1 y 100"); } 
        else { return habilidad; }
    }

    private Integer validarInocencia(Integer inocencia) { 
        if (inocencia < 1 || inocencia > 100) { throw new ValidarAtributoException("La inocencia no puede ser negativa"); } 
        else { return inocencia; }
    }

    @Override
    public Integer getInocencia() { return inocencia; }

    @Override
    public Integer getHabilidad() { return habilidad; }

    @Override
    public Boolean esNervioso() { return nervioso; }

    @Override
    public void reducirInocencia(Integer valor) { inocencia = Math.max(0, inocencia - valor); }

    @Override
    public void reducirHabilidad(Integer valor) { habilidad = Math.max(0, habilidad - valor); }

    @Override
    public void volverseNervioso() { nervioso = true; }

    @Override
    public void dejarDeEstarNervioso() { nervioso = false; }
}