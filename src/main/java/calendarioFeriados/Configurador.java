package calendarioFeriados;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Configurador {

	RepositorioFeriados repo = RepositorioFeriados.getInstance();

	// Agregar feriado dia de la semana en un periodo
	public void agregarFeriado(DayOfWeek diaSemana, LocalDate desde,
			LocalDate hasta) {

		DiaSemanaEnPeriodo diaAAgregar = new DiaSemanaEnPeriodo(diaSemana,
				desde, hasta);

		if (repo.yaExisteEsteDiaDeLaSemanaFeriadoEnEsePeriodo(diaAAgregar)) {
			throw new RuntimeException(
					"Ya existe este dia de la semana como feriado en ese periodo");
		} else if (hasta.isBefore(desde) || desde.equals(hasta)) {
			throw new RuntimeException(
					"Existe un error con el periodo de validez del feriado");
		} else {
			repo.diaSemanaFeriadoEnPeriodo.add(diaAAgregar);
		}
	}

	// Agregar feriado dia de la semana sin rango
	public void agregarFeriado(DayOfWeek diaSemana) {

		DiaSemana diaAAgregar = new DiaSemana(diaSemana);

		if (repo.yaExisteEsteDiaDeLaSemanaFeriado(diaAAgregar)) {
			throw new RuntimeException(
					"Ya existe este dia de la semana como feriado");
		} else {
			repo.diaSemanaFeriado.add(diaAAgregar);
		}
	}

	// Agregar feriado particular de un anio
	public void agregarFeriado(LocalDate fechaAAgregar) {
		if (repo.esteDiaParticularEsFeriado(fechaAAgregar)) {
			throw new RuntimeException(
					"Ya existe este dia en particular como feriado");
		} else {
			repo.diaParticularDeUnAnioFeriado.add(fechaAAgregar);
		}
	}

	// Agregar feriado de dia y mes en un rango de anios
	public void agregarFeriado(int dia, int mes, LocalDate desde,
			LocalDate hasta) {

		DiaSinAnioEnPeriodo diaAAgregar = new DiaSinAnioEnPeriodo(dia, mes,
				desde, hasta);

		if (repo.yaExisteEsteDiaDeEsteMesFeriadoEnEsePeriodo(diaAAgregar)) {
			throw new RuntimeException(
					"Ya existe este dia en este mes como feriado en ese periodo");
		} else if (hasta.isBefore(desde) || desde.equals(hasta)) {
			throw new RuntimeException(
					"Existe un error con el periodo de validez del feriado");
		} else {
			repo.diaDelMesFeriadoEnPeriodo.add(diaAAgregar);
		}
	}

	// Agregar feriado de dia y mes sin periodo
	public void agregarFeriado(int dia, int mes) {

		DiaSinAnio diaAAgregar = new DiaSinAnio(dia, mes);

		if (repo.yaExisteEsteDiaDeEsteMesFeriado(diaAAgregar)) {
			throw new RuntimeException(
					"Ya existe este dia en este mes como feriado");
		} else {
			repo.diaDelMesFeriado.add(diaAAgregar);
		}
	}

}
