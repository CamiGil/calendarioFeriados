package calendarioFeriados;

import static org.junit.Assert.assertEquals;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

public class TestCalendario {

	@Test
	public void unLunesEsUnLunes() {
		LocalDate fecha = LocalDate.of(2017,06,26);
		assertEquals(DayOfWeek.MONDAY, fecha.getDayOfWeek());
	}
	
	@Test
	public void unDia26EsUn26() {
		LocalDate fecha = LocalDate.of(2017,06,26);
		assertEquals(26, fecha.getDayOfMonth());
	}
	
	@Test
	public void elMesDeJunioEsElMesDeJunio() {
		LocalDate fecha = LocalDate.of(2017,06,26);
		assertEquals(Month.JUNE, fecha.getMonth());
	}
	
	@Test
	public void el2017EsEl2017() {
		LocalDate fecha = LocalDate.of(2017,06,26);
		assertEquals(2017, fecha.getYear());
	}
	
	@Test
	public void el25DeMayoEsFeriado() {
		LocalDate fecha = LocalDate.of(LocalDate.now().getYear(),05,25);
		assertEquals(true, FechaFeriado.esFeriado(fecha));
	}
	
	@Test
	public void todosLosLunesSonFeriados() {
		LocalDate fecha = LocalDate.of(2017,07,3);
		assertEquals(true, FechaFeriado.esFeriado(fecha));
	}
		
	@Test
	public void el4DeJulioDe1900FueFeriado() {
		LocalDate fecha = LocalDate.of(1900,07,4);
		assertEquals(true, FechaFeriado.esFeriado(fecha));
	}
	
}
