package com.perfumesStore.Merfumes.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "perfume_id")
    private Perfume perfume;  // Many reviews belong to one perfume.
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // Many reviews belong to one user.

    @Column(nullable = false)
    private String reviewerName;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private int rating;

    public Review () {
    	
    }

	public Review(Long id, Perfume perfume, User user, String reviewerName, String comment, int rating) {
		super();
		this.id = id;
		this.perfume = perfume;
		this.user = user;
		this.reviewerName = reviewerName;
		this.comment = comment;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Perfume getPerfume() {
		return perfume;
	}

	public void setPerfume(Perfume perfume) {
		this.perfume = perfume;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getReviewerName() {
		return reviewerName;
	}

	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", perfume=" + perfume + ", user=" + user + ", reviewerName=" + reviewerName
				+ ", comment=" + comment + ", rating=" + rating + "]";
	}

}