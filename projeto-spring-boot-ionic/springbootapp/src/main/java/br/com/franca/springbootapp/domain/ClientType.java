package br.com.franca.springbootapp.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum ClientType {

	PHYSICAL_PERSON(1, "Physical Person"), LEGAL_PERSON(2, "Legal Person");

	private int key;
	private String value;

	private ClientType(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public static ClientType toEnum(int key) {
		return Arrays.asList(ClientType.values()).stream().filter((e) -> e.key == key).collect(Collectors.toList())
				.get(0);

		/*
		 * if (cod == null) { return null; }
		 * 
		 * for (TipoCliente x : TipoCliente.values()) { if (cod.equals(x.getCod())) {
		 * return x; } }
		 * 
		 * throw new IllegalArgumentException("Id inválido: " + cod);
		 */
	}
}
