package com.major.project.entities;

public class Category 
{ 
	private int cid;
	private String name;
	private String description;
	
	public Category(int cid, String name, String description)
	{
		this.name=name;
		this.cid=cid;
		this.description=description;
	}
	public Category()
	{
		
	}
	public Category(String name, String description)
	{
		this.name=name;
		this.description=description;
	}
	
	public void setName()
	{
		
	}
	public void setCid()
	{
		
	}
	public void setDescription() 
	{
		
	}
	public int getCid() 
	{
		return cid;
	}
	public String getName()
	{
		return name;
	}
	public String getDescription()
	{
		return description;
	}
}
