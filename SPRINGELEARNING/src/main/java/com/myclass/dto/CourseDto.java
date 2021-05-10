package com.myclass.dto;

import java.util.List;

public class CourseDto {

	private int id;
	private String title;
	private String description;
	private String content;
	private String image;
	private int cate_id;
	private int letures_count;	
	private int hour_count;	
	private int view_count;
	private float price;
	private int discout;
	private float promotion_price;
	private String last_update;
	List<VideoDto > Video;
	List<TargetDto> target;
	

	public CourseDto() {
		
	}
	
	public CourseDto(int id, String title, String description, String content, String image, int cate_id) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
		this.image = image;
		this.cate_id = cate_id;
	}
	
	public CourseDto(int id, String title, String description, String content, String image, int cate_id,
			int letures_count, int hour_count, int view_count, float price, int discout, float promotion_price,
			String last_update) {
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

	public List<VideoDto> getVideo() {
		return Video;
	}

	public void setVideo(List<VideoDto> video) {
		Video = video;
	}

	public List<TargetDto> getTarget() {
		return target;
	}

	public void setTarget(List<TargetDto> target) {
		this.target = target;
	}
	
}
