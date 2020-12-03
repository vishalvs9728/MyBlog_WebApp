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
import com.major.project.daodb.*;
import com.major.project.entities.*;
import com.major.project.helper.*;

@MultipartConfig
public class AddPostServlet extends HttpServlet {

	   
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
        	int cid=Integer.parseInt(request.getParameter("cid"));
            String pTitle=request.getParameter("pTitle");
            String pCode=request.getParameter("pCode");
            String pContent=request.getParameter("pContent");
            Part part=request.getPart("pic");
            //getting current userid
            HttpSession session=request.getSession();
            User user=(User) session.getAttribute("currentUser");
            //out.println("your post content is "+pContent);
            //out.println("your post code is "+pCode);
           // out.println(part.getSubmittedFileName());
            
            Post p=new Post(pTitle,pContent,pCode,part.getSubmittedFileName(),null,cid,user.getId());
            PostDao dao=new PostDao(ConnectionProvider.getConnection());
            if(dao.savePost(p))
            {
            	
            	String path ="C:\\Users\\admin\\eclipse-workspace\\FinalYearProject\\WebContent\\blog_pics" + File.separator + part.getSubmittedFileName();
            	Helper.saveFile(part.getInputStream(), path);
            	out.println("saved");
            }
            else
            {
            	out.println("error");
            }
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
}