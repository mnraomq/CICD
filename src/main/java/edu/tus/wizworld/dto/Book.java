package edu.tus.wizworld.dto;

import javax.persistence.*;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="books")
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String title;
	private String author;
    private String illustratedBy;
    private double realRetailPrice;
    private double onlinePrice;
    private String image;
    private String series;
    @Enumerated(EnumType.STRING)
	private Rating rating;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIllustratedBy() {
		return illustratedBy;
	}
	public void setIllustratedBy(String illustratedBy) {
		this.illustratedBy = illustratedBy;
	}
	public double getRealRetailPrice() {
		return realRetailPrice;
	}
	public void setRealRetailPrice(double realRetailPrice) {
		this.realRetailPrice = realRetailPrice;
	}
	public double getOnlinePrice() {
		return onlinePrice;
	}
	public void setOnlinePrice(double onlinePrice) {
		this.onlinePrice = onlinePrice;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
    
}