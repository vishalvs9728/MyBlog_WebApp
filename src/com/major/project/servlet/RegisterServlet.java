package com.major.project.servlet;

import com.major.project.daodb.*;
import com.major.project.entities.*;
import com.major.project.helper.ConnectionProvider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@MultipartConfig
public class RegisterServlet extends HttpServlet {

   
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
          

//            fetch all form data
            String check = request.getParameter("check");
            if (check == null) {
                out.println("box not checked");
            } else {
                //baki ka data yaha nikal rha..
                String name = request.getParameter("user_name");
                String email = request.getParameter("user_email").toUpperCase();
                String password = request.getParameter("user_password");
                String gender = request.getParameter("gender").toUpperCase();
                String about = request.getParameter("about");
                //create user object and set all data to that object..
                User user = new User(name, email, password, gender, about);

                //create a user dao object..
                UserDao dao = new UserDao(ConnectionProvider.getConnection());
                if (dao.saveUser(user)) {
//                save..
                    out.println("done");
                } else {
                    out.println("error");
                }
            }
         
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
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