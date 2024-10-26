package com.perfumesStore.Merfumes.Entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Perfume perfume;
    
    @Column(nullable = false)
    private String product;
    
    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private BigDecimal price;

    public OrderItem () {
    	
    }

    
public OrderItem(Long id, Order order, Perfume perfume, String product, int quantity, BigDecimal price) {
		super();
		this.id = id;
		this.order = order;
		this.perfume = perfume;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}

	public Long getId() {
	    return id;
    }


    public void setId(Long id) {
	    this.id = id;
    }


    public Order getOrder() {
	    return order;
    }


    public void setOrder(Order order) {
	    this.order = order;
    }


    public Perfume getPerfume() {
	    return perfume;
    }


    public void setPerfume(Perfume perfume) {
	    this.perfume = perfume;
    }


    public String getProduct() {
	    return product;
    }


    public void setProduct(String product) {
	    this.product = product;
    }


    public int getQuantity() {
	    return quantity;
    }


    public void setQuantity(int quantity) {
	    this.quantity = quantity;
    }


    public BigDecimal getPrice() {
	    return price;
    }


   public void setPrice(BigDecimal price) {
	    this.price = price;
    }


    @Override
    public String toString() {
	     return "OrderItem [id=" + id + ", order=" + order + ", perfume=" + perfume + ", product=" + product + ", quantity="
			+ quantity + ", price=" + price + "]";
     }
    
    
}
