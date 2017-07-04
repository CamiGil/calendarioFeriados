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
		config.agregarFeriado(fecha);
		assertEquals(true, repo.esFeriado(fecha));
	}

	@Test
	public void todosLosLunesSonFeriadosHastaElInfinito() {

		DayOfWeek dia = DayOfWeek.MONDAY;

		config.agregarFeriado(dia);

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

		config.agregarFeriado(dia, desde, hasta);
		LocalDate fecha = LocalDate.of(2017, 07, 2);
		assertEquals(true, repo.esFeriado(fecha));
	}

	@Test
	public void esteDiaDeLaSemanaNoDeberiaSerFeriadoYNoLoEs() {

		LocalDate fecha = LocalDate.of(2017, 07, 11);
		assertEquals(false, repo.esFeriado(fecha));
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
		config.agregarFeriado(fecha);
	}

	@Test(expected = RuntimeException.class)
	public void el1DeDiciembreYaExistiaComoFeriadoYNoMeDejaGuardarlo() {
		LocalDate desde = LocalDate.of(2000, 1, 1);
		LocalDate hasta = LocalDate.of(3000, 1, 1);

		config.agregarFeriado(1, 12, desde, hasta);
		config.agregarFeriado(1, 12, desde, hasta);
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void noPuedoHacerEl1del13Feriado() {
		LocalDate desde = LocalDate.of(2000, 1, 1);
		LocalDate hasta = LocalDate.of(3000, 1, 1);

		config.agregarFeriado(1, 13, desde, hasta);
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void noPuedoHacerEl32del1Feriado() {
		LocalDate desde = LocalDate.of(2000, 1, 1);
		LocalDate hasta = LocalDate.of(3000, 1, 1);

		config.agregarFeriado(32, 1, desde, hasta);
	}

	@Test
	public void agregoUnDiaDeUnMesParaQueSeaFeriadoYSeHaceFeriado() {
		LocalDate desde = LocalDate.of(2000, 1, 1);
		LocalDate hasta = LocalDate.of(3000, 1, 1);

		config.agregarFeriado(16, 12, desde, hasta);
		LocalDate fecha = LocalDate.of(LocalDate.now().getYear(), 12, 16);
		assertEquals(true, repo.esFeriado(fecha));
	}

	@Test
	public void unFeriadoDespuesDeSuPeriodoDeValidezYaNoEsFeriado() {

		LocalDate desde = LocalDate.of(2000, 1, 1);
		LocalDate hasta = LocalDate.of(3000, 1, 1);

		config.agregarFeriado(13, 12, desde, hasta);
		LocalDate fecha = LocalDate.of(3090, 12, 25);
		assertEquals(false, repo.esFeriado(fecha));
	}

	@Test(expected = RuntimeException.class)
	public void elPeriodoDeValidezNoPuedeSerElMismoDia() {
		// 25/12
		LocalDate desde = LocalDate.of(3000, 1, 1);
		LocalDate hasta = LocalDate.of(3000, 1, 1);

		config.agregarFeriado(25, 12, desde, hasta);
	}

	@Test(expected = RuntimeException.class)
	public void elPeriodoDeValidezNoPuedeTerminarAntesDeEmpezar() {
		// 25/12
		LocalDate desde = LocalDate.of(4000, 1, 1);
		LocalDate hasta = LocalDate.of(3000, 1, 1);

		config.agregarFeriado(25, 12, desde, hasta);
	}

	@Test
	public void agregoLosJuevesComoFeriadosEnUnPeriodoYEsFeriadoEnEsePeriodo() {
		LocalDate fecha = LocalDate.of(2015, 1, 8);
		LocalDate desde = LocalDate.of(2015, 1, 1);
		LocalDate hasta = LocalDate.of(2016, 1, 1);
		config.agregarFeriado(DayOfWeek.THURSDAY, desde, hasta);
		assertEquals(
				true,
				repo.esFeriado(fecha)
						&& repo.esFeriado(LocalDate.of(2015, 1, 15))
						&& repo.esFeriado(LocalDate.of(2015, 7, 6)));
	}

	@Test
	public void agregoMuchosFeriadosYSonFeriados() {
		LocalDate fecha = LocalDate.of(1996, 1, 8);
		LocalDate desde = LocalDate.of(2015, 1, 1);
		LocalDate hasta = LocalDate.of(2333, 1, 1);

		config.agregarFeriado(fecha);
		config.agregarFeriado(DayOfWeek.THURSDAY, desde, hasta);
		config.agregarFeriado(2, 2, desde, hasta);

		assertEquals(
				true,
				repo.esFeriado(fecha)
						&& repo.esFeriado(LocalDate.of(2017, 2, 2))
						&& repo.esFeriado(LocalDate.of(2017, 7, 6)));
	}

	@Test
	public void diaMesFeriadoSinVencimiento() {
		config.agregarFeriado(3, 3);

		assertEquals(
				true,
				repo.esFeriado(LocalDate.of(1000, 3, 3))
						&& repo.esFeriado(LocalDate.of(2017, 3, 3))
						&& repo.esFeriado(LocalDate.of(3000, 3, 3)));
	}

	@Test
	public void agregoMuchosFeriadosYOtrasFechasNoSonFeriados() {
		LocalDate fecha = LocalDate.of(2015, 1, 8);
		LocalDate desde = LocalDate.of(2015, 1, 1);
		LocalDate hasta = LocalDate.of(3000, 1, 1);

		config.agregarFeriado(fecha);
		config.agregarFeriado(DayOfWeek.THURSDAY, desde, hasta);
		config.agregarFeriado(2, 2, desde, hasta);

		assertEquals(
				false,
				repo.esFeriado(LocalDate.of(2017, 8, 1))
						&& repo.esFeriado(LocalDate.of(2017, 2, 1))
						&& repo.esFeriado(LocalDate.of(2017, 7, 7)));
	}

	@Test(expected = java.time.DateTimeException.class)
	public void anioBisiestoFeriadoEnAnioNoBisiesto() {

		assertEquals(false, repo.esFeriado(LocalDate.of(2017, 2, 29)));
	}

	@Test
	public void anioBisiestoFeriadoEnAnioBisiesto() {

		LocalDate desde = LocalDate.of(1000, 1, 1);
		LocalDate hasta = LocalDate.of(3000, 1, 1);

		config.agregarFeriado(29, 2, desde, hasta);

		assertEquals(true, repo.esFeriado(LocalDate.of(2016, 2, 29)));
	}

}
