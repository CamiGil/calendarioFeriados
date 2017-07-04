package calendarioFeriados;

import java.time.LocalDate;

public interface Repositorio {

	public boolean esteDiaDeLaSemanaEsFeriadoEnPeriodo(LocalDate fecha);

	public boolean esteDiaDeLaSemanaEsFeriado(LocalDate fecha);

	public boolean esteDiaDelMesEsFeriadoEnPeriodo(LocalDate fecha);

	public boolean esteDiaDelMesEsFeriado(LocalDate fecha);

	public boolean esteDiaParticularEsFeriado(LocalDate fecha);

	public boolean esFeriado(LocalDate fecha);

	public boolean yaExisteEsteDiaDeLaSemanaFeriadoEnEsePeriodo(
			DiaSemanaEnPeriodo diaAAgregar);

	public boolean yaExisteEsteDiaDeEsteMesFeriadoEnEsePeriodo(
			DiaSinAnioEnPeriodo fechaAAgregar);

	public boolean yaExisteEsteDiaDeEsteMesFeriado(DiaSinAnio diaAAgregar);

	public boolean yaExisteEsteDiaDeLaSemanaFeriado(DiaSemana diaAAgregar);
}
