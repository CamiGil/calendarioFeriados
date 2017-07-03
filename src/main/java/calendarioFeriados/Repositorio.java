package calendarioFeriados;

import java.time.DayOfWeek;
import java.time.LocalDate;

public interface Repositorio {

	public boolean esteDiaDeLaSemanaEsFeriado(LocalDate fecha);

	public boolean esteDiaDelMesEsFeriado(LocalDate fecha);

	public boolean esteDiaParticularEsFeriado(LocalDate fecha);

	public boolean esFeriado(LocalDate fecha);

	public boolean yaExisteEsteDiaFeriado(DayOfWeek diaAAgregar);

	public boolean esteDiaDeEsteMesEsFeriado(DiaSinAnio fechaAAgregar);

}
