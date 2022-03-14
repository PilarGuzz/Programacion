package com.jacaranda;

import java.util.Scanner;

import com.jacaranda.bloc.NotaAlarmaException;
import com.jacaranda.notas.Nota;
import com.jacaranda.notas.NotaAlarma;
import com.jacaranda.bloc.Bloc;

public class MainApp {

	private static final String MENU_PRINCIPAL = "Menu para crear notas\n"
			+"1. Crear nota \n"
			+"2. Crear nota alarma \n"
			+"3. Modificar nota \n"
			+"4. Salir \n";
	
	private static  Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		imprimirMenuPrincipal();
		int opcion = Integer.valueOf(sc.nextLine());
		Bloc bloc = new Bloc("Bloc de pruebas");
		
		while (opcion !=4) {
			if(opcion==1) {
				System.out.println("Introduzca el texto a incluir");
				String texto = sc.nextLine();
				Nota n = new Nota(texto);
				bloc.addNota(n);
			}
			
			imprimirMenuPrincipal();
			opcion = Integer.valueOf(sc.nextLine());

		}
		System.out.println("Ha salido de la aplicacion");
		
		
		
		Nota[]bloc1 = new Nota[5];
		for (int i=0; i<bloc1.length;i++) {
			bloc1[i] = crearNota();
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
		
	public static void imprimirMenuPrincipal() {
		System.out.println(MENU_PRINCIPAL);
	}
		private static Nota crearNota() {
			
			System.out.println("Introduce un mensje para la nota: ");
			String texto = new Scanner (System.in).nextLine();
			Nota nota = new Nota(texto);
			return nota;
		

	}
		
		

}
