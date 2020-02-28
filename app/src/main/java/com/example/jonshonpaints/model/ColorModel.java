package com.example.jonshonpaints.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ColorModel{

	@SerializedName("0")
	@Expose
	private String _0;
	@SerializedName("Id")
	@Expose
	private String id;
	@SerializedName("1")
	@Expose
	private String _1;
	@SerializedName("Name")
	@Expose
	private String name;

	public String get0() {
		return _0;
	}

	public void set0(String _0) {
		this._0 = _0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String get1() {
		return _1;
	}

	public void set1(String _1) {
		this._1 = _1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}