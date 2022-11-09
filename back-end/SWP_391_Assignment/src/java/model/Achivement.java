/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Son
 */
public class Achivement {
    private int AchivementId;
    private int CetificateId;
    private String CompleteDate;
    private int AccountId;

    public Achivement() {
    }

    public Achivement(int AchivementId, int CetificateId, String CompleteDate, int AccountId) {
        this.AchivementId = AchivementId;
        this.CetificateId = CetificateId;
        this.CompleteDate = CompleteDate;
        this.AccountId = AccountId;
    }

    public int getAchivementId() {
        return AchivementId;
    }

    public void setAchivementId(int AchivementId) {
        this.AchivementId = AchivementId;
    }

    public int getCetificateId() {
        return CetificateId;
    }

    public void setCetificateId(int CetificateId) {
        this.CetificateId = CetificateId;
    }

    public String getCompleteDate() {
        return CompleteDate;
    }

    public void setCompleteDate(String CompleteDate) {
        this.CompleteDate = CompleteDate;
    }

    public int getAccountId() {
        return AccountId;
    }

    public void setAccountId(int AccountId) {
        this.AccountId = AccountId;
    }

    @Override
    public String toString() {
        return "Achivement{" + "AchivementId=" + AchivementId + ", CetificateId=" + CetificateId + ", CompleteDate=" + CompleteDate + ", AccountId=" + AccountId + '}';
    }
    
    
}
