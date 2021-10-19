package net.codejava;

public enum Shops {
	REMA("varerRema"),
	FOETEX("varerFøtex");
	
	private String tableName; 
	
	public String getTableName() {
		return tableName;
	}

	Shops(String tableName) {
		this.tableName = tableName; 
	}
	
	
	
}
