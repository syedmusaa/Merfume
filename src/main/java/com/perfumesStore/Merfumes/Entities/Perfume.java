package com.perfumesStore.Merfumes.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Perfume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String brand;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private String fragranceNotes;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String imageUrl;

    @Column
    private float rating;
    
    @OneToMany(mappedBy = "perfume", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;  // A perfume can be part of many order items.

    @OneToMany(mappedBy = "perfume", cascade = CascadeType.ALL)
    private List<Review> reviews;  // A perfume can have multiple customer reviews.
    
    public Perfume() {
    	
    }

	public Perfume(Long id, String name, String brand,String description, String fragranceNotes, BigDecimal price, String imageUrl,
			float rating, List<OrderItem> orderItems, List<Review> reviews) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.fragranceNotes = fragranceNotes;
		this.price = price;
		this.imageUrl = imageUrl;
		this.rating = rating;
		this.orderItems = orderItems;
		this.reviews = reviews;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFragranceNotes() {
		return fragranceNotes;
	}

	public void setFragranceNotes(String fragranceNotes) {
		this.fragranceNotes = fragranceNotes;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Perfume [id=" + id + ", name=" + name + ", brand=" + brand + ", description=" + description + ", fragranceNotes=" + fragranceNotes
				+ ", price=" + price + ", imageUrl=" + imageUrl + ", rating=" + rating + ", orderItems=" + orderItems
				+ ", reviews=" + reviews + "]";
	}
	
}