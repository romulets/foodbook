package com.foodbook.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="comment")
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer idComment;
	
	@Column(nullable=false)
	@NotNull(message="O campo comentário não pode ficar vazio.")
	private String description;
	
	@Column(nullable=false)
	private Date publicationDate;
	
	@ManyToOne
	@JoinColumn(name="comment_recipe_fk", nullable=false)
	private Recipe recipeCommented;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="comment_user_fk", nullable=false)
	private User user;

	public Comment() {}

	public Comment(Integer idComment, Date publicationDate, String description, Recipe recipeCommented, User user) {
		super();
		this.idComment = idComment;
		this.publicationDate = publicationDate;
		this.description = description;
		this.recipeCommented = recipeCommented;
		this.user = user;
	}

	public Integer getIdComment() {
		return idComment;
	}

	public void setIdComment(Integer idComment) {
		this.idComment = idComment;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Recipe getRecipeCommented() {
		return recipeCommented;
	}

	public void setRecipeCommented(Recipe recipeCommented) {
		this.recipeCommented = recipeCommented;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Comment [idComment=" + idComment + ", publicationDate=" + publicationDate + ", description="
				+ description + "]";
	}
	
}
