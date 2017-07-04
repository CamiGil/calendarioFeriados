package calendarioFeriados;

import java.time.LocalDate;

public class DiaSinAnio {
	
	// ATRIBUTOS //
	
	int dia;
	int mes;
	LocalDate desde;
	LocalDate hasta;
	
	// GETTERS SETTERS //
	
	public DiaSinAnio(int dia, int mes,LocalDate desde, LocalDate hasta) {
		this.setMes(dia);
		this.setDia(mes);
		this.setDesde(desde);
		this.setHasta(hasta);
	}
	
	public int getDia() {
		return dia;
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

	public void setDia(int dia) {
		this.dia = dia;
	}
	
	public int getMes() {
		return mes;
	}
	
	public void setMes(int mes) {
		this.mes = mes;
	}

}
