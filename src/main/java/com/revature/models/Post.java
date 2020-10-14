package com.revature.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private Integer id;
	
	@Column(name  = "posted_date")
	private LocalDate postedDate;
	
	private String content;
	
	private String media;
	
	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false)
	private User author;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "saved_posts", joinColumns = @JoinColumn(name = "post_id"),
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> savedUsers = new ArrayList<>();

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public List<User> getSavedUsers() {
		return savedUsers;
	}

	public void setSavedUsers(List<User> savedUsers) {
		this.savedUsers = savedUsers;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(Integer id, LocalDate postedDate, String content, String media, User author) {
		super();
		this.id = id;
		this.postedDate = postedDate;
		this.content = content;
		this.media = media;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", postedDate=" + postedDate + ", content=" + content + ", media=" + media
				+ ", author=" + author + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((media == null) ? 0 : media.hashCode());
		result = prime * result + ((postedDate == null) ? 0 : postedDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (media == null) {
			if (other.media != null)
				return false;
		} else if (!media.equals(other.media))
			return false;
		if (postedDate == null) {
			if (other.postedDate != null)
				return false;
		} else if (!postedDate.equals(other.postedDate))
			return false;
		return true;
	}
	
}
