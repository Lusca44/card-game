package br.com.lucas.typesEnum;

public enum Classes {

	MAGO(1),
	PALADINO(2),
	CAÇADOR(2),
	DRUIDA(2),
	QUALQUER(2);
	
	private int code;

	private Classes(int code) {
	this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Classes valueOf(int code) {
		for(Classes classe : Classes.values()){
			if(classe.getCode() == code) {
				return classe;
			}
		}
		 throw new IllegalArgumentException("Card class not found!");
	}
}
