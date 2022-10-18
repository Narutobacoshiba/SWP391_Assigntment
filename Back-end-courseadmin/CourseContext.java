/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Course;
import model.UserAccount;

/**
 *
 * @author Admin
 */
public class CourseContext extends DBContext{
    public ArrayList<Course> getAlCourses(){
        ArrayList<Course> list = new ArrayList<>();
        try {
            String sql = "select * from Course";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                Course c = new Course();

                c.setCourseID(rs.getInt("CourseID"));
                c.setName(rs.getString("Name"));
                c.setDescription(rs.getString("Description"));
                c.setTinyPictureUrl(rs.getString("TinyPictureUrl"));
                c.setThumbnailUrl(rs.getString("ThumbnailUrl"));
                c.setCreatedDate(rs.getDate("CreatedDate"));
                c.setModifiedDate(rs.getDate("ModifiedDate"));
                c.setPrice(rs.getBigDecimal("Price"));
                c.setStatus(rs.getBoolean("Status"));
                c.setVideoIntroduce(rs.getString("VideoIntroduce"));
                c.setAboutCourse(rs.getString("AboutCourse"));
                UserAccount ac = new UserAccount();

                c.setInstructorId(ac);

                list.add(c);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CourseContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public void insertCourse(Course course) {
        try {
            String sql = "INSERT INTO [dbo].[Course]\n"
                    + "           ([Name]\n"
                    + "           ,[Description]\n"
                    + "           ,[InstructorID]\n"
                    + "           ,[TinyPictureUrl]\n"
                    + "           ,[ThumbnailUrl]\n"
                    + "           ,[CreatedDate]\n"
                    + "           ,[ModifiedDate]\n"
                    + "           ,[Price]\n"
                    + "           ,[Status]\n"
                    + "           ,[VideoIntroduce]\n"
                    + "           ,[AboutCourse])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, course.getName());
            stm.setString(2, course.getDescription());
            stm.setString(3, course.getInstructorId().getId());
            stm.setString(4, course.getThumbnailUrl());
            stm.setString(5, course.getThumbnailUrl());
            stm.setDate(6, course.getCreatedDate());
            stm.setDate(7, null);
            stm.setBigDecimal(8, BigDecimal.ZERO);
            stm.setBoolean(9, course.isStatus());
            stm.setString(10, course.getVideoIntroduce());
            stm.setString(11, course.getAboutCourse());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateCourse(Course course) {
        try {
            String sql = "UPDATE [dbo].[Course]\n"
                    + "   SET [Name] = ?\n"
                    + "      ,[Description] = ?\n"
                    + "      ,[TinyPictureUrl] = ?\n"
                    + "      ,[ThumbnailUrl] = ?\n"
                    + "      ,[ModifiedDate] = ?\n"
                    + "      ,[Price] = ?\n"
                    + "      ,[Status] = ?\n"
                    + "      ,[VideoIntroduce] = ?\n"
                    + "      ,[AboutCourse] = ?\n"
                    + " WHERE CourseID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, course.getName());
            stm.setString(2, course.getDescription());
            stm.setString(3, course.getThumbnailUrl());
            stm.setString(4, course.getThumbnailUrl());
            stm.setDate(5, course.getModifiedDate());
            stm.setBigDecimal(6, BigDecimal.ZERO);
            stm.setBoolean(7, course.isStatus());
            stm.setString(8, course.getVideoIntroduce());
            stm.setString(9, course.getAboutCourse());
            stm.setInt(10, course.getCourseID());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteCourse(int id) {
        try {
            String sql = "DELETE from [Course] WHERE [CourseID] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            
        }
    }
}
