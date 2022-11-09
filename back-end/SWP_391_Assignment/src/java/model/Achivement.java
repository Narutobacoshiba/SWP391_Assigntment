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
    private String CetificateImage;
    private String CetificateName;
    private String DesCription;

    public Achivement() {
    }

    public Achivement(int AchivementId, int CetificateId, String CompleteDate, int AccountId, String CetificateImage, String CetificateName, String DesCription) {
        this.AchivementId = AchivementId;
        this.CetificateId = CetificateId;
        this.CompleteDate = CompleteDate;
        this.AccountId = AccountId;
        this.CetificateImage = CetificateImage;
        this.CetificateName = CetificateName;
        this.DesCription = DesCription;
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

    public String getCetificateImage() {
        return CetificateImage;
    }

    public void setCetificateImage(String CetificateImage) {
        this.CetificateImage = CetificateImage;
    }

    public String getCetificateName() {
        return CetificateName;
    }

    public void setCetificateName(String CetificateName) {
        this.CetificateName = CetificateName;
    }

    public String getDesCription() {
        return DesCription;
    }

    public void setDesCription(String DesCription) {
        this.DesCription = DesCription;
    }

    @Override
    public String toString() {
        return "Achivement{" + "AchivementId=" + AchivementId + ", CetificateId=" + CetificateId + ", CompleteDate=" + CompleteDate + ", AccountId=" + AccountId + ", CetificateImage=" + CetificateImage + ", CetificateName=" + CetificateName + ", DesCription=" + DesCription + '}';
    }

   
  
}
