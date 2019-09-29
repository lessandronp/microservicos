package br.com.solucaocriativa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Capital {
	
	private String country;	
	private String name;
	private String capital;
	private int port;	
}