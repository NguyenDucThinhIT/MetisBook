package com.metis.book.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.metis.book.model.audit.UserDateAudit;
import com.metis.book.model.order.OrderItem;
import com.metis.book.model.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "feedbacks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
public class Feedback extends UserDateAudit {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user", nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "book_id", referencedColumnName = "id")
	private Book book;
	
	@OneToOne
	@JoinColumn(name ="feedback_id", referencedColumnName = "id")
	private Feedback feedback;
	
	@Column(name = "content", length = 200)
	private String content;
	
	@Column(name = "rating")
	private int rating;
	
	
}