package com.cutelife.basic;

public enum Seasons {
	SPRING("SPRING"),SUMER("SUMER"),AUTUM("AUTUM"),WINTER("WINTER");
	private String seasons;
	Seasons(String seasons){
		this.seasons=seasons;
	}
	
	public String getSeasons(){
		return this.seasons;
	}
	public String toString(){
		StringBuffer sbb=new StringBuffer();
		for(Seasons x:Seasons.values()){
			sbb.append(x.getSeasons()+" ");
		}
			return sbb.toString();
	}

}
