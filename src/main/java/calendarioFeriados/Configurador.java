package calendarioFeriados;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Configurador {

	RepositorioFeriados repo = RepositorioFeriados.getInstance();

	// Agregar feriado dia de la semana en un periodo
	public void agregarFeriado(DayOfWeek diaSemana, LocalDate desde, LocalDate hasta) {

		DiaSemanaFeriado diaAAgregar = new DiaSemanaFeriado(diaSemana, desde, hasta);
				
		if (repo.yaExisteEsteDiaDeLaSemanaFeriadoEnEsePeriodo(diaAAgregar)) {
			throw new RuntimeException ("Ya existe este dia de la semana como feriado en ese periodo");
		} else {
			
			repo.diaSemanaFeriado.add(diaAAgregar);
		}
	}

	// Agregar feriado particular de un anio
	public void agregarFeriado(LocalDate fechaAAgregar) {
		if (repo.esteDiaParticularEsFeriado(fechaAAgregar)) {
			throw new RuntimeException ("Ya existe este dia en particular como feriado");
		} else {
			repo.diaParticularDeUnAnioFeriado.add(fechaAAgregar);
		}
	}

	public void agregarFeriado(int dia,int mes,LocalDate desde, LocalDate hasta) {
		
		DiaSinAnio diaAAgregar = new DiaSinAnio(dia,mes, desde, hasta);
		
		if (repo.yaExisteEsteDiaDeEsteMesFeriadoEnEsePeriodo(diaAAgregar)) {
			throw new RuntimeException ("Ya existe este dia en este mes como feriado en ese periodo");
		} else {
			repo.diaDelMesFeriado.add(diaAAgregar);
		}
	}

}
