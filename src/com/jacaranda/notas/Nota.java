package com.jacaranda.notas;

import java.time.LocalDateTime;
import java.util.Objects;

public class Nota implements Comparable<Nota>{
	
	private static int codigoSiguiente;
	private int codigo;
	private String texto;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaUltimaModificacion;
	
	
	public Nota (String texto) {
		this.texto=texto;
		this.codigo = codigoSiguiente++;
		this.fechaCreacion = LocalDateTime.now();
	}

	
	
	//GETTERS AND SETTERS
	public int getCodigo() {
		return codigo;
	}

	public String getTexto() {
		return texto;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public LocalDateTime getFechaModificacion() {
		return fechaUltimaModificacion;
	}

	public void setTexto(String texto) {
		this.texto = texto;
		this.fechaUltimaModificacion = LocalDateTime.now();
	}
	
	public boolean isModificado() {
		return this.fechaUltimaModificacion != null;
	}
	
	public boolean isEmpty() {
		return this.texto == null || this.texto.isBlank();
	}
	
	public boolean isCreadoAnterior(Nota otraNota) {
		return this.getFechaCreacion().isBefore(otraNota.getFechaCreacion());
	}
	
	public boolean isModificadoAnterior(Nota otraNota) {
		boolean esAnterior = false;
		
		if (this.getFechaModificacion() == null && otraNota.getFechaModificacion() == null) {
			esAnterior = false;
		
		}else if (this.isModificado() && otraNota.isModificado()) {
			esAnterior = this.getFechaModificacion().isBefore(otraNota.getFechaModificacion());
		
		}else if (this.isModificado()) {
			esAnterior = true;
		
		}
		
		return false;
	}



	@Override
	public int hashCode() {
		return Objects.hash(codigo, fechaCreacion, fechaUltimaModificacion, texto);
	}



	@Override
	public boolean equals(Object obj) {
		
		boolean sonIguales = true;
		if(obj != null ) {
			if (this == obj) {
				sonIguales = true;
			}else {
				Nota laOtra = (Nota) obj ;
				sonIguales =  this.texto.equals(laOtra.getTexto())
								&& this.getFechaCreacion().equals(laOtra.getFechaCreacion());
			}
		}
		
		return sonIguales;

	}


	@Override
	public String toString() {
		return "Nota " + "[ texto=" + texto + " ]" ;
	}



	@Override
	public int compareTo(Nota otraNota) {
		int result = 0;
		if (otraNota != null) {
			if (this.fechaCreacion.isBefore(otraNota.getFechaCreacion())) {
				result = -1;
				
			}else if (this.fechaCreacion.isAfter(otraNota.getFechaCreacion())) {
				result = 1;
			}
		}
		return result;
		//return this.getFechaCreacion().compareTo(otraNota.getFechaCreacion());
		//return this.getTexto().compareTo(otraNota.getTexto()); comparando por texto

	}

}
