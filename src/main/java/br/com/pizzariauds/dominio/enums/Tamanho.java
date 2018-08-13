package br.com.pizzariauds.dominio.enums;

public enum Tamanho {

	PEQUENA("P", "Pequena"), MEDIA("M", "Média"), GRANDE("G", "Grande");

	private String id;
	private String decricao;

	private Tamanho(String id, String decricao) {
		this.id = id;
		this.decricao = decricao;
	}

	public String getId() {
		return id;
	}

	public String getDecricao() {
		return decricao;
	}

	public static Tamanho toEnum(String id) {
		if (id == null) {
			return null;
		}

		for (Tamanho tamanho : Tamanho.values()) {
			if (tamanho.getId().equals(id)) {
				return tamanho;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + id);
	}
}
