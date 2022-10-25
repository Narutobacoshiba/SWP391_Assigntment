/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Course {
    private int courseID;
    private String name;
    private String description;
    private UserAccount instructorId;
    private String tinyPictureUrl;
    private String thumbnailUrl;
    private Date createdDate;
    private Date modifiedDate;
    private BigDecimal price;
    private boolean status;
    private String videoIntroduce;
    private String aboutCourse;

    public Course() {
    }

    public Course(int courseID, String name, String description, UserAccount instructorId, String tinyPictureUrl, String thumbnailUrl, Date createdDate, Date modifiedDate, BigDecimal price, boolean status, String videoIntroduce, String aboutCourse) {
        this.courseID = courseID;
        this.name = name;
        this.description = description;
        this.instructorId = instructorId;
        this.tinyPictureUrl = tinyPictureUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.price = price;
        this.status = status;
        this.videoIntroduce = videoIntroduce;
        this.aboutCourse = aboutCourse;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserAccount getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(UserAccount instructorId) {
        this.instructorId = instructorId;
    }

    public String getTinyPictureUrl() {
        return tinyPictureUrl;
    }

    public void setTinyPictureUrl(String tinyPictureUrl) {
        this.tinyPictureUrl = tinyPictureUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getVideoIntroduce() {
        return videoIntroduce;
    }

    public void setVideoIntroduce(String videoIntroduce) {
        this.videoIntroduce = videoIntroduce;
    }

    public String getAboutCourse() {
        return aboutCourse;
    }

    public void setAboutCourse(String aboutCourse) {
        this.aboutCourse = aboutCourse;
    }

    @Override
    public String toString() {
        return "Course{" + "courseID=" + courseID + ", name=" + name + ", description=" + description + ", instructorId=" + instructorId + ", tinyPictureUrl=" + tinyPictureUrl + ", thumbnailUrl=" + thumbnailUrl + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", price=" + price + ", status=" + status + ", videoIntroduce=" + videoIntroduce + ", aboutCourse=" + aboutCourse + '}';
    }
    
    
}
