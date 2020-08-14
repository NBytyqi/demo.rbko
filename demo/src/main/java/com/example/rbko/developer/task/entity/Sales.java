package com.example.rbko.developer.task.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;			

import lombok.Data;

@Data
@Entity
@Table(name = "Sale")
public class Sales {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, unique = true)
	private Long id;
	
	@ManyToOne
	private Products product;
	
	private int unitsSold;
	private Date soldDate;
	
}
