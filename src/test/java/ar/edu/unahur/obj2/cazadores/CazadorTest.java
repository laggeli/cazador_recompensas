package ar.edu.unahur.obj2.cazadores;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.profugos.*;
import ar.edu.unahur.obj2.zona.Zona;

public class CazadorTest {
    private Cazador urbano;
    private Cazador rural;
    private Cazador sigiloso;
    private Zona zona;

    @BeforeEach
    void setUp() {
        urbano = new CazadorUrbano();
        rural = new CazadorRural();
        sigiloso = new CazadorSigiloso();
        zona = new Zona("La Rural");
    }

    @Test
    void dadoUnCazadorRural_cuandoNoLograCapturar_entoncesSeCompruebaQueElProfugoPerdioDosNivelesDeInocencia() {
        IProfugo profugo1 = new ProfugoEntrenamientoElite(new ProfugoComun(5, 10, false));
        
        zona.agregarProfugo(profugo1);
        rural.capturar(zona);

        assertEquals(3, profugo1.getInocencia());
    }

    @Test
    void dadoUnCazadorRural_cuandoNoLograCapturar_entoncesSeCompruebaQueElProfugoAhoraEsNervioso() {
        IProfugo profugo1 = new ProfugoProteccionLegal(new ProfugoComun(5, 10, false));
        
        zona.agregarProfugo(profugo1);
        rural.capturar(zona);

        assertEquals(Boolean.TRUE, profugo1.esNervioso());
    }

    @Test
    void dadoUnCazadorRural_cuandoIntentaCapturarAlProfugo_entoncesLoCapturaPorqueElProfugoEsNervioso() {
        IProfugo profugo1 = new ProfugoProteccionLegal(new ProfugoComun(45, 10, true));

        rural.setExperiencia(60.0);

        assertTrue(rural.puedeCapturar(profugo1));
    }

    @Test
    void dadoUnCazadorSigiloso_cuandoIntentaCapturarAlProfugo_entoncesNoLoCapturaPorqueNoEsSuperiorSuNivelDeExperiencia() {
        IProfugo profugo1 = new ProfugoProteccionLegal(new ProfugoComun(45, 10, true));

        sigiloso.setExperiencia(30.0);

        assertFalse(sigiloso.puedeCapturar(profugo1));
    }

    @Test
    void dadoUnCazadorUrbano_cuandoIntentaCapturarAlProfugo_entoncesNoLoCapturaPorqueElProfugoEsNervioso() {
        IProfugo profugo1 = new ProfugoProteccionLegal(new ProfugoComun(45, 10, true));

        urbano.setExperiencia(78.0);

        assertFalse(urbano.puedeCapturar(profugo1));
    }

    @Test
    void dadoUnCazadorSigiloso_cuandoIntimidaAUnProfugoConEvolucion_entoncesElProfugoPierde2DeInocencia() {
        IProfugo profugo = new ProfugoArtesMarciales(new ProfugoProteccionLegal(new ProfugoComun(42, 10, true)));
        
        sigiloso.intimidar(profugo);

        assertEquals(40, profugo.getInocencia());
    } 

    @Test
    void dadoUnCazadorSigiloso_cuandoIntimidaAUnProfugoConEvolucion_entoncesElProfugoPierde5DeHabilidad() {
        IProfugo profugo = new ProfugoEntrenamientoElite(new ProfugoComun(30, 10, false));
        
        sigiloso.intimidar(profugo);

        assertEquals(5, profugo.getHabilidad());
    } 
}