/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;
import model.manageCourse;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quani
 */
public class Course extends DBContext {
    public void InsertCourse(manageCourse C) {
        try {
            String sql = "INSERT INTO [Course]\n"
                    + "           ([Name]\n"
                    + "           ,[description]\n"
                    + "           ,[createddate]\n"
                    + "           ,[aboutcourse]\n"
                    + "           ,[Url]\n"
                    + "           ,[Price]\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, C.getName());
            stm.setString(2, C.getDescription());
            stm.setDate(3, C.getCreateddate());
            stm.setString(4, C.getAboutcourse());
            stm.setString(5, C.getUrl());
            stm.setLong(6, C.getPrice());
            
            stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);;
        }
    }
    public void deleteCourse(int id) {
        try {
            String sql = "DELETE FROM [Course]\n"
                    + "WHERE id = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);;
        }
    }
    public void updateProduct(manageCourse C) {
        try {
            String sql = "UPDATE [product]\n"
                    + "   SET [Name] = ?\n"
                    + "      ,[description] = ?\n"
                    + "      ,[createddate] = ?\n"
                    + "      ,[aboutcourse] = ?\n"
                    + "      ,[Url] = ?\n"
                    + "      ,[Price] = ?\n"                  
                    + " WHERE id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, C.getName());
            stm.setString(2, C.getDescription());
            stm.setDate(3, C.getCreateddate());
            stm.setString(4, C.getAboutcourse());
            stm.setString(5, C.getUrl());
            stm.setLong(6, C.getPrice());
            stm.setInt(7, C.getId());
            stm.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);;
        }

    }
}
