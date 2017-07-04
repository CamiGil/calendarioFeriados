package calendarioFeriados;

import java.time.DayOfWeek;

public class DiaSemana {

	// ATRIBUTOS //
	
	public DayOfWeek dia;
	
	// GETTERS SETTERS //
	
	public DayOfWeek getDia() {
		return dia;
	}

	public void setDia(DayOfWeek dia) {
		this.dia = dia;
	}
	
	public DiaSemana(DayOfWeek dia) {
		this.setDia(dia);
	}
}
