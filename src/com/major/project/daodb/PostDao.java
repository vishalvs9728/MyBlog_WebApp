package com.major.project.daodb;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.major.project.entities.*;
public class PostDao {
	Connection con;
	public PostDao(Connection con) 
	{
		this.con=con;
	}
public ArrayList<Category> getAllCategories()
	{
		ArrayList<Category> list=new ArrayList<>();
		
		try 
		{
			String query="select * from categories order by cid";
			Statement st=this.con.createStatement();
			ResultSet set=st.executeQuery(query);
			while(set.next()) 
			{
				int cid=set.getInt("cid");
				String name=set.getString("name");
				String des=set.getString("description");
				Category c=new Category(cid,name,des);
				list.add(c);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

public boolean savePost(Post p) 
	{
		boolean flag=false;
		try 
		{
			String q="insert into posts(ptitle,pcontent,pcode,ppic,catid,userid) values(?,?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(q);
			pstmt.setString(1, p.getpTitle());
			pstmt.setString(2,p.getpContent());
			pstmt.setString(3,p.getpCode());
			pstmt.setString(4,p.getpPic());
			pstmt.setInt(5,p.getCatId());
			pstmt.setInt(6,p.getUserId());
			pstmt.executeUpdate();
			flag=true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
//get all posts
	public List<Post> getAllPosts()
	{
		List<Post> list=new ArrayList<>();
		//FETCH ALL POST
		
		try
		{
			PreparedStatement p=con.prepareStatement("Select * from posts order by pid desc");
			ResultSet set=p.executeQuery();
			while(set.next()) 
			{
				int pid=set.getInt("pid");
				String pTitle=set.getString("ptitle");
				String pContent=set.getString("pcontent");
				String pCode=set.getString("pcode");
				String pPic=set.getString("ppic");
				Timestamp date=set.getTimestamp("pdate");
				int userId=set.getInt("userid");
				int catId=set.getInt("catid");
				 Post post=new Post(pid,pTitle,pContent,pCode,pPic,date,catId,userId);
				 list.add(post);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Post> getPostByCatId(int catId)
	{
		List<Post> list=new ArrayList<>();
		//FETCH Selected catId POST
		
		try
		{
			PreparedStatement p=con.prepareStatement("Select * from posts where catid=?");
			p.setInt(1, catId);
			ResultSet set=p.executeQuery();
			while(set.next()) 
			{
				int pid=set.getInt("pid");
				String pTitle=set.getString("ptitle");
				String pContent=set.getString("pcontent");
				String pCode=set.getString("pcode");
				String pPic=set.getString("ppic");
				Timestamp date=set.getTimestamp("pdate");
				int userId=set.getInt("userid");
				
				
				 Post post=new Post(pid,pTitle,pContent,pCode,pPic,date,catId,userId);
				 list.add(post);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Post getPostByPostId(int postId) 
	{	Post post=null;
		String q="select * from posts where pid=?";
		
		try {
			PreparedStatement p = this.con.prepareStatement(q);
			p.setInt(1, postId);
			ResultSet set=p.executeQuery();
			if(set.next()) 
			{
				
				int pid=set.getInt("pid");
				String pTitle=set.getString("ptitle");
				String pContent=set.getString("pcontent");
				String pCode=set.getString("pcode");
				String pPic=set.getString("ppic");
				Timestamp date=set.getTimestamp("pdate");
				int userId=set.getInt("userid");
				int catId=set.getInt("catid");
				
				
				post=new Post(pid,pTitle,pContent,pCode,pPic,date,catId,userId);
				
				
				
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return post;
		
	}
	
	public User getPostUser(int uid) 
	{
		User user=null;
		try 
		{
			String q= "select * from users where id=?";
		
			PreparedStatement p = this.con.prepareStatement(q);
			p.setInt(1, uid);
			ResultSet set=p.executeQuery();
			if(set.next()) 
			{
					String name=set.getString("name");
				 	String email=set.getString("email");
	                String password=set.getString("password");
	                String gender=set.getString("gender");
	                String about=set.getString("about");
	                Date date=set.getDate("rdate");
	                String profile=set.getString("profile");
				
	                user=new User(uid,name,email,password,gender,date, about,profile);
			}
		} catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		return user;
	}
	

}
