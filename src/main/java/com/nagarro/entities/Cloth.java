package com.nagarro.entities;

public class Cloth {
	private String id;
	private String name;
	private String colour;
	private String genderRecommendation;
	private String size;
	private Double price;
	private Double rating;
	private String availability;

	public Cloth() {

	}

	public Cloth(String id, String name, String colour, String genderRecommendation, String size, Double price,
			Double rating, String availability) {
		super();
		this.id = id;
		this.name = name;
		this.colour = colour;
		this.genderRecommendation = genderRecommendation;
		this.size = size;
		this.price = price;
		this.rating = rating;
		this.availability = availability;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getGenderRecommendation() {
		return genderRecommendation;
	}

	public void setGenderRecommendation(String genderRecommendation) {
		this.genderRecommendation = genderRecommendation;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Cloth [id=" + id + ", name=" + name + ", colour=" + colour + ", genderRecommendation="
				+ genderRecommendation + ", size=" + size + ", price=" + price + ", rating=" + rating
				+ ", availability=" + availability + "]";
	}

}
