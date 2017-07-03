package calendarioFeriados;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Configurador {

	RepositorioFeriados repo = RepositorioFeriados.getInstance();

	public void crearFeriados() {

		repo.diaSemanaFeriado.add(DayOfWeek.MONDAY);
		repo.diaParticularDeUnAnioFeriado.add(LocalDate.of(1900,07,4));
		
		DiaSinAnio diaMes = new DiaSinAnio();
		diaMes.setDiaSinAnio(LocalDate.of(2017,5,25));		
		repo.diaDelMesFeriado.add(diaMes);
		
	}

}
