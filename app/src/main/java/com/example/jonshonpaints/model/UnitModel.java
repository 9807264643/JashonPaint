package com.example.jonshonpaints.model;

import com.google.gson.annotations.SerializedName;

public class UnitModel{

	@SerializedName("0")
	private String jsonMember0;

	@SerializedName("CategoryId")
	private String categoryId;

	@SerializedName("1")
	private String jsonMember1;

	@SerializedName("2")
	private String jsonMember2;

	@SerializedName("3")
	private String jsonMember3;

	@SerializedName("Colors")
	private String colors;

	@SerializedName("4")
	private String jsonMember4;

	@SerializedName("Price")
	private String price;

	@SerializedName("5")
	private String jsonMember5;

	@SerializedName("Id")
	private String id;

	@SerializedName("CategoryTypeId")
	private String categoryTypeId;

	@SerializedName("Units")
	private String units;

	public void setJsonMember0(String jsonMember0){
		this.jsonMember0 = jsonMember0;
	}

	public String getJsonMember0(){
		return jsonMember0;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setJsonMember1(String jsonMember1){
		this.jsonMember1 = jsonMember1;
	}

	public String getJsonMember1(){
		return jsonMember1;
	}

	public void setJsonMember2(String jsonMember2){
		this.jsonMember2 = jsonMember2;
	}

	public String getJsonMember2(){
		return jsonMember2;
	}

	public void setJsonMember3(String jsonMember3){
		this.jsonMember3 = jsonMember3;
	}

	public String getJsonMember3(){
		return jsonMember3;
	}

	public void setColors(String colors){
		this.colors = colors;
	}

	public String getColors(){
		return colors;
	}

	public void setJsonMember4(String jsonMember4){
		this.jsonMember4 = jsonMember4;
	}

	public String getJsonMember4(){
		return jsonMember4;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setJsonMember5(String jsonMember5){
		this.jsonMember5 = jsonMember5;
	}

	public String getJsonMember5(){
		return jsonMember5;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setCategoryTypeId(String categoryTypeId){
		this.categoryTypeId = categoryTypeId;
	}

	public String getCategoryTypeId(){
		return categoryTypeId;
	}

	public void setUnits(String units){
		this.units = units;
	}

	public String getUnits(){
		return units;
	}

	@Override
 	public String toString(){
		return 
			"UnitModel{" + 
			"0 = '" + jsonMember0 + '\'' + 
			",categoryId = '" + categoryId + '\'' + 
			",1 = '" + jsonMember1 + '\'' + 
			",2 = '" + jsonMember2 + '\'' + 
			",3 = '" + jsonMember3 + '\'' + 
			",colors = '" + colors + '\'' + 
			",4 = '" + jsonMember4 + '\'' + 
			",price = '" + price + '\'' + 
			",5 = '" + jsonMember5 + '\'' + 
			",id = '" + id + '\'' + 
			",categoryTypeId = '" + categoryTypeId + '\'' + 
			",units = '" + units + '\'' + 
			"}";
		}
}