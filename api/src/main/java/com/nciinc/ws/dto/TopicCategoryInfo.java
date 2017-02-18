package com.nciinc.ws.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.nciinc.ws.domain.TopicCategory;

public class TopicCategoryInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	@NotNull
	@Size(max=255)
	private String name;

	@NotNull
	private String description;

	private Date createDate;

	public TopicCategoryInfo() {
	}

	public TopicCategoryInfo(TopicCategory category) {
		id = category.getId();
		name = category.getName();
		description = category.getDescription();
		createDate = category.getCreateDate();
	}

	public TopicCategoryInfo(int id, String name, String description, Date createDate) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}