package calendarioFeriados;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepositorioFeriados implements Repositorio {

	// ATRIBUTOS //

	private static RepositorioFeriados instance = null;

	List<DayOfWeek> diaSemanaFeriado = new ArrayList<DayOfWeek>();
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
				dia -> dia.equals(fecha.getDayOfWeek()));
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

		boolean diaSemanaFeriado = this.esteDiaDeLaSemanaEsFeriado(fecha);
		boolean diaDelMesFeriado = this.esteDiaDelMesEsFeriado(fecha);
		boolean diaParticular = this.esteDiaParticularEsFeriado(fecha);

		return diaSemanaFeriado || diaDelMesFeriado || diaParticular;
	}

	public boolean yaExisteEsteDiaFeriado(DayOfWeek diaAAgregar) {
		return diaSemanaFeriado.stream().anyMatch(
				dia -> dia.equals(diaAAgregar));
	}

	public boolean esteDiaDeEsteMesEsFeriado(DiaSinAnio fechaAAgregar) {
		return diaDelMesFeriado.stream().anyMatch(
				diaDelMes -> diaDelMes.getDia() == fechaAAgregar.getDia()
						&& diaDelMes.getMes() == fechaAAgregar.getMes());
	}

}
