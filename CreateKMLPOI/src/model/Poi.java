package model;

public class Poi {
	private String name;
	private String coordinates;
	private String region;
	private String latx;
	private String lony;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	@Override
	public String toString() {
		return "Poi [name=" + name + ", coordinates=" + coordinates + "]";
	}
	public String getLatx() {
		return latx;
	}
	public void setLatx(String latx) {
		this.latx = latx;
	}
	public String getLony() {
		return lony;
	}
	public void setLony(String lony) {
		this.lony = lony;
	}
	
	
	

}
