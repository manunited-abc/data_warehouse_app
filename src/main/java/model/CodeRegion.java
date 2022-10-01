package model;

public class CodeRegion {
	int codeRegion;
	String province;
	public int getCodeRegion() {
		return codeRegion;
	}
	public void setCode_region(int codeRegion) {
		this.codeRegion = codeRegion;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@Override
	public String toString() {
		return "CodeRegion [codeRegion=" + codeRegion + ", province=" + province + "]";
	}
	
}
