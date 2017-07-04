package calendarioFeriados;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DiaSemanaEnPeriodo extends DiaSemana{

	// ATRIBUTOS //

	public LocalDate desde;
	public LocalDate hasta;

	// GETTERS SETTERS //

	public DiaSemanaEnPeriodo(DayOfWeek dia, LocalDate desde, LocalDate hasta) {
		super(dia);
		this.setDesde(desde);
		this.setHasta(hasta);
	}

	public LocalDate getDesde() {
		return desde;
	}

	public void setDesde(LocalDate desde) {
		this.desde = desde;
	}

	public LocalDate getHasta() {
		return hasta;
	}

	public void setHasta(LocalDate hasta) {
		this.hasta = hasta;
	}

}
