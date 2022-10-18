/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

/**
 *
 * @author Son
 */
public class User {
    
    
    private int UserID;
    private String fullname;
    private String email;
    private String gender;
    private String password;
    private String phone;
    private String avatar;
    private String dob;

    public User() {
    }

    public User(int UserID, String fullname, String email, String gender, String password, String phone, String avatar, String dob) {
        this.UserID = UserID;
        this.fullname = fullname;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.phone = phone;
        this.avatar = avatar;
        this.dob = dob;
    }

    public int getUserID() {
        return UserID;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getDob() {
        return dob;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    
     

   
    
    
    
    
}
