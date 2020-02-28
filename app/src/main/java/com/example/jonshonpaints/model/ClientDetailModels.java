package com.example.jonshonpaints.model;

import com.google.gson.annotations.SerializedName;

public class ClientDetailModels{

	@SerializedName("STATE")
	private String sTATE;

	@SerializedName("EMAIL")
	private String eMAIL;

	@SerializedName("NAME")
	private String nAME;

	@SerializedName("0")
	private String jsonMember0;

	@SerializedName("1")
	private String jsonMember1;

	@SerializedName("2")
	private String jsonMember2;

	@SerializedName("STATUS")
	private String sTATUS;

	@SerializedName("3")
	private String jsonMember3;

	@SerializedName("4")
	private String jsonMember4;

	@SerializedName("5")
	private String jsonMember5;

	@SerializedName("6")
	private String jsonMember6;

	@SerializedName("ADDRESS")
	private String aDDRESS;

	@SerializedName("7")
	private String jsonMember7;

	@SerializedName("GST_NO")
	private String gSTNO;

	@SerializedName("ID")
	private String iD;

	@SerializedName("MOBILE")
	private String mOBILE;

	public void setSTATE(String sTATE){
		this.sTATE = sTATE;
	}

	public String getSTATE(){
		return sTATE;
	}

	public void setEMAIL(String eMAIL){
		this.eMAIL = eMAIL;
	}

	public String getEMAIL(){
		return eMAIL;
	}

	public void setNAME(String nAME){
		this.nAME = nAME;
	}

	public String getNAME(){
		return nAME;
	}

	public void setJsonMember0(String jsonMember0){
		this.jsonMember0 = jsonMember0;
	}

	public String getJsonMember0(){
		return jsonMember0;
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

	public void setSTATUS(String sTATUS){
		this.sTATUS = sTATUS;
	}

	public String getSTATUS(){
		return sTATUS;
	}

	public void setJsonMember3(String jsonMember3){
		this.jsonMember3 = jsonMember3;
	}

	public String getJsonMember3(){
		return jsonMember3;
	}

	public void setJsonMember4(String jsonMember4){
		this.jsonMember4 = jsonMember4;
	}

	public String getJsonMember4(){
		return jsonMember4;
	}

	public void setJsonMember5(String jsonMember5){
		this.jsonMember5 = jsonMember5;
	}

	public String getJsonMember5(){
		return jsonMember5;
	}

	public void setJsonMember6(String jsonMember6){
		this.jsonMember6 = jsonMember6;
	}

	public String getJsonMember6(){
		return jsonMember6;
	}

	public void setADDRESS(String aDDRESS){
		this.aDDRESS = aDDRESS;
	}

	public String getADDRESS(){
		return aDDRESS;
	}

	public void setJsonMember7(String jsonMember7){
		this.jsonMember7 = jsonMember7;
	}

	public String getJsonMember7(){
		return jsonMember7;
	}

	public void setGSTNO(String gSTNO){
		this.gSTNO = gSTNO;
	}

	public String getGSTNO(){
		return gSTNO;
	}

	public void setID(String iD){
		this.iD = iD;
	}

	public String getID(){
		return iD;
	}

	public void setMOBILE(String mOBILE){
		this.mOBILE = mOBILE;
	}

	public String getMOBILE(){
		return mOBILE;
	}

	@Override
 	public String toString(){
		return 
			"ClientDetailModels{" + 
			"sTATE = '" + sTATE + '\'' + 
			",eMAIL = '" + eMAIL + '\'' + 
			",nAME = '" + nAME + '\'' + 
			",0 = '" + jsonMember0 + '\'' + 
			",1 = '" + jsonMember1 + '\'' + 
			",2 = '" + jsonMember2 + '\'' + 
			",sTATUS = '" + sTATUS + '\'' + 
			",3 = '" + jsonMember3 + '\'' + 
			",4 = '" + jsonMember4 + '\'' + 
			",5 = '" + jsonMember5 + '\'' + 
			",6 = '" + jsonMember6 + '\'' + 
			",aDDRESS = '" + aDDRESS + '\'' + 
			",7 = '" + jsonMember7 + '\'' + 
			",gST_NO = '" + gSTNO + '\'' + 
			",iD = '" + iD + '\'' + 
			",mOBILE = '" + mOBILE + '\'' + 
			"}";
		}
}