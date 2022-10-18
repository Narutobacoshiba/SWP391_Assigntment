/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modal.User;

/**
 *
 * @author Son
 */
public class ManagerUserContext extends DBConnect {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        String queryUser = " select * from [User] ";
        try {
            conn = new DBConnect().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(queryUser);// truyen cau len query sang sql sever
            rs = ps.executeQuery(); // chay cau lenh query va tra ve bang ket qua
            while (rs.next()) {
                list.add(new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void DeleteUser(String Uid) {
        String queryDelete = " Delete from [User] where [Userid] = ? ";
        try {
            conn = new DBConnect().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(queryDelete);// truyen cau len query sang sql sever
            ps.setString(1, Uid);
            ps.executeUpdate(); // chay cau lenh query va tra ve bang ket qua

        } catch (Exception e) {

        }

    }

    public void InsertUser(
            int id,
            String fullname,
            String email,
            String gender,
            String password,
            String avatar,
            String dob) {

        String query = " insert into [User] VALUES (?,?,?,?,?,?,?)";
        try {
            conn = new DBConnect().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);// truyen cau len query sang sql sever
            ps.setInt(1, id);
            ps.setString(2, fullname);
            ps.setString(3, email);
            ps.setString(4, gender);
            ps.setString(5, password);
            ps.setString(6, avatar);
            ps.setString(7, dob);

            ps.executeUpdate(); // chay cau lenh query va tra ve bang ket qua

        } catch (Exception e) {
        }
    }

    public void UpdateUser(
            String fullname,
            String email,
            String gender,
            String password,
            String avatar,
            String dob,
            int id ) {

        String query = " update [User] \n"
                + "	  set [fullname] = ?\n"
                + "	   ,[email] = ?\n"
                + "      ,[gender] = ?\n"
                + "      ,[password] = ?\n"
                + "      ,[phone] = ?\n"
                + "      ,[avatar_img] = ?\n"
                + "      ,[dob] = ?\n"
                + "	  where UserId = ?";
        try {
            conn = new DBConnect().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);// truyen cau len query sang sql sever

            ps.setString(1, fullname);
            ps.setString(2, email);
            ps.setString(3, gender);
            ps.setString(4, password);
            ps.setString(5, avatar);
            ps.setString(6, dob);
            ps.setInt(7, id);

            ps.executeUpdate(); // chay cau lenh query va tra ve bang ket qua

        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        ManagerUserContext dao = new ManagerUserContext();
//        List<Product> list = dao.getAllProduct();

        List<User> listC = dao.getAllUser();
        // Product last = dao.getLast();
        //System.out.println(last);
        //List<Product> list = dao.getProductByCid(cid);
        for (User o : listC) {
            System.out.println(o);
        }
    }
}
