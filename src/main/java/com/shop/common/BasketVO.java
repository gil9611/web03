package com.shop.common;

import java.util.Date;

public class BasketVO {
		int bno;
		String bid;
		int bcode;
		String bname;
		int bprice;
		String bcolor;
		String bsize;
		String bmaterial;
		int border;
		Date regdate;
		String sdate;
		public int getBno() {
			return bno;
		}
		public void setBno(int bno) {
			this.bno = bno;
		}
		public String getBid() {
			return bid;
		}
		public void setBid(String bid) {
			this.bid = bid;
		}
		public int getBcode() {
			return bcode;
		}
		public void setBcode(int bcode) {
			this.bcode = bcode;
		}
		public String getBname() {
			return bname;
		}
		public void setBname(String bname) {
			this.bname = bname;
		}
		public int getBprice() {
			return bprice;
		}
		public void setBprice(int bprice) {
			this.bprice = bprice;
		}
		public String getBcolor() {
			return bcolor;
		}
		public void setBcolor(String bcolor) {
			this.bcolor = bcolor;
		}
		public String getBsize() {
			return bsize;
		}
		public void setBsize(String bsize) {
			this.bsize = bsize;
		}
		public String getBmaterial() {
			return bmaterial;
		}
		public void setBmaterial(String bmaterial) {
			this.bmaterial = bmaterial;
		}
		public int getBorder() {
			return border;
		}
		public void setBorder(int border) {
			this.border = border;
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
			return "BasketVO [bno=" + bno + ", bid=" + bid + ", bcode=" + bcode + ", bname=" + bname + ", bprice="
					+ bprice + ", bcolor=" + bcolor + ", bsize=" + bsize + ", bmaterial=" + bmaterial + ", border="
					+ border + ", regdate=" + regdate + ", sdate=" + sdate + "]";
		}
		
}
