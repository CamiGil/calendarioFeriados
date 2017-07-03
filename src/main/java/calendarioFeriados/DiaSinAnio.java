package calendarioFeriados;

import java.time.LocalDate;

public class DiaSinAnio {
	
	// ATRIBUTOS //
	
	int dia;
	int mes;
	
	// GETTERS SETTERS //
	
	public int getDia() {
		return dia;
	}
	
	public void setDia(int dia) {
		this.dia = dia;
	}
	
	public int getMes() {
		return mes;
	}
	
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public void setDiaSinAnio(LocalDate fecha) {
		this.setMes(fecha.getMonthValue());
		this.setDia(fecha.getDayOfMonth());
	}

}
