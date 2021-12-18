package br.com.lucas.typesEnum;

public enum Types {

	MAGIA(1),
	CRIATURA(2);
	
	private int code;

	private Types(int code) {
	this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Types valueOf(int code) {
		for(Types type : Types.values()){
			if(type.getCode() == code) {
				return type;
			}
		}
		 throw new IllegalArgumentException("Card type not found!");
	}
}
