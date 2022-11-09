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
import model.Cetificate;

/**
 *
 * @author Son
 */
public class CetificateContext extends DBContext {

    public ArrayList<Cetificate> getListCetificate() {
        ArrayList<Cetificate> cetificates = new ArrayList<>();
        try {
            String sql = " select * from Cetificate";

            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Cetificate cetificate = new Cetificate();

                cetificate.setCetificateId(rs.getInt("CetificateId"));
                cetificate.setCetificateName(rs.getString("CetificateName"));
                cetificate.setDescription(rs.getString("Description"));
                cetificate.setCetificateImage(rs.getString("CetificateImage"));
                cetificates.add(cetificate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cetificates;
    }

    public Boolean addCetificate(int id,String name, String description, String image) {
        try {
            String sql = " INSERT Cetificate([CetificateID],[CetificateName], [Description], [CetificateImage])\n"
                    + "   VALUEs (?,?,?,?)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setString(2, name);
            stm.setString(3, description);
            stm.setString(4, image);

            stm.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean deleteCetificateById(int id) {
        try {
            String sql = "delete from Cetificate\n"
                    + "where CetificateID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean updateCetificateById(int id, String name, String description, String image) {
        try {
            String sql_update = "update Cetificate \n"
                    + "  set CetificateName = ? , \n"
                    + "  [DesCription] = ? , \n"
                    + "  CetificateImage = ? \n"
                    + "  where CetificateID = ? ";
            PreparedStatement stm = connection.prepareStatement(sql_update);
            stm.setString(1, name);
            stm.setString(2, description);
            stm.setString(3, image);
            stm.setInt(4, id);
            stm.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
