package com.Joe.login;

public class MyLocation {

	private float longtitude;
	private float latitude;
	private long sunset;
	private long sunrise;
	private String country;
	private String city;

	public float getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(float lontitude) {
		this.longtitude = lontitude;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLattitude(float latitude){
		this.latitude = latitude;
	}
	public long getSunset(){
		return sunset;
	}
	public void setSunset(long sunset){
		this.sunset = sunset;
	}
	public long getSunrise(){
		return sunrise;
	}
	public void setSunrise(long sunrise){
		this.sunrise = sunrise;
	}
	public String getCountry(){
		return country;
	}
	public void setCountry(String country){
		this.country = country;
	}
	public String getCity(){
		return city;
	}
	public void setCity(String city){
		this.city = city;
	}
}
