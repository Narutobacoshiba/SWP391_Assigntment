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
import model.Achivement;
import model.Cetificate;
import model.CourseDetail;

/**
 *
 * @author Son
 */
public class AchivementContext extends DBContext {

    public Achivement getCetificateById(int id) {
        Achivement cetifi = new Achivement();

        try {
            String sql = "select a.CompleteDate , c.CetificateImage,c.CetificateName,c.DesCription from Achivement a\n"
                    + "inner join Cetificate c on AchivementID = c.CetificateID \n"
                    + "where AccountID = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                cetifi.setCompleteDate(rs.getString("date"));
                cetifi.setCetificateImage(rs.getString("image"));
                cetifi.setCetificateName(rs.getString("name"));
                cetifi.setDesCription(rs.getString("description"));
                return cetifi;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cetifi;
    }

    public CourseDetail getCourseById(int id) {
        CourseDetail course = new CourseDetail();

        try {
            String sql = "SELECT c.Name,c.Description , c.AboutCourse , c.TinyPictureUrl ,c.InstructorID from Course c\n"
                    + "inner join Account a \n"
                    + "on AccountId = CourseID\n"
                    + "where AccountID = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                course.setName(rs.getString("name"));
                course.setDescription(rs.getString("sescription"));
                course.setAboutCourse(rs.getString("aboutcourse"));
                course.setTinyPictureUrl(rs.getString("picture"));
                course.setInstructorID(rs.getInt("id"));
                return course;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return course;
    }

}
