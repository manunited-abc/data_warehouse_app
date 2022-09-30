package model;

public class Config {
	int id;
	String souceData;
	String ip;
	String author ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSouceDate() {
		return souceData;
	}
	public void setSouceDate(String souceData) {
		this.souceData = souceData;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Config [id=" + id + ", souceDate=" + souceData + ", ip=" + ip + ", author=" + author + "]";
	}
	
}
