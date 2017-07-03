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

	@Test
	public void el25DeMayoDe2017EsFeriado() {
		LocalDate fecha = LocalDate.of(2017, 05, 25);
		DiaSinAnio futuroFeriado = new DiaSinAnio();
		futuroFeriado.setDiaSinAnio(fecha);
		config.agregarFeriado(futuroFeriado);
		assertEquals(true, repo.esFeriado(fecha));
	}
	
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
	public void todosLosLunesSonFeriados() {
		config.agregarFeriado(DayOfWeek.MONDAY);
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
		config.agregarFeriado(DayOfWeek.SUNDAY);
		LocalDate fecha = LocalDate.of(2017, 07, 2);
		assertEquals(true, repo.esFeriado(fecha));
	}

	@Test(expected = RuntimeException.class)
	public void agregoUnDiaDeLaSemanaRepetidoComoFeriadoYNoMeDeja() {
		config.agregarFeriado(DayOfWeek.SUNDAY);
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
		DiaSinAnio futuroFeriado = new DiaSinAnio();
		futuroFeriado.setDia(25);
		futuroFeriado.setMes(12);
		config.agregarFeriado(futuroFeriado);
		LocalDate fecha = LocalDate.of(LocalDate.now().getYear(), 12, 25);
		assertEquals(true, repo.esFeriado(fecha));
	}

	@Test(expected = RuntimeException.class)
	public void agregoUnDiaDeUnMesRepetidoComoFeriadoYNoMeDeja() {
		LocalDate fecha = LocalDate.of(1995, 07, 26);
		config.agregarFeriado(fecha);
	}

}
