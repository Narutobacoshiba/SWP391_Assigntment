/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ViewAccount;

/**
 *
 * @author quani
 */
public class ViewDBContext extends DBContext {
    public List<ViewAccount> getAllAccount() {
        List<ViewAccount> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Account where isAdmin != 1";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ViewAccount account = new ViewAccount();
                account.setId(rs.getString(1));
                account.setEmail(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setRole(rs.getString(4));
               

                list.add(account);
            }
        } catch (Exception ex) {
            Logger.getLogger(ViewAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
