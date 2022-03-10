package com.jacaranda;

import java.util.Scanner;

import com.jacaranda.bloc.NotaAlarmaException;
import com.jacaranda.notas.Nota;
import com.jacaranda.notas.NotaAlarma;

public class MainApp {

	public static void main(String[] args) {
		
		Nota[]bloc = new Nota[5];
		for (int i=0; i<bloc.length;i++) {
			bloc[i] = crearNota();
		}
		
		try {
			NotaAlarma notaAlarma = null;
			
			//notaAlarma = new NotaAlarma("el mensaje");
			notaAlarma.activar();
			System.out.println(notaAlarma.toString());
			
		} catch (Exception e) {
			throw new NotaAlarmaException("se ha producido una excepcion inesperado", e);
			}

		}
		
		private static Nota crearNota() {
			
			System.out.println("Introduce un mensje para la nota: ");
			String texto = new Scanner (System.in).nextLine();
			Nota nota = new Nota(texto);
			return nota;
		

	}
		
		

}
