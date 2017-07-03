package calendarioFeriados;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Configurador {

	RepositorioFeriados repo = RepositorioFeriados.getInstance();

	public void agregarFeriado(DayOfWeek diaAAgregar) {

		if (repo.yaExisteEsteDiaFeriado(diaAAgregar)) {
			throw new RuntimeException ("Ya existe este dia de la semana como feriado");
		} else {
			repo.diaSemanaFeriado.add(diaAAgregar);
		}
	}

	public void agregarFeriado(LocalDate fechaAAgregar) {
		if (repo.esteDiaParticularEsFeriado(fechaAAgregar)) {
			throw new RuntimeException ("Ya existe este dia en particular como feriado");
		} else {
			repo.diaParticularDeUnAnioFeriado.add(fechaAAgregar);
		}
	}

	public void agregarFeriado(DiaSinAnio fechaAAgregar) {
		if (repo.esteDiaDeEsteMesEsFeriado(fechaAAgregar)) {
			throw new RuntimeException ("Ya existe este dia en este mes como feriado");
		} else {
			repo.diaDelMesFeriado.add(fechaAAgregar);
		}
	}

}
