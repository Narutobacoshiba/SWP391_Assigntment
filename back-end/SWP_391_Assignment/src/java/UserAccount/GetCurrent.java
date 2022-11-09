/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package UserAccount;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import io.jsonwebtoken.*;
import jwt.JwtAuthorization;
import dal.UserAccountContext;
import static java.lang.System.out;
/**
 *
 * @author hapha
 */
public class GetCurrent extends HttpServlet {
   
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
            out.println("<title>Servlet GetCurrent</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetCurrent at " + request.getContextPath () + "</h1>");
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
        String res = "";
        Claims claim = JwtAuthorization.validateJwt(request);
        if(claim != null){
            UserAccountContext uac = new UserAccountContext();
            Gson gson = new GsonBuilder().create();
            res = gson.toJson(uac.getUserById(Integer.parseInt(claim.getId())));
        }else{
            response.setStatus(404);
        }
        PrintWriter out_pr = response.getWriter();
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out_pr.print(res);
        out_pr.flush();
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
        String res = "";
        Claims claim = JwtAuthorization.validateJwt(request);
        if(claim != null){
            UserAccountContext uac = new UserAccountContext();
            Gson gson = new GsonBuilder().create();
            res = gson.toJson(uac.getUserById(Integer.parseInt(claim.getId())));
        }else{
            response.setStatus(404);
        }
        PrintWriter out_pr = response.getWriter();
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out_pr.print(res);
        out_pr.flush();
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
