package calendarioFeriados;

import java.time.LocalDate;

public class DiaSinAnioEnPeriodo extends DiaSinAnio{

	// ATRIBUTOS //
	
	public LocalDate desde;
	public LocalDate hasta;

	// GETTERS SETTERS //

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


	// METODOS //
	
	public DiaSinAnioEnPeriodo(int dia, int mes, LocalDate desde, LocalDate hasta) {
		super(dia,mes);
		this.setDesde(desde);
		this.setHasta(hasta);
	}

}
