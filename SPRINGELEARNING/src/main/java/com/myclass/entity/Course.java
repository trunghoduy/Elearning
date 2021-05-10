package com.myclass.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name =  "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "cate_id")
	private int cate_id;

	@Column(name = "letures_count")
	private int letures_count;
	
	@Column(name = "hour_count")
	private int hour_count;
	@Column(name = "view_count")
	private int view_count;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "discout")
	private int discout;
	
	@Column(name = "promotion_price")
	private float promotion_price;
	
	@Column(name = "last_update")
	private String last_update;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cate_id", insertable=false, updatable=false)
	private Category category;
	
	@ManyToMany(mappedBy = "likedCourses", fetch = FetchType.LAZY)
	private List<User> user;
	
	@OneToMany(mappedBy = "course",fetch = FetchType.LAZY)
	private List<Target> targets;
	
	

	@OneToMany(mappedBy = "course",fetch = FetchType.LAZY)
	private List<Video> videos;
	public Course() {
		
	}
	
	
	public Course(int id, int cate_id,String content, String description,  String image, String title,
			int discout,int hour_count,String last_update,int letures_count, float price,  float promotion_price
			,  int view_count
			) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
		this.image = image;
		this.cate_id = cate_id;
		this.letures_count = letures_count;
		this.hour_count = hour_count;
		this.view_count = view_count;
		this.price = price;
		this.discout = discout;
		this.promotion_price = promotion_price;
		this.last_update = last_update;
	}


	public Course(int id, String title, String description, String content, String image, int cate_id) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
		this.image = image;
		this.cate_id = cate_id;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getCate_id() {
		return cate_id;
	}

	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}
	public List<Target> getTargets() {
		return targets;
	}

	public void setTargets(List<Target> targets) {
		this.targets = targets;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}


	public int getLetures_count() {
		return letures_count;
	}


	public void setLetures_count(int letures_count) {
		this.letures_count = letures_count;
	}


	public int getHour_count() {
		return hour_count;
	}


	public void setHour_count(int hour_count) {
		this.hour_count = hour_count;
	}


	public int getView_count() {
		return view_count;
	}


	public void setView_count(int view_count) {
		this.view_count = view_count;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public int getDiscout() {
		return discout;
	}


	public void setDiscout(int discout) {
		this.discout = discout;
	}


	public float getPromotion_price() {
		return promotion_price;
	}


	public void setPromotion_price(float promotion_price) {
		this.promotion_price = promotion_price;
	}


	public String getLast_update() {
		return last_update;
	}


	public void setLast_update(String last_update) {
		this.last_update = last_update;
	}
	
}
