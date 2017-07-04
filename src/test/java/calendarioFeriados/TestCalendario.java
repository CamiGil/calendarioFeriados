package calendarioFeriados;

import static org.junit.Assert.assertEquals;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import org.junit.Test;

public class TestCalendario {

	Configurador config = new Configurador();
	RepositorioFeriados repo = RepositorioFeriados.getInstance();

	@Test
	public void unLunesEsUnLunes() {
		LocalDate fecha = LocalDate.of(2017, 06, 26);
		assertEquals(DayOfWeek.MONDAY, fecha.getDayOfWeek());
	}

	@Test
	public void unDia26EsUn26() {
		LocalDate fecha = LocalDate.of(2017, 06, 26);
		assertEquals(26, fecha.getDayOfMonth());
	}

	@Test
	public void elMesDeJunioEsElMesDeJunio() {
		LocalDate fecha = LocalDate.of(2017, 06, 26);
		assertEquals(Month.JUNE, fecha.getMonth());
	}

	@Test
	public void el2017EsEl2017() {
		LocalDate fecha = LocalDate.of(2017, 06, 26);
		assertEquals(2017, fecha.getYear());
	}

//	@Test
//	public void el25DeMayoEsFeriado() {
//		
//		LocalDate desde = LocalDate.of(1810, 05, 25);
//		LocalDate hasta = LocalDate.of(3000, 05, 25);
//
//		config.agregarFeriado(25,05, desde, hasta);
//		
//		LocalDate fecha = LocalDate.of(2017, 05, 25);
//		assertEquals(true, repo.esFeriado(fecha));
//	}
	
	@Test
	public void el20DeEneroNoEsFeriado() {
		LocalDate fecha = LocalDate.of(2017, 01, 20);
		assertEquals(false, repo.esFeriado(fecha));
	}
	
	@Test
	public void losMartesNoSonFeriados() {
		LocalDate fecha = LocalDate.of(2017, 7, 11);
		assertEquals(false, repo.esFeriado(fecha));
	}
	
	@Test
	public void el5DeAgostoDe2015NoFueFeriado() {
		LocalDate fecha = LocalDate.of(2015, 8, 5);
		assertEquals(false, repo.esFeriado(fecha));
	}

	@Test
	public void el25DeMayoDe1980EsFeriado() {
		LocalDate fecha = LocalDate.of(1980, 05, 25);
		assertEquals(true, repo.esFeriado(fecha));
	}

	@Test
	public void todosLosLunesSonFeriadosHastaElInfinito() {
		
		DayOfWeek dia = DayOfWeek.MONDAY;
		LocalDate desde = LocalDate.of(1810, 05, 25);
		LocalDate hasta = LocalDate.of(9999, 05, 25);
		
		config.agregarFeriado(dia, desde, hasta);
		
		LocalDate fecha = LocalDate.of(2017, 07, 3);
		assertEquals(true, repo.esFeriado(fecha));
	}

	@Test
	public void el4DeJulioDe1900FueFeriado() {
		LocalDate fecha = LocalDate.of(1900, 07, 4);
		config.agregarFeriado(fecha);
		assertEquals(true, repo.esFeriado(fecha));
	}

	@Test
	public void agregoUnDiaDeLaSemanaParaQueSeaFeriadoYSeHaceFeriado() {
		
		DayOfWeek dia = DayOfWeek.SUNDAY;
		LocalDate desde = LocalDate.of(2010, 1, 1);
		LocalDate hasta = LocalDate.of(2019, 1, 1);
		
		config.agregarFeriado(dia,desde,hasta);
		LocalDate fecha = LocalDate.of(2017, 07, 2);
		assertEquals(true, repo.esFeriado(fecha));
	}

	@Test(expected = RuntimeException.class)
	public void agregoUnDiaDeLaSemanaRepetidoComoFeriadoYNoMeDeja() {
		DayOfWeek dia = DayOfWeek.SUNDAY;
		LocalDate desde = LocalDate.of(2010, 1, 1);
		LocalDate hasta = LocalDate.of(2019, 1, 1);
		
		config.agregarFeriado(dia,desde,hasta);
	}

	@Test
	public void agregoUnDiaParticularParaQueSeaFeriadoYSeHaceFeriado() {
		LocalDate fecha = LocalDate.of(1995, 07, 26);
		config.agregarFeriado(fecha);
		assertEquals(true, repo.esFeriado(fecha));
	}

	@Test(expected = RuntimeException.class)
	public void agregoUnDiaParticularRepetidoComoFeriadoYNoMeDeja() {
		LocalDate fecha = LocalDate.of(1995, 07, 26);
		config.agregarFeriado(fecha);
	}

	@Test
	public void agregoUnDiaDeUnMesParaQueSeaFeriadoYSeHaceFeriado() {
		
		LocalDate desde = LocalDate.of(2000, 1, 1);
		LocalDate hasta = LocalDate.of(3000, 1, 1);
		
		config.agregarFeriado(25,12,desde,hasta);
		LocalDate fecha = LocalDate.of(LocalDate.now().getYear(), 12, 25);
		assertEquals(true, repo.esFeriado(fecha));
	}

//	@Test(expected = RuntimeException.class)
//	public void agregoUnDiaDeUnMesRepetidoComoFeriadoYNoMeDeja() {
//		LocalDate desde = LocalDate.of(2000, 1, 1);
//		LocalDate hasta = LocalDate.of(3000, 1, 1);
//		
//		config.agregarFeriado(25,12,desde,hasta);
//	}
	

	public void agregoLosJuevesComoFeriadosDesde1DeEneroDe2015A1DeEneroDe2016() {
		LocalDate fecha = LocalDate.of(2015, 1, 8);
		LocalDate desde = LocalDate.of(2015, 1, 1);
		LocalDate hasta = LocalDate.of(2016, 1, 1);
		config.agregarFeriado(DayOfWeek.THURSDAY,desde,hasta);
		assertEquals(true, repo.esFeriado(fecha));
	}
	
	

}
