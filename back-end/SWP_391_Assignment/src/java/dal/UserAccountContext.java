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
import static java.lang.System.out;
import model.UserAccount;

/**
 *
 * @author hapha
 */
public class UserAccountContext extends DBContext {
    public UserAccount getUser(String username, String password){
        UserAccount user = new UserAccount();
   
        try {
            String sql = "SELECT a.AccountID as id, a.Email as email, r.[Name] as role  FROM\n" +
                         "Account a INNER JOIN [Role] r ON a.RoleID = r.RoleID\n" +
                         "WHERE a.Email = ? and a.[Password] = ?;";
             
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
   
            ResultSet rs = stm.executeQuery();
          
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));

                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user;
    }
    
    public UserAccount getUserById(int id){
        UserAccount user = new UserAccount();
   
        try {
            String sql = "SELECT a.AccountID as id, a.[Username] as username,\n" +
                         "a.[Status] as [status], a.Email as email, r.[Name] as role  FROM\n" +
                         "Account a INNER JOIN [Role] r ON a.RoleID = r.RoleID\n" +
                         "WHERE a.AccountID = ?";
             
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
   
            ResultSet rs = stm.executeQuery();
          
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setRole(rs.getString("role"));
                user.setStatus(rs.getInt("status"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user;
    }
    
    public boolean registerUser(String username, String password, String dob, String address){
        try {
            String sql_insert = "INSERT INTO UserAccount(username, [password], [dob], [address])\n" +
                                "VALUES\n" +
                                "(?, ?, ?, ?)";
            PreparedStatement stm = connection.prepareStatement(sql_insert);
            stm.setString(1, username);
            stm.setString(2, password);
            stm.setString(3, dob);
            stm.setString(4, address);
            stm.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    
    public UserAccount updateUser(String username, String password, String dob, String address){
        UserAccount user = new UserAccount();
        /*
        try {
            String sql_update = "UPDATE UserAccount\n" +
                                "SET password = ?, [dob] = ?, [address] = ?\n" +
                                "WHERE username = ?\n";
            PreparedStatement stm = connection.prepareStatement(sql_update);
            stm.setString(1, password);
            stm.setString(2, dob);
            stm.setString(3, address);
            stm.setString(4, username);
            stm.executeUpdate();
            
            try {
                String sql = "SELECT [username], [password], [dob], [address] FROM UserAccount\n" +
                             "WHERE [username] = ? and [password] = ?";

                PreparedStatement stm_select = connection.prepareStatement(sql);
                stm_select.setString(1, username);
                stm_select.setString(2, password);

                ResultSet rs = stm_select.executeQuery();

                while (rs.next()) {
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setDob(rs.getString("dob"));
                    user.setAddress(rs.getString("address"));

                    return user;
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        return user;
    }
    
    public boolean deleteUser(String username, String password){
        try {
            String sql_insert = "DELETE FROM UserAccount\n" +
                                "WHERE username = ? and password = ?\n";
            PreparedStatement stm = connection.prepareStatement(sql_insert);
            stm.setString(1, username);
            stm.setString(2, password);
            stm.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean deleteUserById(int id){
        try {
            String sql_insert = "DELETE FROM Account\n" +
                                "WHERE AccountID = ?\n";
            PreparedStatement stm = connection.prepareStatement(sql_insert);
            stm.setInt(1, id);
            stm.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public ArrayList<UserAccount> listAllUser(){
        ArrayList<UserAccount> users = new ArrayList<>();
   
        try {
            String sql = "SELECT a.AccountID as id, a.Email as email, r.[Name] as role, a.Username as username, a.[Status] as [status]  FROM\n" +
                         "Account a INNER JOIN [Role] r ON a.RoleID = r.RoleID";
             
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
          
            while (rs.next()) {
                UserAccount user = new UserAccount();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setStatus(rs.getInt("status"));
                user.setRole(rs.getString("role"));
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return users;
    }
    
    public ArrayList<UserAccount> searchUser(String text){
        ArrayList<UserAccount> users = new ArrayList<>();
   
        try {
            String sql = "SELECT a.AccountID as id, a.Email as email, r.[Name] as role, a.Username as username, a.[Status] as [status]  FROM\n" +
                         "Account a INNER JOIN [Role] r ON a.RoleID = r.RoleID\n"+
                         "WHERE a.Username like ?";
            
             
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + text + "%");
            ResultSet rs = stm.executeQuery();
          
            while (rs.next()) {
                UserAccount user = new UserAccount();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setStatus(rs.getInt("status"));
                user.setRole(rs.getString("role"));
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return users;
    }
    
    public boolean banUser(int id){
        try {
            String sql_update = "UPDATE Account\n" +
                                "SET [Status] = 0\n" +
                                "WHERE AccountID = ?\n";
            PreparedStatement stm = connection.prepareStatement(sql_update);
            stm.setInt(1, id);
            stm.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean unbanUser(int id){
        try {
            String sql_update = "UPDATE Account\n" +
                                "SET [Status] = 1\n" +
                                "WHERE AccountID = ?\n";
            PreparedStatement stm = connection.prepareStatement(sql_update);
            stm.setInt(1, id);
            stm.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean editUserProfile(int id, String username, String role, int status, String email){
        try {
            String sql_update = "UPDATE Account\n" +
                                "SET [Status] = ?, [Username] = ?, [Email] = ?,\n" +
                                "[RoleID] = (SELECT RoleID FROM [Role] WHERE [Name] = ?)\n"+
                                "WHERE AccountID = ?\n";
            PreparedStatement stm = connection.prepareStatement(sql_update);
            stm.setInt(1, status);
            stm.setString(2, username);
            stm.setString(3, email);
            stm.setString(4, role);
            stm.setInt(5, id);
            stm.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
