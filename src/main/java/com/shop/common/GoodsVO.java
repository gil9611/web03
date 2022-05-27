package com.shop.common;

import java.util.Date;

public class GoodsVO {
	int gcode;
	String gcategory;
	String gname;
	int gprice;
	String gcolor;
	String gsize;
	String gmeterial;
	int gamount;
	String gcomment;
	String gimg;
	Date regdate;
	String sdate;
	public int getGcode() {
		return gcode;
	}
	public void setGcode(int gcode) {
		this.gcode = gcode;
	}
	public String getGcategory() {
		return gcategory;
	}
	public void setGcategory(String gcategory) {
		this.gcategory = gcategory;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getGprice() {
		return gprice;
	}
	public void setGprice(int gprice) {
		this.gprice = gprice;
	}
	public String getGcolor() {
		return gcolor;
	}
	public void setGcolor(String gcolor) {
		this.gcolor = gcolor;
	}
	public String getGsize() {
		return gsize;
	}
	public void setGsize(String gsize) {
		this.gsize = gsize;
	}
	public String getGmeterial() {
		return gmeterial;
	}
	public void setGmeterial(String gmeterial) {
		this.gmeterial = gmeterial;
	}
	public int getGamount() {
		return gamount;
	}
	public void setGamount(int gamount) {
		this.gamount = gamount;
	}
	public String getGcomment() {
		return gcomment;
	}
	public void setGcomment(String gcomment) {
		this.gcomment = gcomment;
	}
	public String getGimg() {
		return gimg;
	}
	public void setGimg(String gimg) {
		this.gimg = gimg;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	
	@Override
	public String toString() {
		return "GoodsVO [gcode=" + gcode + ", gcategory=" + gcategory + ", gname=" + gname + ", gprice=" + gprice
				+ ", gcolor=" + gcolor + ", gsize=" + gsize + ", gmeterial=" + gmeterial + ", gamount=" + gamount
				+ ", gcomment=" + gcomment + ", gimg=" + gimg + ", regdate=" + regdate + ", sdate=" + sdate + "]";
	}
	
	
}
