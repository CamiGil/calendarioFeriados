package calendarioFeriados;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepositorioFeriados implements Repositorio {

	// ATRIBUTOS //

	private static RepositorioFeriados instance = null;

	List<DiaSemanaFeriado> diaSemanaFeriado = new ArrayList<DiaSemanaFeriado>();
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

	public boolean esteDiaDeLaSemanaEsFeriado(LocalDate fecha) {
		return diaSemanaFeriado.stream().anyMatch(
				dia -> dia.getDia().equals(fecha.getDayOfWeek())
						&& dia.getDesde().isBefore(fecha)
						&& dia.getHasta().isAfter(fecha));
	}

	public boolean esteDiaDelMesEsFeriado(LocalDate fecha) {

		int dia = fecha.getDayOfMonth();
		int mes = fecha.getMonthValue();

		return diaDelMesFeriado.stream().anyMatch(
				diaDelMes -> diaDelMes.getDia() == dia
						&& diaDelMes.getMes() == mes
						&& diaDelMes.getDesde().isBefore(fecha)
						&& diaDelMes.getHasta().isAfter(fecha));
	}

	public boolean esteDiaParticularEsFeriado(LocalDate fecha) {
		return diaParticularDeUnAnioFeriado.stream().anyMatch(
				feriado -> feriado.equals(fecha));
	}

	public boolean esFeriado(LocalDate fecha) {

		boolean diaSemanaFeriado = this.esteDiaDeLaSemanaEsFeriado(fecha);
		boolean diaDelMesFeriado = this.esteDiaDelMesEsFeriado(fecha);
		boolean diaParticular = this.esteDiaParticularEsFeriado(fecha);

		return diaSemanaFeriado || diaDelMesFeriado || diaParticular;
	}

	public boolean yaExisteEsteDiaDeLaSemanaFeriadoEnEsePeriodo(
			DiaSemanaFeriado diaAAgregar) {
		return diaSemanaFeriado.stream().anyMatch(
				combo -> combo.getDia().equals(diaAAgregar)
						&& combo.getDesde().equals(diaAAgregar.getDesde())
						&& combo.getHasta().equals(diaAAgregar.getHasta()));
	}

	public boolean yaExisteEsteDiaDeEsteMesFeriadoEnEsePeriodo(
			DiaSinAnio fechaAAgregar) {
		return diaDelMesFeriado.stream().anyMatch(
				combo -> combo.getDia() == fechaAAgregar.getDia()
						&& combo.getMes() == fechaAAgregar.getMes()
						&& combo.getDesde().equals(fechaAAgregar.getDesde())
						&& combo.getHasta().equals(fechaAAgregar.getHasta()));
	}

}
