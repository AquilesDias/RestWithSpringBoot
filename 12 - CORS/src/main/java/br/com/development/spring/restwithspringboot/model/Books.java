package br.com.development.spring.restwithspringboot.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="books")
public class Books implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "author", nullable = false, length = 50)
	private String author;
	
	private Date launch_date;
	private BigDecimal price;
	
	@Column(name = "title", nullable = false, length = 150)
	private String title;
	
	public Books() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getLaunch_date() {
		return launch_date;
	}

	public void setLaunch_date(Date launch_date) {
		this.launch_date = launch_date;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
