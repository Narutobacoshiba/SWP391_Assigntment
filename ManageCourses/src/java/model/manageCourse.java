/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author quani
 */
public class manageCourse {
    private int id;
    private String name;
    private String description;
    private Date createddate;
    private String aboutcourse;
    private String Url;
    private Long Price;

    public manageCourse() {
    }

    public manageCourse(int id, String name, String description, Date createddate, String aboutcourse, String Url, Long Price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createddate = createddate;
        this.aboutcourse = aboutcourse;
        this.Url = Url;
        this.Price = Price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public String getAboutcourse() {
        return aboutcourse;
    }

    public void setAboutcourse(String aboutcourse) {
        this.aboutcourse = aboutcourse;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public Long getPrice() {
        return Price;
    }

    public void setPrice(Long Price) {
        this.Price = Price;
    }
    
    
    
    
    
    
}
