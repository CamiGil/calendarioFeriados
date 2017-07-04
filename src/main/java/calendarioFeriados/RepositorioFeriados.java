package calendarioFeriados;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepositorioFeriados implements Repositorio {

	// ATRIBUTOS //

	private static RepositorioFeriados instance = null;

	List<DiaSemanaEnPeriodo> diaSemanaFeriadoEnPeriodo = new ArrayList<DiaSemanaEnPeriodo>();
	List<DiaSemana> diaSemanaFeriado = new ArrayList<DiaSemana>();
	List<DiaSinAnioEnPeriodo> diaDelMesFeriadoEnPeriodo = new ArrayList<DiaSinAnioEnPeriodo>();
	List<DiaSinAnio> diaDelMesFeriado = new ArrayList<DiaSinAnio>();
	List<LocalDate> diaParticularDeUnAnioFeriado = new ArrayList<LocalDate>();

	// METODOS //

	protected RepositorioFeriados() {
	}

	public static RepositorioFeriados getInstance() {
		if (instance == null) {
			instance = new RepositorioFeriados();
		}
		return instance;
	}

	public boolean esteDiaDeLaSemanaEsFeriadoEnPeriodo(LocalDate fecha) {
		return diaSemanaFeriadoEnPeriodo.stream().anyMatch(
				dia -> dia.getDia().equals(fecha.getDayOfWeek())
						&& dia.getDesde().isBefore(fecha)
						&& dia.getHasta().isAfter(fecha));
	}

	public boolean esteDiaDeLaSemanaEsFeriado(LocalDate fecha) {
		return diaSemanaFeriado.stream().anyMatch(
				dia -> dia.getDia().equals(fecha.getDayOfWeek()));
	}

	public boolean esteDiaDelMesEsFeriadoEnPeriodo(LocalDate fecha) {

		int dia = fecha.getDayOfMonth();
		int mes = fecha.getMonthValue();

		return diaDelMesFeriadoEnPeriodo.stream().anyMatch(
				diaDelMes -> diaDelMes.getDia() == dia
						&& diaDelMes.getMes() == mes
						&& diaDelMes.getDesde().isBefore(fecha)
						&& diaDelMes.getHasta().isAfter(fecha));
	}

	public boolean esteDiaDelMesEsFeriado(LocalDate fecha) {

		int dia = fecha.getDayOfMonth();
		int mes = fecha.getMonthValue();

		return diaDelMesFeriado.stream().anyMatch(
				diaDelMes -> diaDelMes.getDia() == dia
						&& diaDelMes.getMes() == mes);
	}

	public boolean esteDiaParticularEsFeriado(LocalDate fecha) {
		return diaParticularDeUnAnioFeriado.stream().anyMatch(
				feriado -> feriado.equals(fecha));
	}

	public boolean esFeriado(LocalDate fecha) {

		boolean diaSemanaFeriadoEnPeriodo = this
				.esteDiaDeLaSemanaEsFeriadoEnPeriodo(fecha);
		boolean diaDelMesFeriado = this.esteDiaDelMesEsFeriado(fecha);
		boolean diaParticular = this.esteDiaParticularEsFeriado(fecha);
		boolean diaDelMesFeriadoEnPeriodo = this
				.esteDiaDelMesEsFeriadoEnPeriodo(fecha);
		boolean diaSemanaFeriado = this.esteDiaDeLaSemanaEsFeriado(fecha);

		return diaSemanaFeriadoEnPeriodo || diaDelMesFeriado || diaParticular
				|| diaDelMesFeriadoEnPeriodo || diaSemanaFeriado;
	}

	public boolean yaExisteEsteDiaDeLaSemanaFeriadoEnEsePeriodo(
			DiaSemanaEnPeriodo diaAAgregar) {
		return diaSemanaFeriadoEnPeriodo.stream().anyMatch(
				combo -> combo.getDia().equals(diaAAgregar)
						&& combo.getDesde().equals(diaAAgregar.getDesde())
						&& combo.getHasta().equals(diaAAgregar.getHasta()));
	}

	public boolean yaExisteEsteDiaDeEsteMesFeriadoEnEsePeriodo(
			DiaSinAnioEnPeriodo fechaAAgregar) {
		return diaDelMesFeriadoEnPeriodo.stream().anyMatch(
				combo -> combo.getDia() == fechaAAgregar.getDia()
						&& combo.getMes() == fechaAAgregar.getMes()
						&& combo.getDesde().equals(fechaAAgregar.getDesde())
						&& combo.getHasta().equals(fechaAAgregar.getHasta()));
	}

	public boolean yaExisteEsteDiaDeEsteMesFeriado(DiaSinAnio diaAAgregar) {
		return diaDelMesFeriado.stream().anyMatch(
				diaMes -> diaMes.getDia() == diaAAgregar.getDia()
						&& diaMes.getMes() == diaAAgregar.getMes());
	}

	public boolean yaExisteEsteDiaDeLaSemanaFeriado(DiaSemana diaAAgregar) {
		return diaSemanaFeriadoEnPeriodo.stream().anyMatch(
				dia -> dia.getDia().equals(diaAAgregar));
	}

}
