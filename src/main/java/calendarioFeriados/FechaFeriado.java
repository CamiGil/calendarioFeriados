package calendarioFeriados;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class FechaFeriado {

	public static boolean esFeriado(LocalDate fecha) {
		
		boolean diaSemanaFeriado = diaDeLaSemanaEsFeriado(fecha);
		boolean diaFeriado = elDiaDeEseMesEsFeriado(fecha);
		boolean diaParticular = diaDeUnAnioParticularEsFeriado(fecha);
		
		return diaSemanaFeriado||diaFeriado||diaParticular;
	}
	
	public static boolean diaDeLaSemanaEsFeriado(LocalDate fecha) {

		if(fecha.getDayOfWeek().equals(DayOfWeek.MONDAY)){
			return true;
		}
		return false;

	}

	public static boolean elDiaDeEseMesEsFeriado(LocalDate fecha) {

		if(fecha.equals(LocalDate.of(LocalDate.now().getYear(),5,25))){
			return true;
		}
		return false;

	}

	public static boolean diaDeUnAnioParticularEsFeriado(LocalDate fecha) {

		if(fecha.equals(LocalDate.of(1900,07,4))){
			return true;
		}
		return false;
	}
	
}
