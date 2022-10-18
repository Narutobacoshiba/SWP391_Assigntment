/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ViewAccount;

/**
 *
 * @author quani
 */
public class SearchDBContext extends DBContext {
         public ViewAccount getAccountById(int accountId) {
        try {
            String sql = " select *  from Account where username like '%?%'";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, accountId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ViewAccount account = new ViewAccount();
                account.setId(rs.getString(1));
                account.setEmail(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setRole(rs.getString(4));               
                return account;
            }
        } catch (Exception ex) {
            Logger.getLogger(SearchDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
