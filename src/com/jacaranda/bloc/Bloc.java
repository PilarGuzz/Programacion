package com.jacaranda.bloc;

import java.util.Arrays;

import com.jacaranda.notas.Activable;
import com.jacaranda.notas.BlocException;
import com.jacaranda.notas.Nota; 
import com.jacaranda.notas.NotaAlarma; 


public class Bloc {
	
	private static final int NUMERO_NOTAS_MAXIMA = 50;
	private int numNotas = 0;
	private String nombre;
	private Nota[] notas = new Nota[NUMERO_NOTAS_MAXIMA];
	
	
	
	public Bloc(String texto) {
		this.nombre=texto;
	}
	
	public static int getNumeroNotasMaxima() {
		return NUMERO_NOTAS_MAXIMA;
	}
	public int getNumNotas() {
		return numNotas;
	}
	public String getNombre() {
		return nombre;
	}
	
//	public String getNota(int numNota) {
//		String resulta = "";
//		if (numNota<NUMERO_NOTAS_MAXIMA && numNota>0) {
//			
//			
//		}
//	}
	
	public void activa(int posicion) {
		
		if (posicion<NUMERO_NOTAS_MAXIMA
				&& this.notas[posicion-1] != null
				&& this.notas[posicion-1] instanceof Activable) {
			
				NotaAlarma notaActivar = (NotaAlarma) this.notas[posicion-1];
				notaActivar.activar();			
		}else {
			throw new NotaAlarmaException("No se ha podido activar la alarma");
		}
		
	}
	
	public void desactiva(int posicion) {
		
		if (posicion<NUMERO_NOTAS_MAXIMA
				&& this.notas[posicion-1] != null
				&& this.notas[posicion-1] instanceof Activable) {
			
				NotaAlarma notaActivar = (NotaAlarma) this.notas[posicion-1];
				notaActivar.desactivar();			
		}else {
			throw new NotaAlarmaException("No se ha podido desactivar la alarma");
		}
		
	}
	
	public void updateNotas (int posicion, String nota) {
		if (posicion<NUMERO_NOTAS_MAXIMA) {
			this.notas[posicion].setTexto(nota);
		}else {
			throw new BlocException("Posicion fuera del limite");
		}

	}
	
	public void addNota(Nota nota) {
		
		if (numNotas<NUMERO_NOTAS_MAXIMA) {
			this.notas[numNotas++] = nota;
			numNotas++;
		}
			
	}
	public void addNota(int posicion, Nota nota) {
		if (posicion<NUMERO_NOTAS_MAXIMA) {
			this.notas[posicion] = nota;
	}else {
		throw new BlocException("Posicion fuera del limite");
	}
		
	}
	
	public Nota[] ordenarNotas() {
		
				
		Nota[] notasOrdenadas = new Nota[contarNotasNoNulas()];
		
		int contadorNotasOrdenadas = 0;
		
		for(int i = 0; i< this.notas.length;i++) {
			if(this.notas[i]!=null) {
				notasOrdenadas[contadorNotasOrdenadas++] = this.notas[i];
			}
		}
		
		Arrays.sort(notasOrdenadas);
		return notasOrdenadas;
	}

	private int contarNotasNoNulas() {
		int contadorNotas = 0;
		for(int i = 0; i< this.notas.length;i++) {
			if(this.notas[i]!=null) {
				contadorNotas++;
			}
		}
		return contadorNotas;
	}
	


}
