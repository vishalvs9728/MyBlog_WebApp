package com.major.project.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.major.project.daodb.UserDao;
import com.major.project.entities.Message;
import com.major.project.entities.User;
import com.major.project.helper.ConnectionProvider;
import com.major.project.helper.*;

@MultipartConfig
public class EditServlet extends HttpServlet {

	   
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>EditServlet</title>");
            out.println("</head>");
            out.println("<body>");


            //fetch data of edit form
            String userName=request.getParameter("user_name");
            String userPassword=request.getParameter("user_password");
            String userAbout=request.getParameter("user_about");
            Part part=request.getPart("image");            
            String imageName=part.getSubmittedFileName();
            
            //user from session (chk loginservert where we send the current user)
            
            HttpSession s=request.getSession();
            User user=(User) s.getAttribute("currentUser");
            String oldFile=user.getProfile();
            user.setName(userName);
            user.setPassword(userPassword);
            user.setAbout(userAbout);
            if(!imageName.equals(""))
            	 user.setProfile(imageName);
           
            
            
            //update in data base.....
            UserDao userDao=new UserDao(ConnectionProvider.getConnection());
            boolean ans=userDao.updateUser(user);
            if(ans)
            	{	
            	boolean f=true;
            	
            	if(!imageName.equals("")) {
            		out.println("Updated to db");
            		String path ="C:\\Users\\admin\\eclipse-workspace\\FinalYearProject\\WebContent\\pics" + File.separator + user.getProfile();
            		//request.getRealPath("/")
            		String path1 ="C:\\Users\\admin\\eclipse-workspace\\FinalYearProject\\WebContent\\pics" + File.separator + oldFile;
            		if(!oldFile.equals("default.png"))
            		Helper.deleteFile(path1);
            		
            			if(!Helper.saveFile(part.getInputStream(),path))
            			{		out.println("Profile Update");
            				
            			f=false;
            			}

            			Message msg = new Message("Profile details updated", "success", "alert-success");
                        s.setAttribute("msg", msg);
                        
                        
            		}
            		if(f)
            		{
            			Message msg = new Message("Profile details updated", "success", "alert-success");
            			s.setAttribute("msg", msg);
            		}
            	
            	}
            			
            			
            		
            	
            else 
            {
            	Message msg = new Message("Something went Wrong  ", "error", "alert-danger");
                s.setAttribute("msg", msg);
            }
            
            response.sendRedirect("profile.jsp");
            
            
            
            out.println("</body>");
            out.println("</html>");
        }
        
	}
       
   
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
    	processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
