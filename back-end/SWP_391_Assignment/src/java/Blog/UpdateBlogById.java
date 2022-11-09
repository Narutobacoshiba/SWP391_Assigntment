/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Blog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dal.BlogContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import re.UpdateBlogByIdRequest;
import jwt.JwtAuthorization;
import io.jsonwebtoken.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hapha
 */
public class UpdateBlogById extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateBlogById</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateBlogById at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        Claims claim = JwtAuthorization.validateJwt(request);
        
        if(claim != null && claim.getSubject().equals("admin")){
            StringBuffer jb = new StringBuffer();
            String line;
            try {
                BufferedReader reader = request.getReader();
                while ((line = reader.readLine()) != null) {
                    jb.append(line);
                }
            } catch (Exception e) {
                throw new IOException("Error reading JSON request string");
            }

            try {
                Gson gson = new GsonBuilder().create();  
                UpdateBlogByIdRequest user_request = gson.fromJson(jb.toString(), UpdateBlogByIdRequest.class);  

                BlogContext bc = new BlogContext();
                String res = gson.toJson(bc.updateBlogById(
                        user_request.getId(),user_request.getTitle(),
                        user_request.getDescription(),user_request.getContent(),
                        user_request.getUrl()));

                PrintWriter out_pr = response.getWriter();
                out_pr.print(res);
                out_pr.flush();
            } catch (Exception e) {
                throw new IOException("Error parsing JSON request string");
            }
        }else{
            throw new IOException("Invalid access token");
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
