package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Lottery {
	int code;
	String company;
	String province;
	String relaseDate ;
	String prize0;
	String prize1;
	String prize2;
	String prize3;
	String prize4;
	String prize5;
	String prize6;
	String prize7;
	String prize8;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getRelaseDate() {
		return relaseDate;
	}
	public void setRelaseDate(String relaseDate) {
		this.relaseDate = relaseDate;
	}
	public String getPrize0() {
		return prize0;
	}
	public void setPrize0(String prize0) {
		this.prize0 = prize0;
	}
	public String getPrize1() {
		return prize1;
	}
	public void setPrize1(String prize1) {
		this.prize1 = prize1;
	}
	public String getPrize2() {
		return prize2;
	}
	public void setPrize2(String prize2) {
		this.prize2 = prize2;
	}
	public String getPrize3() {
		return prize3;
	}
	public void setPrize3(String prize3) {
		this.prize3 = prize3;
	}
	public String getPrize4() {
		return prize4;
	}
	public void setPrize4(String prize4) {
		this.prize4 = prize4;
	}
	public String getPrize5() {
		return prize5;
	}
	public void setPrize5(String prize5) {
		this.prize5 = prize5;
	}
	public String getPrize6() {
		return prize6;
	}
	public void setPrize6(String prize6) {
		this.prize6 = prize6;
	}
	public String getPrize7() {
		return prize7;
	}
	public void setPrize7(String prize7) {
		this.prize7 = prize7;
	}
	public String getPrize8() {
		return prize8;
	}
	public void setPrize8(String prize8) {
		this.prize8 = prize8;
	}
	@Override
	public String toString() {
		return "Lottery [code=" + code + ", company=" + company + ", province=" + province + ", relaseDate="
				+ relaseDate + ", prize0=" + prize0 + ", prize1=" + prize1 + ", prize2=" + prize2 + ", prize3=" + prize3
				+ ", prize4=" + prize4 + ", prize5=" + prize5 + ", prize6=" + prize6 + ", prize7=" + prize7
				+ ", prize8=" + prize8 + "]";
	}
	
	
}
