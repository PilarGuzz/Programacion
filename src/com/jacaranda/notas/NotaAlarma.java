package com.jacaranda.notas;

import java.time.LocalDateTime;

public class NotaAlarma extends Nota implements Activable{
	
	private LocalDateTime fechaAlarma;
	private static final int MINUTOS_REPETIR_POR_DEFECTO = 0;
	private int minutosRepetir;
	private boolean activado = false;
	


	public NotaAlarma(String texto, LocalDateTime fecha, boolean activado) {
		super(texto);
	}
	
	public NotaAlarma(String texto, LocalDateTime fecha, int minRep) {
		super(texto);
	}

	public static int getMinutosRepetirPorDefecto() {
		return MINUTOS_REPETIR_POR_DEFECTO;
	}

	private void setFechaAlarma(LocalDateTime fechaAlarma) {
		this.fechaAlarma = fechaAlarma;
	}
	

	@Override
	public void activar() {
		this.activado= true;
	}

	@Override
	public void desactivar() {
		this.activado= false;
		
	}

	public boolean isActivado() {
		return this.activado;
	}

	@Override
	public String toString() {
		return "NotaAlarma [fechaAlarma=" + fechaAlarma + ", minutosRepetir=" + minutosRepetir + ", activado="
				+ activado + "]";
	}
	
	
}
