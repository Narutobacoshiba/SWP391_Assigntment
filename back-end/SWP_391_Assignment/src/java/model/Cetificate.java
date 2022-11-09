/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Son
 */
public class Cetificate {
    private int CetificateId;
    private String CetificateName;
    private String Description;
    private String CetificateImage;
    private int CourseId;

    public Cetificate() {
    }

    public Cetificate(int CetificateId, String CetificateName, String Description, String CetificateImage, int CourseId) {
        this.CetificateId = CetificateId;
        this.CetificateName = CetificateName;
        this.Description = Description;
        this.CetificateImage = CetificateImage;
        this.CourseId = CourseId;
    }

    public int getCetificateId() {
        return CetificateId;
    }

    public void setCetificateId(int CetificateId) {
        this.CetificateId = CetificateId;
    }

    public String getCetificateName() {
        return CetificateName;
    }

    public void setCetificateName(String CetificateName) {
        this.CetificateName = CetificateName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getCetificateImage() {
        return CetificateImage;
    }

    public void setCetificateImage(String CetificateImage) {
        this.CetificateImage = CetificateImage;
    }

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int CourseId) {
        this.CourseId = CourseId;
    }

    @Override
    public String toString() {
        return "Cetificate{" + "CetificateId=" + CetificateId + ", CetificateName=" + CetificateName + ", Description=" + Description + ", CetificateImage=" + CetificateImage + ", CourseId=" + CourseId + '}';
    }

    

   
    
    
    
}
