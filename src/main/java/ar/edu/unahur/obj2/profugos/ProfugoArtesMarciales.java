package ar.edu.unahur.obj2.profugos;

public class ProfugoArtesMarciales extends ProfugoDecorator {
    public ProfugoArtesMarciales(IProfugo profugo) { super(profugo); }

    @Override
    public Integer getHabilidad() { return Math.min(100, profugo.getHabilidad() * 2); }
}