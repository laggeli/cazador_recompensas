package ar.edu.unahur.obj2.reporteria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.cazadores.*;
import ar.edu.unahur.obj2.profugos.*;
import ar.edu.unahur.obj2.zona.Zona;

public class ReporteriaTest {
    private Reporteria reporteria;
    private Cazador urbano;
    private Cazador rural;
    private Cazador sigiloso;
    private Zona zona;

    @BeforeEach
    void setUp() {
        reporteria = Reporteria.getInstance();
        reporteria.limpiar();
        
        urbano = new CazadorUrbano();
        rural = new CazadorRural();
        sigiloso = new CazadorSigiloso();
        zona = new Zona("La Rural");

        reporteria.agregarCazador(urbano);
        reporteria.agregarCazador(rural);
        reporteria.agregarCazador(sigiloso);
    }

    @Test
    void dadoUnaReporteria_cuandoLosCazadoresCapturanEnUnaZona_entoncesSeCompruebaQueElCazadorConMasCapturasEsElUrbano() {
        IProfugo profugo1 = new ProfugoArtesMarciales(new ProfugoComun(5, 10, true));
        IProfugo profugo2 = new ProfugoEntrenamientoElite(new ProfugoComun(5, 15, false));
        
        zona.agregarProfugo(profugo1);
        zona.agregarProfugo(profugo2);
        urbano.capturar(zona);

        assertEquals(urbano, reporteria.getCazadorConMasCapturas());
    }

    @Test
    void dadoUnaReporteria_cuandoElCazadorCapturaProfugos_entoncesSeCompruebaQueElProfugoMasHabilEsEl2() {
        IProfugo profugo1 = new ProfugoEntrenamientoElite(new ProfugoComun(5, 10, false));
        IProfugo profugo2 = new ProfugoEntrenamientoElite(new ProfugoComun(5, 15, false));
        
        zona.agregarProfugo(profugo1);
        zona.agregarProfugo(profugo2);
        urbano.setExperiencia(20.0);
        urbano.capturar(zona);

        assertEquals(profugo2, reporteria.getProfugoMasHabil());
    }

    @Test
    void dadoUnaReporteria_cuandoLosCazadoresLogranCapturar_entoncesDevuelveUnaListaConLosCapturados() {
        IProfugo profugo1 = new ProfugoEntrenamientoElite(new ProfugoComun(5, 10, false));
        IProfugo profugo2 = new ProfugoEntrenamientoElite(new ProfugoComun(5, 15, false));
        
        zona.agregarProfugo(profugo1);
        zona.agregarProfugo(profugo2);
        urbano.setExperiencia(20.0);
        urbano.capturar(zona);

        assertEquals(List.of(profugo1, profugo2), reporteria.todosLosCapturados());
    }

    @Test
    void dadoUnaReporteria_cuandoLosCazadoresNoLogranCapturarANadie_entoncesDevuelveUnaListaVacia() {
        IProfugo profugo1 = new ProfugoEntrenamientoElite(new ProfugoComun(5, 10, false));
        IProfugo profugo2 = new ProfugoEntrenamientoElite(new ProfugoComun(5, 15, false));
        
        zona.agregarProfugo(profugo1);
        zona.agregarProfugo(profugo2);
        rural.capturar(zona);

        assertTrue(reporteria.todosLosCapturados().isEmpty());
    }
}