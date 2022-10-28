/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CourseDescription;
import model.CourseDetail;
/**
 *
 * @author hapha
 */
public class CourseContext extends DBContext {
    public ArrayList<CourseDescription> getListCourse(int status){
        ArrayList<CourseDescription> courses = new ArrayList<>();
        try {
            String sql = "SELECT c.CourseID, c.[Name], c.[Description], c.InstructorID,\n" +
                         "c.ThumbnailUrl, c.CreatedDate, c.ModifiedDate, c.[Status] \n" +
                         "FROM [Course] c";
            
            if(status == 0){
                sql += "\nWHERE c.[Status] = 0";
            }else if(status == 1){
                sql += "\nWHERE c.[Status] = 1";
            }
             
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
          
            while (rs.next()) {
                CourseDescription course = new CourseDescription();
                
                course.setCourseID(rs.getInt("CourseID"));
                course.setName(rs.getString("Name"));
                course.setDescription(rs.getString("Description"));
                course.setInstructorId(rs.getInt("InstructorID"));
                course.setCreatedDate(rs.getDate("CreatedDate"));
                course.setModifiedDate(rs.getDate("ModifiedDate"));
                course.setThumbnailUrl(rs.getString("ThumbnailUrl"));
                course.setStatus(rs.getInt("Status"));
                courses.add(course);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return courses;
    } 
    
    public boolean updateCourseStatus(int id, int status){
        try {
            if(status == 0 || status == 1){
                String sql_update = "UPDATE [Course]\n" +
                                "SET [Status] = ?\n" +
                                "WHERE [CourseID] = ?\n";
                PreparedStatement stm = connection.prepareStatement(sql_update);
                stm.setInt(1, status);
                stm.setInt(2, id);
                stm.executeUpdate();

                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean deleteCourseById(int id){
        try {
            String sql_insert = "DELETE FROM [Course]\n" +
                                "WHERE [CourseID] = ?\n";
            PreparedStatement stm = connection.prepareStatement(sql_insert);
            stm.setInt(1, id);
            stm.executeUpdate();
      
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public CourseDetail getCourseById(int id){
        CourseDetail course = new CourseDetail();
        try {
            String sql = "SELECT *\n" +
                         "FROM [Course] c\n" +
                         "WHERE [CourseID] = ?";
             
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            
            ResultSet rs = stm.executeQuery();
          
            while (rs.next()) {
                course.setCourseID(rs.getInt("CourseID"));
                course.setName(rs.getString("Name"));
                course.setDescription(rs.getString("Description"));
                course.setInstructorID(rs.getInt("InstructorID"));
                course.setTinyPictureUrl(rs.getString("TinyPictureUrl"));
                course.setThumbnailUrl(rs.getString("ThumbnailUrl"));
                course.setCreatedDate(rs.getDate("CreatedDate"));
                course.setModifiedDate(rs.getDate("ModifiedDate"));
                course.setPrice(rs.getFloat("Price"));
                course.setStatus(rs.getInt("Status"));
                course.setVideoIntroduce(rs.getString("VideoIntroduce"));
                course.setAboutCourse(rs.getString("AboutCourse"));
                return course;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return course;
    }
}
