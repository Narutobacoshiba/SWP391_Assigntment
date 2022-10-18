/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import model.BlogDescription;
import model.BlogDetail;

/**
 *
 * @author hapha
 */
public class BlogContext extends DBContext {
    public ArrayList<BlogDescription> getListBlog(){
        ArrayList<BlogDescription> blogs = new ArrayList<>();
        try {
            String sql = "SELECT b.BlogID, b.Title, b.[Description], b.CreatedDate, b.NumberOfView  FROM Blog b;";
             
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
          
            while (rs.next()) {
                BlogDescription blog = new BlogDescription();
                blog.setAuthor("admin");
                blog.setCreatedDate(rs.getDate("CreatedDate"));
                blog.setDescription(rs.getString("Description"));
                blog.setId(rs.getInt("BlogID"));
                blog.setNumberOfView(rs.getInt("NumberOfView"));
                blog.setTitle(rs.getString("Title"));
                blogs.add(blog);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return blogs;
    }
    
    public BlogDetail getBlogById(int id){
        BlogDetail blog = new BlogDetail();
        try {
            String sql = "SELECT b.BlogID, b.Title, b.[Description], b.CreatedDate, b.NumberOfView, b.Content, b.ThumbnailUrl  FROM Blog b\n" +
                            "WHERE b.BlogID = ?;";
             
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            
            ResultSet rs = stm.executeQuery();
          
            while (rs.next()) {
                blog.setAuthor("admin");
                blog.setCreatedDate(rs.getDate("CreatedDate"));
                blog.setDescription(rs.getString("Description"));
                blog.setId(rs.getInt("BlogID"));
                blog.setNumberOfView(rs.getInt("NumberOfView"));
                blog.setTitle(rs.getString("Title"));
                blog.setContent(rs.getString("Content"));
                blog.setThumbnailUrl(rs.getString("ThumbnailUrl"));
                return blog;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return blog;
    }
}
