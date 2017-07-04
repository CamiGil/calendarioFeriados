package calendarioFeriados;

import java.time.LocalDate;

public interface Repositorio {

	public boolean esteDiaDeLaSemanaEsFeriado(LocalDate fecha);

	public boolean esteDiaDelMesEsFeriado(LocalDate fecha);

	public boolean esteDiaParticularEsFeriado(LocalDate fecha);

	public boolean esFeriado(LocalDate fecha);

	public boolean yaExisteEsteDiaDeLaSemanaFeriadoEnEsePeriodo(
			DiaSemanaFeriado diaAAgregar);

	public boolean yaExisteEsteDiaDeEsteMesFeriadoEnEsePeriodo(
			DiaSinAnioEnPeriodo fechaAAgregar);
}
