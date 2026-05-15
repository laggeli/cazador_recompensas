package ar.edu.unahur.obj2.profugos;

public class ProfugoProteccionLegal extends ProfugoDecorator {
    public ProfugoProteccionLegal(IProfugo profugo) { super(profugo); }

    @Override
    public Integer getInocencia() { return Math.max(40, profugo.getInocencia()); }
}