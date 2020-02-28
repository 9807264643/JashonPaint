package com.example.jonshonpaints.model;

import com.google.gson.annotations.SerializedName;

public class ProductModel{

	@SerializedName("0")
	private String jsonMember0;

	@SerializedName("CategoryCode")
	private String categoryCode;

	@SerializedName("1")
	private String jsonMember1;

	@SerializedName("2")
	private String jsonMember2;

	@SerializedName("Id")
	private String id;

	@SerializedName("CategoryType")
	private String categoryType;

	public void setJsonMember0(String jsonMember0){
		this.jsonMember0 = jsonMember0;
	}

	public String getJsonMember0(){
		return jsonMember0;
	}

	public void setCategoryCode(String categoryCode){
		this.categoryCode = categoryCode;
	}

	public String getCategoryCode(){
		return categoryCode;
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

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setCategoryType(String categoryType){
		this.categoryType = categoryType;
	}

	public String getCategoryType(){
		return categoryType;
	}

	@Override
 	public String toString(){
		return 
			"ProductModel{" + 
			"0 = '" + jsonMember0 + '\'' + 
			",categoryCode = '" + categoryCode + '\'' + 
			",1 = '" + jsonMember1 + '\'' + 
			",2 = '" + jsonMember2 + '\'' + 
			",id = '" + id + '\'' + 
			",categoryType = '" + categoryType + '\'' + 
			"}";
		}
}