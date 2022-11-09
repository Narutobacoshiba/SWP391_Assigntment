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
    
    public Boolean addBlog(String blogTitle, String blogDescription, String blogContent, String thumnailUrl){
        try {
            String sql = "INSERT INTO Blog (Title, [Description], Content, CreatedDate,\n" + 
                         "AuthorID, Display, ThumbnailUrl, NumberOfView)\n" +
                         "VALUES (?,?,?,GETDATE(),6,1,?,0)";
             
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, blogTitle);
            stm.setString(2, blogDescription);
            stm.setString(3, blogContent);
            stm.setString(4, thumnailUrl);
            
            stm.executeUpdate();
          
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean deleteBlogById(int id){
        try {
            String sql_insert = "DELETE FROM Blog\n" +
                                "WHERE BlogID = ?\n";
            PreparedStatement stm = connection.prepareStatement(sql_insert);
            stm.setInt(1, id);
            stm.executeUpdate();
      
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean updateBlogById(int id, String title, String description, String content, String url){
        try {
            String sql_update = "UPDATE Blog\n" +
                                "SET Title = ?, [Description] = ?, Content = ?,\n" +
                                "ThumbnailUrl = ?, CreatedDate = GETDATE()\n" +
                                "WHERE BlogID = ?\n";
            PreparedStatement stm = connection.prepareStatement(sql_update);
            stm.setString(1, title);
            stm.setString(2, description);
            stm.setString(3, content);
            stm.setString(4, url);
            stm.setInt(5, id);
            stm.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean updateBlogViewById(int id, int view){
        try {
            String sql_update = "UPDATE Blog\n" +
                                "SET NumberOfView = ?\n" +
                                "WHERE BlogID = ?\n";
            PreparedStatement stm = connection.prepareStatement(sql_update);
            stm.setInt(1, view);
            stm.setInt(2, id);
            stm.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
