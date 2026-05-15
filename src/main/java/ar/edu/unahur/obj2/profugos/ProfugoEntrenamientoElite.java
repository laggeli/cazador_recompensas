package ar.edu.unahur.obj2.profugos;

public class ProfugoEntrenamientoElite extends ProfugoDecorator {
    public ProfugoEntrenamientoElite(IProfugo profugo) { super(profugo); }

    @Override
    public Boolean esNervioso() { return false; }
}