package com.greatlearning.bookstore.bookstoremanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
     private int ID;
	
     private String Title;
     private String Author;
     private String Genre;
     private double price;
     private int qty;
     

     
	public Cart() {
		super();
	}
	
	public Cart(int iD, String title, String author, String genre, double price, int qty) {
		super();
		ID = iD;
		Title = title;
		Author = author;
		Genre = genre;
		this.price = price;
		this.qty = qty;
	}
	
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "Cart [ID=" + ID + ", Title=" + Title + ", Author=" + Author + ", Genre=" + Genre + ", price=" + price
				+ ", qty=" + qty + "]";
	}
   
}
