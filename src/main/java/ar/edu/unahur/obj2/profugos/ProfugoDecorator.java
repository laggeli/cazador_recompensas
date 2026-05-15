package ar.edu.unahur.obj2.profugos;

public abstract class ProfugoDecorator implements IProfugo {
    protected IProfugo profugo;

    public ProfugoDecorator(IProfugo profugo) { this.profugo = profugo; }

    @Override
    public Integer getInocencia() { return profugo.getInocencia(); }

    @Override
    public Integer getHabilidad() { return profugo.getHabilidad(); }

    @Override
    public Boolean esNervioso() { return profugo.esNervioso(); }

    @Override
    public void reducirInocencia(Integer valor) { profugo.reducirInocencia(valor); }

    @Override
    public void reducirHabilidad(Integer valor) { profugo.reducirHabilidad(valor); }

    @Override
    public void volverseNervioso() { profugo.volverseNervioso(); }

    @Override
    public void dejarDeEstarNervioso() { profugo.dejarDeEstarNervioso(); }
}